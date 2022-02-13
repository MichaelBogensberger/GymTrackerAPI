package com.gymtracker.gymtracker.service;

import com.gymtracker.gymtracker.model.Exercise;
import com.gymtracker.gymtracker.model.ExerciseHistory;
import com.gymtracker.gymtracker.model.User;
import com.gymtracker.gymtracker.pojo.ExerciseHistoryList;
import com.gymtracker.gymtracker.repository.ExerciseHistoryRepository;
import com.gymtracker.gymtracker.repository.ExerciseRepository;
import com.gymtracker.gymtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ExerciseHistoryService {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ExerciseHistoryRepository exerciseHistoryRepository;



    public ExerciseHistory addHistory(Integer exercise_id, Date date, Double weight) {
        Exercise foundExercise = exerciseRepository.findById(exercise_id).get();

        ExerciseHistory nHistory = new ExerciseHistory();
        nHistory.setDate(date);
        nHistory.setWeight(weight);
        nHistory.setExercise(foundExercise);
        return exerciseHistoryRepository.save(nHistory);

    }


    public List<ExerciseHistoryList> getHistory(Integer exercise_id) {
        return exerciseHistoryRepository.findByUserId(exercise_id);
    }


}
