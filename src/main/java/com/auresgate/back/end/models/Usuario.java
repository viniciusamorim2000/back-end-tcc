package com.auresgate.back.end.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario implements Serializable {

    @Id
    private Integer id;

    private String nome;
    private String email;
    private String senha;
    private String telefone;



}

