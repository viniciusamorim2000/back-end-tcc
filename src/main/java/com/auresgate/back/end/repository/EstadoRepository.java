package com.auresgate.back.end.repository;

import com.auresgate.back.end.models.Animal;
import com.auresgate.back.end.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
