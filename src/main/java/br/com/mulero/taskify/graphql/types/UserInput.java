package br.com.mulero.taskify.graphql.types;

import br.com.mulero.taskify.rest.enumerator.Role;

import java.util.Optional;

public record UserInput(String email, String password, Optional<Role> role, ProfileInput profile) {
}
