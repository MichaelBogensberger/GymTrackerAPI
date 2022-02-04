package com.gymtracker.gymtracker.controller;

import com.gymtracker.gymtracker.configuration.AccessValidation;
import com.gymtracker.gymtracker.exeption.ValidationDeclinedException;
import com.gymtracker.gymtracker.model.User;
import com.gymtracker.gymtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    AccessValidation accessValidation;



    @GetMapping("/api/user/{id}")
    public User getUserById(@PathVariable Integer id, Authentication authentication) throws ValidationDeclinedException {

        if(accessValidation.validateUser(id, authentication)) {
            return userService.findById(id, authentication);
        } else {
            throw new ValidationDeclinedException();
        }

    }


    @PostMapping( "/api/users")
    public String createUser(@RequestHeader String firstname,
                             @RequestHeader String lastname,
                             @RequestHeader  String email,
                             @RequestHeader  String password,
                             @RequestHeader String username) {
        return userService.createUser(username, email, firstname, lastname, password);
    }









}
