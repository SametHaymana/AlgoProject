public class Student {
    public static int count = 0;
    String name;
    int number;
    int class_n;
    int department_code;
    int number_of_lessons_from_above = 0;
    int number_of_lessons_from_below = 0;
    int number_of_lessons_from_same = 0;
    int number_of_lessons_from_other_department = 0;
    public Student(String name, int number, int class_n, int department_code) {
        this.name = name;
        this.number = count;
        this.class_n = class_n;
        count++;
        this.department_code = department_code;
    }
}
