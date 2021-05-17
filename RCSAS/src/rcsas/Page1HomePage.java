package rcsas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;


public class Page1HomePage extends JFrame implements ActionListener{
    
    final private Panel y1,y2,y2_1, w, content;
    final private Button login, signup, exit;
    final private JLabel system, welcome, describe;
    
    public Page1HomePage(){
        Font myFont = new Font("Serif", Font.PLAIN, 32);

        //Frame Properties
        setSize(1500,800);
        setLocation(200,100);
                
        //Panel Properties
        y1 = new Panel(new GridLayout(2,1));
        add(y1,BorderLayout.CENTER);
        
        w = new Panel(new GridBagLayout());
        welcome = new JLabel("Welcome to the RCSAS!");
        welcome.setFont(new Font("Serif", Font.BOLD,88));
        w.add(welcome);
        y1.add(w);
        content = new Panel();
        describe = new JLabel("<html>We have conduct classes on ten type of sports which are the Swimming, Badminton, Football, Archery, Gymnastics, Volleyball, Basketball, Cricket, Tennis and Table Tennis at Puchong, Subang and Damansara.</html>");
        describe.setFont(new Font("Serif", Font.PLAIN,24));
        describe.setPreferredSize(new Dimension(1000,300));
        content.add(describe);
        y1.add(content);
        
        y2 = new Panel();
        y2.setBackground(new java.awt.Color(204, 166, 166));
        y2.setLayout(new GridLayout(1,2));
        
        system = new JLabel("Real Champions Sport Academy",Label.LEFT);
        system.setFont(myFont);
        y2.add(system);
        
        y2_1 = new Panel(new GridBagLayout());
        y2_1.setPreferredSize(new Dimension(1500,100));
        
        //Creating Button
        login = new Button("Login");
        signup = new Button("Sign up");
        exit = new Button("Exit");
        
        //Properties of Button
        login.setPreferredSize(new Dimension(100,40));
        login.setFont(new Font("Serif", Font.PLAIN, 18));
        signup.setPreferredSize(new Dimension(100,40));
        signup.setFont(new Font("Serif", Font.PLAIN, 18));
        exit.setPreferredSize(new Dimension(100,40));
        exit.setFont(new Font("Serif", Font.PLAIN, 18));
        
        //Adding Action Listener to Button
        login.addActionListener(this);
        signup.addActionListener(this);
        exit.addActionListener(this);
        
        //Adding item
        y2_1.add(login, new GridBagConstraints());
        y2_1.add(signup, new GridBagConstraints());
        y2_1.add(exit, new GridBagConstraints());
        y2.add(y2_1);
        add(y2,BorderLayout.NORTH);
        setVisible(true);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you want to save your change?");
                switch(a){
                    case JOptionPane.YES_OPTION:
                        Save();
                    case JOptionPane.NO_OPTION:
                        System.exit(0);
                    case JOptionPane.CANCEL_OPTION:
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    case JOptionPane.CLOSED_OPTION:
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
       if(e.getSource()==exit){
           Save();
        } else if(e.getSource()==signup){
            setVisible(false);
            RCSAS.SignuPage.setVisible(true);
        } else{
            String[] options = {"Admin", "Student"};
            int op = JOptionPane.showOptionDialog(null, "Please select your role:","Role for Login",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            //Admin
            if(op == 0){
                String s = JOptionPane.showInputDialog("Username:");
                for(int i=0; i<RCSAS.allAdmin.size(); i++){
                    Admin c = RCSAS.allAdmin.get(i);
                    if(s.equals(c.getName())){
                        RCSAS.whoLogin = c;
                        break;
                    }
                }            
                if(RCSAS.whoLogin==null){
                    JOptionPane.showMessageDialog(null, "Wrong username!");
                }else{
                    s = JOptionPane.showInputDialog("Password:");
                    if(Integer.parseInt(s) != RCSAS.whoLogin.getPin()){
                        JOptionPane.showMessageDialog(null, "Wrong password!");
                        RCSAS.whoLogin = null;
                    } else{
                        setVisible(false);
                        RCSAS.AdminSecondPage.setVisible(true);
                    }
                }
            }
            
            //Student
            else if(op == 1){
                String s = JOptionPane.showInputDialog("Username:");
                for(int i=0; i<RCSAS.allStudent.size(); i++){
                    Student c = RCSAS.allStudent.get(i);
                    if(s.equals(c.getName())){
                        RCSAS.current = c;
                        break;
                    }
                }
                
                if(RCSAS.current==null){
                    JOptionPane.showMessageDialog(null, "Wrong username!");
                }else{
                    s = JOptionPane.showInputDialog("Password:");
                    if(Integer.parseInt(s) == RCSAS.current.getPin()){
                        setVisible(false);
                        SettingStudentMainPage();
                        RCSAS.StudentMainPage.setVisible(true);
                    } else{
                        JOptionPane.showMessageDialog(null, "Wrong password!");
                        RCSAS.current = null;
                    }
                }
            }
            //Error
            else{
                System.out.println("Error");
            }
        }
    }
    
    private void Save(){
        String input = JOptionPane.showInputDialog("Password:");
        if (null == input){
            
        } else switch (input) {
            case "12345":
                try{
                    //Admin
                    PrintWriter p = new PrintWriter("admin.txt");
                    for(int i=0; i<RCSAS.allAdmin.size(); i++){
                        Admin c = RCSAS.allAdmin.get(i);
                        p.println(c.getName());
                        p.println(c.getPin());
                        p.println();
                    }
                    p.close();
                    
                    //Coach
                    p = new PrintWriter("coach.txt");
                    for(int i=0; i<RCSAS.allCoach.size(); i++){
                        Coach b = RCSAS.allCoach.get(i);
                        p.println(b.getId());
                        p.println(b.getName());
                        p.println(b.getPhone());
                        p.println(b.getGender());
                        p.println(b.getAddress());
                        p.println(b.getEcontact());
                        p.println(b.getSport());
                        p.println(b.getJoined());
                        p.println(b.getDuration());
                        p.println();
                    }
                    p.close();
                    
                    //Student
                    p = new PrintWriter("student.txt");
                    for(int i=0; i<RCSAS.allStudent.size(); i++){
                        Student st = RCSAS.allStudent.get(i);
                        p.println(st.getName());
                        p.println(st.getPin());
                        p.println(st.getGender());
                        p.println(st.getPhone());
                        p.println(st.getEmail());
                        p.println(st.getEm_phone());
                        p.println();
                    }
                    p.close();
                    
                    //Classes
                    p = new PrintWriter("classes.txt");
                    for(int i=0; i<RCSAS.allClasses.size(); i++){
                        RegisteredClasses b = RCSAS.allClasses.get(i);
                        p.println(b.getStudent().getName());
                        p.println(b.getSport());
                        p.println(b.getHourdone());
                        p.println(b.getHasPaid());
                        p.println(b.isIsAssign());
                        p.println(b.isIsPaid());
                        p.println();
                    }
                    p.close();
                    
                    //Booking
                    p = new PrintWriter("booking.txt");
                    for(int i=0; i<RCSAS.allBooking.size(); i++){
                        Booking b = RCSAS.allBooking.get(i);
                        p.println(b.getId());
                        p.println(b.getVenue());
                        p.println(b.getDate());
                        p.println(b.getSport());
                        p.println(b.getTimeStarted());
                        p.println(b.getDuration());
                        p.println(b.getTimeEnded());
                        p.println(b.getOwner().getName());
                        p.println();
                    }
                    p.close();
                    
                    //Feedback
                    p = new PrintWriter("feedback.txt");
                    for(int i=0; i<RCSAS.allFeedback.size(); i++){
                        Feedback b = RCSAS.allFeedback.get(i);
                        p.println(b.getCoach().getId());
                        p.println(b.getStudent().getName());
                        p.println(b.getStar());
                        p.println(b.getComment());
                        p.println();
                    }
                    p.close();
                    
                    System.exit(0);
                } 
                
                catch(Exception ex){
                    System.out.println("Error in stop!");
                }
            default:
                JOptionPane.showMessageDialog(null,"Wrong password!");
                break;
        }
    }
    private void SettingStudentMainPage(){
        RCSAS.StudentMainPage.studentname = new JLabel(RCSAS.current.getName());
        RCSAS.StudentMainPage.studentgender = new JLabel(RCSAS.current.getGender());
        RCSAS.StudentMainPage.studentcontact = new JLabel(RCSAS.current.getPhone());
        RCSAS.StudentMainPage.studentemail = new JLabel(RCSAS.current.getEmail());
        RCSAS.StudentMainPage.studenteme_contact = new JLabel(RCSAS.current.getEm_phone());
        
        RCSAS.StudentMainPage.studentname.setFont(new Font("Serif", Font.PLAIN, 26));
        RCSAS.StudentMainPage.studentgender.setFont(new Font("Serif", Font.PLAIN, 26));
        RCSAS.StudentMainPage.studentcontact.setFont(new Font("Serif", Font.PLAIN, 26));
        RCSAS.StudentMainPage.studentemail.setFont(new Font("Serif", Font.PLAIN, 26));
        RCSAS.StudentMainPage.studenteme_contact.setFont(new Font("Serif", Font.PLAIN, 26));
        
        RCSAS.StudentMainPage.detail.add(RCSAS.StudentMainPage.studentname);
        RCSAS.StudentMainPage.detail.add(RCSAS.StudentMainPage.studentgender);
        RCSAS.StudentMainPage.detail.add(RCSAS.StudentMainPage.studentcontact);
        RCSAS.StudentMainPage.detail.add(RCSAS.StudentMainPage.studentemail);
        RCSAS.StudentMainPage.detail.add(RCSAS.StudentMainPage.studenteme_contact);
    }
}
