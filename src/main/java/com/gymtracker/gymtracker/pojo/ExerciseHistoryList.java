package com.gymtracker.gymtracker.pojo;

import java.util.Date;

public class ExerciseHistoryList {
    private Date date;
    private Double weight;

    public ExerciseHistoryList(Date date, Double weight) {
        this.date = date;
        this.weight = weight;
    }

    public ExerciseHistoryList() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
