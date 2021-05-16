package rcsas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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

    }
}
