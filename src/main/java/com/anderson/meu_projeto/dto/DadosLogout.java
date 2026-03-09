package com.anderson.meu_projeto.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosLogout(
    @NotBlank
    String refreshToken
) {
    
}
