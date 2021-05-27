package rcsas;

//import java.util.Date;

import java.time.LocalDate;
import java.time.LocalTime;


public class Booking {
    private String id;
    private String venue;
    private Sport sport;
    private LocalDate date;
    private LocalTime timeStarted;
    private int duration;
    private LocalTime timeEnded;
    private Coach teacher;
    private Student owner;

    public Booking(String id, String venue, Sport sport, LocalDate date, LocalTime timeStarted, int duration, Coach teacher, Student owner) {
        this.id = id;
        this.venue = venue;
        this.sport = sport;
        this.date = date;
        this.timeStarted = timeStarted;
        this.duration = duration;
        this.teacher = teacher;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getVenue() {
        return venue;
    }
    public void setVenue(String venue) {
        this.venue = venue;
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
    public void setSport(Sport sport) {
        this.sport = sport;
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
        timeEnded = timeStarted.plusHours(duration);
        return timeEnded;
    }

    public void setTimeEnded(LocalTime timeEnded) {
        this.timeEnded = timeEnded;
    }

    public Coach getTeacher() {
        return teacher;
    }

    public void setTeacher(Coach teacher) {
        this.teacher = teacher;
    }
    
    public Student getOwner() {
        return owner;
    }
    public void setOwner(Student owner) {
        this.owner = owner;
    }
    
    
}