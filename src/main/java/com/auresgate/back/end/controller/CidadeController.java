package com.auresgate.back.end.controller;

import com.auresgate.back.end.models.Cidade;
import com.auresgate.back.end.models.Estado;
import com.auresgate.back.end.repository.CidadeRepository;
import com.auresgate.back.end.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public ResponseEntity<List<Cidade>> listarCidade(){
        return ResponseEntity.ok().body(cidadeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(cidadeRepository.findById(id).get());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> adicionarCidade(@RequestBody Cidade cidade){
        Cidade cidadeSalvo = cidadeRepository.save(cidade);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/cidade").path("/{id}")
                .buildAndExpand(cidadeSalvo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
