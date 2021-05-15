package rcsas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;


public class Page1HomePage extends JFrame implements ActionListener{
    
    private Panel y1,y2,y2_1, w, content;
    private Button login, signup, exit;
    private Label system, welcome, describe;
    
    public Page1HomePage(){
        Font myFont = new Font("Serif", Font.PLAIN, 32);

        //Frame Properties
        setSize(1500,800);
        setLocation(200,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        //Panel Properties
        y1 = new Panel(new GridLayout(1,2));
        add(y1,BorderLayout.CENTER);
        
        w = new Panel(new GridBagLayout());
        welcome = new Label("Welcome to the RCSAS!");
        w.add(welcome);
        content = new Panel(new GridBagLayout());
        describe = new Label("");
        content.add(describe);
        
        y2 = new Panel();
        y2.setBackground(new java.awt.Color(204, 166, 166));
        y2.setLayout(new GridLayout(1,2));
        
        system = new Label("Real Champions Sport Academy",Label.LEFT);
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
    }
    
    public void actionPerformed(ActionEvent e){
       if(e.getSource()==exit){
            String input = JOptionPane.showInputDialog("Password:");
            if(input.equals("12345")){
                try{
                    PrintWriter p = new PrintWriter("admin.txt");
                    for(int i=0; i<RCSAS.allAdmin.size(); i++){
                        Admin c = RCSAS.allAdmin.get(i);
                        p.println(c.getName());
                        p.println(c.getPin());
                        p.println();
                    } 
                    p.close();
                    p = new PrintWriter("student.txt");
                    for(int i=0; i<RCSAS.allStudent.size(); i++){
                        Student st = RCSAS.allStudent.get(i);
                        p.println(st.getName());
                        p.println(st.getPin());
                        p.println(st.getGender());
                        p.println(st.getPhone());
                        p.println(st.getEmail());
                        p.println(st.getSport());
                        p.println();
                    } 
                    p.close();
                    p = new PrintWriter("booking.txt");
                    for(int i=0; i<RCSAS.allBooking.size(); i++){
                        Booking b = RCSAS.allBooking.get(i);
                        p.println(b.getId());
                        p.println(b.getHall());
                        p.println(b.getDate());
                        p.println(b.getSport());
                        p.println(b.getCentre());
//                        p.println(b.getTimeStarted());
//                       p.println(b.getDuration());
//                       p.println(b.getTimeEnded());                      
                        p.println(b.getPrice());
                        p.println(b.isPaid());
                        p.println(b.getOwner().getName());
                        p.println();               
                    }
                    p.close();      
                    System.exit(0);
                    } catch(Exception ex){
                        System.out.println("Error in stop!");
                }
            } else{
                JOptionPane.showMessageDialog(exit,"Wrong password!");
            }
        } else if(e.getSource()==signup){
            setVisible(false);
            RCSAS.SignuPage.setVisible(true);
        } else{
            String s = JOptionPane.showInputDialog("Username:");
            for(int i=0; i<RCSAS.allAdmin.size(); i++){
                Admin c = RCSAS.allAdmin.get(i);
                if(s.equals(c.getName())){
                    RCSAS.whoLogin = c;
                    break;
                }
            }
            for(int i=0; i<RCSAS.allStudent.size(); i++){
                Student c = RCSAS.allStudent.get(i);
                if(s.equals(c.getName())){
                    RCSAS.current = c;
                    break;
                }
            }
            if((RCSAS.current==null)&&(RCSAS.whoLogin==null)){
                JOptionPane.showMessageDialog(null, "Worng username!");
            } else{
                if(RCSAS.whoLogin!=null){
                    s = JOptionPane.showInputDialog("Password:");
                    if(Integer.parseInt(s) != RCSAS.whoLogin.getPin()){
                        JOptionPane.showMessageDialog(null, "Wrong password!");
                        RCSAS.whoLogin = null;
                    } else{
                        setVisible(false);  //same as this.setVisible(false);
                        RCSAS.AdminSecondPage.setVisible(true);
                    }
                }else if(RCSAS.current!=null){
                    s = JOptionPane.showInputDialog("Password:");
                    if(Integer.parseInt(s) == RCSAS.current.getPin()){
                        setVisible(false);  //same as this.setVisible(false);
                        RCSAS.StudentMainPage.setVisible(true);
                    } else{
                        JOptionPane.showMessageDialog(null, "Wrong password!");
                        RCSAS.current = null;
                    }
                }

            }
        }
    }
}
