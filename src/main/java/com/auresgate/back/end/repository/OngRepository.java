package com.auresgate.back.end.repository;

import com.auresgate.back.end.models.Ong;
import com.auresgate.back.end.models.Pessoa;
import com.auresgate.back.end.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OngRepository extends JpaRepository<Ong, Integer> {
    Ong findOngByNome(String nome);
}
