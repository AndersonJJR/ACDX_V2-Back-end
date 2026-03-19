package com.anderson.meu_projeto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.anderson.meu_projeto.dto.DadosAtualizarProduto;
import com.anderson.meu_projeto.dto.DadosCadastroProduto;
import com.anderson.meu_projeto.dto.DadosListagemProduto;
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
    public ResponseEntity<DadosListagemProduto> cadastrarProduto(@RequestBody @Valid DadosCadastroProduto dados){
        Products produto = new Products(dados);
        repository.save(produto);
        
        return ResponseEntity.ok(new DadosListagemProduto(produto));
    }

    @PostMapping("/{id}/imagem")
    public ResponseEntity<Void> uploadImagem(@PathVariable Long id , @RequestParam("file") MultipartFile file){
        service.salvarImagem(id, file);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar-ativos")
    public ResponseEntity<List<Products>> listarProdutos(){
      return ResponseEntity.ok(service.listarProdutosAtivo());  
    }

    @GetMapping("/listar-inativos")
    public ResponseEntity<List<Products>> listarProdutosInativos(){
        return ResponseEntity.ok(service.listarProdutosInativos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<DadosListagemProduto> buscarProduto(@PathVariable Long id){
        Products produto = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosListagemProduto(produto));
    }

    @PutMapping("/{id}/desabilitar")
    @Transactional
    public ResponseEntity<Void> desabilitarProduto(@PathVariable Long id){
        Products produto = repository.getReferenceById(id);
        produto.desabilitar();
        repository.save(produto);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/habilitar")
    @Transactional
    public ResponseEntity<Void> habilitarProduto(@PathVariable Long id){
        Products produto = repository.getReferenceById(id);
        produto.habilitar();
        repository.save(produto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclusaoProduto(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<DadosListagemProduto> atualizarProduto(@PathVariable Long id , @RequestBody DadosAtualizarProduto dados){
        Products produto = repository.getReferenceById(id);
        produto.atualizarDados(dados);
        repository.save(produto);

        return ResponseEntity.ok(new DadosListagemProduto(produto));
    }

}
