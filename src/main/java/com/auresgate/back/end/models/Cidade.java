package com.auresgate.back.end.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;
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
public class Cidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "cidade")
    @JsonIgnore
    private List<Endereco> enderecos;

    @ManyToOne()
    private Estado estado;
}
