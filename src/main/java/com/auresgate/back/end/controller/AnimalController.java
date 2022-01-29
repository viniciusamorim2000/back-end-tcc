package com.auresgate.back.end.controller;

import com.auresgate.back.end.models.Animal;
import com.auresgate.back.end.models.Ong;
import com.auresgate.back.end.repository.AnimalRepository;
import com.auresgate.back.end.repository.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping
    public ResponseEntity<List<Animal>> listarAnimal(){
        return ResponseEntity.ok().body(animalRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(animalRepository.findById(id).get());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> adicionarAnimal(@RequestBody @Validated Animal animal){
        Animal animalSalvo = animalRepository.save(animal);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/animal").path("/{id}")
                .buildAndExpand(animalSalvo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Integer id){
        animalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteallAnimal(){
        animalRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
