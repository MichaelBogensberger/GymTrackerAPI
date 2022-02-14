package com.gymtracker.gymtracker.controller;

import com.gymtracker.gymtracker.configuration.AccessValidation;
import com.gymtracker.gymtracker.exeption.ValidationDeclinedException;
import com.gymtracker.gymtracker.model.Exercise;
import com.gymtracker.gymtracker.model.Plan;
import com.gymtracker.gymtracker.pojo.PlanList;
import com.gymtracker.gymtracker.pojo.weightList;
import com.gymtracker.gymtracker.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlanController {

    @Autowired
    AccessValidation accessValidation;

    @Autowired
    PlanService planService;


    //add plan
    @PostMapping( "/api/user/{id}/plan")
    public Plan addPlan(@RequestHeader String type,
                        @RequestHeader Integer type_order,
                        @PathVariable Integer id,
                        Authentication authentication) throws ValidationDeclinedException {
        if(accessValidation.validateUser(id, authentication.getName())) {
            return planService.addPlan(id, type, type_order);
        } else {
            throw new ValidationDeclinedException();
        }
    }


    @GetMapping("/api/user/{id}/plan")
    public List<PlanList> getPlan(@PathVariable Integer id, Authentication authentication) throws ValidationDeclinedException {
        if(accessValidation.validateUser(id, authentication.getName())) {
            return planService.getPlan(id);
        } else {
            throw new ValidationDeclinedException();


        }
    }





}
