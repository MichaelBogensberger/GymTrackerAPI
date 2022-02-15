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
    @PostMapping( "/api/user/{user_id}/exercise")
    public Exercise addExercise(@RequestHeader String name,
                                @RequestHeader Integer reps,
                                @RequestHeader Integer sets,
                                @PathVariable Integer user_id,
                                @RequestHeader Double gewicht,
                                Authentication authentication) throws ValidationDeclinedException {
        if(accessValidation.validateUser(user_id, authentication.getName())) {
            return exerciseService.addExercise(user_id, name, reps, sets, gewicht);
        } else {
            throw new ValidationDeclinedException();
        }
    }


    @GetMapping("/api/user/{user_id}/exercise")
    public List<ExerciseList> getAllExercises(@PathVariable Integer user_id, Authentication authentication) throws ValidationDeclinedException {
        if(accessValidation.validateUser(user_id, authentication.getName())) {
            return exerciseService.getAllExercises(user_id);
        } else {
            throw new ValidationDeclinedException();
        }
    }


    @PutMapping( "/api/user/{user_id}/exercise/{exId}")
    public Exercise updateExercise(@RequestHeader String name,
                                @RequestHeader Integer reps,
                                @RequestHeader Integer sets,
                                @PathVariable Integer user_id,
                                @RequestHeader Double gewicht,
                                @PathVariable Integer exId,
                                Authentication authentication) throws ValidationDeclinedException {
        if(accessValidation.validateUser(user_id, authentication.getName())) {
            return exerciseService.updateExercise(name, reps, sets, gewicht, exId);
        } else {
            throw new ValidationDeclinedException();
        }
    }

    @DeleteMapping(value = "/api/exercise/{id}")
    public String deletePost(@PathVariable Integer id) {
        exerciseService.deleteExercise(id);
        return "{\"erfolg\":\"true\"}";
    }






}
