package com.demo.demoproject.rest;

import com.demo.demoproject.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    private Coach myCoach2;
    @Autowired

    DemoController(
            @Qualifier("baseBallCoach") Coach coach,
            @Qualifier("baseBallCoach") Coach coach2
            ) {
        System.out.println("in demoController const "+ getClass().getSimpleName());
        this.myCoach = coach;
        this.myCoach2 = coach2;
    }

    @GetMapping("/Coach")
    public String comment(){
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/check")
    public String check(){
        return (myCoach==myCoach2)? "Dono same hai":"dono alag hai";
//        output is No
    }
}

