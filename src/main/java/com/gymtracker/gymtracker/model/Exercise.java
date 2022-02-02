package com.gymtracker.gymtracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @Column(name = "exercise_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty
    private String name;

    @Min(0)
    @Max(40)
    private int sets;

    @Min(0)
    @Max(40)
    private int reps;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false, insertable=false, updatable=false)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy="exercise")
    private Set<ExerciseHistory> exerciseHistories;


    @ManyToOne
    @JoinColumn(name="plan_id", nullable=false, insertable=false, updatable=false)
    private Plan plan;


}
