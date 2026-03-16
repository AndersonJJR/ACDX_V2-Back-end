package com.anderson.meu_projeto.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anderson.meu_projeto.dto.DadosAutenticacao;
import com.anderson.meu_projeto.dto.DadosLogin;
import com.anderson.meu_projeto.dto.DadosRefreshToken;
import com.anderson.meu_projeto.dto.DadosRegistroAutenticacao;
import com.anderson.meu_projeto.exception.CustomException;
import com.anderson.meu_projeto.model.NotificationEmail;
import com.anderson.meu_projeto.model.Users;
import com.anderson.meu_projeto.model.VerificationToken;
import com.anderson.meu_projeto.repository.UsersRepository;
import com.anderson.meu_projeto.repository.VerificationTokenRepository;
import com.anderson.meu_projeto.security.JwtProvider;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;
    
    public void signUp(DadosRegistroAutenticacao dados){
        Users user = new Users();
        user.setUsername(dados.username());
        user.setPassword(passwordEncoder.encode(dados.password()));
        user.setEmail(dados.email());
        user.setCreated(Instant.now());
        user.setEnabled(false);

        usersRepository.save(user);

        String token = generateVerificationToken(user);

        mailService.sendMail(new NotificationEmail("Por favor ative a sua conta",
         user.getEmail(), "Obrigado por se inscrever no nosso serviço, clique no link para validar seu email : " +
        "http://localhost:8080/api/v1/auth/accountVerification/" + token));
    }

    private String generateVerificationToken(Users user){
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUsers(user);

        verificationTokenRepository.save(verificationToken);
        return token;
    }

    private void buscarUsuarioEValidar(VerificationToken verificationToken){
        String nome = verificationToken.getUsers().getUsername();
        Users user = usersRepository.findByUsername(nome).orElseThrow(() -> new CustomException("Usuário não encontrado!"));
        user.setEnabled(true);
        usersRepository.save(user);
    }

    public void verificarConta(String token){
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        buscarUsuarioEValidar(verificationToken.orElseThrow(() -> new CustomException("Token invalido!")));
    }

    public DadosAutenticacao login(DadosLogin login){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(login.email(),login.password()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtProvider.gerarToken(authentication);
            return DadosAutenticacao.builder()
            .authenticationToken(token)
            .refreshToken(refreshTokenService.geraRefreshToken().getToken())
            .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpiracaoEmMillis()))
            .username(login.email())
            .build();
    }

    public DadosAutenticacao refreshToken(DadosRefreshToken dadosRefreshToken){
        refreshTokenService.validateRefresh(dadosRefreshToken.refreshToken());
        String token = jwtProvider.gerarTokenComNome(dadosRefreshToken.username());
        return DadosAutenticacao.builder()
            .authenticationToken(token)
            .refreshToken(dadosRefreshToken.refreshToken())
            .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpiracaoEmMillis()))
            .username(dadosRefreshToken.username())
            .build();
    }

    public Boolean estaLogado(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }
}
