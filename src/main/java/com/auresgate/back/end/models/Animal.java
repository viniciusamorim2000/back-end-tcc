package com.auresgate.back.end.models;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.*;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String sexo;
    private String raca;
    private String estado;
    private String descricao;

    @OneToOne
    @NotNull
    private Localizacao localizacao;

    @OneToOne
    private Chamado chamado;
}
