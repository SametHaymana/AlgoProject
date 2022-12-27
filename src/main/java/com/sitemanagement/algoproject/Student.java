package com.sitemanagement.algoproject;

public class Student {
    public static int count = 0;
    String name;
    int number;
    int classN;
    int departmentCode;
    int numberOfLessons = 0;
    //array for lessons taken by student
    Lesson[] lessonsTaken=new Lesson[30];

    public Student(String name, int classN, int departmentCode) {
        this.name = name;
        this.number = count;
        this.classN = classN;
        count++;
        this.departmentCode = departmentCode;
    }
    //student enrollment method
    public void enroll(Lesson lesson){
            lessonsTaken[numberOfLessons]=lesson;
            numberOfLessons++;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", number=" + number + ", classN=" + classN + ", departmentCode=" + departmentCode
                + ", numberOfLessons=" + numberOfLessons + "]";    
    }
}
