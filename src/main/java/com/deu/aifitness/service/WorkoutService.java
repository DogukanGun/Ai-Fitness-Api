package com.deu.aifitness.service;

import com.deu.aifitness.model.dto.workout.WorkoutDto;
import com.deu.aifitness.model.dto.workout.WorkoutImageDto;
import com.deu.aifitness.model.entity.workout.Workout;
import com.deu.aifitness.model.entity.workout.WorkoutImage;
import com.deu.aifitness.model.request.workout.CreateWorkoutImageRequest;
import com.deu.aifitness.model.request.workout.CreateWorkoutRequest;
import com.deu.aifitness.model.request.workout.UpdateWorkoutRequest;
import com.deu.aifitness.model.response.Response;
import com.deu.aifitness.repository.WorkoutImageRepository;
import com.deu.aifitness.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.jdbc.Work;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import static com.deu.aifitness.model.mapper.WorkoutMapper.WORKOUT_MAPPER;

@Service
@RequiredArgsConstructor
public class WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final WorkoutImageRepository workoutImageRepository;

    //workout
    public ResponseEntity<WorkoutDto> createWorkout(CreateWorkoutRequest createWorkoutRequest){
        WorkoutImage workoutImage = WORKOUT_MAPPER.createWorkoutImage(createWorkoutRequest.getWorkoutImage());
        workoutImageRepository.save(workoutImage);
        createWorkoutRequest.setImageId(workoutImage.getId());
        Workout workout = WORKOUT_MAPPER.createWorkout(createWorkoutRequest);
        workoutRepository.save(workout);
        WorkoutDto workoutDto = WORKOUT_MAPPER.convertToWorkoutDto(workout);
        return ResponseEntity.ok(workoutDto);
    }
    public ResponseEntity<WorkoutDto> updateWorkout(int id,UpdateWorkoutRequest updateWorkoutRequest){
        Workout workout = getWorkout(id);
        WORKOUT_MAPPER.updateWorkout(workout,updateWorkoutRequest);
        workout = workoutRepository.save(workout);
        WorkoutDto workoutDto = WORKOUT_MAPPER.convertToWorkoutDto(workout);
        return ResponseEntity.ok(workoutDto);
    }

    public Response deleteWorkout(int id){
        Workout workout = getWorkout(id);
        try {
            workoutRepository.deleteById(id);

        }catch (Exception e){
            return Response.builder()
                    .message(e.getLocalizedMessage())
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
        return Response.builder()
                .message("")
                .status(HttpStatus.OK)
                .build();
    }

    public ResponseEntity<WorkoutImageDto> getWorkoutImageById(int id){
        WorkoutImageDto workoutImageDto =  WORKOUT_MAPPER.convertToWorkoutImageDto(getWorkoutImage(id));

        return ResponseEntity.ok(workoutImageDto);
    }

    public ResponseEntity<WorkoutDto> getWorkoutDto(int id){
        Workout workout = getWorkout(id);
        WorkoutDto workoutDto = WORKOUT_MAPPER.convertToWorkoutDto(workout);
        WorkoutImageDto workoutImageDto = WORKOUT_MAPPER.convertToWorkoutImageDto(getWorkoutImage(workout.getImageId()));
        workoutDto.setWorkoutImageDto(workoutImageDto);
        return ResponseEntity.ok(workoutDto);
    }
    private Workout getWorkout(int id){
        return workoutRepository.findById(id).orElseThrow(()->new NotFoundException("Workout not found"));
    }
    private WorkoutImage getWorkoutImage(int id){
        return workoutImageRepository.findById(id).orElseThrow(()->new NotFoundException("Workout not found"));
    }

}
