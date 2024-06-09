package com.demo.demoproject.common;

import org.springframework.stereotype.Component;

@Component
public class TannisCoach implements Coach{
    public TannisCoach() {
        System.out.println("in tannis const"+ getClass());
    }
    @Override
    public String getDailyWorkout() {
        return "practice daily workout to become master in tennis";
    }
}
