package br.com.mulero.taskify.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Date;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class JwtProvider {

    public static final Algorithm ALGORITHM = Algorithm.HMAC256(SecurityConstants.JWT_SECRET);

    public static final String USERNAME = "username";
    public static final String ROLES = "roles";

    public String createToken(String username, Set<GrantedAuthority> roles) {
        return JWT.create()
                .withIssuer(SecurityConstants.ISSUER)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .withJWTId(UUID.randomUUID().toString())
                .withClaim(USERNAME, username)
                .withClaim(ROLES, roles.stream().map(GrantedAuthority::getAuthority).toList())
                .sign(ALGORITHM);
    }

    public DecodedJWT decodeToken(String token) {
        return JWT.require(ALGORITHM)
                .build()
                .verify(token);
    }

    public boolean isValid(String token) {
        return !decodeToken(token).getExpiresAt().before(new Date());
    }

    public Claim getClaim(String jwtToken, String claim) {
        return decodeToken(jwtToken).getClaim(claim);
    }

    public String getUsername(String jwtToken) {
        return getClaim(jwtToken, USERNAME).asString();
    }

    public Set<GrantedAuthority> getRoles(String jwtToken) {
        return getClaim(jwtToken, ROLES).asList(String.class).stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }
}
