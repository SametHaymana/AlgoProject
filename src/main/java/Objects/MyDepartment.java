/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.util.ArrayList;

/**
 *
 * @author hasaneke
 */
public class MyDepartment {
    
    
    private String name;
    
    private String departmentCode;
    private int numberOfEnrolledStudents;
    private ArrayList<DepLesson> lessons;
    
    
    public MyDepartment(String name, String departmentCode) {
        this.name = name;
        this.departmentCode = departmentCode;
        this.numberOfEnrolledStudents = 0;
        this.lessons = new ArrayList<>();
    }
    
    public void addLesson(DepLesson les){
        this.lessons.add(les);
    }
    
    public ArrayList<DepLesson> getLessons(){
        return this.lessons;
    }
    
    public String getDepartmentCode(){
        return this.departmentCode;
    }
    
    public String getName(){
        return this.name;
    }
}