package rcsas;

//import java.util.Date;

import java.time.LocalDate;
import java.time.LocalTime;


public class Booking {
    private int id;
    private Hall hall;
    private LocalDate date;
    private Sport sport;
    private SportCenter centre;
    private LocalTime timeStarted;
    private int duration;
    private LocalTime timeEnded;
    private int price;
    private boolean paid;
    private Student owner;

    public Booking(int id, Hall hall, LocalDate date, Sport sport, SportCenter centre, LocalTime timeStarted, int duration, LocalTime timeEnded, int price, boolean paid, Student owner) {
        this.id = id;
        this.hall = hall;
        this.date = date;
        this.sport = sport;
        this.centre = centre;
        this.timeStarted = timeStarted;
        this.duration = duration;
        this.timeEnded = timeEnded;
        this.price = price;
        this.paid = paid;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Hall getHall() {
        return hall;
    }
    public void setHall(Hall hall) {
        this.hall = hall;
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public Sport getSport() {
        return sport;
    }
    public void setSport(Sport code_sp) {
        this.sport = sport;
    }
    public SportCenter getCentre() {
        return centre;
    }
    public void setCentre(SportCenter code_sc) {
        this.centre = code_sc;
    }

    public LocalTime getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(LocalTime timeStarted) {
        this.timeStarted = timeStarted;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalTime getTimeEnded() {
        return timeEnded;
    }

    public void setTimeEnded(LocalTime timeEnded) {
        this.timeEnded = timeEnded;
    }
        
      public int getPrice() {
        return price;
     }
      public void setPrice(int price) {
        this.price = price;
        }
      public boolean isPaid() {
        return paid;
     }
     public void setPaid(boolean paid) {
       this.paid = paid;
     }
     public Student getOwner() {
        return owner;
     }
     public void setOwner(Student owner) {
          this.owner = owner;
     }
    
    
}