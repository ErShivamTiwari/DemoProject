package com.demo.demoproject.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{

    public BaseBallCoach() {
        System.out.println("in baseBal const"+ getClass());
    }
    @Override
    public String getDailyWorkout() {
        return "target to ball";
    }
}
