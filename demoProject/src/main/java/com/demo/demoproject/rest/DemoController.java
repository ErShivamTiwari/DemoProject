package com.demo.demoproject.rest;

import com.demo.demoproject.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    @Autowired

    DemoController(@Qualifier("baseBallCoach") Coach coach) {
        System.out.println("in demoController const "+ getClass().getSimpleName());
        this.myCoach = coach;
    }

    @GetMapping("/Coach")
    public String comment(){
        return myCoach.getDailyWorkout();
    }
}

