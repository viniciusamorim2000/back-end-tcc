package com.auresgate.back.end.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String complemento;
    private Integer numero;
    private String bairro;

    @OneToMany(mappedBy = "endereco")
    @JsonIgnore
    private List<Usuario> usuarios;

    @ManyToOne()
    private Cidade cidade;
}
