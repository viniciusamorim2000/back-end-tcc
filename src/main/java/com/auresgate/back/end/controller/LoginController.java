package com.auresgate.back.end.controller;

import com.auresgate.back.end.models.Ong;
import com.auresgate.back.end.models.Pessoa;
import com.auresgate.back.end.models.dto.LoginDTO;
import com.auresgate.back.end.repository.OngRepository;
import com.auresgate.back.end.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<LoginDTO> recuperarUsuario(@RequestParam String username, @RequestParam String senha){
        LoginDTO retorno = new LoginDTO();
        Pessoa pessoa = pessoaRepository.findPessoaByNome(username);
        if(pessoa != null && pessoa.getSenha().equals(senha)){
            retorno.setId(pessoa.getId());
            retorno.setNome(pessoa.getNome());
            retorno.setIsPerson(true);
        }else{
            Ong ong = ongRepository.findOngByNome(username);
            if(ong != null && ong.getSenha().equals(senha)){
                retorno.setId(ong.getId());
                retorno.setNome(ong.getNome());
                retorno.setIsPerson(false);
            }
        }
        return ResponseEntity.ok(retorno);
    }
}
