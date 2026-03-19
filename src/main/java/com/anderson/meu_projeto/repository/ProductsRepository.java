package com.anderson.meu_projeto.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import com.anderson.meu_projeto.model.products.Products;

public interface ProductsRepository extends JpaRepository<Products , Long>{
    
    @NativeQuery("SELECT * FROM produtos WHERE ativo = 1")
    List<Products> findAllByAtivo();

    @NativeQuery("SELECT * FROM produtos WHERE ativo = 0")
    List<Products> findAllByAtivoFalse();
}
