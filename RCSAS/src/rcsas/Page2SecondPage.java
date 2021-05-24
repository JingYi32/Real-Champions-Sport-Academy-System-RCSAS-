package rcsas;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.*;
public class Page2SecondPage extends JFrame implements ActionListener{
    private final Button book, booking_records, display, pay, logout; //booking records=status //display = coach + sport records
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
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you want to save your change?");
                switch(a){
                    case JOptionPane.YES_OPTION:
                        String input = JOptionPane.showInputDialog("Password:");
                        if (null == input){

                        } else if(Integer.parseInt(input) == RCSAS.currentAdmin.getPin()){
                            RCSAS.HomePage.Save();
                            setVisible(false);
                            RCSAS.HomePage.setVisible(true);
                            RCSAS.currentAdmin = null;
                            RCSAS.currentStudent = null;
                            RCSAS.currentCoach = null;
                            RCSAS.currentLogin = null;
                        } else{
                            JOptionPane.showMessageDialog(null,"Wrong password!");
                        }
                    case JOptionPane.NO_OPTION:
                            setVisible(false);
                            RCSAS.HomePage.setVisible(true);
                            RCSAS.currentAdmin = null;
                            RCSAS.currentStudent = null;
                            RCSAS.currentCoach = null;
                            RCSAS.currentLogin = null;
                    case JOptionPane.CANCEL_OPTION:
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    case JOptionPane.CLOSED_OPTION:
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }
    
    
    @Override
    @SuppressWarnings("empty-statement")
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==logout){
            String input = JOptionPane.showInputDialog("Password:");
            if (null == input){

            } else if(Integer.parseInt(input) == RCSAS.currentAdmin.getPin()){
                RCSAS.HomePage.Save();
                setVisible(false);
                RCSAS.HomePage.setVisible(true);
                RCSAS.currentAdmin = null;
                RCSAS.currentStudent = null;
                RCSAS.currentCoach = null;
                RCSAS.currentLogin = null;
            } else{
                JOptionPane.showMessageDialog(null,"Wrong password!");
            }
        }  
        
        else if(e.getSource()==book){
            String name = JOptionPane.showInputDialog("Student:");
            for(int i=0; i<RCSAS.allStudent.size(); i++){
                Student student = RCSAS.allStudent.get(i);
                if(name.equals(student.getName())){
                    RCSAS.currentStudent = student;
                    break;
                }
            }
            if(RCSAS.currentStudent == null){
                JOptionPane.showMessageDialog(null, "Worng student name!");
            }
            else{
                int size = RCSAS.currentStudent.getMyClasses().size();
                if(size==0 || (!RCSAS.currentStudent.getMyClasses().get(size-1).isFinish())){
                    boolean flag = true;
                    boolean flagSport = false;
                    try{
                        LocalDate b = LocalDate.parse(JOptionPane.showInputDialog("Date(YYYY-MM-DD):"));
                        String sport[] = RCSAS.allSportName.toArray(new String[RCSAS.allSportName.size()]);
                        String c1 = (String)JOptionPane.showInputDialog(
                            null,
                            "Sport:",
                            "Selecting Sport",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            sport,
                            null);
                        Sport c = null;
                        for(int i=0; i<RCSAS.allSport.size(); i++){
                            Sport sp = RCSAS.allSport.get(i);
                            if(sp.getName().equals(c1)){
                                c = sp;
                                flagSport = true;
                                break;
                            }
                        }
                        if(!flagSport){
                            throw new Exception();
                        }
                        LocalTime d = LocalTime.parse(JOptionPane.showInputDialog("Time(HH:MM):"));
                        if((d.compareTo(LocalTime.parse("09:00:00"))<0) || (d.compareTo(LocalTime.parse("23:00:00"))>0)){
                            throw new Exception();
                        }
                        int f = Integer.parseInt(JOptionPane.showInputDialog("Duration:"));
                        int in = 1;
                        String a = null;
                        for(int i=0; i<RCSAS.allBooking.size(); i++){
                            Booking x = RCSAS.allBooking.get(i);
                            if (b.equals(x.getDate()) && c.equals(x.getSport()) && d.equals(x.getTimeStarted())){
                                in = in + 1;
                            }else{
                                
                            }
                        }System.out.println(in);
                        
                        if(in>c.getNo_hall()){
                            flag = false;
                        }
                        
                        if(!flag){
                            JOptionPane.showMessageDialog(null, "Not available!");
                        } else{
                            String v = c.getVenue()+String.format("%02d", in);
                            int idno = 1+RCSAS.allBooking.size();
                            String id = "L-"+ String.format("%04d", idno);
                            Booking y = new Booking(id,v,b,c,d,f,RCSAS.currentStudent);
                            RCSAS.currentStudent.getMyBooking().add(y);
                            RCSAS.allBooking.add(y);
                            JOptionPane.showMessageDialog(null, "Id: "+id);
                        }
                    } catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Wrong input!");
                    }
                }
            
                else{
                    JOptionPane.showMessageDialog(null,"You have unpaid booking!");
                }
            }
            RCSAS.currentStudent = null;
        } else{
            int size = RCSAS.currentStudent.getMyClasses().size();
            if(size==0 || RCSAS.currentStudent.getMyClasses().get(size-1).isPaid()){
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

