package com.deu.aifitness.controller;

import com.deu.aifitness.model.dto.workout.UserWorkoutDto;
import com.deu.aifitness.model.dto.workout.WorkoutDto;
import com.deu.aifitness.model.request.workout.CreateUserWorkoutRequest;
import com.deu.aifitness.model.request.workout.CreateWorkoutRequest;
import com.deu.aifitness.model.request.workout.UpdateWorkoutRequest;
import com.deu.aifitness.service.UserWorkoutService;
import com.deu.aifitness.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import org.hibernate.jdbc.Work;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workout")
@RequiredArgsConstructor
public class WorkoutController {
    private final WorkoutService workoutService;
    private final UserWorkoutService userWorkoutService;

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

    @PostMapping("updateRate/{id}")
    public ResponseEntity<WorkoutDto> changeRate(@PathVariable int id,@RequestParam double newRate){
        return workoutService.changeRate(id, newRate);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity deleteWorkout(@PathVariable int id){
        return workoutService.deleteWorkout(id);
    }

    @PostMapping("workout/name/{name}")
    public ResponseEntity<List<WorkoutDto>> getWorkoutsByName(@PathVariable String name){
        return workoutService.getAllWorkoutByName(name);
    }

    @PostMapping("workout/all")
    public ResponseEntity<List<WorkoutDto>> getWorkouts(){
        return workoutService.getAllWorkouts();
    }

    @PostMapping("userworkout/upload")
    public UserWorkoutDto uploadUserWorkout(@RequestBody CreateUserWorkoutRequest createUserWorkoutRequest){
        return userWorkoutService.createUserWorkout(createUserWorkoutRequest);
    }

}
