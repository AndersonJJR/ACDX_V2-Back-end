package com.anderson.meu_projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anderson.meu_projeto.model.products.Products;
import com.anderson.meu_projeto.repository.ProductsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService {
    
    private final ProductsRepository productsRepository;

    public List<Products> listarProdutos(){

        List<Products> produtos = productsRepository.findAll();
        return produtos;
    }


}
