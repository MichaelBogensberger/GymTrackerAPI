package com.gymtracker.gymtracker.controller;

import com.gymtracker.gymtracker.configuration.AccessValidation;
import com.gymtracker.gymtracker.exeption.ValidationDeclinedException;
import com.gymtracker.gymtracker.model.Day;
import com.gymtracker.gymtracker.model.Weight;
import com.gymtracker.gymtracker.pojo.DayList;
import com.gymtracker.gymtracker.pojo.weightList;
import com.gymtracker.gymtracker.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class DayController {

    @Autowired
    AccessValidation accessValidation;

    @Autowired
    DayService dayService;


    //add day
    @PostMapping( "/api/user/{id}/day")
    public Day addDay(@RequestHeader Integer day, @PathVariable Integer id, Authentication authentication) throws ValidationDeclinedException {
        if(accessValidation.validateUser(id, authentication)) {
            return dayService.addDay(id, day);
        } else {
            throw new ValidationDeclinedException();
        }
    }


    @GetMapping("/api/user/{id}/day")
    public List<DayList> getWeight(@PathVariable Integer id, Authentication authentication) throws ValidationDeclinedException {
        if(accessValidation.validateUser(id, authentication)) {
            return dayService.findById(id);
        } else {
            throw new ValidationDeclinedException();


        }
    }






}
