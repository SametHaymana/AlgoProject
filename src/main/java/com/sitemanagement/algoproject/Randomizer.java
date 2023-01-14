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

    /*
        This class will create a faculty and fill the faculty with random students, LEssons, Lecturers 
     */
    public Faculty faculty = new Faculty("Faculty of Engineering");
    Lesson[][] schedule = new Lesson[22][5];

    public Randomizer() throws FileNotFoundException, Exception {
        this.generateDepertments();
        this.randomizeStudents();

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

                dep.addLesson(new Lesson(akts, name, isMandotary, lesssonCode, classN, depertmentCode));

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

                int classYear = rand.nextInt(4) + 1;

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
                if (lesson.getAkts() == 3 && schedule[hours][day] == null && schedule[hours + 1][day] == null) {
                    schedule[hours][day] = lesson;
                    schedule[hours + 1][day] = lesson;
                    System.out.println(lessonDay + "   " + hour + ":" + minute);
                    System.out.println(schedule[hours][day]);
                    System.out.println(schedule[hours + 1][day]);

                    return;
                } else if (lesson.getAkts() == 4 && schedule[hours][day] == null && schedule[hours + 2][day] == null) {
                    schedule[hours][day] = lesson;
                    schedule[hours + 1][day] = lesson;
                    schedule[hours + 2][day] = lesson;
                    System.out.println(lessonDay + "   " + hour + ":" + minute);
                    System.out.println(schedule[hours][day]);
                    System.out.println(schedule[hours + 2][day]);
                    return;
                } else if (lesson.getAkts() == 5 && schedule[hours][day] == null && schedule[hours + 3][day] == null) {
                    schedule[hours][day] = lesson;
                    schedule[hours + 1][day] = lesson;
                    schedule[hours + 2][day] = lesson;
                    schedule[hours + 3][day] = lesson;
                    System.out.println(lessonDay + "   " + hour + ":" + minute);
                    System.out.println(schedule[hours][day]);
                    System.out.println(schedule[hours + 3][day]);
                    return;
                }

            }
        }

    }

}
