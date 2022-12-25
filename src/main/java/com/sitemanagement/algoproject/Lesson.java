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

    public Lesson(int AKTS, String name, Boolean isMandatory, int lessonCode, int classN, int departmentCode) {
        this.AKTS = AKTS;
        this.name = name;
        this.isMandatory = isMandatory;
        this.lessonCode = Integer.parseInt(""+departmentCode+classN+lessonCode);
        this.classN = classN;
        this.departmentCode = departmentCode;
    }

    //returns true if enrollment is succsessful
    public boolean enrollment_isFull(){
        if(enrollmentCount<enrollmentLimit){
            isFull=false;
            enrollmentCount++;
            return true;
        }else{
            isFull=true;
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