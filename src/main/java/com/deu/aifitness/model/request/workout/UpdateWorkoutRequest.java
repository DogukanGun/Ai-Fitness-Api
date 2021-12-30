package com.deu.aifitness.model.request.workout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateWorkoutRequest {

    private String workoutName;

    private String workoutDescription;
}
