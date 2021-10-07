package com.auresgate.back.end.controller;

import com.auresgate.back.end.models.Pessoa;
import com.auresgate.back.end.models.Usuario;
import com.auresgate.back.end.repository.PessoaRepository;
import com.auresgate.back.end.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoa(){
        return ResponseEntity.ok().body(pessoaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(pessoaRepository.findById(id).get());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> adicionarPessoa(@RequestBody Pessoa pessoa){
        Pessoa pessoaSalvo = pessoaRepository.save(pessoa);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/pessoa").path("/{id}")
                .buildAndExpand(pessoaSalvo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
