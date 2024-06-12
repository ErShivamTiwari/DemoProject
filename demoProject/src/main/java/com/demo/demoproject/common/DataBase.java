package com.demo.demoproject.common;

import org.springframework.stereotype.Component;


public class DataBase {
    int id;
    int rollNumber;
    int age;

    public void setData(int id, int rollNumber, int age) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.age = age;
    }
    public int sum(){
        return id+age;
    }
}
