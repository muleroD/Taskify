package br.com.mulero.taskify.rest.request;

import br.com.mulero.taskify.rest.enumerator.Role;

import java.time.LocalDate;

public record RegisterRequest(String name, LocalDate birthDate, String email, String password, Role role) {
}
