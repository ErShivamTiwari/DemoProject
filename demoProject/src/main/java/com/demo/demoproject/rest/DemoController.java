package com.demo.demoproject.rest;

import com.demo.demoproject.common.Coach;
import com.demo.demoproject.common.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
//    private Coach myCoach;

    private DataBase dataBase;

    @Autowired
    public DemoController(DataBase dataBase){
        this.dataBase = dataBase;
    }

//    DemoController(@Qualifier("swimCoach") Coach coach)
//    {
//        this.myCoach = coach;
//
//    }

//
//    @GetMapping("/Coach")
//    public String checkBeanScope(){
//        return "null";
//    }
//
//    @GetMapping("/try")
//    public String swimCoachInstruction(){
//        return myCoach.getDailyWorkout();
//    }

    @GetMapping("/db")
    public int dunum(){

        dataBase.setData(31,6,9);
       int summ= dataBase.sum();
       return summ;
    }

}

