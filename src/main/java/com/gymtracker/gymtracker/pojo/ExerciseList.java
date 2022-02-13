package com.gymtracker.gymtracker.pojo;

public class ExerciseList {

    private Integer exercise_id;
    private String name;
    private Integer reps;
    private Integer sets;

    public ExerciseList(Integer exercise_id, String name, Integer reps, Integer sets) {
        this.exercise_id = exercise_id;
        this.name = name;
        this.reps = reps;
        this.sets = sets;
    }

    public ExerciseList() {
    }

    public Integer getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Integer exercise_id) {
        this.exercise_id = exercise_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }
}
