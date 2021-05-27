package rcsas;

import java.awt.*;
import java.io.*;
import java.time.*;
import java.util.*;
import javax.swing.*;

public class RCSAS {
    //Page
    public static Page1HomePage HomePage = new Page1HomePage();
    public static Page2AdminMainPage AdminSecondPage = new Page2AdminMainPage();
    public static Page2RegisterPage SignupPage = new Page2RegisterPage();
    //Person
    public static Role currentLogin = null;
    public static Admin currentAdmin = null;
    public static Student currentStudent = null;
    public static Coach currentCoach = null;
    //ArrayList
    public static ArrayList<Sport> allSport = new ArrayList<Sport>();
    public static ArrayList<String> allSportName = new ArrayList<String>();
    public static ArrayList<Admin> allAdmin = new ArrayList<Admin>();
    public static ArrayList<Coach> allCoach = new ArrayList<Coach>();
    public static ArrayList<String> allCoachName = new ArrayList<String>();
    public static ArrayList<Student> allStudent = new ArrayList<Student>();
    public static ArrayList<String> allStudentName = new ArrayList<String>();
    public static ArrayList<Classes> allClasses = new ArrayList<Classes>();
    public static ArrayList<Booking> allBooking = new ArrayList<Booking>();
    public static ArrayList<Feedback> allFeedback = new ArrayList<Feedback>();
    
    public static void setButton(JButton but){
        but.setBackground(new java.awt.Color(125, 155, 171));
        but.setForeground(Color.WHITE);
        but.setPreferredSize(new Dimension(100,40));
    }
    
    public static void main(String[] args) {
        ScanFile();
    }
    
    private static void ScanFile(){
        try{
            //
            //Sport
            Scanner s = new Scanner(new File("sport.txt"));
            while(s.hasNext()){
                String a = s.nextLine();                            //id
                String b = s.nextLine();                            //name
                SportCentre c = SportCentre.valueOf(s.nextLine());  //location
                String d = s.nextLine();                            //venue
                int e = Integer.parseInt(s.nextLine());             //no_hall
                int f = Integer.parseInt(s.nextLine());             //price
                s.nextLine();
                
                Sport sp = new Sport(a,b,c,d,e,f);
                allSport.add(sp);
                allSportName.add(sp.getName());
            } s.close();
            
            //
            //Admin
            //
            s = new Scanner(new File("admin.txt"));
            while(s.hasNext()){
                String id = s.nextLine();
                String a = s.nextLine();                            //name
                int b = Integer.parseInt(s.nextLine());             //pin
                s.nextLine();
                
                Admin c = new Admin(id,a,b);
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
                String g = s.nextLine();                            //Sport
                LocalDate h = LocalDate.parse(s.nextLine());        //DateJoined
                int i = Integer.parseInt(s.nextLine());             //Duration
                s.nextLine();
                
                for(int sp=0; sp<allSport.size(); sp++){
                    Sport x = allSport.get(sp);
                    if(g.equals(x.getName())){
                        Coach ch = new Coach(a,b,c,d,e,f,x,h,i);
                        allCoach.add(ch);
                        allCoachName.add(b);                  
                    }
                }
            } s.close();
            
            //
            //Student
            //
            s = new Scanner(new File("student.txt"));
            while(s.hasNext()){
                String id = s.nextLine();                           //id
                String a = s.nextLine();                            //name
                int b = Integer.parseInt(s.nextLine());             //pin
                String c = s.nextLine();                            //gender
                String d = s.nextLine();                            //phone
                String e = s.nextLine();                            //email
                String f = s.nextLine();                            //emergency contact
                
                s.nextLine();
                Student st = new Student(id,a,b,c,d,e,f);
                allStudent.add(st);
                allStudentName.add(st.getName());
            } s.close();
            
            //
            //Classes
            //
            boolean error5 = true;
            s = new Scanner(new File("classes.txt"));
            while(s.hasNext()){
                String id = s.nextLine();
                String a = s.nextLine();                            //StudentName
                String b1 = String.valueOf(s.nextLine());           //Sport
                int fe = Integer.parseInt(s.nextLine());            //hourdone
                int c = Integer.parseInt(s.nextLine());             //hourdone
                int d = Integer.parseInt(s.nextLine());             //hasPaid
                boolean e = Boolean.parseBoolean(s.nextLine());     //isAssign
                boolean f = Boolean.parseBoolean(s.nextLine());     //isPaid
                s.nextLine();
                Sport b = null;

                for(int sp=0; sp<allSport.size(); sp++){
                    Sport y = allSport.get(sp);
                    if(b1.equals(y.getName())){
                        b = y;
                    }
                }
                
                for(int st=0; st<allStudent.size(); st++){
                    Student x = allStudent.get(st);
                    if(a.equals(x.getName())){
                        Classes cl = new Classes(id,x,b,fe,c,d,e,f);
                        x.getMyClasses().add(cl);
                        allClasses.add(cl);
                        error5 = false;
                        break;
                    }
                }
                
                
                if(error5){
                    System.out.println("errorclass");
                }
            } s.close();
            
            //
            //Booking
            //
            boolean error6 = true;
            s = new Scanner(new File("booking.txt"));
            while(s.hasNext()){
                String a = s.nextLine();                            //id
                String b = s.nextLine();                            //venue
                LocalDate c = LocalDate.parse(s.nextLine());        //date
                String d1 = String.valueOf(s.nextLine());           //sport
                LocalTime f = LocalTime.parse(s.nextLine());        //timeStarted
                int g = Integer.parseInt(s.nextLine());             //duration
                String i1 = s.nextLine();                           //CoachName
                String h1 = s.nextLine();                           //StudentName
                s.nextLine();
                Coach i = null;
                Sport d = null;
               
                
                for(int sp=0; sp<allSport.size(); sp++){
                    Sport y = allSport.get(sp);
                    if(d1.equals(y.getName())){
                        d = y;
                    }
                }
                
                for(int sp=0; sp<allCoach.size(); sp++){
                    Coach y = allCoach.get(sp);
                    if(i1.equals(y.getName())){
                        i = y;
                    }
                }
                
                for(int st=0; st<allStudent.size(); st++){
                    Student x = allStudent.get(st);
                    if(h1.equals(x.getName())){
                        Booking z = new Booking(a,b,d,c,f,g,i,x);
                        x.getMyBooking().add(z);
                        allBooking.add(z);
                        error6 = false;
                    }
                }
                        
                if(error6){
                    System.out.println("errorbooking");
                }
            }s.close();
            
            //
            //Feedback
            //
            s = new Scanner(new File("feedback.txt"));
            while(s.hasNext()){
                String a1 = s.nextLine();                           //coach
                String b1 = s.nextLine();                           //student
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
          
