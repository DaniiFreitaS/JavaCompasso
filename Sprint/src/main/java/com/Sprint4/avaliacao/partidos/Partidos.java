package com.Sprint4.avaliacao.partidos;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "partido")
public class Partidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;
    @Enumerated(EnumType.STRING)
    private IdeologiaEnun ideologia;
    private LocalDate dataFundacao;

    public Partidos(){
    }
    public Partidos(String nome,String sigla, IdeologiaEnun ideologia, LocalDate dataFundacao){
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.ideologia = ideologia;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

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