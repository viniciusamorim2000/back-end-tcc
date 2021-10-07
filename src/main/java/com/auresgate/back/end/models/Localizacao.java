package com.auresgate.back.end.models;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String latitude;
    private String longitude;

    @OneToOne
    private Animal animal;
}
