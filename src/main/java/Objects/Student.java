package Objects;

import java.util.ArrayList;

public class Student {
    
    
    private static int MIN_SAME_YEAR_LECTURES = 6;
    private static int MAX_UPPER_YEAR_LECTURE = 3;
    private static int MAX_LOWER_YEAR_LECTURE = 3;
    private static int MAX_AKTS = 30;
    
    
    
    private String name;
    private String surname;
    private int id;
    private int classYear;
    private String departmentCode;
    private int akts;
    private ArrayList<Lesson> enrolledLessons;
    public int countOftermCourse;
    public int countOfUpperTermCourse;
    public int countOfLowerTermCourse;
    
    
  

    public Student(int id, String name, String surname, int classYear, String departmentCode) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.classYear = classYear;
        this.departmentCode = departmentCode;
        
        this.enrolledLessons = new ArrayList<>();
        
        this.akts = 0;
        countOftermCourse= 0;
        countOfUpperTermCourse = 0;
        countOfLowerTermCourse= 0;
    }
    
    
    /**
     *
     * @param lesson
     * @return
     */
    public boolean enroll(Lesson lesson){
        /* if he has akts to enroll */
        if(this.akts + lesson.getAkts() < MAX_AKTS  && this.enrolledLessons.size() <= 6 && this.isEligable(lesson)){

            // Student can enroll the class
            this.enrolledLessons.add(lesson);
            this.akts += lesson.getAkts();
            return true;
        }
        return false;
    }
    
    
    private boolean isEligable(Lesson lesson){  
        // Same year lesson
        if(lesson.getClassYear() == this.classYear && this.countOftermCourse > MIN_SAME_YEAR_LECTURES)
            return true;
        
        if(lesson.getClassYear() > this.classYear && this.countOfUpperTermCourse < MAX_UPPER_YEAR_LECTURE)
            return true;
        
        if(lesson.getClassYear() < this.classYear && this.countOfLowerTermCourse < MAX_LOWER_YEAR_LECTURE)
            return true;
        
        return false;
        
    }
   
    
    @Override
    public String toString() {
        return "Student [name=" + name + " Surname="+ surname +" , number=" + id + ", classN=" + this.classYear + ", departmentCode=" + departmentCode
                + ", numberOfLessons=" + this.enrolledLessons.size() + "]";    
    }
}
