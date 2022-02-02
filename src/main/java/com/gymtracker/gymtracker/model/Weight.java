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
import java.text.SimpleDateFormat;


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
    private Long id;

    @Min(0)
    @Max(500)
    @NotEmpty
    private Double weight;

    @NotEmpty
    private Date date;


    @ManyToOne
    @JoinColumn(name="user_id", nullable=false, insertable=false, updatable=false)
    private User user;

}
