package com.auresgate.back.end.repository;

import com.auresgate.back.end.models.Pessoa;
import com.auresgate.back.end.models.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Pessoa findPessoaByNome(String nome);
}
