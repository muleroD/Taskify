package br.com.mulero.taskify.security.filter;

import br.com.mulero.taskify.security.jwt.JwtProvider;
import br.com.mulero.taskify.security.jwt.SecurityConstants;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

public class AuthorizationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public AuthorizationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        String header = Optional.ofNullable(req.getHeader(SecurityConstants.HEADER_TYPE)).orElse("");

        if (!StringUtils.hasText(header) && !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        String token = header.replace(SecurityConstants.TOKEN_PREFIX, "");
        if (!jwtProvider.isValid(token)) {
            chain.doFilter(req, res);
            return;
        }

        String username = jwtProvider.getUsername(token);
        Set<GrantedAuthority> roles = jwtProvider.getRoles(token);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                username, null, roles);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }
}