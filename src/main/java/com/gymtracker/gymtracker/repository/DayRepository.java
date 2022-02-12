package com.gymtracker.gymtracker.repository;

import com.gymtracker.gymtracker.model.Day;
import com.gymtracker.gymtracker.pojo.DayList;
import com.gymtracker.gymtracker.pojo.weightList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayRepository extends JpaRepository<Day, Integer> {


    @Query("select new com.gymtracker.gymtracker.pojo.DayList(d.day) from Day d where d.user.id = :id")
    List<DayList> findAllByUserId(@Param("id") Integer id);


}
