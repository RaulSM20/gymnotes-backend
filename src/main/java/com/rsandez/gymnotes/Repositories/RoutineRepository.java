package com.rsandez.gymnotes.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rsandez.gymnotes.Entities.Routine;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Integer> {

    @Query("SELECT routine FROM Routine routine LEFT JOIN RoutineExercise re on routine.id = re.routine.id LEFT JOIN Exercise exercise on exercise.id = re.exercise.id WHERE routine.id = :id")
    Routine findRoutineWithExercises(@Param("id") Integer id);
}