package com.gymtracker.gymtracker.controller;

import com.gymtracker.gymtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired private UserService userService;


    // neuen User anlegen
    @PostMapping(value= "/api/createUser")
    public String createUser(@RequestHeader String first, @RequestHeader String last, @RequestHeader String email, @RequestHeader String pw, @RequestHeader boolean enabled) {

        return userService.apiCreateUser(first, last, email, pw, enabled);

    }





}
