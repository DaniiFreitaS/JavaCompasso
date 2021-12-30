package com.Sprint4.avaliacao.controller.dto;

import com.Sprint4.avaliacao.partidos.IdeologiaEnun;
import com.Sprint4.avaliacao.partidos.Partidos;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PartidosDto {

    private String nome;
    private String sigla;
    private IdeologiaEnun ideologia;
    @JsonFormat(pattern = "dd/MM/yyyy" , shape = JsonFormat.Shape.STRING )
    private LocalDate dataFundacao;

    public PartidosDto(Partidos partidos){
        this.nome = partidos.getNome();
        this.sigla = partidos.getSigla();
        this.dataFundacao = partidos.getDataFundacao();
        this.ideologia = partidos.getIdeologia();
    }

    public static List<PartidosDto> converter(List<Partidos> partidos){
        return partidos.stream().map(PartidosDto::new).collect(Collectors.toList());
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public IdeologiaEnun getIdeologia() {
        return ideologia;
    }

    public void setIdeologia(IdeologiaEnun ideologia) {
        this.ideologia = ideologia;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
