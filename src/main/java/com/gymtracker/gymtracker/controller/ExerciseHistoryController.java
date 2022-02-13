package com.gymtracker.gymtracker.controller;

import com.gymtracker.gymtracker.configuration.AccessValidation;
import com.gymtracker.gymtracker.exeption.ValidationDeclinedException;
import com.gymtracker.gymtracker.model.Exercise;
import com.gymtracker.gymtracker.model.ExerciseHistory;
import com.gymtracker.gymtracker.pojo.ExerciseHistoryList;
import com.gymtracker.gymtracker.pojo.PlanList;
import com.gymtracker.gymtracker.service.ExerciseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class ExerciseHistoryController {

    @Autowired
    AccessValidation accessValidation;

    @Autowired
    ExerciseHistoryService exerciseHistoryService;


    //add exercise history
    @PostMapping( "/api/user/{user_id}/exercise/{exercise_id}/history")
    public ExerciseHistory addExerciseHistory(@RequestHeader Date date,
                                              @RequestHeader Double weight,
                                              @PathVariable Integer exercise_id,
                                              @PathVariable Integer user_id,
                                              Authentication authentication) throws ValidationDeclinedException {
        if(accessValidation.validateUser(user_id, authentication)) {
            return exerciseHistoryService.addHistory(exercise_id, date, weight);
        } else {
            throw new ValidationDeclinedException();
        }
    }

    @GetMapping("/api/user/{id}/exercise/{exercise_id}/history")
    public List<ExerciseHistoryList> getHistory(@PathVariable Integer id, @PathVariable Integer exercise_id , Authentication authentication) throws ValidationDeclinedException {
        if(accessValidation.validateUser(id, authentication)) {
            return exerciseHistoryService.getHistory(exercise_id);
        } else {
            throw new ValidationDeclinedException();


        }
    }







}
