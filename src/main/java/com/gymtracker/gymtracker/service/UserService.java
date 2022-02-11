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
    


    public User findById(Integer id, Authentication authentication) {
        System.out.println(userRepository.findIdByUsername("Michi"));

        /*
        if(val.validateUser(id, authentication)) {
            return userRepository.findById(id).get();
        } else {
            return userRepository.findById(id).get();
        }
         */
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

}
