package com.gymtracker.gymtracker.repository;

import com.gymtracker.gymtracker.model.User;
import com.gymtracker.gymtracker.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightRepository extends JpaRepository<Weight, Integer> {

}
