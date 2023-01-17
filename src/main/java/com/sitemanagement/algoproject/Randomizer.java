/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sitemanagement.algoproject;

import java.util.*;
import java.io.*;
import Objects.*;
import java.util.stream.Collectors;

public class Randomizer {
    //this number shows how many teachers will set freedays

    private static int lecturersCount = 60;

    /*
        This class will create a faculty and fill the faculty with random students, LEssons, Lecturers 
     */
    public Faculty faculty = new Faculty("Faculty of Engineering");
    Lesson[][] schedule = new Lesson[23][5];
    Classrooms[] rooms = new Classrooms[25];
    Lecturer[] lecturers = new Lecturer[180];

    int classCount;

    public Randomizer() throws FileNotFoundException, Exception {
        this.generateDepertments();
        this.randomizeStudents();
        this.generateClasses();

    }

    private void generateExtraClasses() {
        Random rand = new Random();
        char b = 'B';

        for (int i = 15; i < 20; i++) {
            rooms[i] = new Classrooms(b, i, b + String.valueOf(i), 50);
        }
    }

    public void generateClasses() {
        int pin = 0;
        char a = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = pin; j < pin + 5; j++) {
                rooms[j] = new Classrooms(a, j, a + String.valueOf(j), 50);
                System.out.println(rooms[j]);
            }
            pin += 5;
            a++;
        }
    }

    // I check room to place lesson
    public boolean checkRoom(Classrooms room, int d, int h, int akts) {
        //I initialize the flag because we should know how many hours available
        //if flag-1 == akts we return true
        //flag-1 because we assume for 3 akts our lecture time 1 hour so 2 unit
        int flag = 0;
        for (int i = 0; i < akts; i++) {
            if (room.availableHours[h][d] == 0) {
                flag++;
            }
        }
        if (flag-1 == akts) {
            return true;
        } else {
            return false;
        }

    }

    private void generateDepertments() throws FileNotFoundException, Exception {
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

                dep.addLesson(new Lesson(akts, name, isMandotary, lesssonCode, classN, depertmentCode, null, null, null));

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

    //we can initialize with give lecturer abject and days or we can use generateLecturerFreeDaysRandomly() function to generate randomly
    public void generateLecturerFreeDays(Lecturer lecturer, int day) throws Exception {
        lecturer.setFreeDay(day);
    }

    public void generateLecturerFreeDaysRandomly() throws Exception {
        Random rand = new Random();
        int day = rand.nextInt(5);
        for (int i = 0; i < lecturersCount; i++) {
            int lecurersIndex = rand.nextInt(180);
            lecturers[lecurersIndex].setFreeDay(day);
        }

    }

    private void randomizeStudents() throws FileNotFoundException {
        /*
            This function fill created depertments with random sutudents
         */

        // Load names ass array for accesing random names in instend time
        ArrayList<String> names = this.readLines(new File("names.txt"));

        Random rand = new Random();

        // Iterate throught depertments
        for (Department dp : faculty.getDepartments()) {

            // for each depertment will add 200 students
            for (int i = 0; i < 200; i++) {

                // Generate random user information
                // Random name and surname
                String name = names.get(rand.nextInt(88000));
                String surname = names.get(rand.nextInt(88000));

                int classYear = (i % 50) + 1;

                Student student = new Student(i, name, surname, classYear, dp.getDepartmentCode());

                // Select random lesson
                Lesson randLesson = dp.getLessons().get(rand.nextInt(dp.getLessons().size() - 1));
                // enroll lesson for student to the limit
                while (student.enroll(randLesson)) {
                    // Add enrolled list to also lesson
                    randLesson.enroll(student);

                    // Get another random lesson
                    randLesson = dp.getLessons().get(rand.nextInt(dp.getLessons().size() - 1));

                }

            }

        }

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
        for (int i = 0; i < rooms.length; i++) {

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
                    if (checkRoom(rooms[i], day, hours, lesson.getAkts())) {

                        if (lesson.getAkts() == 3 && schedule[hours][day] == null && schedule[hours + 1][day] == null) {
                            rooms[i].availableHours[hours][day]=1;
                            rooms[i].availableHours[hours+1][day]=1;
                            schedule[hours][day] = lesson;
                            schedule[hours + 1][day] = lesson;
                            //  schedule[hours + 2][day] = lesson;
                            System.out.println(lessonDay + "   " + hour + ":" + minute);
                            System.out.println(schedule[hours][day]);
                            System.out.println(schedule[hours + 1][day]);
                            return;
                        } else if (lesson.getAkts() == 4 && schedule[hours][day] == null && schedule[hours + 2][day] == null) {
                            rooms[i].availableHours[hours][day]=1;
                            rooms[i].availableHours[hours+1][day]=1;
                            rooms[i].availableHours[hours+2][day]=1;
                            
                            schedule[hours][day] = lesson;
                            schedule[hours + 1][day] = lesson;
                            schedule[hours + 2][day] = lesson;
                            //             schedule[hours + 3][day] = lesson;
                            System.out.println(lessonDay + "   " + hour + ":" + minute);
                            System.out.println(schedule[hours][day]);
                            System.out.println(schedule[hours + 2][day]);
                            return;
                        } else if (lesson.getAkts() == 5 && schedule[hours][day] == null && schedule[hours + 3][day] == null) {
                            rooms[i].availableHours[hours][day]=1;
                            rooms[i].availableHours[hours+1][day]=1;
                            rooms[i].availableHours[hours+2][day]=1;
                            rooms[i].availableHours[hours+3][day]=1;
                            schedule[hours][day] = lesson;
                            schedule[hours + 1][day] = lesson;
                            schedule[hours + 2][day] = lesson;
                            schedule[hours + 3][day] = lesson;
//                    schedule[hours + 4][day] = lesson;
                            System.out.println(lessonDay + "   " + hour + ":" + minute);
                            System.out.println(schedule[hours][day]);
                            System.out.println(schedule[hours + 3][day]);
                            return;
                        }
                    }

                }
            }

        }
    }

}
