import java.io.FileNotFoundException;

//making hello world
class a {
    public static void main(String args[]) throws FileNotFoundException {
        //line below generates departments and lessons
        Generator.generate();
        //line below generates students
        Generator.generateStudents();
    }
}