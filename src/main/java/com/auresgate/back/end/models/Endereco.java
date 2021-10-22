package com.auresgate.back.end.models;

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

    private String rua;
    private Integer numero;
    private String bairro;
    private String cep;

    @OneToMany(mappedBy = "endereco")
    private List<Usuario> usuarios;

    @ManyToOne()
    private Cidade cidade;
}
