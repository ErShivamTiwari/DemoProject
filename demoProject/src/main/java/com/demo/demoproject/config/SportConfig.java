package com.demo.demoproject.config;

import com.demo.demoproject.common.Coach;
import com.demo.demoproject.common.DataBase;
import com.demo.demoproject.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class SportConfig {
//    @Bean
//    public Coach swimCoach(){
//        return new SwimCoach();
//    }
//
//}

@Configuration
public class SportConfig {
    @Bean
    public DataBase dataBase(){
        return new DataBase();
    }
}