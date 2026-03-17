package com.anderson.meu_projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anderson.meu_projeto.model.products.Products;

public interface ProductsRepository extends JpaRepository<Products , Long>{
    
}
