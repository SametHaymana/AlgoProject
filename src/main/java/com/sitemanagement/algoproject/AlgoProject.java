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
        Randomizer randomize = new Randomizer();
        
        for(Department dp : randomize.faculty.getDepartments()){
            System.out.println("---------- " + dp.getName()+ " -----------" );
            for(Lesson ls : dp.getLessons()){
                System.out.println("------------ Lesson --------------");
                System.out.println(ls.toString() );
                System.out.println("------------ Students --------------");
                for(Student st : ls.getStudents()){
                    System.out.println(st.toString());
                }


            }
            
        }
        
        
    }
}
