package com.rsandez.gymnotes.Repositories;

import com.rsandez.gymnotes.Entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
}