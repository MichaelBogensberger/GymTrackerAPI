package com.gymtracker.gymtracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @Column(name = "plan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String type;

    @NotEmpty
    private int type_order;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false, insertable=false, updatable=false)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy="plan")
    private Set<Exercise> exercises;


}