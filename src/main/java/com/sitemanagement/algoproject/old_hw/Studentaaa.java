
public class Studentaaa {
    String name;
    String lastName;
    int ID;
    String department;
    String faculty;

    public Studentaaa(String name, String lastName, int ID, String department, String faculty){
        this.name = name;
        this.lastName = lastName;
        this.ID = ID;
        this.department = department;
        this.faculty = faculty; 
    }
    public Studentaaa(){
        
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getFaculty() {
        return faculty;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    @Override
    public String toString() {
        return this.name+" "+this.lastName+" "+this.department+" "+this.faculty+" "+this.ID;
    }
}