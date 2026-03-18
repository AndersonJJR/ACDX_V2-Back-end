package com.anderson.meu_projeto.model.products;

import com.anderson.meu_projeto.dto.DadosAtualizarProduto;
import com.anderson.meu_projeto.dto.DadosCadastroProduto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Produto")
@Table(name = "produtos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Products {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@OneToMany
    @JoinTable(name = "produto_id")
    private List<Venda> aparacicoesEmVendas;*/

    private String nome;
    @Enumerated (EnumType.STRING)
    private ProductsCategory categoria;
    private Double custo_unitario;
    private Integer tempo_producao_minutos;
    private Double preco_sugerido;
    private String descricao;

    private Boolean ativo;

    public Products(DadosCadastroProduto dados){
        this.nome = dados.nome();
        this.categoria = dados.categoria();
        this.custo_unitario = dados.custo_unitario();
        this.tempo_producao_minutos = dados.tempo_producao_minutos();
        this.preco_sugerido = dados.preco_sugerido();
        this.descricao = dados.descricao();
        this.ativo = true;
    }

    public void desabilitar() {
        this.ativo = false;
    }

    public void atualizarDados(DadosAtualizarProduto dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();}
        if (dados.categoria() != null) {
            this.categoria = dados.categoria();}
        if (dados.custo_unitario() != null){
            this.custo_unitario = dados.custo_unitario();}
        if (dados.tempo_producao_minutos() != null) {
            this.tempo_producao_minutos = dados.tempo_producao_minutos();}
        if (dados.preco_sugerido() != null) {
            this.preco_sugerido = dados.preco_sugerido();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
    }
}
