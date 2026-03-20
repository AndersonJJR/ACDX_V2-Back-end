package com.anderson.meu_projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anderson.meu_projeto.exception.CustomException;
import com.anderson.meu_projeto.model.products.Products;
import com.anderson.meu_projeto.repository.ProductsRepository;
import com.anderson.meu_projeto.storage.StorageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService {
    
    private final ProductsRepository productsRepository;
    private final StorageService storageService;

    public List<Products> listarProdutosAtivo(){

        List<Products> produtos = productsRepository.findAllByAtivo();
        return produtos;
    }

    public List<Products> listarProdutosInativos(){
        List<Products> produtos = productsRepository.findAllByAtivoFalse();
        return produtos;
    }

    public void salvarImagem(Long id , MultipartFile file){
        Products produto = productsRepository.findById(id)
        .orElseThrow(() -> new CustomException("Produto não encontrado"));

        String nomeArquivo = "produto_" + id + "_" + file.getOriginalFilename();
        storageService.store(file , nomeArquivo);

        String url = "/files/" + nomeArquivo;
        produto.atualizarImagem(url);
        productsRepository.save(produto);
    }

}
