package com.anderson.meu_projeto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosRegistroAutenticacao(
    @NotBlank(message = "Nome não pode ser vazio ou nulo")
    String username,
    @NotBlank(message = "Email não pode ser vazio ou nulo")
    @Email(message = "Formato de email invalido")
    String email,
    @NotBlank(message = "Senha não pode ser vazia ou nula")
    String password
) {
    
}
