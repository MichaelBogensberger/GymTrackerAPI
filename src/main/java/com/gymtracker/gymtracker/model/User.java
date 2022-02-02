package com.gymtracker.gymtracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.*;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String firstname;

    @NotEmpty
    private String lastname;

    @NotEmpty
    @Min(50)
    @Max(300)
    private Double height;

    @Email
    private String email;

    @NotEmpty
    private String password;


    @OneToMany(mappedBy="user")
    private Set<Exercise> exercises;

    @OneToMany(mappedBy="user")
    private Set<Day> days;

    @OneToMany(mappedBy="user")
    private Set<Weight> weights;

    @OneToMany(mappedBy="user")
    private Set<Plan> plans;


}
