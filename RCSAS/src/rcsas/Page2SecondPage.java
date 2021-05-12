package rcsas;
import java.awt.*;
import java.awt.event.*;
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
            RCSAS.whoLogin = null;
         }  else if(e.getSource()==book){
            int size = RCSAS.whoLogin.getMyBooking().size();
            if(size==0 || RCSAS.whoLogin.getMyBooking().get(size-1).isPaid()){
                try{
                    String a = JOptionPane.showInputDialog("Hall:");
                    Hall a1 = Hall.valueOf(a);
                    String b = JOptionPane.showInputDialog("Day:");
                    Day b1 = Day.valueOf(b); 
                    String c = JOptionPane.showInputDialog("Code_Sport:");
                    Sport c1 = Sport.valueOf(c);
                    String d = JOptionPane.showInputDialog("Code_Sport_Centre:");
                    Sport d1 = Sport.valueOf(d);
                    int f = Integer.parseInt(JOptionPane.showInputDialog("Time:"));
                    if(f<9 || f>23){
                        throw new Exception();
                    }
                     boolean flag = true;
                    for(int i=0; i<RCSAS.allBooking.size(); i++){
                        Booking x = RCSAS.allBooking.get(i);
                        if(x.getHall().toString().equals(a) &&
                                x.getDate().toString().equals(b) &&
                                x.getTimeStarted() == f){
                            JOptionPane.showMessageDialog(book, "Not available!");
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        int id = 10001+RCSAS.allBooking.size();
                        Booking x = new Booking(id,a1,b1,c1,d1,f,false,RCSAS.whoLogin);
                        RCSAS.whoLogin.getMyBooking().add(x);
                        RCSAS.allBooking.add(x);
                        JOptionPane.showMessageDialog(book, "Id: "+id);
                    } 
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(book, "Wrong input!");
                }
            } else{
                JOptionPane.showMessageDialog(book,"You have unpaid booking!");
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

