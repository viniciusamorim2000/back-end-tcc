package com.auresgate.back.end.controller;

import com.auresgate.back.end.models.Animal;
import com.auresgate.back.end.models.Chamado;
import com.auresgate.back.end.models.Pessoa;
import com.auresgate.back.end.models.Usuario;
import com.auresgate.back.end.models.dto.ChamadoDTO;
import com.auresgate.back.end.models.dto.ChamadoResgateDTO;
import com.auresgate.back.end.models.dto.LoginDTO;
import com.auresgate.back.end.models.enumeration.Status;
import com.auresgate.back.end.repository.ChamadoRepository;
import com.auresgate.back.end.repository.OngRepository;
import com.auresgate.back.end.repository.PessoaRepository;
import com.auresgate.back.end.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {
    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Chamado>> listarChamado(){
        return ResponseEntity.ok().body(chamadoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chamado> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(chamadoRepository.findById(id).get());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> adicionarChamado(@RequestBody @Validated ChamadoDTO chamadoDTO){
        Pessoa pessoa = pessoaRepository.findById(chamadoDTO.getLoginDTO().getId()).get();

        Chamado chamado = new Chamado();
        chamado.setStatus(Status.ABERTO);
        chamado.setData_hora_abertura(new Date());
        chamado.setAnimal(chamadoDTO.getAnimal());
        chamado.setUsuario_abriu_chamado(pessoa);

        Chamado chamadoSalvo = chamadoRepository.save(chamado);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/chamado").path("/{id}")
                .buildAndExpand(chamadoSalvo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public void associarUsuarioResgate(@RequestBody ChamadoResgateDTO chamadoResgateDTO){
        Chamado chamado = chamadoRepository.findById(chamadoResgateDTO.getIdChamado()).get();

        Usuario usuario = chamadoResgateDTO.getLoginDTO().getIsPerson() ?
            usuarioRepository.findUsuarioByEmail(pessoaRepository.findById(chamadoResgateDTO.getLoginDTO().getId()).get().getEmail())
                    : usuarioRepository.findUsuarioByEmail(ongRepository.findById(chamadoResgateDTO.getLoginDTO().getId()).get().getEmail());

        chamado.setUsuario_atendeu_chamado(usuario);
        chamado.setStatus(Status.ANDAMENTO);

        chamadoRepository.save(chamado);
    }


    @PutMapping
    public void finalizarChamado(@RequestBody ChamadoResgateDTO chamadoResgateDTO){
        Chamado chamado = chamadoRepository.findById(chamadoResgateDTO.getIdChamado()).get();

        chamado.setStatus(Status.FECHADO);
        chamado.setData_hora_fechamento(new Date());

        chamadoRepository.save(chamado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteChamado(@PathVariable Integer id){
        chamadoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteChamado(){
        chamadoRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
