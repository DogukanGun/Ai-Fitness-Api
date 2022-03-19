package com.deu.aifitness.model.entity.workout;

import com.deu.aifitness.model.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_workout")
@SuperBuilder
@SQLDelete(sql="Update user_workout SET is_deleted = true where id = ?")
@Where(clause = "is_deleted=false")
public class UserWorkout extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String workoutName;

    @Column(length = 1350000)
    private String image1;

    @Column(length = 1350000)
    private String image2;

    @Column(length = 1350000)
    private String image3;

}
