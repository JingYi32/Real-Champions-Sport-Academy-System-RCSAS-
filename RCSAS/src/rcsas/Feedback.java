
package rcsas;

public class Feedback {
    private Coach coach;
    private Student student;
    private int star;
    private String comment;

    public Feedback(Coach coach, Student student, int star, String comment) {
        this.coach = coach;
        this.student = student;
        this.star = star;
        this.comment = comment;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}