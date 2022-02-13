package com.gymtracker.gymtracker.service;

import com.gymtracker.gymtracker.model.Exercise;
import com.gymtracker.gymtracker.model.Plan;
import com.gymtracker.gymtracker.model.User;
import com.gymtracker.gymtracker.pojo.ExerciseList;
import com.gymtracker.gymtracker.repository.ExerciseRepository;
import com.gymtracker.gymtracker.repository.PlanRepository;
import com.gymtracker.gymtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PlanRepository planRepository;

    public Exercise addExercise(Integer user_id, Integer plan_id, String name, Integer reps, Integer sets) {
        User foundUser = userRepository.findById(user_id).get();
        Plan foundPlan = planRepository.findById(plan_id).get();

        Exercise nExercise = new Exercise();
        nExercise.setName(name);
        nExercise.setReps(reps);
        nExercise.setSets(sets);
        nExercise.setUser(foundUser);
        nExercise.setPlan(foundPlan);
        return exerciseRepository.save(nExercise);

    }

    public List<ExerciseList> getExercise(Integer user_id, Integer plan_id) {
        return exerciseRepository.findByUserId(user_id, plan_id);
    }


    public List<ExerciseList> getAllExercises(Integer user_id) {
        return exerciseRepository.findAllByUserId(user_id);
    }

}
