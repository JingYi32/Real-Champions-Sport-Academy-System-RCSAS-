package rcsas;
import java.util.*;

public class Student extends Role{
    private String gender;
    private String phone;
    private String email;
    private String em_phone;
    private ArrayList<Sport> mysport = new ArrayList<>();
    private ArrayList<Classes> myClasses = new ArrayList<>();
    private ArrayList<Booking> myBooking = new ArrayList<>();

    public Student(String id, String name, int pin, String gender, String phone, String email, String em_phone) {
        this.id = id;
        this.name = name;
        this.pin = pin;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.em_phone = em_phone;
    }

    public String getId() {
        return id;
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

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
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

    public String getEm_phone() {
        return em_phone;
    }

    public void setEm_phone(String em_phone) {
        this.em_phone = em_phone;
    }

    public ArrayList<Sport> getMysport() {
        return mysport;
    }

    public void setMysport(ArrayList<Sport> mysport) {
        this.mysport = mysport;
    }

    public ArrayList<Classes> getMyClasses() {
        return myClasses;
    }

    public void setMyClasses(ArrayList<Classes> myClasses) {
        this.myClasses = myClasses;
    }

    public ArrayList<Booking> getMyBooking() {
        return myBooking;
    }

    public void setMyBooking(ArrayList<Booking> myBooking) {
        this.myBooking = myBooking;
    }
    
}
