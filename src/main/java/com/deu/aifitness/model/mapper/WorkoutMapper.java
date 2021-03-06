package com.deu.aifitness.model.mapper;

import com.deu.aifitness.model.dto.workout.WorkoutDto;
import com.deu.aifitness.model.entity.workout.Workout;
import com.deu.aifitness.model.request.workout.CreateWorkoutRequest;
import com.deu.aifitness.model.request.workout.UpdateWorkoutRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WorkoutMapper {
    WorkoutMapper WORKOUT_MAPPER = Mappers.getMapper(WorkoutMapper.class);

    Workout createWorkout(CreateWorkoutRequest createWorkoutRequest);

    WorkoutDto convertToWorkoutDto(Workout workout);

    void updateWorkout(@MappingTarget Workout workout, UpdateWorkoutRequest updateWorkoutRequest);

    List<WorkoutDto> convertToWorkoutDtoList(List<Workout> workoutList);
}
