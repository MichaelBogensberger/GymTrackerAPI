package com.gymtracker.gymtracker.repository;

import com.gymtracker.gymtracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query("select u.id from User u WHERE u.username = :username")
    Integer findIdByUsername(@Param("username") String username);

}
