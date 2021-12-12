package com.sprint3.avaliacao.estados;

import javax.persistence.*;

@Entity
@Table(name = "ESTADOS")
public class Estados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private RegioesEnum regiao;
    private int populacao;
    private String capital;
    private double area;

    public Estados() {
    }

    public Estados(String nome, RegioesEnum regiao, int populacao, String capital, double area) {
        this.nome = nome;
        this.regiao = regiao;
        this.populacao = populacao;
        this.capital = capital;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public RegioesEnum getRegiao() {
        return regiao;
    }

    public int getPopulacao() {
        return populacao;
    }

    public String getCapital() {
        return capital;
    }

    public double getArea() {
        return area;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRegiao(RegioesEnum regiao) {
        this.regiao = regiao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setArea(double area) {
        this.area = area;
    }
}