package rcsas;
import java.util.Date;

public class Student {
    private String name;
    private int pin;
<<<<<<< HEAD
    private int phone;
=======
    private long phone;
>>>>>>> parent of e0fa173 (20210512)
    private String address;
    private String email;
    private Date dob;

<<<<<<< HEAD
    public Student(String name, int pin, int phone, String address, String email, Date dob) {
=======
    public Student(String name, int pin, long phone, String address, String email, Date dob) {
>>>>>>> parent of e0fa173 (20210512)
        this.name = name;
        this.pin = pin;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.dob = dob;
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

    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    
}
