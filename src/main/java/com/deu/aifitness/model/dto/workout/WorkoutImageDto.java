package com.deu.aifitness.model.dto.workout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkoutImageDto {

    private Integer id;

    private String tag;

}
