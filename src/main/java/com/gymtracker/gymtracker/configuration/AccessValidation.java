package com.gymtracker.gymtracker.configuration;

import com.gymtracker.gymtracker.model.User;
import com.gymtracker.gymtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class AccessValidation {

    @Autowired
    UserRepository userRepository;


    public boolean validateUser(Integer requestedId, Authentication authentication) {
        if(userRepository.findIdByUsername(authentication.getName()) == requestedId) {
            return true;
        } else {
            return false;
        }
    }


}
