import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
public class Generator{
    public static Faculty generate() throws FileNotFoundException{
        //generating faculty
        Faculty faculty=new Faculty("Faculty of Engineering");
        //generating departments
        Department[] departments=new Department[6]; 
        departments[0]=new Department("Computer Engineering", 1);
        departments[1]=new Department("Civil Engineering", 2);
        departments[2]=new Department("Mechanical Engineering", 3);
        departments[3]=new Department("Electric Electronic", 4);
        departments[4]=new Department("Industry Engineering", 5);
        departments[5]=new Department("Energy Systems Engineering", 6);

        //generating lessons for each department
        //there should be at least 30 lessons for each department
        for (Department department : departments) {
            department.lessons= generateLessons(department);
        }

        return null;
    }

    //generating lessons for each department
    private static Lesson[] generateLessons(Department department) throws FileNotFoundException{
        Lesson[] lessons=new Lesson[30];

        Random rand = new Random();
        //opening file scanner
        File myObj = new File(department.name+".txt");
        Scanner s = new Scanner(myObj);


        for (int i = 0; i < lessons.length; i++) {
            String data = s.nextLine();
            lessons[i]=new Lesson(rand.nextInt(5)+1, data, (rand.nextInt(10)<2 ? false:true), i, rand.nextInt(4)+1, department.departmentCode);
            System.out.println(lessons[i].toString());
        }
        return lessons;
    }


    //generating students
    

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
