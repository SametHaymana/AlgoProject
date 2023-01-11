/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sitemanagement.algoproject;


import java.util.*;
import java.io.*;
import Objects.*;



public class Randomizer {
    /*
        This class will create a faculty and fill the faculty with random students, LEssons, Lecturers 
    */
    
    
    public Faculty faculty = new Faculty("Faculty of Engineering");
    
    public Randomizer() throws FileNotFoundException, Exception{
        this.generateDepertments();
        
    }
    
    
    private void generateDepertments() throws FileNotFoundException, Exception{
        /*
            Depertments name is storing in the "Dataset" directory as its name of depertments,
            for example "Electric Electronic.txt" is the file of the Electric Electronic deperments
            lessons store in this file. For this design we will use the name of files as depertment anme and 
            add lectures for this depertments.
            
        */
        
        
        // List files in the directory of dataset
        String[] depertmentFiles = new File("dataSet").list();
        
        // Create depertments and lecturess 
        for(int i = 0 ; i<depertmentFiles.length ; i++){
            
            // For name of the depertment remove extesion of file name
            String depertmentName = depertmentFiles[i].split("\\.")[0];
            
            // Create depertment object
            Department dep = new Department(depertmentName, i);
            
            // Add lessosn with reading files
            
            File depertmentFile = new File("dataSet",depertmentFiles[i]);
            
            Scanner scanner = new Scanner(depertmentFile);
            
            while(scanner.hasNextLine()){
                dep.addLesson(new Lesson(scanner.nextLine()));
            }
            
            scanner.close();
            
            
            // Add depertmant to the faculty
            try{
                
                this.faculty.addDepertment(dep);

            }catch(Exception e){
                // There is no slot for new depertment
                break;
                
            }
            
        }
    
    }
    
    
    
    private ArrayList<String> readLines(File file) throws FileNotFoundException{
        // Helper function for reed file and return lines as index of string array
        ArrayList<String> result = new ArrayList<>();
        
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            result.add(scanner.nextLine());
        }
        
        return result;
        
    }
    
    
    
    private void randomizeStudents() throws FileNotFoundException{
        /*
            This function fill created depertments with random sutudents
        
        
        */
        
        // Load names ass array for accesing random names in instend time
        ArrayList<String> names = this.readLines(new File("names.txt"));
        
        
        // Iterate throught depertments
        for (Department dp : faculty.getDepartments()){
            
            
            // for each depertment will add 200 students
            for(int i=0 ; i< 200 ; i++){
                
            }
            
            
        }



        
    }
    
    
    
    
    
    
    
    
}
