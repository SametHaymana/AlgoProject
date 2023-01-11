package Objects;


import java.util.ArrayList;

public class Faculty {
    
    private String name;
    
    private ArrayList<Department> departments;
    
    public Faculty(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }
    
    
    public ArrayList<Department> addDepertment(Department dp) throws Exception{
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
    
    public ArrayList<Department> getDepartments(){
        
        return this.departments;

    }
    
    
    
    
}
