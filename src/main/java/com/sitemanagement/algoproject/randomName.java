/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sitemanagement.algoproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author seydullahkaya
 */
public class randomName {
    
   
    
    public static String main(String[] args) throws FileNotFoundException, IOException{
                    
        List<String> nameSurname = new ArrayList<>();

        
        //reading
        //file directory is null
        File f =new File("");
       
        
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)))) {
            String s;
            while((s=reader.readLine())!=null) {
                nameSurname.add(s);
            }
        } 
       
        
       //random method
           int counter = 0;
       Random randomName= new Random();
       for(int i =0 ;i<nameSurname.size();i++){
           counter= randomName.nextInt(nameSurname.size());
           }
    
        
       
       return nameSurname.get(counter);
       
        
        
        
        
        
        
        
        
        
        
        
                    }
                    }
    
        

            
    
    
    
    

