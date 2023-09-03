package br.com.mulero.taskify.security;

public class UserRoles {

    private UserRoles() {
        throw new IllegalStateException("Utility class");
    }

    public static final String ADMIN = "ROLE_ADMIN";
    public static final String USER = "ROLE_USER";
}
