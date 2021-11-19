package com.auresgate.back.end.controller;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    public ResponseEntity<?> adicionarChamado(@RequestBody ChamadoDTO chamadoDTO) throws IOException {
        Pessoa pessoa = pessoaRepository.findById(chamadoDTO.getLoginDTO().getId()).get();


        Chamado chamado = new Chamado();
        chamado.setStatus(Status.ABERTO);
        chamado.setData_hora_abertura(new Date());
        chamado.setImagem(chamadoDTO.getImg());
        chamado.setAnimal(chamadoDTO.getAnimal());
        chamado.setUsuario_abriu_chamado(pessoa);

        Chamado chamadoSalvo = chamadoRepository.save(chamado);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/chamado").path("/{id}")
                .buildAndExpand(chamadoSalvo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @Value("${file.upload-dir}")
    String FILE_DIRETORIO;

    @PostMapping("/upload")
    public ResponseEntity<Object> fileUpload(@RequestParam("File") MultipartFile imagem) throws IOException {
        File file = new File(FILE_DIRETORIO+imagem.getOriginalFilename());
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(imagem.getBytes());
        fileOutputStream.close();
        return new ResponseEntity<Object>("Imagem salva com sucesso", HttpStatus.OK);
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


    @PutMapping("/finalizar/{id}")
    public void finalizarChamado(@RequestPart MultipartFile file, @PathVariable Integer id) throws IOException {
        Chamado chamado = chamadoRepository.findById(id).get();

        chamado.setImagem(file.getBytes());
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
