package com.auresgate.back.end.models;

import com.auresgate.back.end.models.enumeration.Sexo;
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
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
}

