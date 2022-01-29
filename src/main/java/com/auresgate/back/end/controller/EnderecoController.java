package com.auresgate.back.end.controller;


import com.auresgate.back.end.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("endereco")
public class EnderecoController {
    @Autowired
    private EnderecoRepository addressRepository;

    @DeleteMapping("")
    public ResponseEntity<Void> deletePessoa(){
        addressRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
