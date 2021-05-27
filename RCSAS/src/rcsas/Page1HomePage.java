package rcsas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;


public class Page1HomePage extends JFrame implements ActionListener{
    
    final private Panel contain, header,headerbut, w, content, footer;
    final private JButton login, signup, exit, sport, schedule;
    final private JLabel system, welcome, describe;
    public Font title = new Font("Agency FB", Font.PLAIN, 60);
    public Font label = new Font("Centaur", Font.BOLD, 26);
    public Font normal = new Font("Centaur", Font.PLAIN,24);
    public Font button = new Font("Agency FB", Font.BOLD, 18);
    
    public Page1HomePage(){
        setSize(1500,800);
        setLocation(200,100);
        
        //
        //header
        //
        header = new Panel();
        header.setBackground(new java.awt.Color(197, 215, 214));
        header.setLayout(new GridLayout(1,2));
        
        system = new JLabel("REAL CHAMPIONS SPORT ACADEMY",Label.LEFT);
        system.setForeground(Color.WHITE);
        system.setFont(new Font("Agency FB", Font.BOLD, 32));
        header.add(system);
        
        //
        //Center
        //
        contain = new Panel(new GridLayout(2,1));
        add(contain,BorderLayout.CENTER);
        
        w = new Panel(new GridBagLayout());
        welcome = new JLabel("Welcome to the RCSAS!");
        welcome.setFont(new Font("Agency FB", Font.BOLD,88));
        welcome.setForeground(Color.WHITE);
        w.add(welcome);
        w.setBackground(new java.awt.Color(197, 215, 214));
        contain.add(w);
        content = new Panel();
        describe = new JLabel("<html>We have conduct classes on ten type of sports which are the Swimming, Badminton, Football, Archery, Gymnastics, Volleyball, Basketball, Cricket, Tennis and Table Tennis at Puchong, Subang and Damansara.</html>");
        describe.setFont(new Font("Centaur", Font.PLAIN,24));
        describe.setPreferredSize(new Dimension(1000,300));
        content.setBackground(new java.awt.Color(243, 250, 249));
        content.add(describe);
        contain.add(content);
        
        
        headerbut = new Panel(new GridBagLayout());
        headerbut.setPreferredSize(new Dimension(1500,100));
        
        //Creating Button
        login = new JButton("Login");
        signup = new JButton("Sign up");
        exit = new JButton("Exit");
        
        //Properties of Button
        RCSAS.setButton(login);
        RCSAS.setButton(signup);
        RCSAS.setButton(exit);
        
        login.setFont(button);
        signup.setFont(button);
        exit.setFont(button);
        
        //Adding Action Listener to Button
        login.addActionListener(this);
        signup.addActionListener(this);
        exit.addActionListener(this);
        
        //Adding item
        headerbut.add(login, new GridBagConstraints());
        headerbut.add(signup, new GridBagConstraints());
        headerbut.add(exit, new GridBagConstraints());
        header.add(headerbut);
        add(header,BorderLayout.NORTH);
        setVisible(true);
        
        //
        //footer
        //
        footer = new Panel();
        footer.setBackground(new java.awt.Color(243, 250, 249));
        sport = new JButton("Know More");
        sport.setPreferredSize(new Dimension(100,40));
        sport.setFont(new Font("Agency FB", Font.BOLD, 18));
        sport.setBackground(new java.awt.Color(197, 215, 214));
        sport.addActionListener(this);
        schedule = new JButton("Schedule");
        schedule.setPreferredSize(new Dimension(100,40));
        schedule.setFont(new Font("Agency FB", Font.BOLD, 18));
        schedule.setBackground(new java.awt.Color(197, 215, 214));
        schedule.addActionListener(this);
        footer.add(sport);
        footer.add(schedule);
        add(footer, BorderLayout.SOUTH);
        
        
        //
        //WindowListener
        //
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Really want to exit?");
                switch(a){
                    case JOptionPane.YES_OPTION:
                        System.exit(0);
                    case JOptionPane.NO_OPTION:
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
            int a = JOptionPane.showConfirmDialog(null, "Really want to exit?");
            switch(a){
                case JOptionPane.YES_OPTION:
                    System.exit(0);
                case JOptionPane.NO_OPTION:
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                case JOptionPane.CANCEL_OPTION:
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                case JOptionPane.CLOSED_OPTION:
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        } else if(e.getSource()==signup){
            setVisible(false);
            RCSAS.SignupPage.setVisible(true);
        } else if(e.getSource() == login){
            String[] options = {"Admin", "Student"};
            int op = JOptionPane.showOptionDialog(null, "Please select your role:","Role for Login",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            //Admin
            if(op == 0){
                String s = JOptionPane.showInputDialog("Username:");
                if (s == null){
                    
                } else{
                    for(int i=0; i<RCSAS.allAdmin.size(); i++){
                        Admin c = RCSAS.allAdmin.get(i);
                        if(s.equals(c.getName())){
                            RCSAS.currentAdmin = c;
                            break;
                        }
                    }            
                    if(RCSAS.currentAdmin==null){
                        JOptionPane.showMessageDialog(null, "Wrong username!");
                    }else{
                        s = JOptionPane.showInputDialog("Password:");
                        if(Integer.parseInt(s) != RCSAS.currentAdmin.getPin()){
                            JOptionPane.showMessageDialog(null, "Wrong password!");
                            RCSAS.currentAdmin = null;
                        } else{
                            RCSAS.currentLogin = RCSAS.currentAdmin;
                            setVisible(false);
                            RCSAS.AdminSecondPage.setVisible(true);
                        }
                    }
                }
            }
            
            //Student
            else if(op == 1){
                String s = JOptionPane.showInputDialog("Username:");
                if (s ==null){
                    
                } else{
                    for(int i=0; i<RCSAS.allStudent.size(); i++){
                        Student c = RCSAS.allStudent.get(i);
                        if(s.equals(c.getName())){
                            RCSAS.currentStudent = c;
                            break;
                        }
                    }

                    if(RCSAS.currentStudent==null){
                        JOptionPane.showMessageDialog(null, "Wrong username!");
                    }else{
                        s = JOptionPane.showInputDialog("Password:");
                        if(Integer.parseInt(s) == RCSAS.currentStudent.getPin()){
                            RCSAS.currentLogin = RCSAS.currentStudent;
                            setVisible(false);
                            Page2StudentMainPage smp = new Page2StudentMainPage();
                            smp.setVisible(true);
                        } else{
                            JOptionPane.showMessageDialog(null, "Wrong password!");
                            RCSAS.currentStudent = null;
                        }
                    }
                }
            }
            //Error
            else{
                
            }
        } else if(e.getSource() == sport){
            setVisible(false);
            Page3SportPage SportPage = new Page3SportPage();
            SportPage.setVisible(true);
        } else if(e.getSource() ==schedule){
            setVisible(false);
            Page3SchedulePage schedulepage = new Page3SchedulePage();
            schedulepage.setVisible(true);
        }
    }
    
    public void Save(){
        try{
            //Sport
            PrintWriter p = new PrintWriter("sport.txt");
            for(int i=0; i<RCSAS.allSport.size(); i++){
                Sport c = RCSAS.allSport.get(i);
                p.println(c.getId());
                p.println(c.getName());
                p.println(c.getLocation());
                p.println(c.getVenue());
                p.println(c.getNo_hall());
                p.println(c.getPrice());
                p.println();
            } p.close();
            
            //Admin
            p = new PrintWriter("admin.txt");
            for(int i=0; i<RCSAS.allAdmin.size(); i++){
                Admin c = RCSAS.allAdmin.get(i);
                p.println(c.getId());
                p.println(c.getName());
                p.println(c.getPin());
                p.println();
            } p.close();

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
                p.println(b.getSport().getName());
                p.println(b.getJoined());
                p.println(b.getDuration());
                p.println();
            } p.close();

            //Student
            p = new PrintWriter("student.txt");
            for(int i=0; i<RCSAS.allStudent.size(); i++){
                Student st = RCSAS.allStudent.get(i);
                p.println(st.getId());
                p.println(st.getName());
                p.println(st.getPin());
                p.println(st.getGender());
                p.println(st.getPhone());
                p.println(st.getEmail());
                p.println(st.getEm_phone());
                p.println();
            } p.close();

            //Classes
            p = new PrintWriter("classes.txt");
            for(int i=0; i<RCSAS.allClasses.size(); i++){
                Classes b = RCSAS.allClasses.get(i);
                p.println(b.getId());
                p.println(b.getStudent().getName());
                p.println(b.getSport().getName());
                p.println(b.getPrice());
                p.println(b.getHourdone());
                p.println(b.getHasPaid());
                p.println(b.isFinish());
                p.println(b.isPaid());
                p.println();
            } p.close();

            //Booking
            p = new PrintWriter("booking.txt");
            for(int i=0; i<RCSAS.allBooking.size(); i++){
                Booking b = RCSAS.allBooking.get(i);
                p.println(b.getId());
                p.println(b.getVenue());
                p.println(b.getDate());
                p.println(b.getSport().getName());
                p.println(b.getTimeStarted());
                p.println(b.getDuration());
                p.println(b.getTeacher().getName());
                p.println(b.getOwner().getName());
                p.println();
            } p.close();

            //Feedback
            p = new PrintWriter("feedback.txt");
            for(int i=0; i<RCSAS.allFeedback.size(); i++){
                Feedback b = RCSAS.allFeedback.get(i);
                p.println(b.getCoach().getName());
                p.println(b.getStudent().getName());
                p.println(b.getStar());
                p.println(b.getComment());
                p.println();
            } p.close();
        } 

        catch(Exception ex){
            System.out.println("Error in stop!");
        }
    }
}
