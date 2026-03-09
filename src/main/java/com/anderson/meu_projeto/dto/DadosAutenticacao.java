package com.anderson.meu_projeto.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosAutenticacao {
    
    private String authenticationToken;
    private String refreshToken;
    private Instant expiresAt;
    private String username;
}
