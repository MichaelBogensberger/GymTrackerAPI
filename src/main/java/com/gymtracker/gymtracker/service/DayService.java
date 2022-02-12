package com.gymtracker.gymtracker.service;

import com.gymtracker.gymtracker.model.Day;
import com.gymtracker.gymtracker.model.User;
import com.gymtracker.gymtracker.pojo.DayList;
import com.gymtracker.gymtracker.repository.DayRepository;
import com.gymtracker.gymtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DayService {

    @Autowired
    DayRepository dayRepository;

    @Autowired
    UserRepository userRepository;

    public Day addDay(Integer id, Integer day) {
        User foundUser = userRepository.findById(id).get();
        Day newDay = new Day();
        newDay.setDay(day);
        newDay.setUser(foundUser);
        return dayRepository.save(newDay);
    }


    public List<DayList> findById(Integer id) {
        return dayRepository.findAllByUserId(id);
    }

}
