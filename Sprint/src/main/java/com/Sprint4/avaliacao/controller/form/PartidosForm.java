package com.Sprint4.avaliacao.controller.form;

import com.Sprint4.avaliacao.partidos.IdeologiaEnun;
import com.Sprint4.avaliacao.partidos.Partidos;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PartidosForm {

    @NotNull
    @NotEmpty
    @Length(max = 50)
    private String nome;
    @Length(max = 20)
    private String sigla;
    @Enumerated(EnumType.STRING)
    private IdeologiaEnun ideologia;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy" , shape = JsonFormat.Shape.STRING )
    private LocalDate dataFundacao;

    public PartidosForm(){
    }
    public PartidosForm(Partidos partidos){
        this.nome = partidos.getNome();
        this.dataFundacao = partidos.getDataFundacao();
        this.ideologia = partidos.getIdeologia();
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

    public Partidos converter(PartidosForm partidos){
        return new Partidos(partidos.getNome(), partidos.getSigla(), partidos.getIdeologia(), partidos.getDataFundacao());

    }
}
