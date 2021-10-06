package com.auresgate.back.end.controller;

import com.auresgate.back.end.models.Ong;
import com.auresgate.back.end.models.Pessoa;
import com.auresgate.back.end.repository.OngRepository;
import com.auresgate.back.end.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ongs")
public class OngController {
    @Autowired
    private OngRepository ongRepository;

    @GetMapping
    public ResponseEntity<List<Ong>> listarOng(){
        return ResponseEntity.ok().body(ongRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ong> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(ongRepository.findById(id).get());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> adicionarOng(@RequestBody Ong ong){
        Ong ongSalvo = ongRepository.save(ong);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/ong").path("/{id}")
                .buildAndExpand(ongSalvo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
