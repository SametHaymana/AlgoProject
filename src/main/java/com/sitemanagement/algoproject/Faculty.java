package com.sitemanagement.algoproject;


public class Faculty {
    
    private String name;
    
    public  Department[] departments;
    
    public Faculty(String name) {
        this.name = name;
        this.departments = new Department[6];
    }
}
