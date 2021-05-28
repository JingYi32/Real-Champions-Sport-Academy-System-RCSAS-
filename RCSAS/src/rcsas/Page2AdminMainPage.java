package rcsas;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javafx.scene.control.DatePicker;
import javax.swing.*;

public class Page2AdminMainPage extends JFrame implements ActionListener{
    final private JLabel title,describe;  
    final private Panel contain,w;
    final private JPanel header,content,label,detail,below;
    private final JButton  add_schedulercds,schedule, display, pay, logout; //add_schedulercds=add schedule records //display = coach + sport records 
    public static ArrayList<Student> allStudent = new ArrayList<Student>();
    private Classes currentClasses;
            
    public Page2AdminMainPage(){
        setSize(1500,800);
        setLocation(200,100);
        
        //
        //header
        //
        header = new JPanel();
        header.setBackground(new java.awt.Color(197, 215, 214));
        header.setBounds(0,0,1500,100);
        title = new JLabel("Admin Page");
        header.add(title);
        title.setFont(RCSAS.HomePage.title);
        title.setForeground(Color.BLACK);
        add(header);
        
        //
        //content
        ///
        content = new JPanel(new BorderLayout());
        content.setBackground(new java.awt.Color(197, 215, 214));
        content.setBounds(0,100,1500,500);
        add(content);
        label = new JPanel(new GridLayout(0,1));
        label.setBackground(new java.awt.Color(197, 215, 214));
        detail = new JPanel(new GridLayout(0,1));
        detail.setBackground(new java.awt.Color(197, 215, 214)); 
        
        //
        //Center
        //
        contain = new Panel(new GridLayout(2,1));
        add(contain,BorderLayout.CENTER);
        
        w = new Panel(new GridBagLayout());
        describe = new JLabel(".......................Welcome to the RCSAS!......................");
        describe.setFont(new Font("Agency FB", Font.BOLD,88));
        describe.setForeground(Color.WHITE);
        w.add(describe);
        w.setBackground(new java.awt.Color(197, 215, 214));
        contain.add(w);
        content.add(describe);        
        
        add_schedulercds = new JButton("Add Schedule Records");
        schedule = new JButton("Schedule");
        display = new JButton("Display");
        pay = new JButton("Pay");
        logout = new JButton("Logout");
              
        add_schedulercds.addActionListener(this);
        schedule.addActionListener(this);
        display.addActionListener(this);
        pay.addActionListener(this);
        logout.addActionListener(this);
              
        setSTButton(add_schedulercds);
        setSTButton(schedule);
        setSTButton(display);
        setSTButton(pay);
        setSTButton(logout);
        
        below = new JPanel();
        below.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        below.setBackground(new java.awt.Color(243, 250, 249));
        below.add(add_schedulercds);
        below.add(schedule);
        below.add(display);
        below.add(pay);
        below.add(logout);
        below.setBounds(0,600,1500,200);
        add(below);
        
        header.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        header.setBackground(new java.awt.Color(243, 250, 249));                     
       // header.add(add_schedulercds);
       // header.add(schedule);
       // header.add(display);
       // header.add(pay);
        //header.add(logout);
       // header.setBounds(0,600,1500,200);
       add(header);
        
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
//    @SuppressWarnings("empty-statement")
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
        
        else if(e.getSource()==display){
            setVisible(false);
            Page3DisplayPage DisplayPage = new Page3DisplayPage();
            DisplayPage.setVisible(true);
        }
        
        else if(e.getSource()==add_schedulercds){            
            AddSchedule();
            RCSAS.currentStudent = null;
        } 
        
        else if (e.getSource() == schedule){
            setVisible(false);
            Page3SchedulePage schedulepage = new Page3SchedulePage();
            schedulepage.setVisible(true);
        }
        
        else if (e.getSource() == pay){
//            int size = RCSAS.currentStudent.getMyClasses().size();
//            if(size==0 || RCSAS.currentStudent.getMyClasses().get(size-1).isPaid()){
//                JOptionPane.showMessageDialog(null,"You have no unpaid bookings!");                                                                 
//            }                  
        }
    }

       
    private void setSTButton(JButton but) {
        but.setBackground(new java.awt.Color(125, 155, 171));
        but.setForeground(Color.BLACK);
        but.setPreferredSize(new Dimension(310,40));
        but.setFont(RCSAS.HomePage.button);
        but.addActionListener(this);
    }
    
