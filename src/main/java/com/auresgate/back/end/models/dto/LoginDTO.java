package com.auresgate.back.end.models.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class LoginDTO {
    private Integer id;
    private String nome;
    private Boolean isPerson;
}
