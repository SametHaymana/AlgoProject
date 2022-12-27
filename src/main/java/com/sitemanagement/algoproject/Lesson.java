package com.sitemanagement.algoproject;

public class Lesson {
    int AKTS;
    String name;
    int enrollmentLimit=50;
    int enrollmentCount=0;
    Boolean isFull=false;
    Boolean isMandatory;
    int lessonCode;
    int classN;
    int departmentCode;
    //student array that hold enrolled students
    Student[] enrolledStudents=new Student[enrollmentLimit];
    public Lesson(int AKTS, String name, Boolean isMandatory, int lessonCode, int classN, int departmentCode) {
        this.AKTS = AKTS;
        this.name = name;
        this.isMandatory = isMandatory;
        this.lessonCode = Integer.parseInt(""+departmentCode+classN+lessonCode);
        this.classN = classN;
        this.departmentCode = departmentCode;
    }

    //returns true if enrollment is succsessful
    public void enroll(Student std){
        if(AvailableForEnrollment()){
            //adding student to enrolled students array
            enrolledStudents[enrollmentCount]=std;
            //increasing enrollment count
            enrollmentCount++;
        }else{
            isFull=true;
        }
    }

    //method for enrollment availability
    public boolean AvailableForEnrollment(){
        if(enrollmentCount<=enrollmentLimit && isFull != false){
            return true;
        }else{
            return false;
        }
    }

    //writing to string
    public String toString() {
        return "Lesson [AKTS=" + AKTS + ", name=" + name + ", enrollmentLimit=" + enrollmentLimit + ", enrollmentCount="
                + enrollmentCount + ", isFull=" + isFull + ", isMandatory=" + isMandatory + ", lessonCode=" + lessonCode
                + ", classN=" + classN + ", departmentCode=" + departmentCode + "]";
    }
}