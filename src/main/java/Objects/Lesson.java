package Objects;


import Objects.Student;
import java.util.ArrayList;

public class Lesson {
    
    private static int EnrollmentLimit = 50;
    
    private int akts;
    private String LectureName;
    private int enrollmentCount;
    private int lessonCode;
    private int classYear;
    private int departmentCode;
    private ArrayList<Student> enrolledStudents;
    
    private  boolean isMandatory;
    
    public Lesson(String name){
        this.LectureName = name;
    }
    
    public Lesson(int akts, String name, Boolean isMandatory, int lessonCode, int classN, int depertmentCode){
        this.akts = akts;
        this.LectureName = name;
        this.lessonCode = lessonCode;
        this.classYear = classN;
        this.departmentCode = depertmentCode;
        
        this.enrolledStudents = new ArrayList<>();
    } 
    
    

    public boolean isAvaliableChair(){
        return this.enrolledStudents.size() < EnrollmentLimit; 
    }

    
    
    /**
     *
     * @param std
     * @return
     */
    public boolean enroll(Student std){
       if(this.isAvaliableChair()){
           // Add student
           this.enrolledStudents.add(std);
           return true;
       }
       else return false;
        
    }
    
    
    
    public int getAkts(){return this.akts;}
    public String getLectureName (){return this.LectureName;}
    public int getLectureCode(){return this.lessonCode;}
    public int getClassYear(){return this.classYear;}
    public int getDepartmentCode(){return this.departmentCode;}
    
    
    

    
    @Override
    public String toString() {
        return "Lesson [AKTS=" + akts + ", name=" + LectureName + ", enrollmentLimit=" + lessonCode + ", enrollmentCount="
                + this.enrolledStudents.size()  + ", isFull=" + !isAvaliableChair() + ", isMandatory=" + isMandatory + ", lessonCode=" + lessonCode
                + ", classN=" + classYear + ", departmentCode=" + departmentCode + "]";
    }
}