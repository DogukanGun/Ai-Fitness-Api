package com.deu.aifitness.repository;

import com.deu.aifitness.model.entity.workout.WorkoutImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutImageRepository extends JpaRepository<WorkoutImage,Integer> {
}
