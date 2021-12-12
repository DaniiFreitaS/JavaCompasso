package com.sprint3.avaliacao.controller;

import com.sprint3.avaliacao.controller.dto.EstadosDto;
import com.sprint3.avaliacao.controller.form.EstadosForm;
import com.sprint3.avaliacao.estados.Estados;
import com.sprint3.avaliacao.estados.RegioesEnum;
import com.sprint3.avaliacao.repository.EstadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estados")
public class EstadosController {
    @Autowired
    private EstadosRepository estadosRepository;

    @GetMapping
    public List<EstadosDto> lista(
            @RequestParam(required = false,value = "regiao") RegioesEnum regiao,
            @RequestParam(required = false,value = "filtro") String filtro
    ){
        List<Estados> estados = null;
        if(regiao == null && filtro == null){
            estados =  estadosRepository.findAll();
        }else if (regiao != null){
            estados = estadosRepository.findByRegiao(regiao);
        }else if (filtro != null){
                estados = estadosRepository.findAll(Sort.by(filtro).descending());
        }
        return EstadosDto.converter(estados);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EstadosDto> listaId(@PathVariable Long id){
        Optional<Estados>  listaid = estadosRepository.findById(id);
        if (listaid.isPresent()) {
            return ResponseEntity.ok(new EstadosDto(listaid.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EstadosDto> cadastrar(@RequestBody @Valid EstadosForm form, UriComponentsBuilder uriBuider){

        Estados estados = form.converter(form);
        estadosRepository.save(estados);
        URI uri = uriBuider.path("/estados/{id}").buildAndExpand(estados.getId()).toUri();
        return ResponseEntity.created(uri).body(new EstadosDto(estados));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EstadosDto> atualizar(@PathVariable Long id, @RequestBody @Valid EstadosForm form){
        Optional<Estados> verifica = estadosRepository.findById(id);
        if(verifica.isPresent()){
            Estados estados = form.atualizar(id, estadosRepository);
            return ResponseEntity.ok(new EstadosDto(estados));
        }
        return  ResponseEntity.notFound().build();
    }
    @DeleteMapping ("/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id){
        Optional<Estados> verifica = estadosRepository.findById(id);
        if(verifica.isPresent()){
            estadosRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.notFound().build();
    }




}
