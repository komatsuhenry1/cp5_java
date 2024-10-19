package com.example.brinquedos.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "TDS_Sec_MVC_TB_Brinquedos")
public class Brinquedo {
    @Id
    @SequenceGenerator(name = "brinquedo_seq", sequenceName = "TDS_Sec_MVC_TB_Brinquedos_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brinquedo_seq")
    private Long id;

    private String nome;
    private String descricao;
    private double preco;

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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}