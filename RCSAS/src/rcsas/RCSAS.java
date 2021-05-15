package rcsas;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class RCSAS {
    public static Page1HomePage HomePage = new Page1HomePage();
    public static RegisterPage SignuPage = new RegisterPage();
    public static Page2SecondPage AdminSecondPage = new Page2SecondPage();
    public static Page2StudentMainPage StudentMainPage = new Page2StudentMainPage();
    public static Student current = null;
    public static Admin whoLogin = null;
    public static ArrayList<Student> allStudent = new ArrayList<Student>();
    public static ArrayList<Admin> allAdmin = new ArrayList<Admin>();
    public static ArrayList<Booking> allBooking = new ArrayList<Booking>();
    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(new File("admin.txt"));
            while(s.hasNext()){
                String a = s.nextLine();
                int b = Integer.parseInt(s.nextLine());
                s.nextLine();
                Admin c = new Admin(a,b);
                allAdmin.add(c);
            }
            s.close();
            s = new Scanner(new File("student.txt"));
            while(s.hasNext()){
                String a = s.nextLine();                            //name
                int b = Integer.parseInt(s.nextLine());             //pin
                String c = s.nextLine();                            //gender
                String d = s.nextLine();                            //phone
                String e = s.nextLine();                            //email
                String f = s.nextLine();                            //emergency contact
                Sport g = Sport.valueOf(s.nextLine());              //sport
                
                s.nextLine();
                Student st = new Student(a,b,c,d,e,f,g);
                allStudent.add(st);
            }
            s.close();
            s = new Scanner(new File("booking.txt"));
            while(s.hasNext()){
                int a = Integer.parseInt(s.nextLine());             //id
                Hall b = Hall.valueOf(s.nextLine());                //hall
                LocalDate c = LocalDate.parse(s.nextLine());        //date
                Sport d = Sport.valueOf(s.nextLine());              //sport
                SportCenter e = SportCenter.valueOf(s.nextLine());  //sportcenter
                LocalTime f = LocalTime.parse(s.nextLine());        //timeStarted
                int g = Integer.parseInt(s.nextLine());             //duration
                LocalTime h = LocalTime.parse(s.nextLine());        //timeEnded
                int i = Integer.parseInt(s.nextLine());             //price
                boolean j = Boolean.parseBoolean(s.nextLine());     //paid
                String k = s.nextLine();                            //StudentName
                s.nextLine();
                for(int st=0; st<allStudent.size(); st++){
                    Student x = allStudent.get(st);
                    if(k.equals(x.getName())){
                        Booking y = new Booking(a,b,c,d,e,f,g,h,i,j,x);
                        x.getMyBooking().add(y);
                        allBooking.add(y);                    
                    }
                }
            }
        } catch(Exception ex){
            System.out.println("Error in read!");
        }
    }
}
          
