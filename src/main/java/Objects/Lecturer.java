package Objects;

import Objects.Lesson;
import java.util.ArrayList;
import java.util.Random;



public class Lecturer {

    private static int MAX_FREE_DAY = 1;
    private static int MAX_LECTURE = 5;
    
    private int id;
    private String name ;
    private String surname;
    private boolean[] avaliableWeekDays ;
    private ArrayList<Lesson> lessons;
    Random rand = new Random();
    
    public Lecturer(int id, String Name, String Surname) throws Exception{
        this.id = id;
        this.name = Name;
        this.surname = Surname;
        this.avaliableWeekDays = new boolean[5];
        this.lessons = new ArrayList<>();

        // Set random free day
        if(rand.nextInt(10)==0){
            this.setFreeDay(rand.nextInt(5));
        }
        else{
            this.setAvaliableAllDay();
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }
    
    /*
     *
     * @param dayNumber  : number in [0-4] representing day of a week monday<->friday
     */
    public void setFreeDay(int dayNumber) throws Exception{
       
       // Set all day as wroking 
       this.setAvaliableAllDay();
       
       if(dayNumber > 4 && dayNumber < 0){
           throw new IllegalArgumentException("Out Of bound exception");
       }
       
       // Set this day lecturer free day in week
       this.avaliableWeekDays[dayNumber] = false;
        
    }

    /*
    *   Set All day as working
    */
    private void setAvaliableAllDay(){
        for(int i = 0; i < 5; i++){
            this.avaliableWeekDays[i] = true;
        }
        /*
        for(boolean day : this.avaliableWeekDays){   //burda çok şey öğrendik!!!!
            day = true;
        }
        */
    }
    //getter for available week days
    public boolean[] getAvaliableWeekDays() {
        return avaliableWeekDays;
    }
    /**
     *
     * @param lesson
     * @return
     */
    public ArrayList<Lesson> enroll(Lesson lesson){
        // Check MAX_LESSON
        if(this.lessons.size() < MAX_LECTURE)
            // Add new Lecture
            this.lessons.add(lesson);
        
        return this.lessons;
    }
    
    


    
    


}
