package com.auresgate.back.end.repository;

import com.auresgate.back.end.models.Cidade;
import com.auresgate.back.end.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
