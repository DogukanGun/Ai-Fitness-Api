package com.deu.aifitness.model.request.workout;


import com.deu.aifitness.model.entity.workout.WorkoutImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateWorkoutRequest {

    private String workoutName;

    private String workoutDescription;

    private double workoutRating;

    private Integer imageId;

    private CreateWorkoutImageRequest workoutImage;

}
