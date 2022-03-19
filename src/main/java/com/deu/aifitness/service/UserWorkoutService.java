package com.deu.aifitness.service;

import com.deu.aifitness.model.dto.workout.UserWorkoutDto;
import com.deu.aifitness.model.entity.workout.UserWorkout;
import com.deu.aifitness.model.request.workout.CreateUserWorkoutRequest;
import com.deu.aifitness.repository.UserWorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.deu.aifitness.model.mapper.UserWorkoutMapper.USER_WORKOUT_MAPPER;

@Service
@RequiredArgsConstructor
public class UserWorkoutService {

    private final UserWorkoutRepository userWorkoutRepository;

    public UserWorkoutDto createUserWorkout(CreateUserWorkoutRequest createUserWorkoutRequest){
        UserWorkout userWorkout = USER_WORKOUT_MAPPER.createUserWorkout(createUserWorkoutRequest);
        return USER_WORKOUT_MAPPER.convertToUserWorkoutDto(userWorkoutRepository.save(userWorkout));
    }

}
