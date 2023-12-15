package br.com.mulero.taskify.security.jwt;

public class SecurityConstants {

    private SecurityConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String ISSUER = "br.com.mulero.taskify";
    public static final String AUTHORIZATION_TYPE = "Bearer";
    public static final String HEADER_TYPE = "Authorization";
    public static final String TOKEN_PREFIX = AUTHORIZATION_TYPE + " ";
    public static final String JWT_SECRET = "Xv?ZZGF8*x_?X29R"; // TODO: Move to environment variable
    public static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000; // 24 hours
    public static final String LOGIN_URL = "/api/login";
    public static final String GRAPHQL_URL = "/graphql";

}
