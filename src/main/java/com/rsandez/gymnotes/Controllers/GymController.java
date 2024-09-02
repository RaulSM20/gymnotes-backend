package com.rsandez.gymnotes.Controllers;

import com.rsandez.gymnotes.Entities.Exercise;
import com.rsandez.gymnotes.Entities.Routine;
import com.rsandez.gymnotes.Entities.RoutineExercise;
import com.rsandez.gymnotes.Service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gym")
public class GymController {

    @Autowired
    private GymService gymService;

     //  endpoints

    @GetMapping("/routines")
    public List<Routine> getAllRoutines() {
        return gymService.getAllRoutines();
    }
    
    @GetMapping("/routines/{id}")
    public Routine getRoutineWithExercises(@PathVariable Integer id) {
        return gymService.getRoutineWithExercises(id);
    }

    @PostMapping("/routines")
    public Routine createRoutine(@RequestBody Routine routine) {
        return gymService.saveRoutine(routine);
    }

    @GetMapping("/exercises")
    public List<Exercise> getAllExercises() {
        return gymService.getAllExercises();
    }

    @PostMapping("/exercises")
    public Exercise createExercise(@RequestBody Exercise exercise) {
        return gymService.saveExercise(exercise);
    }

    @PostMapping("/routine-exercises")
    public RoutineExercise createRoutineExercise(@RequestBody RoutineExercise routineExercise) {
        return gymService.saveRoutineExercise(routineExercise);
    }

    @PostMapping("/addExerciseToRoutine")
    public RoutineExercise addExerciseToRoutine(
            @RequestParam Integer routineId,
            @RequestParam Integer exerciseId,
            @RequestParam int numSeries,
            @RequestParam int numRep,
            @RequestParam int rir) {
        return gymService.addExerciseToRoutine(routineId, exerciseId, numSeries, numRep, rir);
    }
   
}
