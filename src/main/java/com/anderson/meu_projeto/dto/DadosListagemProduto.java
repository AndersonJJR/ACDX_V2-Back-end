package com.anderson.meu_projeto.dto;

import com.anderson.meu_projeto.model.products.Products;
import com.anderson.meu_projeto.model.products.ProductsCategory;

public record DadosListagemProduto(
    Long id,
    String nome,
    ProductsCategory categoria,
    Double custo_unitario,
    String descricao,
    Boolean ativo,
    String imagemUrl
) {

    public DadosListagemProduto(Products dados) {
        this(dados.getId(), dados.getNome(), dados.getCategoria(),
    dados.getCusto_unitario(), dados.getDescricao(), dados.getAtivo(),
dados.getImagemUrl());
    }
}
