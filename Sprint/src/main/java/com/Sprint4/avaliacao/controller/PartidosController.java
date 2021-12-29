package com.Sprint4.avaliacao.controller;


import com.Sprint4.avaliacao.controller.dto.PartidosDto;
import com.Sprint4.avaliacao.partidos.Partidos;
import com.Sprint4.avaliacao.repository.PartidosRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidosController {
    @Autowired
    private PartidosRepository partidosRepository;

    @GetMapping
    public List<PartidosDto> lista(){
        List<Partidos> partidos = null;

        partidos = partidosRepository.findAll();

        return PartidosDto.converter(partidos);


    }

}
