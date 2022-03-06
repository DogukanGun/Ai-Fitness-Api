package com.deu.aifitness.model.entity.workout;


import com.deu.aifitness.model.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.swing.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "workout")
@SuperBuilder
@SQLDelete(sql="Update workout SET is_deleted = true where id = ?")
@Where(clause = "is_deleted=false")
public class Workout extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String workoutName;

    private String workoutDescription;

    private double workoutRating;

    private String workoutImage;

}
