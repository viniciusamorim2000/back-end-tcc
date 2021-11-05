package com.auresgate.back.end.models;

import com.auresgate.back.end.models.enumeration.Sexo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Pessoa extends Usuario {

    private Integer idade;

    @OneToMany(mappedBy = "usuario_abriu_chamado")
    @JsonIgnore
    private List<Chamado> chamado_aberto;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

}

