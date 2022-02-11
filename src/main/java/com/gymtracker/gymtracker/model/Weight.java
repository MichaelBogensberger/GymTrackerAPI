package com.gymtracker.gymtracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "weight")
public class Weight {
    @Id
    @Column(name = "weight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Min(0)
    @Max(500)
    private Double weight;

    private Date date;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}
