package com.deu.aifitness.model.mapper;

import com.deu.aifitness.model.dto.workout.UserWorkoutDto;
import com.deu.aifitness.model.entity.workout.UserWorkout;
import com.deu.aifitness.model.request.workout.CreateUserWorkoutRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserWorkoutMapper {

    UserWorkoutMapper USER_WORKOUT_MAPPER = Mappers.getMapper(UserWorkoutMapper.class);

    UserWorkoutDto convertToUserWorkoutDto(UserWorkout userWorkout);

    UserWorkout createUserWorkout(CreateUserWorkoutRequest createUserWorkoutRequest);
}
