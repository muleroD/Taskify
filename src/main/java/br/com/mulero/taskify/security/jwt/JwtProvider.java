package br.com.mulero.taskify.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

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

    public boolean isTokenValid(String token) {
        return !decodeToken(token).getExpiresAt().before(new Date());
    }

    public String getUsername(String jwtToken) {
        return decodeToken(jwtToken).getClaim(USERNAME).asString();
    }
}
