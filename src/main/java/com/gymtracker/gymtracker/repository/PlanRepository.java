package com.gymtracker.gymtracker.repository;

import com.gymtracker.gymtracker.model.Plan;
import com.gymtracker.gymtracker.model.Weight;
import com.gymtracker.gymtracker.pojo.PlanList;
import com.gymtracker.gymtracker.pojo.weightList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {

    @Query("select new com.gymtracker.gymtracker.pojo.PlanList(p.id, p.type, p.type_order) from Plan p where p.user.id = :id")
    List<PlanList> findByUserId(@Param("id") Integer id);


}
