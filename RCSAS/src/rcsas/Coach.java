package rcsas;
import java.util.Date;

public class Coach {
    private int id;
    private String name;
    private Date joined;
    private Date terminated;
    private int rate;
    private long phone;
    private String address;
    private int code_sc;
    private int code_sp;
    private int Rating;

    public Coach(int id, String name, Date joined, Date terminated, int rate, long phone, int code_sc, String name_sc, int code_sp, String name_sp, int Rating) {
        this.id = id;
        this.name = name;
        this.joined = joined;
        this.terminated = terminated;
        this.rate = rate;
        this.phone = phone;
        this.code_sc = code_sc;
        this.code_sp = code_sp;
        this.Rating = Rating;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getJoined() {
        return joined;
    }
    public void setJoined(Date joined) {
        this.joined = joined;
    }

    public Date getTerminated() {
        return terminated;
    }
    public void setTerminated(Date terminated) {
        this.terminated = terminated;
    }

    public int getRate() {
        return rate;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }

    public long getPhone() {
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

    public int getCode_sc() {
        return code_sc;
    }
    public void setCode_sc(int code_sc) {
        this.code_sc = code_sc;
    }

    public int getCode_sp() {
        return code_sp;
    }
    public void setCode_sp(int code_sp) {
        this.code_sp = code_sp;
    }

    public int getRating() {
        return Rating;
    }
    public void setRating(int Rating) {
        this.Rating = Rating;
    }
}
