package com.anderson.meu_projeto.dto;

import com.anderson.meu_projeto.model.products.ProductsCategory;

public record DadosAtualizarProduto(
    String nome,
    ProductsCategory categoria,
    Double custo_unitario,
    String descricao,
    Integer tempo_producao_minutos,
    Double preco_sugerido
    
) {
    
}
