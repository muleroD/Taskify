package br.com.mulero.taskify.security.filter;

import br.com.mulero.taskify.security.LoginRequest;
import br.com.mulero.taskify.security.UserDetailsServiceImpl;
import br.com.mulero.taskify.security.jwt.JwtProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import java.io.IOException;
import java.util.List;

public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final UserDetailsServiceImpl userDetailsService;

    public AuthenticationFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService) {
        super(defaultFilterProcessesUrl, authenticationManager);
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        LoginRequest loginRequest = new LoginRequest(req.getParameter("username"), req.getParameter("password"));

        return getAuthenticationManager()
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        String username = (String) authResult.getPrincipal();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        String token = new JwtProvider().createToken(username, (List<GrantedAuthority>) userDetails.getAuthorities());

        req.setAttribute("Authorization", token);
        chain.doFilter(req, res);
    }
}
