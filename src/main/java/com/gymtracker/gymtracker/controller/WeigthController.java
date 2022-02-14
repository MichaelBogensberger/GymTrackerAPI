package com.gymtracker.gymtracker.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.gymtracker.gymtracker.configuration.AccessValidation;
import com.gymtracker.gymtracker.exeption.ValidationDeclinedException;
import com.gymtracker.gymtracker.model.User;
import com.gymtracker.gymtracker.model.Weight;
import com.gymtracker.gymtracker.pojo.weightList;
import com.gymtracker.gymtracker.service.UserService;
import com.gymtracker.gymtracker.service.WeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WeigthController {

    @Autowired
    private WeightService weightService;

    @Autowired
    AccessValidation accessValidation;



    @GetMapping("/api/user/{id}/currentWeight")
    public Double getCurrentWeight(@PathVariable Integer id, Authentication authentication) throws ValidationDeclinedException {
        System.out.println("in app");
        if(accessValidation.validateUser(id, authentication.getName())) {
            return weightService.findMostCurrentByUserId(id);
        } else {
            throw new ValidationDeclinedException();
        }
    }

    @GetMapping("/api/user/{id}/weight")
    public List<weightList> getWeight(@PathVariable Integer id, Authentication authentication) throws ValidationDeclinedException {
        System.out.println("in app");
        if(accessValidation.validateUser(id, authentication.getName())) {
            return weightService.findByUserId(id);
        } else {
            throw new ValidationDeclinedException();


        }
    }






    //add weight
    @PostMapping( "/api/user/{id}/weight")
    public Weight addWeight(@RequestHeader Double weight, @RequestHeader Date date, @PathVariable Integer id, Authentication authentication) throws ValidationDeclinedException {
        if(accessValidation.validateUser(id, authentication.getName())) {
            System.out.println(weight);
            System.out.println(date);
            return weightService.addWeight(id, weight, date);
        } else {
            throw new ValidationDeclinedException();
        }
    }





}
