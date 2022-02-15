package com.gymtracker.gymtracker.repository;

import com.gymtracker.gymtracker.model.Exercise;
import com.gymtracker.gymtracker.pojo.ExerciseList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {


    @Query("select new com.gymtracker.gymtracker.pojo.ExerciseList(e.id, e.name, e.reps, e.sets, e.gewicht) from Exercise e where e.user.id = :user_id")
    List<ExerciseList> findAllByUserId(Integer user_id);



}
