package com.deu.aifitness.model.dto.workout;


import com.deu.aifitness.model.entity.workout.WorkoutImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkoutDto {

    private Integer id;

    private String workoutName;

    private String workoutDescription;

    private double workoutRating;

    private WorkoutImageDto workoutImageDto;

}
