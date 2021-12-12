package com.sprint3.avaliacao.controller.form;

import com.sprint3.avaliacao.controller.dto.EstadosDto;
import com.sprint3.avaliacao.estados.Estados;
import com.sprint3.avaliacao.estados.RegioesEnum;
import com.sprint3.avaliacao.repository.EstadosRepository;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.stream.Collectors;

public class EstadosForm {
    @NotNull
    @NotEmpty @Length(max = 50)
    private String nome;
    @Enumerated(EnumType.STRING)
    private RegioesEnum regiao;
    @Range(min = 0)
    private int populacao;
    @NotNull @NotEmpty @Length(max = 50)
    private String capital;
    @Range(min = 0)
    private double area;

    public EstadosForm(){}

    public EstadosForm(Estados estados){
        this.nome = estados.getNome();
        this.regiao = estados.getRegiao();
        this.populacao = estados.getPopulacao();
        this.capital = estados.getCapital();
        this.area = estados.getArea();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public RegioesEnum getRegiao() {
        return regiao;
    }
    public void setRegiao(RegioesEnum regiao) {
        this.regiao = regiao;
    }
    public int getPopulacao() {
        return populacao;
    }
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public Estados atualizar(Long id, EstadosRepository estadosRepository) {
        Estados estado = estadosRepository.getById(id);
        estado.setNome(this.nome);
        estado.setArea(this.area);
        estado.setCapital(this.capital);
        estado.setPopulacao(this.populacao);
        estado.setRegiao(this.regiao);

        return estado;
    }
    public Estados converter(EstadosForm estados){
        return new Estados(estados.getNome(), estados.getRegiao(), estados.getPopulacao(), estados.getCapital(), estados.getArea());
    }
}
