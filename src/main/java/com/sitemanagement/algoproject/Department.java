package com.sitemanagement.algoproject;

public class Department {
    
    
    private String name;
    
    private int departmentCode;
    private int numberOfEnrolledStudents;
    public Lesson[] lessons;
    
    
    public Department(String name, int departmentCode) {
        this.name = name;
        this.departmentCode = departmentCode;
        this.numberOfEnrolledStudents = 0;
        this.lessons = new Lesson[30];
    }
}
