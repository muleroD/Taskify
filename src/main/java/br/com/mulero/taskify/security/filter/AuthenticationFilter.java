package br.com.mulero.taskify.security.filter;

import br.com.mulero.taskify.rest.request.LoginRequest;
import br.com.mulero.taskify.security.UserDetailsServiceImpl;
import br.com.mulero.taskify.security.jwt.JwtProvider;
import br.com.mulero.taskify.security.jwt.SecurityConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final UserDetailsServiceImpl userDetailsService;

    public AuthenticationFilter(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService) {
        super(new AntPathRequestMatcher(SecurityConstants.LOGIN_URL, HttpMethod.POST.name()), authenticationManager);
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException {
        InputStream requestBody = req.getInputStream();
        LoginRequest loginRequest = new ObjectMapper().readValue(requestBody, LoginRequest.class);

        UsernamePasswordAuthenticationToken authenticatedCredentials = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());

        return getAuthenticationManager().authenticate(authenticatedCredentials);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        String username = (String) authResult.getPrincipal();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        String token = new JwtProvider().createToken(username, (List<GrantedAuthority>) userDetails.getAuthorities());

        res.setHeader(SecurityConstants.HEADER_TYPE, token);
        chain.doFilter(req, res);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
