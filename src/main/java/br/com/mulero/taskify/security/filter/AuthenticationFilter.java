package br.com.mulero.taskify.security.filter;

import br.com.mulero.taskify.rest.request.LoginRequest;
import br.com.mulero.taskify.security.jwt.JwtProvider;
import br.com.mulero.taskify.security.jwt.SecurityConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final JwtProvider jwtProvider;

    public AuthenticationFilter(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        super(new AntPathRequestMatcher(SecurityConstants.LOGIN_URL, HttpMethod.POST.name()), authenticationManager);
        this.jwtProvider = jwtProvider;
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
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication authResult) {
        User authenticatedUser = (User) authResult.getPrincipal();

        String token = jwtProvider.createToken(authenticatedUser.getUsername(), (Set<GrantedAuthority>) authenticatedUser.getAuthorities());
        res.setHeader(SecurityConstants.HEADER_TYPE, SecurityConstants.TOKEN_PREFIX + token);

        res.setStatus(HttpServletResponse.SC_OK);
    }
}
