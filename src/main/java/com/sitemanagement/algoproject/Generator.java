package com.sitemanagement.algoproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
public class Generator{
    //generating faculty
    private static Faculty faculty=new Faculty("Faculty of Engineering");
    
    public static Faculty generate() throws FileNotFoundException{
        
        
        //generating departments
        Department[] departments=new Department[6]; 
        departments[0]=new Department("Computer Engineering", 1);
        departments[1]=new Department("Civil Engineering", 2);
        departments[2]=new Department("Mechanical Engineering", 3);
        departments[3]=new Department("Electric Electronic", 4);
        departments[4]=new Department("Industrial Engineering", 5);
        departments[5]=new Department("Energy Systems Engineering", 6);

        //generating lessons for each department
        //there should be at least 30 lessons for each department
        for (Department department : departments) {
            department.lessons= generateLessons(department);
        }
        
        faculty.departments=departments;

        return faculty;
    }

    //generating lessons for each department
    private static Lesson[] generateLessons(Department department) throws FileNotFoundException{
        Lesson[] lessons=new Lesson[30];

        Random rand = new Random();
        //opening file scanner
        File myObj = new File(department.name+".txt");
        Scanner s = new Scanner(myObj);

        for (int i = 0; i < 24; i++) {
            String data = s.nextLine();

            lessons[i]=new Lesson(3+rand.nextInt(3), data, (rand.nextInt(10)<2 ? false:true), i, (i/6)+1, department.departmentCode);
            System.out.println(lessons[i].toString());
        }

        for (int i = 24; i < 30; i++) {
            String data = s.nextLine();

            lessons[i]=new Lesson(3+rand.nextInt(3), data, (rand.nextInt(10)<2 ? false:true), i, rand.nextInt(4)+1, department.departmentCode);
            System.out.println(lessons[i].toString());
        }

        s.close();
        return lessons;
    }

    
    //generating students
    public static void generateStudents() throws FileNotFoundException{
        
        for (Department department : Faculty.departments) {
            Random rand = new Random();
            //generating 200 students for each department

            for (int i = 0; i < 200; i++) {
                //TODO:Buraya student name generator implemente edilecek!!
                Student student=new Student("Student "+i, (i/50)+1, department.departmentCode);
                
                //enrolling students to their own lessons randomly around 5 to 7
                for(int x=0;x<5+rand.nextInt(3);x++){
                    enroller(department, student);
                }

                //enrollling students to other departments lessons randomly around 0 to 2 to simulate ORTAK DERSLER :)
                for(int x=0;x<rand.nextInt(3);x++){
                    //randomly choosing a different department from faculty and enrolling student to it
                    Department dep=Faculty.departments[rand.nextInt(Faculty.departments.length)];
                    if(dep.departmentCode!=department.departmentCode){
                        enroller(dep, student);
                    }
                }
                //TODO: Buraya yukarıdan veya aşağıdan eklenecek ders sayısını belirleyecek bir random variable yazılacak
            }
        }

    }
    //this method randolmly chooses one lesson from department and enrolls student to it
    private static  void enroller(Department dep, Student student){
        Random rand = new Random();
        int lessonIndex=rand.nextInt(dep.lessons.length-1);
        Lesson lesson= dep.lessons[lessonIndex];
        System.out.println(lesson.name);
        lesson.enroll(student);
        student.enroll(lesson);

    }

    public static void generateClassroom(){
        char a='A';
        for (int i = 0; i <= 2; i++) {
            for (int j = 2; j < 10; j++) {
                //a+String.valueOf(j) is for decleare ıd
                Classrooms clsr = new Classrooms(a,j,a+String.valueOf(j),50);
                System.out.println(""+clsr.id);
                System.out.println(clsr.Seatlimit);
            }
            a++;
        }
    }

    /*
    private static void Maincode_student_creating(LinkedList<Studentaaa> Students) {

        // creating an String array to store names
        String[] Names = new String[7944];
        // getting names from the internet
        Getting_Names_From_URLS(Names);
        // creating a String array to store surnames
        String[] Surnames = new String[88799];
        // getting surnames from the internet
        Getting_Surnames_From_URLS(Surnames);
        // Array that holds faculty names
        String[] Faculty_Names = new String[9];
        Faculty_Depart_Name_Generator(Faculty_Names, "Faculty ");
        // Array that holds department names
        String[] Dept_Names = new String[9];
        Faculty_Depart_Name_Generator(Dept_Names, "Department ");

        // creating 81k student
        for (int i = 0; i < 81000; i++) {
            Students.add(Student_Generator(Names, Surnames, Faculty_Names, Dept_Names));
        }

    }
    */
}
