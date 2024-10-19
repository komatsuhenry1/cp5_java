package com.example.brinquedos.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor // Adiciona o construtor sem parâmetros
public class BrinquedoDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private String descricao;

    @NotNull
    private double preco;

    public BrinquedoDTO(Brinquedo brinquedo) {
        this.id = brinquedo.getId();
        this.nome = brinquedo.getNome();
        this.descricao = brinquedo.getDescricao();
        this.preco = brinquedo.getPreco();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
