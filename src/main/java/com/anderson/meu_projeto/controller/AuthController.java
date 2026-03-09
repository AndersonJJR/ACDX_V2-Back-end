package com.anderson.meu_projeto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.meu_projeto.dto.DadosAutenticacao;
import com.anderson.meu_projeto.dto.DadosLogin;
import com.anderson.meu_projeto.dto.DadosRefreshToken;
import com.anderson.meu_projeto.dto.DadosRegistroAutenticacao;
import com.anderson.meu_projeto.service.AuthService;
import com.anderson.meu_projeto.service.RefreshTokenService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;
    
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody @Valid DadosRegistroAutenticacao dados){
        authService.signUp(dados);
        
        return ResponseEntity.ok("Cadastro de Usuário realizado com sucesso");
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token){
        authService.verificarConta(token);
        return ResponseEntity.ok("Conta verificada com sucesso");
    }

    @PostMapping("/login")
    public DadosAutenticacao login(@RequestBody DadosLogin login){
        return authService.login(login);
    }

    @PostMapping("/refresh/token")
    public DadosAutenticacao refreshToken(@Valid @RequestBody DadosRefreshToken dadosRefreshToken){
        return authService.refreshToken(dadosRefreshToken); 
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody DadosRefreshToken dadosRefreshToken){
        refreshTokenService.deleteRefreshToken(dadosRefreshToken.refreshToken());
        return ResponseEntity.ok("Refresh Token deletado com sucesso!");
    }
}
