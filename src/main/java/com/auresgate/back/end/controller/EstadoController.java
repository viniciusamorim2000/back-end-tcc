package com.auresgate.back.end.controller;

import com.auresgate.back.end.models.Cidade;
import com.auresgate.back.end.models.Estado;
import com.auresgate.back.end.models.Usuario;
import com.auresgate.back.end.repository.CidadeRepository;
import com.auresgate.back.end.repository.EstadoRepository;
import com.auresgate.back.end.repository.UsuarioRepository;
import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public ResponseEntity<List<Estado>> listarEstado(){
        return ResponseEntity.ok().body(estadoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(estadoRepository.findById(id).get());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> adicionarEstado(@RequestBody Estado estado){
        Estado estadoSalvo = estadoRepository.save(estado);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/estado").path("/{id}")
                .buildAndExpand(estadoSalvo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Integer id){
        estadoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
