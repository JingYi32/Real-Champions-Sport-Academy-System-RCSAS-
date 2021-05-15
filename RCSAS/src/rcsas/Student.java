package rcsas;
import java.time.LocalDate;
import java.util.*;

public class Student {
    private String name;
    private int pin;
    private String gender;
    private String phone;
    private String email;
    private Sport sport;
    private ArrayList<Booking> myBooking = new ArrayList<Booking>();

    public Student(String name, int pin, String gender, String phone, String email, Sport sport) {
        this.name = name;
        this.pin = pin;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.sport = sport;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }    

    public ArrayList<Booking> getMyBooking() {
        return myBooking;
    }

    public void setMyBooking(ArrayList<Booking> myBooking) {
        this.myBooking = myBooking;
    }
    
}
