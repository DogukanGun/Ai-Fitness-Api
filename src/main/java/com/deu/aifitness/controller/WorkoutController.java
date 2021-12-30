package com.deu.aifitness.controller;

import com.deu.aifitness.model.dto.workout.WorkoutDto;
import com.deu.aifitness.model.dto.workout.WorkoutImageDto;
import com.deu.aifitness.model.request.workout.CreateWorkoutRequest;
import com.deu.aifitness.model.request.workout.UpdateWorkoutRequest;
import com.deu.aifitness.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("workout")
@RequiredArgsConstructor
public class WorkoutController {
    private final WorkoutService workoutService;

    @PostMapping
    public ResponseEntity<WorkoutDto> createWorkout(@RequestBody CreateWorkoutRequest createWorkoutRequest){
        return workoutService.createWorkout(createWorkoutRequest);
    }

    @PostMapping("update/{id}")
    public ResponseEntity<WorkoutDto> updateWorkout(@PathVariable int id, @RequestBody UpdateWorkoutRequest updateWorkoutRequest){
        return workoutService.updateWorkout(id, updateWorkoutRequest);
    }

    @GetMapping("workout/{id}")
    public ResponseEntity<WorkoutDto> getWorkout(@PathVariable int id){
        return workoutService.getWorkoutDto(id);
    }

    @GetMapping("workoutImage/{id}")
    public ResponseEntity<WorkoutImageDto> getWorkoutImage(@PathVariable int id){
        return workoutService.getWorkoutImageById(id);
    }

    @PatchMapping("updateRate/{id}")
    public ResponseEntity<WorkoutDto> changeRate(@PathVariable int id,@RequestParam double newRate){
        return workoutService.changeRate(id, newRate);
    }
}
