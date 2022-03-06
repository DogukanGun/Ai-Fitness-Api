package com.deu.aifitness.repository;

import com.deu.aifitness.model.entity.workout.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Integer> {
    List<Workout> findByWorkoutName(String name);
}
