package rcsas;

import java.util.Date;

public class Booking {
    private int id;
    private Hall hall;
    private Date date;
    private String code_sp;
    private String code_sc;
    private int timeStarted;
    private int duration;
    private int timeEnded;
    private int price;
    private boolean paid;
    private Student owner;

    public Booking(int id, Hall hall, Date date, String code_sp, String code_sc, int timeStarted, int duration, int timeEnded, int price, boolean paid, Student owner) {
        this.id = id;
        this.hall = hall;
        this.date = date;
        this.code_sp = code_sp;
        this.code_sc = code_sc;
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
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getCode_sp() {
        return code_sp;
    }
    public void setCode_sp(String code_sp) {
        this.code_sp = code_sp;
    }
    public String getCode_sc() {
        return code_sc;
    }
    public void setCode_sc(String code_sc) {
        this.code_sc = code_sc;
    }
    public int getTimeStarted() {
        return timeStarted;
    }
    public void setTimeStarted(int timeStarted) {
        this.timeStarted = timeStarted;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getTimeEnded() {
        return timeEnded;
    }
    public void setTimeEnded(int timeEnded) {
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