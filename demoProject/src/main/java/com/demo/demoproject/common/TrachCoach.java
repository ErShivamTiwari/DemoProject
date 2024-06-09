package com.demo.demoproject.common;

import org.springframework.stereotype.Component;

@Component
public class TrachCoach implements Coach{

    public TrachCoach() {
        System.out.println("in track const"+ getClass());
    }
    @Override
    public String getDailyWorkout() {
        return "run hard to win in race and dont distract from track";
    }
}
