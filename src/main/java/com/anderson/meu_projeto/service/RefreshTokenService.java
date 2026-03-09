package com.anderson.meu_projeto.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.anderson.meu_projeto.exception.CustomException;
import com.anderson.meu_projeto.model.RefreshToken;
import com.anderson.meu_projeto.repository.RefreshTokenRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenService {
    
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken geraRefreshToken(){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreatedDate(Instant.now());

        return refreshTokenRepository.save(refreshToken);
    }

    public void validateRefresh(String token){
        refreshTokenRepository.findByToken(token).orElseThrow(() -> new CustomException("Token refresh invalido!"));
    }

    public void deleteRefreshToken(String token){
        refreshTokenRepository.deleteByToken(token);
    }
}
