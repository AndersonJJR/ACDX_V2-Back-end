package com.anderson.meu_projeto.dto;

import com.anderson.meu_projeto.model.products.ProductsCategory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProduto(
        @NotBlank(message = "Nome não pode ser vazio") String nome,
        @NotNull(message = "Categoria não pode ser vazia") ProductsCategory categoria,
        @NotNull(message = "Custo unitário não pode ser nulo") Double custo_unitario,

        Integer tempo_producao_minutos,

        Double preco_sugerido) {
    
}
