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
}
