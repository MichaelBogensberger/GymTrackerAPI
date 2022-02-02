package com.gymtracker.gymtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gymtracker.gymtracker.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

}
