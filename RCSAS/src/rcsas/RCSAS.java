package rcsas;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

public class RCSAS {
    public static Page1HomePage HomePage = new Page1HomePage();
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
                String a = s.nextLine();
                int b = Integer.parseInt(s.nextLine());
                long c = Long.parseLong(s.nextLine());
                String d = s.nextLine();
                s.nextLine();
                Student st = new Student(a,b,c,d);
                allStudent.add(st);
            }
            // s = new Scanner(new File("booking.txt"));
            //while(s.hasNext()){
            //    int a = Integer.parseInt(s.nextLine());
            //    Hall b = Hall.valueOf(s.nextLine());
            //Date c = Date.valueOf(s.nextLine());
            //   int d = Integer.parseInt(s.nextLine());
            //   boolean e = Boolean.parseBoolean(s.nextLine());
            //  String f = s.nextLine();
            //  s.nextLine();
            //  for(int i=0; i<allAdmin.size(); i++){
            //      Admin x = allAdmin.get(i);
            //      if(f.equals(x.getName())){
            //          Booking y = new Booking(a,b,d,e,x);
            //        x.getMyBooking().add(y);
            //          allBooking.add(y);                    
                
                    
        } catch(Exception ex){
            System.out.println("Error in read!");
                }
        }
    }
          
