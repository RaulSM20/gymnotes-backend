package com.rsandez.gymnotes.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "routine_exercise")
public class RoutineExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "routine_id", nullable = false)
    @JsonBackReference
    private Routine routine;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    // @JsonManagedReference
    private Exercise exercise;

    @Column
    private int numSeries;

    @Column
    private int numRep;

    @Column
    private int rir;
}
