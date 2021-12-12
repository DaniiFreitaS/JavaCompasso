package com.sprint3.avaliacao.controller.dto;


import com.sprint3.avaliacao.estados.Estados;
import com.sprint3.avaliacao.estados.RegioesEnum;
import java.util.List;
import java.util.stream.Collectors;

public class EstadosDto {
    private Long id;
    private String nome;
    private RegioesEnum regiao;
    private int populacao;
    private String capital;
    private double area;

    public EstadosDto(Estados estados){
        this.id = estados.getId();
        this.nome = estados.getNome();
        this.regiao = estados.getRegiao();
        this.populacao = estados.getPopulacao();
        this.capital = estados.getCapital();
        this.area = estados.getArea();
    }
    public static List<EstadosDto> converter(List<Estados> estados){
        return estados.stream().map(EstadosDto::new).collect(Collectors.toList());
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
}
