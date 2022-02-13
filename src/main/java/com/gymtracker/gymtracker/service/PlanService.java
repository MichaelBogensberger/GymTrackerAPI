package com.gymtracker.gymtracker.service;

import com.gymtracker.gymtracker.model.Plan;
import com.gymtracker.gymtracker.model.User;
import com.gymtracker.gymtracker.pojo.PlanList;
import com.gymtracker.gymtracker.repository.PlanRepository;
import com.gymtracker.gymtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    PlanRepository planRepository;

    @Autowired
    UserRepository userRepository;

    public Plan addPlan(Integer id, String type, Integer type_order) {
        User foundUser = userRepository.findById(id).get();

        Plan nPlan = new Plan();
        nPlan.setType(type);
        nPlan.setType_order(type_order);
        nPlan.setUser(foundUser);
        return planRepository.save(nPlan);

    }


    public List<PlanList> getPlan(Integer id) {
        return planRepository.findByUserId(id);
    }


}
