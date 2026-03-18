package com.anderson.meu_projeto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.anderson.meu_projeto.dto.DadosCadastroProduto;
import com.anderson.meu_projeto.model.products.Products;
import com.anderson.meu_projeto.repository.ProductsRepository;
import com.anderson.meu_projeto.service.ProductsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsRepository repository;
    private final ProductsService service;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarProduto(@RequestBody @Valid DadosCadastroProduto dados){
        Products produto = new Products(dados);
        repository.save(produto);
        
        return ResponseEntity.ok("Produto criado");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Products>> listarProdutos(){
      return ResponseEntity.ok(service.listarProdutos());  
    }


}
