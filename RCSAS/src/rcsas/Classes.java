
package rcsas;

public class Classes {
    private String id;
    private Student student;
    private Sport sport;
    private int hourdone;
    private int hasPaid;
    private boolean Finish;
    private boolean Paid;

    public Classes(String id, Student student, Sport sport, int hourdone, int hasPaid, boolean Finish, boolean Paid) {
        this.id = id;
        this.student = student;
        this.sport = sport;
        this.hourdone = hourdone;
        this.hasPaid = hasPaid;
        this.Finish = Finish;
        this.Paid = Paid;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public int getHourdone() {
        return hourdone;
    }

    public void setHourdone(int hourdone) {
        this.hourdone = hourdone;
    }

    public int getHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(int hasPaid) {
        this.hasPaid = hasPaid;
    }

    public boolean isFinish() {
        return Finish;
    }

    public void setFinish(boolean isAssign) {
        this.Finish = isAssign;
    }

    public boolean isPaid() {
        return Paid;
    }

    public void setPaid(boolean isPaid) {
        this.Paid = Paid;
    }
}

