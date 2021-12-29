package com.Sprint4.avaliacao.partidos;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "partido")
public class Partidos {
    //nome, sigla, ideologia, data_fundacao
    private String nome;
    private IdeologiaEnun ideologia;
    private LocalDate dataFundacao;

    public Partidos(){
    }
    public Partidos(String nome, IdeologiaEnun ideologia, LocalDate dataFundacao){
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.ideologia = ideologia;
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
}