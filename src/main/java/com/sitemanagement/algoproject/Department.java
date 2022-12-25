package com.sitemanagement.algoproject;

public class Department {
    String name;
    int departmentCode;
    int numberOfEnrolledStudents=0;
    Lesson[] lessons=new Lesson[30];
    public Department(String name, int departmentCode) {
        this.name = name;
        this.departmentCode = departmentCode;
    }
}
