package com.deu.aifitness.service;

import com.deu.aifitness.model.dto.workout.WorkoutDto;
import com.deu.aifitness.model.entity.workout.Workout;
import com.deu.aifitness.model.request.workout.CreateWorkoutRequest;
import com.deu.aifitness.model.request.workout.UpdateWorkoutRequest;
import com.deu.aifitness.model.response.Response;
import com.deu.aifitness.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

import static com.deu.aifitness.model.mapper.WorkoutMapper.WORKOUT_MAPPER;

@Service
@RequiredArgsConstructor
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    //workout
    public ResponseEntity<WorkoutDto> createWorkout(CreateWorkoutRequest createWorkoutRequest){
        Workout workout = WORKOUT_MAPPER.createWorkout(createWorkoutRequest);
        workoutRepository.save(workout);
        WorkoutDto workoutDto = WORKOUT_MAPPER.convertToWorkoutDto(workout);
        return ResponseEntity.ok(workoutDto);
    }


    public ResponseEntity<List<WorkoutDto>> getAllWorkouts(){
        return ResponseEntity.ok(WORKOUT_MAPPER.convertToWorkoutDtoList(workoutRepository.findAll()));
    }

    public ResponseEntity<List<WorkoutDto>> getAllWorkoutByName(String name){
        return ResponseEntity.ok(WORKOUT_MAPPER.convertToWorkoutDtoList(workoutRepository.findByWorkoutName(name)));
    }

    public ResponseEntity<WorkoutDto> updateWorkout(int id,UpdateWorkoutRequest updateWorkoutRequest){
        Workout workout = getWorkout(id);
        WORKOUT_MAPPER.updateWorkout(workout,updateWorkoutRequest);
        workout = workoutRepository.save(workout);
        WorkoutDto workoutDto = WORKOUT_MAPPER.convertToWorkoutDto(workout);
        return ResponseEntity.ok(workoutDto);
    }

    public ResponseEntity deleteWorkout(int id){
        try {
            workoutRepository.deleteById(id);
            return ResponseEntity.ok(Response.builder()
                    .message("")
                    .status(HttpStatus.OK)
                    .build());
        }catch (Exception e){
            return ResponseEntity.ok(Response.builder()
                    .message(e.getLocalizedMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build());
        }
    }

    public ResponseEntity<WorkoutDto> changeRate(int id,double newRate){
        Workout workout = getWorkout(id);
        workout.setWorkoutRating(newRate);
        return ResponseEntity.ok(WORKOUT_MAPPER.convertToWorkoutDto(workout));
    }
    public ResponseEntity<WorkoutDto> getWorkoutDto(int id){
        Workout workout = getWorkout(id);
        WorkoutDto workoutDto = WORKOUT_MAPPER.convertToWorkoutDto(workout);
        return ResponseEntity.ok(workoutDto);
    }
    private Workout getWorkout(int id){
        return workoutRepository.findById(id).orElseThrow(()->new NotFoundException("Workout not found"));
    }
}
