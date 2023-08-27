package br.com.mulero.taskify.security.jwt;

import org.springframework.beans.factory.annotation.Value;

public class SecurityConstants {

    private SecurityConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String ISSUER = "br.com.mulero.taskify";
    public static final String AUTHORIZATION_TYPE = "Bearer";
    public static String JWT_SECRET;
    public static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000; // 24 hours
    public static final String TOKEN_PREFIX = AUTHORIZATION_TYPE + " ";
    public static final String HEADER_TYPE = "Authorization";
    public static final String REGISTER_URL = "/api/register"; // Endpoint de cadastro de usuário
    public static final String LOGIN_URL = "/api/login"; // Endpoint de login de usuário

    @Value("${spring.security.secret}")
    public static void setJwtSecret(String jwtSecret) {
        JWT_SECRET = jwtSecret;
    }
}
