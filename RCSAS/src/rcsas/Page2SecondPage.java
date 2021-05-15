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
                    boolean flag = true;
                    String a = null;
                    LocalDate b1 = null;
                    Sport c1 = null;
                    LocalTime d1 = null;
                    int f = 0;
                    LocalTime g = null;
                    int h = 0;
                    try{
                        String b = JOptionPane.showInputDialog("Date(YYYY-MM-DD):");
                        b1 = LocalDate.parse(b); 
                        String c = JOptionPane.showInputDialog("Sport:");
                        c1 = Sport.valueOf(c);
                        String d = JOptionPane.showInputDialog("Time(HH:MM):");
                        d1 = LocalTime.parse(d);
                        if((d1.compareTo(LocalTime.parse("09:00:00"))<0) || (d1.compareTo(LocalTime.parse("23:00:00"))>0)){
                            throw new Exception();
                        }
                        f = Integer.parseInt(JOptionPane.showInputDialog("Duration:"));
                        g = d1.plusHours(f);
                        h =Integer.parseInt(JOptionPane.showInputDialog("Price:"));
                        for(int bk=0; bk<RCSAS.allBooking.size(); bk++){
                            Booking x = RCSAS.allBooking.get(bk);
                            for(int no_hall=1; no_hall<=c1.getNo_hall(); no_hall++){
                                a = c1.getVenue()+no_hall;
                                System.out.println(a);
                                if (x.getVenue().toString().equals(a) && x.getDate().toString().equals(b) &&  x.getSport().toString().equals(c) && x.getTimeStarted() == d1){
                                    flag = false;
                                }else{
                                    flag = true;
                                    break;
                                }
                            }
                        }
                    } catch(Exception ex){
                        flag = false;
                        JOptionPane.showMessageDialog(null, "Wrong input!");
                    }
                    
                    if(flag){
                        int id = 10001+RCSAS.allBooking.size();
                        Booking x = new Booking(id,a,b1,c1,d1,f,g,h,false,RCSAS.current);
                        RCSAS.whoLogin.getMyBooking().add(x);
                        RCSAS.allBooking.add(x);
                        JOptionPane.showMessageDialog(null, "Id: "+id);
                    }else{
                        JOptionPane.showMessageDialog(null, "Not available!");
                    }
                }
            
                else{
                    JOptionPane.showMessageDialog(null,"You have unpaid booking!");
                }
            }
        } else{
            int size = RCSAS.whoLogin.getMyBooking().size();
            if(size==0 || RCSAS.whoLogin.getMyBooking().get(size-1).isPaid()){
                JOptionPane.showMessageDialog(null,"You have no unpaid bookings!");
            //} else{
              //  int id = RCSAS.whoLogin.getMyBooking().get(size-1).getId();
               // RCSAS.third.getMessage1().setText("Your booking id is "+id+"!");
                //setVisible(false);
               // RCSAS.third.setVisible(true);
            }
         }
     }
}

