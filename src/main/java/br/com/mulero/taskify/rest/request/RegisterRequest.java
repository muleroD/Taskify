package br.com.mulero.taskify.rest.request;

import br.com.mulero.taskify.rest.enumerator.Role;

public record RegisterRequest(String name, String email, String password, Role role) {
}
