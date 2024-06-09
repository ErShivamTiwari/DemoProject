package com.demo.demoproject.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("in cricket const"+ getClass());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice 10 over daily";
    }
}