    private void AddSchedule(){
       String[] name1 = RCSAS.allStudentName.toArray(new String[RCSAS.allStudentName.size()]);
       String name = (String)JOptionPane.showInputDialog(null, "Student:", 
            "Current Student", JOptionPane.QUESTION_MESSAGE, null, name1, null);
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
                    //Sport
                    ArrayList<String> sports = new ArrayList<>();
                    for(int i=0; i<RCSAS.currentStudent.getMyClasses().size(); i++){
                        sports.add(RCSAS.currentStudent.getMyClasses().get(i).getSport().getName());
                    }
                    String sport[] = sports.toArray(new String[sports.size()]);
                    String c1 = (String)JOptionPane.showInputDialog(
                        null,
                        "Sport:",
                        "Selecting Sport",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        sport,
                        null);
                    Sport c = null;
                    for(int i=0; i<RCSAS.currentStudent.getMyClasses().size(); i++){
                        Sport sp = RCSAS.currentStudent.getMyClasses().get(i).getSport();
                        if(sp.getName().equals(c1)){
                            c = sp;
                            currentClasses = RCSAS.currentStudent.getMyClasses().get(i);
                            break;
                        }
                    }
                    
                    //Date
                    LocalDate b = LocalDate.parse(JOptionPane.showInputDialog("Date(YYYY-MM-DD):"));
                    if(!b.isAfter(LocalDate.now())){
                        throw new Exception("Please select a future date.");
                    }
                    
                    //Time
                    LocalTime d = LocalTime.parse(JOptionPane.showInputDialog("Time(HH:MM):"));
                    if((d.compareTo(LocalTime.parse("09:00:00"))<0) || (d.compareTo(LocalTime.parse("23:00:00"))>0)){
                        throw new Exception();
                    }
                    
                    //Duration
                    int f = Integer.parseInt(JOptionPane.showInputDialog("Duration:"));
                    long f1 = f;
                    LocalTime end = d.plusHours(f1);
                    
                    if(f+currentClasses.getHourdone() > 20){
                        throw new Exception("Student are not allow to have that much of time to traning. His/her available hour is"+ (20-currentClasses.getHourdone()));
                    }
                    
                    if(end.isAfter(LocalTime.parse("23:00:00"))){
                        throw new Exception();
                    }
                    
                    Coach g = null;
                    //Coach
                    String[] coachn = RCSAS.allCoachName.toArray(new String[RCSAS.allCoachName.size()]);
                    String coacht = (String)JOptionPane.showInputDialog(null, "Coach:", 
                        "Select Coach", JOptionPane.QUESTION_MESSAGE, null, coachn, null);
                    for(int i=0; i<RCSAS.allCoach.size(); i++){
                        Coach ch = RCSAS.allCoach.get(i);
                        if(name.equals(ch.getName())){
                            g = ch;
                            break;
                        }           
                    } 
                    
                    int in = 1;
                    String a = null;
                    for(int i=0; i<RCSAS.allBooking.size(); i++){
                        Booking x = RCSAS.allBooking.get(i);
                        if (b.equals(x.getDate()) && c.equals(x.getSport()) && d.equals(x.getTimeStarted())){
                            in = in + 1;
                        }else{

                        }
                    }System.out.println(in);
                    
                    for(int i=0; i<RCSAS.allBooking.size(); i++){
                        Booking x = RCSAS.allBooking.get(i);
                        if (g.equals(x.getTeacher()) && d.equals(x.getTimeStarted()) && b.equals(x.getDate())){
                            flag = false;
                        }
                    }

                    if(in>c.getNo_hall()){
                        flag = false;
                    }

                    if(!flag){
                        JOptionPane.showMessageDialog(null, "Not available!");
                    } else{
                        currentClasses.setHourdone(currentClasses.getHourdone()+f);
                        if(currentClasses.getHourdone() >= 20){
                            currentClasses.setFinish(true);
                        }
                        String v = c.getVenue()+String.format("%02d", in);
                        int idno = 1+RCSAS.allBooking.size();
                        String id = "L-"+ String.format("%04d", idno);
                        Booking y = new Booking(id,v,c,b,d,f,g,RCSAS.currentStudent);
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
    }
}

