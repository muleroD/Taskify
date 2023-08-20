package br.com.mulero.taskify.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class JwtService {

    public static final Algorithm ALGORITHM = Algorithm.HMAC256(SecurityConstants.JWT_SECRET);

    public static final String USERNAME = "username";
    public static final String ROLES = "roles";

    public String createToken(String username, List<String> roles) {
        return JWT.create()
                .withIssuer(SecurityConstants.ISSUER)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .withJWTId(UUID.randomUUID().toString())
                .withClaim(USERNAME, username)
                .withClaim(ROLES, roles)
                .sign(ALGORITHM);
    }

    public DecodedJWT verifyToken(String token) {
        JWT.require(ALGORITHM)
                .build()
                .verify(token);

        return JWT.decode(token);
    }
}
