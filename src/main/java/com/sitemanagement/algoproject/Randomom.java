/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sitemanagement.algoproject;

import Objects.Classrooms;
import Objects.Lecturer;
import Objects.Lesson;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import Objects.RoomResponse;
import Objects.DepLesson;
import Objects.MyDepartment;
import Objects.MyFaculty;

/**
 *
 * @author hasaneke
 */
public class Randomom {

    public void generateClasses() {
        int pin = 0;
        char a = 'A';
        for (int i = 0; i < 40; i++) {
            for (int j = pin; j < pin + 7; j++) {
                rooms[j] = new Classrooms(a, j, a + String.valueOf(j), 50);
                System.out.println(rooms[j]);
            }
            pin += 5;
            a++;
        }
    }
    public MyFaculty faculty = new MyFaculty("Faculty of Engineering");
    int[][][] roomAvailability = new int[5][280][100];
    Classrooms[] rooms = new Classrooms[280];

    public void generateDepertments() throws FileNotFoundException, Exception {

        /*
            Depertments name is storing in the "Dataset" directory as its name of depertments,
            for example "Electric Electronic.txt" is the file of the Electric Electronic deperments
            lessons store in this file. For this design we will use the name of files as depertment anme and 
            add lectures for this depertments.
            
         */
        // List files in the directory of dataset
        String[] depertmentFiles = new File("dataSet").list();
        generateClasses();
        // Create depertments and lecturess 
        for (int i = 0; i < depertmentFiles.length; i++) {

            // For name of the depertment remove extesion of file name
            String depertmentName = depertmentFiles[i].split("\\.")[0];

            // Create depertment object
            // depertment code is starting char of each word in the depertment name
            String depertmentCode = Arrays.stream(depertmentName.split(" "))
                    .map(s -> s.substring(0, 1))
                    .collect(Collectors.joining()).toUpperCase();

            MyDepartment dep = new MyDepartment(depertmentName, depertmentCode);

            // Add lessosn with reading files
            File depertmentFile = new File("dataSet", depertmentFiles[i]);

            Scanner scanner = new Scanner(depertmentFile);

            Random rand = new Random();
            while (scanner.hasNextLine()) {
                // inceramet value
                int j = 0;

                // Add random information to lessons
                // Akts will be betwen 3 - 5
                int akts = 3 + rand.nextInt(3);
                String name = scanner.nextLine();

                // Creating classN is the year of lecture it will be 1-4
                int classN = rand.nextInt(3) + 1;   // it is betwen 0-3 so add 1 

                // Lesson code is simple code that will assignet for each unique lessons
                String lesssonCode = depertmentCode + classN + "0" + j++;

                // Randomly make it mondotary of not
                Boolean isMandotary = rand.nextInt(99999) % 2 == 0 ? Boolean.TRUE : Boolean.FALSE;
                RoomResponse room = getRoom(akts);
                DepLesson lesson = new DepLesson(akts, name, isMandotary, lesssonCode, classN, depertmentCode, generateLecturer(), room.roomCode, room.start + 8, room.end + 8, room.day);
                dep.addLesson(lesson);  
                j++;
            }
            
            scanner.close();

            // Add depertmant to the faculty
            try {

                this.faculty.addDepertment(dep);

            } catch (Exception e) {
                // There is no slot for new depertment
                break;

            }

        }

    }

    public void displaySchedule() {
          for(int dep = 0; dep<this.faculty.getDepartments().size(); dep++){
              System.out.println(this.faculty.getDepartments().get(dep).getName());
             for(int day = 0; day<5; day++) {
               System.out.println(getDay(day));
               for(int ls = 0; ls<this.faculty.getDepartments().get(dep).getLessons().size(); ls++) {
                   System.out.println(this.faculty.getDepartments().get(dep).getLessons().get(ls));
               }
           }
          }
           
    }

    public Lecturer generateLecturer() throws FileNotFoundException, Exception {
        ArrayList<String> lecturerName = this.readLines(new File("names.txt"));
        Random rand = new Random();
        return new Lecturer(rand.nextInt(75000), lecturerName.get(rand.nextInt(75000)), lecturerName.get(rand.nextInt(75000)));
    }

    private ArrayList<String> readLines(File file) throws FileNotFoundException {
        // Helper function for reed file and return lines as index of string array
        ArrayList<String> result = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            result.add(scanner.nextLine());
        }

        return result;
    }

    public RoomResponse getRoom(int akts) {
        for (int i = 0; i < 5; i++) {
            for (int r = 0; r < 50; r++) {
                for (int h = 0; h < 8 ; h++) {
                    if (roomAvailability[i][r][h] == 0) {
                            boolean flag = false;
                            for(int x = h; x<h+akts; x++) {
                                if(roomAvailability[i][r][x] == 1) {
                                    flag = !flag;
                                    break;
                                }
                            }
                            if(flag) break;
                            for (int f = h; f < h + (akts-2); f++) {
                                roomAvailability[i][r][f] = 1;
                            }
                            return new RoomResponse(getDay(i),h, h + (akts / 2), rooms[r].id);
                    }
                }
            }
        }
        return null;
    }

    public String getDay(int d) {
        switch (d) {
            case 0:
                return "Monday";

            case 1:
                return "Tuesday";

            case 2:
                return "Wednesday";

            case 3:
                return "Thursday";

            case 4:
                return "Friday";
        }
        return "";
    }
}
