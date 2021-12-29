package com.Sprint4.avaliacao.controller;


import com.Sprint4.avaliacao.controller.dto.PartidosDto;
import com.Sprint4.avaliacao.controller.form.PartidosForm;
import com.Sprint4.avaliacao.partidos.Partidos;
import com.Sprint4.avaliacao.repository.PartidosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    @PostMapping
    @Transactional
    public ResponseEntity<PartidosDto> cadastrar(@RequestBody @Valid PartidosForm form, UriComponentsBuilder uriBuider){

        Partidos partidos = form.converter(form);
        partidosRepository.save(partidos);
        URI uri = uriBuider.path("/estados/{id}").buildAndExpand(partidos.getId()).toUri();
        return ResponseEntity.created(uri).body(new PartidosDto(partidos));
    }

}
