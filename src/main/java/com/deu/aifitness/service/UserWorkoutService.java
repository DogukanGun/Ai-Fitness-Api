package com.deu.aifitness.service;

import com.deu.aifitness.model.dto.workout.UploadWorkoutDto;
import com.deu.aifitness.model.dto.workout.UserWorkoutDto;
import com.deu.aifitness.model.entity.workout.UserWorkout;
import com.deu.aifitness.model.request.workout.CreateUserWorkoutRequest;
import com.deu.aifitness.model.request.workout.UploadWorkoutRequest;
import com.deu.aifitness.repository.UserWorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.deu.aifitness.model.mapper.UserWorkoutMapper.USER_WORKOUT_MAPPER;

@Service
@RequiredArgsConstructor
public class UserWorkoutService {

    private final UserWorkoutRepository userWorkoutRepository;

    public UserWorkoutDto createUserWorkout(CreateUserWorkoutRequest createUserWorkoutRequest){
        UserWorkout userWorkout = USER_WORKOUT_MAPPER.createUserWorkout(createUserWorkoutRequest);
        return USER_WORKOUT_MAPPER.convertToUserWorkoutDto(userWorkoutRepository.save(userWorkout));
    }

    public UploadWorkoutDto uploadWorkoutRequest(UploadWorkoutRequest uploadWorkoutRequest){
        //burada makine öğrenemsi için modele git
        List<String> list = new ArrayList<>();
        list.add("deneme 1");
        list.add("deneme 2");
        return UploadWorkoutDto.builder().workoutImages(list).build();
    }
}
