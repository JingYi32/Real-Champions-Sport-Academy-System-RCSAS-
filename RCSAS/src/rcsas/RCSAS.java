package rcsas;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class RCSAS {
    //Page
    public static Page1HomePage HomePage = new Page1HomePage();
    public static Page2SecondPage AdminSecondPage = new Page2SecondPage();
    public static Page2StudentMainPage StudentMainPage = new Page2StudentMainPage();
    public static Page3RegisterPage SignuPage = new Page3RegisterPage();
    //Person
    public static Admin whoLogin = null;
    public static Student current = null;
    public static Coach currentCoach = null;
    //ArrayList
    public static ArrayList<Admin> allAdmin = new ArrayList<Admin>();
    public static ArrayList<Coach> allCoach = new ArrayList<Coach>();
    public static ArrayList<Student> allStudent = new ArrayList<Student>();
    public static ArrayList<RegisteredClasses> allClasses = new ArrayList<RegisteredClasses>();
    public static ArrayList<Booking> allBooking = new ArrayList<Booking>();
    public static ArrayList<Feedback> allFeedback = new ArrayList<Feedback>();
    
    public static void main(String[] args) {
        ScanFile();
    }
    
    private static void ScanFile(){
        try{
            //
            //Admin
            //
            Scanner s = new Scanner(new File("admin.txt"));
            while(s.hasNext()){
                String a = s.nextLine();                            //name
                int b = Integer.parseInt(s.nextLine());             //pin
                s.nextLine();
                
                Admin c = new Admin(a,b);
                allAdmin.add(c);
            } s.close();
            
            //
            //Coach
            //
            s = new Scanner(new File("coach.txt"));
            while(s.hasNext()){
                String a = s.nextLine();                            //id
                String b = s.nextLine();                            //name
                String c = s.nextLine();                            //phone
                String d = s.nextLine();                            //gender
                String e = s.nextLine();                            //address
                String f = s.nextLine();                            //econtact
                Sport g = Sport.valueOf(s.nextLine());              //S[prt
                LocalDate h = LocalDate.parse(s.nextLine());        //DateJoined
                int i = Integer.parseInt(s.nextLine());             //Duration
                s.nextLine();
                
                Coach ch = new Coach(a,b,c,d,e,f,g,h,i);
                allCoach.add(ch);
            } s.close();
            
            //
            //Student
            //
            s = new Scanner(new File("student.txt"));
            while(s.hasNext()){
//                String id = s.nextLine();                           //id
                String a = s.nextLine();                            //name
                int b = Integer.parseInt(s.nextLine());             //pin
                String c = s.nextLine();                            //gender
                String d = s.nextLine();                            //phone
                String e = s.nextLine();                            //email
                String f = s.nextLine();                            //emergency contact
                
                s.nextLine();
                Student st = new Student(a,b,c,d,e,f);
                allStudent.add(st);
            } s.close();
            
            //
            //Classes
            //
            s = new Scanner(new File("classes.txt"));
            while(s.hasNext()){
                String a = s.nextLine();                            //StudentName
                Sport b = Sport.valueOf(s.nextLine());              //Sport
                int c = Integer.parseInt(s.nextLine());             //hourdone
                int d = Integer.parseInt(s.nextLine());             //hasPaid
                boolean e = Boolean.parseBoolean(s.nextLine());     //isAssign
                boolean f = Boolean.parseBoolean(s.nextLine());     //isPaid
                s.nextLine();

                for(int st=0; st<allStudent.size(); st++){
                    Student x = allStudent.get(st);
                    if(a.equals(x.getName())){
                        RegisteredClasses cl = new RegisteredClasses(x,b,c,d,e,f);
                        x.getMyClasses().add(cl);
                        allClasses.add(cl);                    
                    }
                }
            } s.close();
            
            //
            //Booking
            //
            s = new Scanner(new File("booking.txt"));
            while(s.hasNext()){
                int a = Integer.parseInt(s.nextLine());             //id
                String b = s.nextLine();                            //venue
                LocalDate c = LocalDate.parse(s.nextLine());        //date
                Sport d = Sport.valueOf(s.nextLine());              //sport
                LocalTime f = LocalTime.parse(s.nextLine());        //timeStarted
                int g = Integer.parseInt(s.nextLine());             //duration
                String h = s.nextLine();                            //StudentName
                s.nextLine();
                
                for(int st=0; st<allStudent.size(); st++){
                    Student x = allStudent.get(st);
                    if(h.equals(x.getName())){
                        Booking y = new Booking(a,b,c,d,f,g,x);
                        x.getMyBooking().add(y);
                        allBooking.add(y);                    
                    }
                }
            }s.close();
            
            //
            //Feedback
            //
            s = new Scanner(new File("feedback.txt"));
            while(s.hasNext()){
                
                String a1 = s.nextLine();                           //coach
                String b1 = s.nextLine();                            //student
                int c = Integer.parseInt(s.nextLine());             //start
                String d = s.nextLine();                            //comment
                s.nextLine();
                Student b = null;

                for(int st=0; st<allStudent.size(); st++){
                    Student x = allStudent.get(st);
                    if(b1.equals(x.getName())){
                        b = x;
                    }
                }
                
                for(int cl=0; cl<allCoach.size(); cl++){
                    Coach x = allCoach.get(cl);
                    if(a1.equals(x.getName())){
                        Feedback y = new Feedback(x,b,c,d);
                        x.getMyfeedback().add(y);
                        allFeedback.add(y);   
                    }
                }
                
                if(b != null){

                }
            }s.close();
            
        } 
        
        catch(FileNotFoundException | NumberFormatException ex){
            System.out.println("Error in read!");
        }
    }
}
          
