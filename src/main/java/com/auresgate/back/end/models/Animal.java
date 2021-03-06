package com.auresgate.back.end.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String estado;
    private String descricao;

    @OneToOne(cascade = CascadeType.PERSIST)
    @NotNull
    private Localizacao localizacao;

    @JsonIgnore
    @OneToOne
    private Chamado chamado;

    @Lob
    private byte[] imagem;
}
