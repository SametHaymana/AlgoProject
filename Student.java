public class Student {
    public static int count = 0;
    String name;
    int number;
    int classN;
    int departmentCode;
    int numberOfLessonsFromAbove = 0;
    int numberOfLessonsFromBelow = 0;
    public Student(String name, int classN, int departmentCode) {
        this.name = name;
        this.number = count;
        this.classN = classN;
        count++;
        this.departmentCode = departmentCode;
    }
}
