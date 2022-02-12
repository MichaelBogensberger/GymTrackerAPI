package com.gymtracker.gymtracker.repository;

import com.gymtracker.gymtracker.model.User;
import com.gymtracker.gymtracker.model.Weight;
import com.gymtracker.gymtracker.pojo.weightList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WeightRepository extends JpaRepository<Weight, Integer> {


    @Query("select max(w.weight) from Weight w where w.user.id = :id")
    Double findMostCurrentByUserId(@Param("id") Integer id);

    @Query("select new com.gymtracker.gymtracker.pojo.weightList(w.weight, w.date) from Weight w where w.user.id = :id")
    List<weightList> findByUserId(@Param("id") Integer id);

}
