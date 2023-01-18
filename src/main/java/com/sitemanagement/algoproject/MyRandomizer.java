/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sitemanagement.algoproject;

import Objects.Classrooms;
import Objects.Department;
import Objects.Faculty;
import Objects.Lecturer;
import Objects.Lesson;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author hasaneke
 */
public class MyRandomizer {

    public Faculty faculty = new Faculty("Faculty of Engineering");
    Lesson[][] schedule = new Lesson[23][5];
    Lecturer[] lecturers = new Lecturer[180];
    int[][][] roomAvailability = new int[5][25][17];
    Classrooms[] rooms = new Classrooms[25];
    int[][] scheduleCheck = new int[23][5];

    public void generateDepertments() throws FileNotFoundException, Exception {
        /*
            Depertments name is storing in the "Dataset" directory as its name of depertments,
            for example "Electric Electronic.txt" is the file of the Electric Electronic deperments
            lessons store in this file. For this design we will use the name of files as depertment anme and 
            add lectures for this depertments.
            
         */

        // List files in the directory of dataset
        String[] depertmentFiles = new File("dataSet").list();

        // Create depertments and lecturess 
        for (int i = 0; i < depertmentFiles.length; i++) {

            // For name of the depertment remove extesion of file name
            String depertmentName = depertmentFiles[i].split("\\.")[0];

            // Create depertment object
            // depertment code is starting char of each word in the depertment name
            String depertmentCode = Arrays.stream(depertmentName.split(" "))
                    .map(s -> s.substring(0, 1))
                    .collect(Collectors.joining()).toUpperCase();

            Department dep = new Department(depertmentName, depertmentCode);

            // Add lessosn with reading files
            File depertmentFile = new File("dataSet", depertmentFiles[i]);

            Scanner scanner = new Scanner(depertmentFile);

            Random rand = new Random();
            while (scanner.hasNextLine()) {
                // inceramet value
                int j = 0;

                // Add random information to lessons
                // Akts will be betwen 3 - 5
                int akts = 3 + rand.nextInt(2);
                String name = scanner.nextLine();

                // Creating classN is the year of lecture it will be 1-4
                int classN = rand.nextInt(3) + 1;   // it is betwen 0-3 so add 1 

                // Lesson code is simple code that will assignet for each unique lessons
                String lesssonCode = depertmentCode + classN + "0" + j++;

                // Randomly make it mondotary of not
                Boolean isMandotary = rand.nextInt(99999) % 2 == 0 ? Boolean.TRUE : Boolean.FALSE;
                Lesson lesson = new Lesson(akts, name, isMandotary, lesssonCode, classN, depertmentCode, generateLecturer(), getRoom(akts), null);
                dep.addLesson(lesson);
                lessonSchedule(lesson);
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

    private ArrayList<String> readLines(File file) throws FileNotFoundException {
        // Helper function for reed file and return lines as index of string array
        ArrayList<String> result = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            result.add(scanner.nextLine());
        }

        return result;

    }

    public void generateRandomLecturers() throws FileNotFoundException, Exception {
        int id = 0;
        //I read from names.txt
        ArrayList<String> lecturerName = this.readLines(new File("names.txt"));
        Random rand = new Random();
        //We create numberofDepartments * lessonNumber lecturer
        for (Department dp : faculty.getDepartments()) {
            for (int i = 0; i < dp.getLessons().size(); i++) {
                id++;
                String lecturerNames = lecturerName.get(rand.nextInt(75000));
                String lecturerSurname = lecturerName.get(rand.nextInt(75000));
                Lecturer lecturer = new Lecturer(id, lecturerNames, lecturerSurname);
                Lesson lesson = dp.getLessons().get(i);
                lesson.setLecturer(lecturer);

            }
        }
    }

    public void generateClasses() {
        int pin = 0;
        char a = 'A';
        for (int i = 0; i < 5; i++) {
            for (int j = pin; j < pin + 5; j++) {
                rooms[j] = new Classrooms(a, j, a + String.valueOf(j), 50);
                System.out.println(rooms[j]);
            }
            pin += 5;
            a++;
        }
    }

    public Lecturer generateLecturer() throws FileNotFoundException, Exception {
        ArrayList<String> lecturerName = this.readLines(new File("names.txt"));
        Random rand = new Random();
        return new Lecturer(rand.nextInt(75000), lecturerName.get(rand.nextInt(75000)), lecturerName.get(rand.nextInt(75000)));
    }

    public String getRoom(int akts) {
        for (int i = 0; i < 5; i++) {
            for (int r = 0; r < 25; r++) {
                for (int h = 0; h < 17; h++) {
                    if (roomAvailability[i][r][h] == 0) {

                        roomAvailability[i][r][h] = 1;

                        return rooms[r].id;
                    }
                }
            }
        }
        return null;
    }

    public void lessonSchedule(Lesson lesson) {
        /*
        3 AKTS = 1 Hour
        4 AKTS = 1.5 Hour
        5 AKTS = 2 Hour
         */
        String lessonDay = "";
        int hour = 0;
        String minute = "";

        for (int hours = 0; hours < 22; hours++) {
            for (int day = 0; day < 5; day++) {
                switch (day) {
                    case 0:
                        lessonDay = "Monday";
                        break;
                    case 1:
                        lessonDay = "Tuesday";
                        break;
                    case 2:
                        lessonDay = "Wednesday";
                        break;
                    case 3:
                        lessonDay = "Thursday";
                        break;
                    case 4:
                        lessonDay = "Friday";
                        break;
                }

                if (hours % 2 == 0) {
                    minute = "00";
                } else {
                    minute = "30";
                }
                hour = 8 + (hours / 2);
                // int roomIndex = checkRoom(day, hours, lesson.getAkts());
                //lesson.roomCode = rooms[roomIndex].id;
                if (hour > 18) {
                    return;
                }
                if (lesson.getAkts() == 3 && scheduleCheck[hours][day] == 0 && scheduleCheck[hours + 1][day] == 0) {

                    schedule[hours][day] = lesson;
                    schedule[hours + 1][day] = lesson;
                    scheduleCheck[hours][day] = 1;
                    scheduleCheck[hours + 1][day] = 1;
                    //  schedule[hours + 2][day] = lesson;
                    System.out.println(lessonDay + "   " + hour + ":" + minute);
                    // System.out.println(schedule[hours][day]);
                    //System.out.println(schedule[hours + 1][day]);
                    return;
                } else if (lesson.getAkts() == 4 && scheduleCheck[hours][day] == 0 && scheduleCheck[hours + 2][day] == 0) {

                    schedule[hours][day] = lesson;
                    schedule[hours + 1][day] = lesson;
                    schedule[hours + 2][day] = lesson;
                    scheduleCheck[hours][day] = 1;
                    scheduleCheck[hours + 1][day] = 1;

                    scheduleCheck[hours + 2][day] = 1;
                    //             schedule[hours + 3][day] = lesson;
                    System.out.println(lessonDay + "   " + hour + ":" + minute);
                    System.out.println(schedule[hours][day]);
                    //System.out.println(schedule[hours + 2][day]);
                    return;
                } else if (lesson.getAkts() == 5 && scheduleCheck[hours][day] == 0 && scheduleCheck[hours + 3][day] == 0) {
                    schedule[hours][day] = lesson;
                    schedule[hours + 1][day] = lesson;
                    schedule[hours + 2][day] = lesson;
                    schedule[hours + 3][day] = lesson;
                    scheduleCheck[hours][day] = 1;
                    scheduleCheck[hours + 1][day] = 1;

                    scheduleCheck[hours + 2][day] = 1;
                    scheduleCheck[hours + 3][day] = 1;

//                    schedule[hours + 4][day] = lesson;
                    System.out.println(lessonDay + "   " + hour + ":" + minute);
                    //System.out.println(schedule[hours][day]);
                    //System.out.println(schedule[hours + 3][day]);
                    return;
                }
            }

        }

    }

}
