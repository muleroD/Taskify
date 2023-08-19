package br.com.mulero.taskify.security.jwt;

import org.springframework.beans.factory.annotation.Value;

public class SecurityConstants {

    private SecurityConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String AUTHORIZATION_TYPE = "Bearer";
    public static String JWT_SECRET;
    public static final long EXPIRATION_TIME = 86400000; // 1 day
    public static final String TOKEN_PREFIX = AUTHORIZATION_TYPE + " ";
    public static final String HEADER_TYPE = "Authorization";
    public static final String SIGN_UP_URL = "/api/sign-up";
    public static final String SIGN_IN_URL = "/api/sign-in";

    @Value("${br.com.mulero.taskify.security.jwtSecret}")
    public static void setJwtSecret(String jwtSecret) {
        JWT_SECRET = jwtSecret;
    }
}
