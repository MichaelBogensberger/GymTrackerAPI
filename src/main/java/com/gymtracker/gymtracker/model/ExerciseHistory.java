package com.gymtracker.gymtracker.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "exercise_history")
public class ExerciseHistory {

    @Id
    @Column(name = "exercise_history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Min(0)
    @Max(700)
    private Double weight;


    @NotEmpty
    @DateTimeFormat(fallbackPatterns = "dd/MM/yyyy")
    private Date date;

    @ManyToOne
    @JoinColumn(name="exercise_id")
    private Exercise exercise;

}
