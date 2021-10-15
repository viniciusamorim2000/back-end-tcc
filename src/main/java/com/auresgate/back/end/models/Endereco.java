package com.auresgate.back.end.models;

import com.sun.istack.internal.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Required;

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

    @OneToMany
    private List<Usuario> usuarios;
    @ManyToOne
    private Cidade cidade;
}
