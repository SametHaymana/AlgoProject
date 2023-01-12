package Objects;

import Objects.Lesson;
import java.util.ArrayList;

public class Department {
    
    
    private String name;
    
    private String departmentCode;
    private int numberOfEnrolledStudents;
    private ArrayList<Lesson> lessons;
    
    
    public Department(String name, String departmentCode) {
        this.name = name;
        this.departmentCode = departmentCode;
        this.numberOfEnrolledStudents = 0;
        this.lessons = new ArrayList<>();
    }
    
    public void addLesson(Lesson les){
        this.lessons.add(les);
    }
    
    public ArrayList<Lesson> getLessons(){
        return this.lessons;
    }
    
    public String getDepartmentCode(){
        return this.departmentCode;
    }
    
    public String getName(){
        return this.name;
    }
}
