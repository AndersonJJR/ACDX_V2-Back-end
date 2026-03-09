package com.anderson.meu_projeto.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosLogin(
    @NotBlank(message = "Nome não pode estar vazio")
    String username,
    @NotBlank(message = "Senha não pode estar vazio")
    String password) {
}
