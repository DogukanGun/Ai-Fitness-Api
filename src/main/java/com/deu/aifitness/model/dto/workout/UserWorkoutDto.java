package com.deu.aifitness.model.dto.workout;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserWorkoutDto {

    private String username;

    private String workoutName;

    private String image1;

    private String image2;

    private String image3;
}
