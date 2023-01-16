package Objects;


import Objects.Student;
import java.util.ArrayList;

public class Lesson {
    
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
    private String date;
    public Lesson(String name){
        this.LectureName = name;
    }
    
    public Lesson(int akts, String name, Boolean isMandatory, String lessonCode, int classN, String depertmentCode, Lecturer lecturer, String roomCode, String date){
        this.akts = akts;
        this.LectureName = name;
        this.lessonCode = lessonCode;
        this.classYear = classN;
        this.departmentCode = depertmentCode;
        this.enrolledStudents = new ArrayList<>();
        this.lecturer = lecturer;
        this.roomCode = roomCode;
        this.date = date;
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
        return "Lesson [AKTS=" + akts + ", name=" + LectureName + ", enrollmentLimit=" + EnrollmentLimit + ", enrollmentCount="
                + this.enrolledStudents.size()  + ", isFull=" + !isAvaliableChair() + ", isMandatory=" + isMandatory + ", lessonCode=" + lessonCode
                + ", classN=" + classYear + ", departmentCode=" + departmentCode + ", lecturer=" + lecturer + ", class=" + roomCode + ", date=" + date +"]";
    }
}