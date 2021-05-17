
package rcsas;

public class RegisteredClasses {
    private Student student;
    private Sport sport;
    private int hourdone;
    private int hasPaid;
    private boolean isAssign;
    private boolean isPaid;

    public RegisteredClasses(Student student, Sport sport, int hourdone, int hasPaid, boolean isAssign, boolean isPaid) {
        this.student = student;
        this.sport = sport;
        this.hourdone = hourdone;
        this.hasPaid = hasPaid;
        this.isAssign = isAssign;
        this.isPaid = isPaid;
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

    public boolean isIsAssign() {
        return isAssign;
    }

    public void setIsAssign(boolean isAssign) {
        this.isAssign = isAssign;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
    
    
}

