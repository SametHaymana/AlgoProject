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

public class MyFaculty {
    
    private String name;
    
    private ArrayList<MyDepartment> departments;
    
    public MyFaculty(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }
    
    
    public ArrayList<MyDepartment> addDepertment(MyDepartment dp) throws Exception{
        /*
            Check over size and return exception if needed
        */
        
        
        if(this.departments.size() > 6){
            String errorMessage = "Over of size for adding new deppartment for "+this.name+" faculty.";
           
            throw new Exception(errorMessage);
        }
        
        this.departments.add(dp);
        return this.departments;
    }
    
    public ArrayList<MyDepartment> getDepartments(){
        
        return this.departments;

    }
    
    
    
    
}
