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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public ResponseEntity<List<Cidade>> listarCidade(){
        return ResponseEntity.ok().body(cidadeRepository.findAll());
    }

    @GetMapping("/estado/{id}")
    public ResponseEntity<List<Cidade>> listarCidadePorEstado(@PathVariable Integer id){
        return ResponseEntity.ok().body(cidadeRepository.findAll().stream().filter( c -> {
            return c.getEstado().getId().equals(id);
        }).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(cidadeRepository.findById(id).get());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> adicionarCidade(@RequestBody Cidade cidade){
        Estado estado = estadoRepository.findById(cidade.getEstado().getId()).get();
        cidade.setEstado(estado);
        Cidade cidadeSalvo = cidadeRepository.save(cidade);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/cidade").path("/{id}")
                .buildAndExpand(cidadeSalvo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCidade(@PathVariable Integer id){
        cidadeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> deleteCidades(){
        cidadeRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
