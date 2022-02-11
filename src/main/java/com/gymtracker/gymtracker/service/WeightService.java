package com.gymtracker.gymtracker.service;

import com.gymtracker.gymtracker.model.User;
import com.gymtracker.gymtracker.model.Weight;
import com.gymtracker.gymtracker.repository.UserRepository;
import com.gymtracker.gymtracker.repository.WeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class WeightService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeightRepository weightRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public Weight addWeight(Integer id, Double weight, Date date) {
        User foundUser = userRepository.findById(id).get();
        Weight nweight = new Weight();
        nweight.setWeight(weight);
        nweight.setDate(date);
        nweight.setUser(foundUser);

        return weightRepository.save(nweight);


    }

}
