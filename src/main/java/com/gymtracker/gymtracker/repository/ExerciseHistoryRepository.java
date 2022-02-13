package com.gymtracker.gymtracker.repository;

import com.gymtracker.gymtracker.model.Exercise;
import com.gymtracker.gymtracker.model.ExerciseHistory;
import com.gymtracker.gymtracker.pojo.ExerciseHistoryList;
import com.gymtracker.gymtracker.pojo.ExerciseList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseHistoryRepository extends JpaRepository<ExerciseHistory, Integer> {


    @Query("select new com.gymtracker.gymtracker.pojo.ExerciseHistoryList(h.date, h.weight) from ExerciseHistory h where h.exercise.id = :exercise_id")
    List<ExerciseHistoryList> findByUserId(Integer exercise_id);


}
