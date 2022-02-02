package com.gymtracker.gymtracker.repository;

import com.gymtracker.gymtracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String username);

}
