/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author hasaneke
 */
 public class RoomResponse {
   public double start;
   public double end;
   public String roomCode;
   public String day;
    public RoomResponse(String day, double start, double end, String roomCode) {
        this.start = start;
        this.end = end;
        this.roomCode = roomCode;
        this.day = day;
    }
} 