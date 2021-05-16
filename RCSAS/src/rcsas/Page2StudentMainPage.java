package rcsas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Page2StudentMainPage extends JFrame implements ActionListener{
    private Button SearchCoach, ViewRecord, ViewSchedule, Logout;
    
    public Page2StudentMainPage(){
        setSize(500,500);
        setLocation(1000,300);
        setLayout(new FlowLayout());
        
        SearchCoach = new Button("Search Coach Detials");
        ViewRecord = new Button("View Self Record");
        ViewSchedule = new Button("View Registered Schedule");
        Logout = new Button("Log Out");
        
        SearchCoach.addActionListener(this);
        ViewRecord.addActionListener(this);
        ViewSchedule.addActionListener(this);
        Logout.addActionListener(this);
        
        add(SearchCoach);
        add(ViewRecord);
        add(ViewSchedule);
        add(Logout);
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
}
