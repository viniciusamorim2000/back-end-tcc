package com.auresgate.back.end;

import com.auresgate.back.end.models.*;
import com.auresgate.back.end.repository.CidadeRepository;
import com.auresgate.back.end.repository.EstadoRepository;
import com.auresgate.back.end.repository.PessoaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AuresgateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuresgateApplication.class, args);
	}
}
