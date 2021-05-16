package rcsas;
import java.util.Date;

public class Student {
    private String name;
    private int pin;
<<<<<<< HEAD
<<<<<<< HEAD
    private int phone;
=======
=======
>>>>>>> parent of 6f7245d (20210514)
    private long phone;
>>>>>>> parent of e0fa173 (20210512)
    private String address;
    private String email;
<<<<<<< HEAD
    private Date dob;

<<<<<<< HEAD
    public Student(String name, int pin, int phone, String address, String email, Date dob) {
=======
    public Student(String name, int pin, long phone, String address, String email, Date dob) {
>>>>>>> parent of e0fa173 (20210512)
=======
    private ArrayList<Booking> myBooking = new ArrayList<Booking>();

    public Student(String name, int pin, long phone, String email) {
>>>>>>> parent of 6f7245d (20210514)
        this.name = name;
        this.pin = pin;
        this.phone = phone;
        this.address = address;
        this.email = email;
<<<<<<< HEAD
        this.dob = dob;
=======
>>>>>>> parent of 6f7245d (20210514)
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
