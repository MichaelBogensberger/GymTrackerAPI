package com.gymtracker.gymtracker.pojo;


import java.util.Date;

public class weightList {

    private Double weight;
    private Date date;

    public weightList(Double weight, Date date) {
        this.weight = weight;
        this.date = date;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public weightList() {
    }

}
