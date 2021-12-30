package com.Sprint4.avaliacao.controller;


import com.Sprint4.avaliacao.controller.dto.PartidosDto;
import com.Sprint4.avaliacao.controller.form.PartidosForm;
import com.Sprint4.avaliacao.partidos.IdeologiaEnun;
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
import java.util.Optional;

@RestController
@RequestMapping("/partidos")
public class PartidosController {
    @Autowired
    private PartidosRepository partidosRepository;

    @GetMapping
    public List<PartidosDto> lista(
            @RequestParam(required = false,value = "ideologia")IdeologiaEnun ideologia
    ){
        List<Partidos> partidos = null;
        if(ideologia != null){

            partidos = partidosRepository.findByIdeologia(ideologia);
        }else {
            partidos = partidosRepository.findAll();
        }
        return PartidosDto.converter(partidos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PartidosDto> listaId(@PathVariable Long id){
        Optional<Partidos>  listaid = partidosRepository.findById(id);
        if (listaid.isPresent()) {
            return ResponseEntity.ok(new PartidosDto(listaid.get()));
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    @Transactional
    public ResponseEntity<PartidosDto> cadastrar(@RequestBody @Valid PartidosForm form, UriComponentsBuilder uriBuider){

        Partidos partidos = form.converter(form);
        partidosRepository.save(partidos);
        URI uri = uriBuider.path("/estados/{id}").buildAndExpand(partidos.getId()).toUri();
        return ResponseEntity.created(uri).body(new PartidosDto(partidos));
    }

    @DeleteMapping ("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id){
        Optional<Partidos> verifica = partidosRepository.findById(id);
        if(verifica.isPresent()){
            partidosRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.notFound().build();
    }

}
