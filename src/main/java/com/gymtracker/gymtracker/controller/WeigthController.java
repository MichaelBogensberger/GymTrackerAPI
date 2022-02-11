package com.gymtracker.gymtracker.controller;

import com.gymtracker.gymtracker.configuration.AccessValidation;
import com.gymtracker.gymtracker.exeption.ValidationDeclinedException;
import com.gymtracker.gymtracker.model.User;
import com.gymtracker.gymtracker.model.Weight;
import com.gymtracker.gymtracker.service.UserService;
import com.gymtracker.gymtracker.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
public class WeigthController {

    @Autowired
    private WeightService weightService;

    @Autowired
    AccessValidation accessValidation;



    //add weight
    @PostMapping( "/api/user/{id}/weight")
    public Weight addWeight(@RequestHeader Double weight, @RequestHeader Date date, @PathVariable Integer id, Authentication authentication) throws ValidationDeclinedException {
        if(accessValidation.validateUser(id, authentication)) {
            System.out.println(weight);
            System.out.println(date);
            return weightService.addWeight(id, weight, date);
        } else {
            throw new ValidationDeclinedException();
        }
    }





}
