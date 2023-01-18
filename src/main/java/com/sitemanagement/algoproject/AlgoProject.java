/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sitemanagement.algoproject;

import java.io.FileNotFoundException;
import Objects.*;
import java.util.Random;

/**
 *
 * @author tomahawk
 */
public class AlgoProject {

    public static void main(String[] args) throws FileNotFoundException, Exception {
        // I initialize the K varible to check lesson to place correctly
        int k = 0;
        int classroomcount=15;
        Random rand = new Random();
        Classrooms[] rooms = new Classrooms[15];
        Randomizer randomize = new Randomizer();
        randomize.generateRandomLecturers();
        rooms = randomize.generateClasses();
  
        for (Department dp : randomize.faculty.getDepartments()) {
            System.out.println("---------- " + dp.getName() + " -----------");

            for (Lesson ls : dp.getLessons()) {
                // I initialze the classrooms randomly thats why I created i
                int i = rand.nextInt(classroomcount);
                randomize.lessonSchedule(ls);
                k++;
            }
            //// System.out.println("------------ Lesson --------------");
            //// System.out.println(ls.toString() );
            ////
            //// System.out.println("------------ Students --------------");
            //// for(Student st : ls.getStudents()){
            //// System.out.println(st.toString());
            //// }

        }
        System.out.println(k);
    }

}
