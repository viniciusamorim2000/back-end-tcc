package com.auresgate.back.end.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Chamado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Animal animal;

    @ManyToOne
    private Pessoa usuario_abriu_chamado;

    @ManyToOne
    private Usuario usuario_atendeu_chamado;

}
