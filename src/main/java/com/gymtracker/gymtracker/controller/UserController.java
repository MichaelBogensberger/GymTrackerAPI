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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    AccessValidation accessValidation;



    //get User
    @GetMapping("/api/user/{id}")
    public User getUserById(@PathVariable Integer id, Authentication authentication) throws ValidationDeclinedException {

        System.out.println("Geschickte ID: " + id);
        userService.findIdByUsername(authentication.getName());
        System.out.println("USERNAME IST ------> " + authentication.getName());
        System.out.println("ERG: " + accessValidation.validateUser(id, authentication.getName()));


        if(accessValidation.validateUser(id, authentication.getName()) == true) {
            return userService.findById(id);
        } else {
            System.out.println("ERROR");
            throw new ValidationDeclinedException();
        }

    }

    @PostMapping("/api/user/{id}/calcBMI")
    public User calcBMI(@PathVariable Integer id) {
        return userService.calcBMI(id);
    }




    //create User
    @PostMapping( "/api/createUser")
    public User createUser(@RequestHeader String firstname,
                             @RequestHeader String lastname,
                             @RequestHeader  String email,
                             @RequestHeader  String password,
                             @RequestHeader String username,
                           @RequestHeader Double height) {
        return userService.createUser(username, email, firstname, lastname, password, height);
    }

    // edit Height
    @PutMapping("/api/user/height/{id}")
    public User updateHeight(@RequestHeader Double height, @PathVariable Integer id, Authentication authentication) throws ValidationDeclinedException {

        if(accessValidation.validateUser(id, authentication.getName())) {
            return userService.updateHeight(id, height);
        } else {
            throw new ValidationDeclinedException();
        }


    }









}
