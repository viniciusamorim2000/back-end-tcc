package com.auresgate.back.end.models.dto;

import com.auresgate.back.end.models.Animal;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class ChamadoDTO {
    private Animal animal;

    private LoginDTO loginDTO;
}
