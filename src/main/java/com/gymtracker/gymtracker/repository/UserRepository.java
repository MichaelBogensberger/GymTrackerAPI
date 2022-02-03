package com.gymtracker.gymtracker.repository;

import com.gymtracker.gymtracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
