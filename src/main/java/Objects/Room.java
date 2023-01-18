/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author hasaneke
 */
public class Room {
    char block;
    int floor;
    public String id;
    int seatlimit;
    public int availableHours[][];
    
    public Room(char block, int floor, String id, int Seatlimit) {
        this.block = block;
        this.floor = floor;
        this.id = id;
        this.seatlimit = Seatlimit;
        availableHours = new int[23][5];
    }
    @Override
    public String toString() {
       return "block= " + block + " floor: " + floor + " id= " + id + "limit= " +  seatlimit + " available hours = " + availableHours[9][0];
    }
}
