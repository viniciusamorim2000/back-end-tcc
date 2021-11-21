package com.auresgate.back.end;

import com.auresgate.back.end.models.*;
import com.auresgate.back.end.repository.CidadeRepository;
import com.auresgate.back.end.repository.EstadoRepository;
import com.auresgate.back.end.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AuresgateApplication implements CommandLineRunner{

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuresgateApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Estado estado1 = new Estado(null,"Acre","AC",null);
		Estado estado2 = new Estado(null,"Alagoas","AL",null);
		Estado estado3 = new Estado(null,"Amapá","AP",null);
		Estado estado4 = new Estado(null,"Amazonas","AM",null);
		Estado estado5 = new Estado(null,"Bahia","BA",null);
		Estado estado6 = new Estado(null,"Ceará","CE",null);
		Estado estado7 = new Estado(null,"Distrito Federal","DF",null);
		Estado estado8 = new Estado(null,"Espírito Santo","ES",null);
		Estado estado9 = new Estado(null,"Goiás","GO",null);
		Estado estado10 = new Estado(null,"Maranhão","MA",null);
		Estado estado11 = new Estado(null,"Mato Grosso","MT",null);
		Estado estado12 = new Estado(null,"Mato Grosso do Sul","MS",null);
		Estado estado13 = new Estado(null,"Minas Gerais","MG",null);
		Estado estado14 = new Estado(null,"Pará","PA",null);
		Estado estado15 = new Estado(null,"Paraíba","PB",null);
		Estado estado16 = new Estado(null,"Paraná","PR",null);
		Estado estado17 = new Estado(null,"Pernambuco","PE",null);
		Estado estado18 = new Estado(null,"Piauí","PI",null);
		Estado estado19 = new Estado(null,"Rio de Janeiro","RJ",null);
		Estado estado20 = new Estado(null,"Rio Grande do Norte","RN",null);
		Estado estado21 = new Estado(null,"Rio Grande do Sul","RS",null);
		Estado estado22 = new Estado(null,"Rondônia","RO",null);
		Estado estado23 = new Estado(null,"Roraima","RR",null);
		Estado estado24 = new Estado(null,"Santa Catarina","SC",null);
		Estado estado25 = new Estado(null,"São Paulo","SP",null);
		Estado estado26 = new Estado(null,"Sergipe","SE",null);
		Estado estado27 = new Estado(null,"Tocantins","TO",null);

		Cidade cidade = new Cidade(null,"Brasília",null,estado7);

		estadoRepository.saveAll(Arrays.asList(estado1,estado2 ,estado3 ,estado4 ,estado5 ,estado6 ,estado7 ,estado8 ,estado9 ,estado10,estado11,estado12,estado13,estado14,estado15,estado16,estado17,estado18,estado19,estado20,estado21,estado22,estado23,estado24,estado25,estado26,estado27));
		cidadeRepository.save(cidade);
	}
}
