package com.auresgate.back.end.models;

import lombok.*;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Pessoa extends Usuario {

    private Integer idade;
    private String sexo;
}

