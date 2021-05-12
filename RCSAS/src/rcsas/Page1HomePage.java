package rcsas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;


public class Page1HomePage extends JFrame implements ActionListener{
    private Button login, signup, exit;
    
    public Page1HomePage(){
        //Frame Properties
        setSize(1500,900);
        setLocation(200,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        //Panel Properties
        JPanel panel = new JPanel();
        panel.setBounds(0,0,1500,80);
        panel.setBackground(new java.awt.Color(204, 166, 166));
        
        //Creating Button
        login = new Button("Login");
        signup = new Button("Sign up");
        exit = new Button("Exit");
        
        //Properties of Button
        login.setBounds(1240,25,70,25);
        signup.setBounds(1320, 25, 70, 25);
        exit.setBounds(1400, 25, 70, 25);
        
        //Adding Action Listener to Button
        login.addActionListener(this);
        signup.addActionListener(this);
        exit.addActionListener(this);
        
        //Adding item
        add(login);
        add(signup);
        add(exit);
        add(panel);   
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
                    p = new PrintWriter("booking.txt");
                    for(int i=0; i<RCSAS.allBooking.size(); i++){
                        Booking b = RCSAS.allBooking.get(i);
                        p.println(b.getId());
                        p.println(b.getHall());
                        p.println(b.getDate());
                        p.println(b.getCode_sp());
                        p.println(b.getCode_sc());
                        p.println(b.getTimeStarted());
                        p.println(b.getDuration());
                        p.println(b.getTimeEnded());                      
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
            String a = JOptionPane.showInputDialog("Enter name:");
            boolean flag = true;
            for(int i=0; i<RCSAS.allAdmin.size(); i++){
                Admin c = RCSAS.allAdmin.get(i);
                if(a.equals(c.getName())){
                    flag = false;
                    break;
                }   
}
            if(flag){
                int pin = Integer.parseInt(JOptionPane.showInputDialog("Pin"));
                Admin c = new Admin(a,pin);
                RCSAS.allAdmin.add(c);
            } else{
                JOptionPane.showMessageDialog(signup, "Name has been used!");
            }
        } else{
            String s = JOptionPane.showInputDialog("Username:");
            for(int i=0; i<RCSAS.allAdmin.size(); i++){
                Admin c = RCSAS.allAdmin.get(i);
                if(s.equals(c.getName())){
                    RCSAS.whoLogin = c;
                    break;
                }
            }
            if(RCSAS.whoLogin==null){
                JOptionPane.showMessageDialog(login, "Worng username!");
            } else{
                s = JOptionPane.showInputDialog("Password:");
                if(Integer.parseInt(s) != RCSAS.whoLogin.getPin()){
                    JOptionPane.showMessageDialog(login, "Wrong password!");
                    RCSAS.whoLogin = null;
                } else{
                    setVisible(false);  //same as this.setVisible(false);
                    RCSAS.SecondPage.setVisible(true);
                }
            }
        }
    }
}
