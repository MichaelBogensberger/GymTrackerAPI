package com.gymtracker.gymtracker.controller;

import com.gymtracker.gymtracker.model.User;
import com.gymtracker.gymtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired private UserService userService;



    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }


    @PostMapping( "/user")
    public String createUser(@RequestHeader String firstname,
                             @RequestHeader String lastname,
                             @RequestHeader  String email,
                             @RequestHeader  String password) {
        return userService.createUser(email, firstname, lastname, password);
    }









}
