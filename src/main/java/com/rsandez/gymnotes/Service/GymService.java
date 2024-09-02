package com.rsandez.gymnotes.Service;

import com.rsandez.gymnotes.Entities.Exercise;
import com.rsandez.gymnotes.Entities.Routine;
import com.rsandez.gymnotes.Entities.RoutineExercise;
import com.rsandez.gymnotes.Repositories.ExerciseRepository;
import com.rsandez.gymnotes.Repositories.RoutineExerciseRepository;
import com.rsandez.gymnotes.Repositories.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GymService {

    @Autowired
    private RoutineRepository routineRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private RoutineExerciseRepository routineExerciseRepository;

    // Metodos para manejar las operaciones de rutina, ejercicio, y rutina-ejercicio.

    public List<Routine> getAllRoutines() {
        return routineRepository.findAll();
    }
    public Routine getRoutineWithExercises(@PathVariable Integer id) {
        return routineRepository.findRoutineWithExercises(id);
    }

    public Routine saveRoutine(Routine routine) {
        return routineRepository.save(routine);
    }
    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public RoutineExercise saveRoutineExercise(RoutineExercise routineExercise) {
        return routineExerciseRepository.save(routineExercise);
    }

    public RoutineExercise addExerciseToRoutine(Integer routineId, Integer exerciseId, int numSeries, int numRep, int rir) {
        Routine routine = routineRepository.findById(routineId).orElseThrow(() -> new RuntimeException("Routine not found"));
        Exercise exercise = exerciseRepository.findById(exerciseId).orElseThrow(() -> new RuntimeException("Exercise not found"));

        RoutineExercise routineExercise = RoutineExercise.builder()
                .routine(routine)
                .exercise(exercise)
                .numSeries(numSeries)
                .numRep(numRep)
                .rir(rir)
                .build();

        return routineExerciseRepository.save(routineExercise);
    }
}
