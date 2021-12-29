package com.Sprint4.Sprint4.partidos;
import javax.persistence.*;

@Entity
@Table()
public class Partidos {
    //nome, sigla, ideologia, data_fundacao
    private String nome;
    private IdeologiaEnun ideologia;
    private String dataFundacao;
}