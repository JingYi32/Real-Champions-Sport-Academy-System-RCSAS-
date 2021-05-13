package rcsas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Page2StudentMainPage extends JFrame implements ActionListener{
    private Button SearchCoach, ViewRecord, ViewSchedule, Logout;
    private JPanel a;
    
    public Page2StudentMainPage(){
        setSize(500,500);
        setLocation(700,300);
        setLayout(new GridBagLayout());
        
        SearchCoach = new Button("Search Coach Detials");
        SearchCoach.setPreferredSize(new Dimension(350,40));
        SearchCoach.setFont(new Font("Serif", Font.PLAIN, 32));
        ViewRecord = new Button("View Self Record");
        ViewRecord.setPreferredSize(new Dimension(350,40));
        ViewRecord.setFont(new Font("Serif", Font.PLAIN, 32));
        ViewSchedule = new Button("View Registered Schedule");
        ViewSchedule.setPreferredSize(new Dimension(350,40));
        ViewSchedule.setFont(new Font("Serif", Font.PLAIN, 32));
        Logout = new Button("Log Out");
        Logout.setPreferredSize(new Dimension(350,40));
        Logout.setFont(new Font("Serif", Font.PLAIN, 32));
        
        SearchCoach.addActionListener(this);
        ViewRecord.addActionListener(this);
        ViewSchedule.addActionListener(this);
        Logout.addActionListener(this);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 5.0;
        
        a = new JPanel(new GridBagLayout());
        a.add(SearchCoach, gbc);
        a.add(ViewRecord, gbc);
        a.add(ViewSchedule, gbc);
        a.add(Logout, gbc);
        add(a,gbc);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                setVisible(false);
                RCSAS.HomePage.setVisible(true);
                RCSAS.current = null;
            }
        });
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==Logout){
            setVisible(false);
            RCSAS.HomePage.setVisible(true);
            RCSAS.current = null;
        }
        
        else if(e.getSource()==SearchCoach){
            
        }
        
        else if(e.getSource()==ViewRecord){
            
        }
        
        else{
            
        }
    }
}
