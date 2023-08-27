package br.com.mulero.taskify.rest.request;

public record RegisterRequest(String name, String email, String password, String role) {
}
