package com.anderson.meu_projeto.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosRefreshToken(
    @NotBlank
    String refreshToken,
    String username) {
    
}
