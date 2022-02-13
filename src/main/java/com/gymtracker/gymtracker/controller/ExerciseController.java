package com.gymtracker.gymtracker.controller;

import com.gymtracker.gymtracker.configuration.AccessValidation;
import com.gymtracker.gymtracker.exeption.ValidationDeclinedException;
import com.gymtracker.gymtracker.model.Exercise;
import com.gymtracker.gymtracker.model.Weight;
import com.gymtracker.gymtracker.pojo.ExerciseList;
import com.gymtracker.gymtracker.pojo.PlanList;
import com.gymtracker.gymtracker.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExerciseController {

    @Autowired
    AccessValidation accessValidation;

    @Autowired
    ExerciseService exerciseService;

    //add exercise
    @PostMapping( "/api/user/{user_id}/plan/{plan_id}/exercise")
    public Exercise addExercise(@RequestHeader String name,
                                @RequestHeader Integer reps,
                                @RequestHeader Integer sets,
                                @PathVariable Integer plan_id,
                                @PathVariable Integer user_id,
                                Authentication authentication) throws ValidationDeclinedException {
        if(accessValidation.validateUser(user_id, authentication)) {
            return exerciseService.addExercise(user_id, plan_id, name, reps, sets);
        } else {
            throw new ValidationDeclinedException();
        }
    }


    @GetMapping("/api/user/{user_id}/plan/{plan_id}/exercise")
    public List<ExerciseList> getExercise(@PathVariable Integer user_id,@PathVariable Integer plan_id, Authentication authentication) throws ValidationDeclinedException {
        if(accessValidation.validateUser(user_id, authentication)) {
            return exerciseService.getExercise(user_id, plan_id);
        } else {
            throw new ValidationDeclinedException();
        }
    }

    @GetMapping("/api/user/{user_id}/exercise")
    public List<ExerciseList> getAllExercises(@PathVariable Integer user_id, Authentication authentication) throws ValidationDeclinedException {
        if(accessValidation.validateUser(user_id, authentication)) {
            return exerciseService.getAllExercises(user_id);
        } else {
            throw new ValidationDeclinedException();
        }
    }





}
