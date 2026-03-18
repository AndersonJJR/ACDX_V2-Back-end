package com.anderson.meu_projeto.dto;

import com.anderson.meu_projeto.model.products.ProductsCategory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarProduto(
    @NotBlank
    String nome,
    @NotNull
    ProductsCategory categoria,
    Double custo_unitario,
    String descricao,
    Integer tempo_producao_minutos,
    Double preco_sugerido
    
) {
    
}
