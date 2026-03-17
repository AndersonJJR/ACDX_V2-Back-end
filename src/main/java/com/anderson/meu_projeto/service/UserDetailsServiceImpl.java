package com.anderson.meu_projeto.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anderson.meu_projeto.model.Users;
import com.anderson.meu_projeto.repository.UsersRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
    
    private final UsersRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> userOptional = repository.findByEmail(email);
        Users user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Não existe usuário com esse email: " +
            email
        ));

        return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true , true , true , getAuthorities("USER"));
    }
    
     private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return List.of(new SimpleGrantedAuthority(role));
    }
}
