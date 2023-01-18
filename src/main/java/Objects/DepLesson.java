package Objects;


import Objects.Lecturer;
import Objects.Student;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hasaneke
 */
public class DepLesson {
      private static int EnrollmentLimit = 50;
    
    private int akts;
    private String LectureName;
    private int enrollmentCount;
    private String lessonCode;
    private int classYear;
    private String departmentCode;
    private ArrayList<Student> enrolledStudents;
    private  boolean isMandatory;
    private  Lecturer lecturer;
    public String roomCode;
    private double start;
    private double end;
    private String day;
    public DepLesson(String name){
        this.LectureName = name;
    }
    
    public DepLesson(int akts, String name, Boolean isMandatory, String lessonCode, int classN, String depertmentCode, Lecturer lecturer, String roomCode, double start, double end, String day){
        this.akts = akts;
        this.LectureName = name;
        this.lessonCode = lessonCode;
        this.classYear = classN;
        this.departmentCode = depertmentCode;
        this.enrolledStudents = new ArrayList<>();
        this.lecturer = lecturer;
        this.roomCode = roomCode;
        this.start = start;
        this.end = end;
        this.day = day;
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
    
    public void setLecturer(Lecturer lectr) {
        this.lecturer = lectr;
    }
    
    
    public int getAkts(){return this.akts;}
    public String getLectureName (){return this.LectureName;}
    public String getLectureCode(){return this.lessonCode;}
    public int getClassYear(){return this.classYear;}
    public String getDepartmentCode(){return this.departmentCode;}
    public ArrayList<Student> getStudents(){ return this.enrolledStudents;}
    
    
    @Override
    public String toString() {
        return "Lesson [AKTS = " + akts + ", name = " + LectureName + ", enrollmentLimit = " + EnrollmentLimit + ", enrollmentCount = "
                + this.enrolledStudents.size()  + ", isFull = " + !isAvaliableChair() + ", isMandatory = " + isMandatory + ", lessonCode = " + lessonCode
                + ", classN = " + classYear + ", departmentCode = " + departmentCode + ", lecturer Name = " + lecturer.getName()+", lecturer Surname = "
                +lecturer.getSurname()+", lecturer ıd = "+lecturer.getId()+ ", class = " + roomCode + ", day= " +day+", start=" + start + ", end" + end +"]";
    }
}
