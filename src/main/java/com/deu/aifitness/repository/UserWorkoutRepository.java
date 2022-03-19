package com.deu.aifitness.repository;

import com.deu.aifitness.model.entity.workout.UserWorkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWorkoutRepository extends JpaRepository<UserWorkout,Integer> {
}
