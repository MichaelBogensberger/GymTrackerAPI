package com.gymtracker.gymtracker.service;

import com.gymtracker.gymtracker.configuration.AccessValidation;
import com.gymtracker.gymtracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.gymtracker.gymtracker.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired WeightService weightService;
    


    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }



    public User createUser(String username, String email, String firstname, String lastname, String password) {
        User user = new User();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        //user.setPassword(password);
        userRepository.save(user);

        return user;
    }


    public User updateHeight(Integer id, Double height) {
        User foundUser = userRepository.findById(id).get();
        foundUser.setHeight(height);
        return userRepository.save(foundUser);
    }


    public String calcBMI(Integer id) {
        User foundUser = userRepository.findById(id).get();
        Double height = foundUser.getHeight();
        Double weight = weightService.findMostCurrentByUserId(id);
        Double bmi = weight / Math.pow(height/100,2);
        bmi = Math.round(bmi * 100.0) / 100.0;

        foundUser.setBmi(bmi);
        userRepository.save(foundUser);
        return "BMI berechnet und gespeichert: " + bmi;
    }


}
