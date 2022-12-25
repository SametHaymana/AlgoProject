//
//import java.net.URL;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.Random;
//import java.util.Scanner;
//
//public class Mainaaaa {
//
//    static int Global_Student_Count = 0;
//
//    static int Years_ID_number = 13;
//
//    static int Current_Faculty_ID = 50;
//
//    static int Current_Department_ID = 70;
//
//    public static void main(String[] args) {
//
//        LinkedList<Studentaaa> Students = new LinkedList();
//        System.out.println("FETCHING DATA...");
//
//        long start = System.currentTimeMillis();
//        Maincode_student_creating(Students);
//        long end = System.currentTimeMillis();
//        System.out.println("\n<--- Student creation time = "+(end-start)+" milliseconds --->\n");
//
//
//        System.out.println("Students Array size:" + Students.size());
//
//        HashTable OurHashingTable = new HashTable(4001);
//
//
//        long start1 = System.currentTimeMillis();
//        for (Studentaaa student : Students) {
//            OurHashingTable.insert(student.ID, student);
//        }
//        long end1 = System.currentTimeMillis();
//        System.out.println("\n<--- Insering students to hash table = "+(end1-start1)+" milliseconds --->\n");
//
//
//        System.out.println("Our hashing table student size= " + OurHashingTable.getSize());
//        System.out.println("Our Hashing table size" + OurHashingTable.getTableSize());
//        Random rand = new Random();
//        int random = rand.nextInt(81000);
//
//        System.out.println("\nStartring searching for students");
//
//
//        start = System.currentTimeMillis();
//
//        for (int i = 0; i < 100; i++) {
//            System.out.println(OurHashingTable.get(Students.get(random).ID).toString());
//            random = rand.nextInt(81000);
//        }
//
//        end = System.currentTimeMillis();
//        System.out.println("\nFinished searching\n");
//        System.out.println("<--- Searching 100 students from hash table = "+(end-start)+" milliseconds --->\n");
//        //System.out.println("\n*************************************************\n");
//        
//        
//        System.out.println("Open adressing Part didn t work well, so we didn t add it but Class is exist");
//    }
//
//    private static void Maincode_student_creating(LinkedList<Studentaaa> Students) {
//
//        // creating an String array to store names
//        String[] Names = new String[7944];
//        // getting names from the internet
//        Getting_Names_From_URLS(Names);
//        // creating a String array to store surnames
//        String[] Surnames = new String[88799];
//        // getting surnames from the internet
//        Getting_Surnames_From_URLS(Surnames);
//        // Array that holds faculty names
//        String[] Faculty_Names = new String[9];
//        Faculty_Depart_Name_Generator(Faculty_Names, "Faculty ");
//        // Array that holds department names
//        String[] Dept_Names = new String[9];
//        Faculty_Depart_Name_Generator(Dept_Names, "Department ");
//
//        // creating 81k student
//        for (int i = 0; i < 81000; i++) {
//            Students.add(Student_Generator(Names, Surnames, Faculty_Names, Dept_Names));
//        }
//
//    }
//
//    private static void Faculty_Depart_Name_Generator(String[] Faculty_names, String Name_First_Part) {
//        for (int i = 0; i < 9; i++) {
//            Faculty_names[i] = Name_First_Part + "" + (i + 1);
//        }
//    }
//
//    private static void Getting_Surnames_From_URLS(String[] surnames) {
//        int Surname_ARR_Count = 0;
//        try {
//            URL url = new URL("https://raw.githubusercontent.com/arineng/arincli/master/lib/last-names.txt");
//            Surname_ARR_Count = Writer(url, Surname_ARR_Count, surnames, 0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void Getting_Names_From_URLS(String[] Names) {
//        int Names_Arr_count = 0;
//        try {
//            URL url = new URL("https://www.cs.cmu.edu/Groups/AI/areas/nlp/corpora/names/male.txt");
//            Names_Arr_count = Writer(url, Names_Arr_count, Names, 6);
//            url = new URL("https://www.cs.cmu.edu/Groups/AI/areas/nlp/corpora/names/female.txt");
//            Names_Arr_count = Writer(url, Names_Arr_count, Names, 6);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static int Writer(URL url, int count, String[] names, int skipping_line_count) {
//        try {
//            Scanner s = new Scanner(url.openStream());
//            for (int i = 0; i < skipping_line_count; i++) {
//                s.nextLine();
//            }
//            while (s.hasNextLine()) {
//                String line = s.nextLine();
//                names[count] = line;
//                count++;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Error Getting Names!");
//        }
//        return count;
//    }
//
//    private static Studentaaa Student_Generator(String[] names, String[] surnames, String[] Faculty_names,
//            String[] Depart_names) {
//        Studentaaa student = new Studentaaa();
//        student.setID(ID_Generator());
//        Random rand = new Random();
//        student.setName(names[rand.nextInt(7944)]);
//        student.setLastName(surnames[rand.nextInt(88799)]);
//
//        student.setDepartment(Depart_names[GetNextDepartIndex()]);
//        student.setFaculty(Faculty_names[GetNextFacultyIndex()]);
//
//        Global_Student_Count++;
//        return student;
//    }
//
//    private static int ID_Generator() {
//        String ID = String.valueOf(Next_Year_ID_number()) + String.valueOf(Faculty_ID_number())
//                + String.valueOf(Department_ID_number() + String.valueOf(Random_NNN_Creater()));
//        return Integer.parseInt(ID);
//
//    }
//
//    static private int Next_Year_ID_number() {
//        if (Global_Student_Count % 8100 != 0 || Global_Student_Count == 0) {// 8100
//            return Years_ID_number;
//        } else {
//            Years_ID_number++;
//            Current_Faculty_ID = 49;
//            return Years_ID_number;
//        }
//    }
//
//    private static int Faculty_ID_number() {// 9 TANE FACULTY VAR
//
//        if (Global_Student_Count % 900 != 0 || Global_Student_Count == 0) {// DOĞRU 900
//            return Current_Faculty_ID;
//        } else {
//            Current_Faculty_ID++;
//
//            Current_Department_ID = 69;// 70
//
//            return Current_Faculty_ID;
//        }
//    }
//
//    private static int Department_ID_number() {
//
//        if (Global_Student_Count % 100 != 0 || Global_Student_Count == 0) {// 100
//            return Current_Department_ID;
//        } else {
//            Current_Department_ID++;
//            return Current_Department_ID;
//        }
//    }
//
//    static private int index = 0;
//    static private int facultyIndex = 0;
//
//    private static int GetNextDepartIndex() {
//        if (Global_Student_Count % 900 != 0 || Global_Student_Count == 0) {
//            if (Global_Student_Count % 100 != 0 || Global_Student_Count == 0) {
//                return index;
//            } else {
//                index++;
//                return index;
//            }
//        } else {
//            index = 0;
//            return index;
//        }
//    }
//
//    private static int GetNextFacultyIndex() {
//        if (Global_Student_Count % 8100 != 0 || Global_Student_Count == 0) {
//            if (Global_Student_Count % 900 != 0 || Global_Student_Count == 0) {
//                return facultyIndex;
//            } else {
//                facultyIndex++;
//                return facultyIndex;
//            }
//        } else {
//            facultyIndex = 0;
//            return facultyIndex;
//        }
//    }
//
//    static HashSet<Integer> Hundered_Rand_INT = new HashSet();
//
//    private static int Random_NNN_Creater() {
//        Random random = new Random();
//        int a = random.nextInt(999 - 100) + 100;
//
//        if (Hundered_Rand_INT.size() == 100) {
//            Hundered_Rand_INT.clear();
//        }
//
//        if (!Hundered_Rand_INT.contains(a)) {
//            Hundered_Rand_INT.add(a);
//            return a;
//        } else {
//            return Random_NNN_Creater();
//        }
//
//    }
//
//}