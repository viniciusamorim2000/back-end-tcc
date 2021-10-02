package com.auresgate.back.end.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "TB_USUARIO")
@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String senha;
    private String telefone;



}

