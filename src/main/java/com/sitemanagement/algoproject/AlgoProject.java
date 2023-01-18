/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sitemanagement.algoproject;

import java.io.FileNotFoundException;
import Objects.*;

/**
 *
 * @author tomahawk
 */
public class AlgoProject {

    public static void main(String[] args) throws FileNotFoundException, Exception {
        Randomom random = new Randomom();
        random.generateDepertments();
        random.displaySchedule();
//        Randomizer randomize = new Randomizer();
//        MyRandomizer rand = new MyRandomizer();
//        rand.generateClasses();
//        rand.generateDepertments();
//        randomize.generateRandomLecturers();
//        randomize.generateClasses();
//        for(Department dp : randomize.faculty.getDepartments()){
//            System.out.println("---------- " + dp.getName()+ " -----------" );
//            randomize.schedule= new Lesson[22][5];
//            
//            for(Lesson ls : dp.getLessons()){
//                randomize.lessonSchedule(ls);
////                System.out.println("------------ Lesson --------------");
////                System.out.println(ls.toString() );
////                
////                System.out.println("------------ Students --------------");
////                for(Student st : ls.getStudents()){
////                    System.out.println(st.toString());
////                }
//
//
//            }
//            
//        }
        
        
    }
}
