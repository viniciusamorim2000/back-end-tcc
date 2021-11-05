package com.auresgate.back.end.models;

import com.auresgate.back.end.models.enumeration.Status;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    private Date data_hora_abertura = new Date();

    private Date data_hora_fechamento;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Animal animal;

    @ManyToOne
    private Pessoa usuario_abriu_chamado;

    @ManyToOne
    private Usuario usuario_atendeu_chamado;

}
