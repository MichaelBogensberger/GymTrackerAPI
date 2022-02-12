package com.gymtracker.gymtracker.model;

import lombok.*;

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


    private Double weight;

    private Date date;


    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

    public Weight(Integer id, Double weight, Date date) {
        this.id = id;
        this.weight = weight;
        this.date = date;
    }

}
