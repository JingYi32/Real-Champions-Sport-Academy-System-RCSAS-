package rcsas;
import java.time.LocalDate;
import java.util.*;

public class Student {
    private String name;
    private int pin;
    private long phone;
    private String email;
    private ArrayList<Booking> myBooking = new ArrayList<Booking>();

    public Student(String name, int pin, long phone, String email) {
        this.name = name;
        this.pin = pin;
        this.phone = phone;
        this.email = email;
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
