package com.sprint3.avaliacao.repository;

import com.sprint3.avaliacao.estados.Estados;
import com.sprint3.avaliacao.estados.RegioesEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.*;
import java.util.List;

public interface EstadosRepository extends JpaRepository<Estados, Long> {
    List<Estados> findByRegiao(@NotNull @NotEmpty @Length(max = 50) RegioesEnum regiao);

}
