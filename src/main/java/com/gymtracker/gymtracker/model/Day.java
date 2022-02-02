package com.gymtracker.gymtracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "day")
public class Day {

    @Id
    @Column(name = "day_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String day;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false, insertable=false, updatable=false)
    private User user;


}
