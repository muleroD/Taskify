package br.com.mulero.taskify.graphql.types;

import java.time.LocalDate;

public record ProfileInput(String name, LocalDate birthDate) {
}
