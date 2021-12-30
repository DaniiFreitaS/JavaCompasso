package com.Sprint4.avaliacao.repository;

import com.Sprint4.avaliacao.partidos.IdeologiaEnun;
import com.Sprint4.avaliacao.partidos.Partidos;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface PartidosRepository extends JpaRepository<Partidos, Long> {
    List<Partidos> findByIdeologia(@NotNull @NotEmpty @Length(max = 50) IdeologiaEnun ideologia);
}
