package com.sitemanagement.algoproject;

public class Lecturer {
    int name;
    boolean[] available_days = new boolean[5];
    Lesson[] giving_Lessons;

    public Lecturer(int name, Lesson[] giving_Lessons) {
        this.name = name;
        this.giving_Lessons = giving_Lessons;
    }
    
    

}
