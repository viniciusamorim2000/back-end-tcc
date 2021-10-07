package com.auresgate.back.end.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String endereco;
    private String nome;
    private String email;
    private String senha;
    private String telefone;

}

