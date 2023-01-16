package Objects;

import Objects.Lesson;
import java.util.ArrayList;



public class Lecturer {

    private static int MAX_FREE_DAY = 1;
    private static int MAX_LECTURE = 5;
    
    private int id;
    private String name ;
    private String surname;
    private boolean[] avaliableWeekDays ;
    private ArrayList<Lesson> lessons;
    
    public Lecturer(int id, String Name, String Surname){
        this.id = id;
        this.name = Name;
        this.surname = Surname;
        
        this.avaliableWeekDays = new boolean[5];
        this.lessons = new ArrayList<>();
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
        for(boolean day : this.avaliableWeekDays){
            day = true;
        }
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
