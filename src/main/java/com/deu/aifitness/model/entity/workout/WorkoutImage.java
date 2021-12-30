package com.deu.aifitness.model.entity.workout;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Table(name = "workout_image")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkoutImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String tag;

}
