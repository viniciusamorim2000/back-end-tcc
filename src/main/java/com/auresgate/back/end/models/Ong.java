package com.auresgate.back.end.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Ong extends Usuario {

    private String cnpj;
}

