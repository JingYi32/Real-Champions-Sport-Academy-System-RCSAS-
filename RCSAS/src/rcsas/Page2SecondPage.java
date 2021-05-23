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
    @Override
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==logout){
            String input = JOptionPane.showInputDialog("Password:");
            if (null == input){

            } else switch (input) {
                case "12345":
                    RCSAS.HomePage.Save();
                    setVisible(false);
                    RCSAS.HomePage.setVisible(true);
                default:
                    JOptionPane.showMessageDialog(null,"Wrong password!");
                    break;
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
                    try{
                        LocalDate b = LocalDate.parse(JOptionPane.showInputDialog("Date(YYYY-MM-DD):")); 
                        Sport c = Sport.valueOf(JOptionPane.showInputDialog("Sport:"));
                        LocalTime d = LocalTime.parse(JOptionPane.showInputDialog("Time(HH:MM):"));
                        if((d.compareTo(LocalTime.parse("09:00:00"))<0) || (d.compareTo(LocalTime.parse("23:00:00"))>0)){
                            throw new Exception();
                        }
                        int f = Integer.parseInt(JOptionPane.showInputDialog("Duration:"));
                        String a = null;
                        for(int no1 = 1; no1<= c.getNo_hall(); no1++){
                            a = c.getVenue()+no1;
                            System.out.println(a);
                            for(int i=0; i<RCSAS.allBooking.size(); i++){
                                Booking x = RCSAS.allBooking.get(i);
                                if (a.equals(x.getVenue()) && x.getDate()==b &&  x.getSport()==c && x.getTimeStarted()==d){
                                    flag = false;
                                }
                            }
                        }
                        if(!flag){
                            JOptionPane.showMessageDialog(null, "Not available!");
                        } else{
                                int idno = 10001+RCSAS.allBooking.size();
                                String id = "L-"+idno;
                                Booking y = new Booking(id,a,b,c,d,f,RCSAS.currentStudent);
                                RCSAS.currentStudent.getMyBooking().add(y);
                                RCSAS.allBooking.add(y);
                                JOptionPane.showMessageDialog(null, "Id: "+id);
                        }
                    } catch(Exception ex){
                        flag = false;
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

