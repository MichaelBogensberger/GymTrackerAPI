package com.gymtracker.gymtracker.service;

import com.gymtracker.gymtracker.model.Exercise;
import com.gymtracker.gymtracker.model.User;
import com.gymtracker.gymtracker.pojo.ExerciseList;
import com.gymtracker.gymtracker.repository.ExerciseRepository;
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



    public Exercise addExercise(Integer user_id, String name, Integer reps, Integer sets,Double gewicht) {
        User foundUser = userRepository.findById(user_id).get();

        Exercise nExercise = new Exercise();
        nExercise.setName(name);
        nExercise.setReps(reps);
        nExercise.setSets(sets);
        nExercise.setUser(foundUser);
        nExercise.setGewicht(gewicht);

        return exerciseRepository.save(nExercise);

    }


    public List<ExerciseList> getAllExercises(Integer user_id) {
        return exerciseRepository.findAllByUserId(user_id);
    }

    public Exercise updateExercise(String name, Integer reps, Integer sets, Double gewicht, Integer exId) {
        Exercise foundExercise = exerciseRepository.findById(exId).get();
        foundExercise.setGewicht(gewicht);
        foundExercise.setSets(sets);
        foundExercise.setReps(reps);
        foundExercise.setName(name);
        return exerciseRepository.save(foundExercise);
    }

    public void deleteExercise(Integer id) {
        exerciseRepository.deleteById(id);
    }
}
