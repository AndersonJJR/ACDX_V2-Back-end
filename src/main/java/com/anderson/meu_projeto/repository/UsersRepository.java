package com.anderson.meu_projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anderson.meu_projeto.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

    Optional<Users> findByUsername(String nome);
    
}
