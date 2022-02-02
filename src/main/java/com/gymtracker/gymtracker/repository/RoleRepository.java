package com.gymtracker.gymtracker.repository;

import com.gymtracker.gymtracker.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}