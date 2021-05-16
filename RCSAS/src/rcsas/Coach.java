package rcsas;
import java.time.LocalDate;
import java.util.*;

public class Coach {
    private String id;
    private String name;
    private String phone;
    private String gender;
    private String address;
    private String econtact;        //Emergency contact
    private Sport sport;
    private LocalDate joined;
    private int duration;
    private LocalDate terminated;
    private int hourrate;
    private ArrayList<Feedback> myfeedback = new ArrayList<>();
    private int Rating;

    public Coach(String id, String name, String phone, String gender, String address, String econtact, Sport sport, LocalDate joined, int duration) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.econtact = econtact;
        this.sport = sport;
        this.joined = joined;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEcontact() {
        return econtact;
    }

    public void setEcontact(String econtact) {
        this.econtact = econtact;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public LocalDate getJoined() {
        return joined;
    }

    public void setJoined(LocalDate joined) {
        this.joined = joined;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getTerminated() {
        return terminated;
    }

    public void setTerminated(LocalDate terminated) {
        this.terminated = terminated;
    }

    public int getHourrate() {
        return hourrate;
    }

    public void setHourrate(int hourrate) {
        this.hourrate = hourrate;
    }

    public ArrayList<Feedback> getMyfeedback() {
        return myfeedback;
    }

    public void setMyfeedback(ArrayList<Feedback> myfeedback) {
        this.myfeedback = myfeedback;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }
}
