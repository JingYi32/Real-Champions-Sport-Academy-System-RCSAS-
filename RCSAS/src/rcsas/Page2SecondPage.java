package rcsas;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.*;

public class Page2SecondPage extends JFrame implements ActionListener{
    private Button book, booking_records, display, pay, logout; //booking records=status //display = coach + sport records   
    public Page2SecondPage(){
        setSize(250,100);
        setLocation(1000,300);
        setLayout(new FlowLayout());
        book = new Button("Book");
        booking_records = new Button("Booking Records");
        display = new Button("Display");
        pay = new Button("Pay");
        logout = new Button("Logout");  
        book.addActionListener(this);
        booking_records.addActionListener(this);
        display.addActionListener(this);
        pay.addActionListener(this);
        logout.addActionListener(this);        
        add(book);
        add(booking_records);
        add(display);
        add(pay);
        add(logout);
    }
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==logout){
            setVisible(false);
            RCSAS.HomePage.setVisible(true);
            Student student = null;
        }  
        
        else if(e.getSource()==book){
            String name = JOptionPane.showInputDialog("Student:");
            for(int i=0; i<RCSAS.allStudent.size(); i++){
                Student student = RCSAS.allStudent.get(i);
                if(name.equals(student.getName())){
                    RCSAS.current = student;
                    break;
                }
            }
            if(RCSAS.current == null){
                JOptionPane.showMessageDialog(null, "Worng student name!");
            }
            else{
                int size = RCSAS.current.getMyBooking().size();
                if(size==0 || RCSAS.current.getMyBooking().get(size-1).isPaid()){
                    try{
                        String a = JOptionPane.showInputDialog("Hall:");
                        Hall a1 = Hall.valueOf(a);
                        String b = JOptionPane.showInputDialog("Date(YYYY-MM-DD):");
                        LocalDate b1 = LocalDate.parse(b); 
                        String c = JOptionPane.showInputDialog("Sport:");
                        Sport c1 = Sport.valueOf(c);
                        String d = JOptionPane.showInputDialog("Sport Centre:");
                        SportCenter d1 = SportCenter.valueOf(d);
                        String f = JOptionPane.showInputDialog("Time(HH:MM):");
                        LocalTime f1 = LocalTime.parse(f);
                        if((f1.compareTo(LocalTime.parse("09:00:00"))<0) || (f1.compareTo(LocalTime.parse("23:00:00"))>0)){
                            throw new Exception();
                        }
                        int g = Integer.parseInt(JOptionPane.showInputDialog("Duration:"));
                        LocalTime h = f1.plusHours(g);
                        int i =Integer.parseInt(JOptionPane.showInputDialog("Price:"));
                        boolean flag = true;
                        for(int bk=0; bk<RCSAS.allBooking.size(); bk++){
                            Booking x = RCSAS.allBooking.get(bk);
                            if(x.getHall().toString().equals(a) && 
                                    x.getDate().toString().equals(b) &&
                                    x.getSport().toString().equals(c) &&
                                    x.getTimeStarted() == f1){
                                JOptionPane.showMessageDialog(book, "Not available!");
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            int id = 10001+RCSAS.allBooking.size();
                            Booking x = new Booking(id,a1,b1,c1,d1,f1,g,h,i,false,RCSAS.current);
                            RCSAS.whoLogin.getMyBooking().add(x);
                            RCSAS.allBooking.add(x);
                            JOptionPane.showMessageDialog(book, "Id: "+id);
                        } 
                    } catch(Exception ex){
                        JOptionPane.showMessageDialog(book, "Wrong input!");
                    }
                }
            
                else{
                    JOptionPane.showMessageDialog(book,"You have unpaid booking!");
                }
            }
        } else{
            int size = RCSAS.whoLogin.getMyBooking().size();
            if(size==0 || RCSAS.whoLogin.getMyBooking().get(size-1).isPaid()){
                JOptionPane.showMessageDialog(pay,"You have no unpaid bookings!");
            //} else{
              //  int id = RCSAS.whoLogin.getMyBooking().get(size-1).getId();
               // RCSAS.third.getMessage1().setText("Your booking id is "+id+"!");
                //setVisible(false);
               // RCSAS.third.setVisible(true);
            }
         }
     }
}

