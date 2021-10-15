package com.auresgate.back.end.controller;

import com.auresgate.back.end.models.Usuario;
import com.auresgate.back.end.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuario(){
        return ResponseEntity.ok().body(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(usuarioRepository.findById(id).get());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> adicionarUsuario(@RequestBody @Validated Usuario usuario){
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/usuario").path("/{id}")
                .buildAndExpand(usuarioSalvo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
