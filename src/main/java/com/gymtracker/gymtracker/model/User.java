package com.gymtracker.gymtracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;


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
    private Integer id;

    @Column(unique=true)
    private String username;

    @NotEmpty
    private String firstname;

    @NotEmpty
    private String lastname;

    @Min(50)
    @Max(300)
    private Double height;

    @Email
    private String email;

    @NotEmpty
    private String password;

    private Double bmi;

    @JsonIgnore
    @OneToMany(mappedBy="user")
    private Set<Exercise> exercises;

    @JsonIgnore
    @OneToMany(mappedBy="user")
    private Set<Day> days;

    @JsonIgnore
    @OneToMany(mappedBy="user")
    private Set<Weight> weights;

    @JsonIgnore
    @OneToMany(mappedBy="user")
    private Set<Plan> plans;


}
