package com.anderson.meu_projeto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.meu_projeto.dto.DadosCadastroProduto;
import com.anderson.meu_projeto.model.products.Products;
import com.anderson.meu_projeto.repository.ProductsRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsRepository repository;
    
    public ResponseEntity<String> cadastrarProduto(@RequestBody @Valid DadosCadastroProduto dados){
        Products produto = new Products(dados);
        repository.save(produto);
        
        return ResponseEntity.ok("Produto criado");
    }
}
