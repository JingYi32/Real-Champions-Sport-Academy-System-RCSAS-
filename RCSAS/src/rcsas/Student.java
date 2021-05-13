package rcsas;
import java.time.LocalDate;
import java.util.*;

public class Student {
    private String name;
    private int pin;
    private String gender;
    private long phone;
    private String email;
    private String sport;
    private ArrayList<Booking> myBooking = new ArrayList<Booking>();

    public Student(String name, int pin, String gender, long phone, String email, String sport) {
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

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
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

    public long getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }    
    
}
