package com.deu.aifitness.model.dto.workout;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkoutDto {

    private Integer id;

    private String workoutName;

    private String workoutDescription;

    private double workoutRating;

    private String workoutImage;

}
