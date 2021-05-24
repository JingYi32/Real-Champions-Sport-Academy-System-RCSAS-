
package rcsas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Page3SportPage extends JFrame implements ActionListener{
    
    private final JPanel header, footer;
    private final JButton back, schedule;
    private final JLabel title;
    private final JPanel Swimming, Badminton, Football, Archery, Gymnastics, Volleyball, Basketball, Cricket, Tennis, TableTennis ;
    private final JTabbedPane sport;
    
    public Page3SportPage(){
        setSize(1500,800);
        setLocation(200,100);
        setLayout(null);
        setBackground(new java.awt.Color(243, 250, 249));
        
        //
        //header
        //
        header = new JPanel();
        title = new JLabel("- SPORT -");
        title.setFont(RCSAS.HomePage.title);
        header.add(title);
        header.setBounds(0,0,1500,100);
        add(header);
        
        //
        //content
        //
        Swimming = new JPanel();
        Badminton = new JPanel();
        Football = new JPanel();
        Archery = new JPanel();
        Gymnastics = new JPanel();
        Volleyball = new JPanel();
        Basketball = new JPanel();
        Cricket = new JPanel();
        Tennis = new JPanel();
        TableTennis = new JPanel();
        
        sport = new JTabbedPane();
        sport.setBounds(300,300,1300,600);
        sport.add("Swimming",Swimming);
        sport.add("Badminton",Badminton);
        sport.add("Football",Football);
        sport.add("Archery",Archery);
        sport.add("Gymnastics",Gymnastics);
        sport.add("Volleyball",Volleyball);
        sport.add("Basketball",Basketball);
        sport.add("Cricket",Cricket);
        sport.add("Tennis",Tennis);
        sport.add("Table Tennis",TableTennis);
        
        sport.setFont(RCSAS.HomePage.label);
        sport.setBounds(50, 100, 1400, 500);
        add(sport);
        
        
        //
        //footer
        //
        footer = new JPanel();
        back = new JButton("BACK");
        schedule = new JButton("SCHEDULE");
        
        RCSAS.setButton(back);
        RCSAS.setButton(schedule);
        back.setFont(RCSAS.HomePage.button);
        schedule.setFont(RCSAS.HomePage.button);
        footer.add(back);
        footer.add(schedule);
        footer.setBounds(0, 700, 1500, 100);
        add(footer);
        
        back.addActionListener(this);
        schedule.addActionListener(this);
        
        
        //
        //WindowListener
        //
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (RCSAS.currentLogin == null) {
                    setVisible(false);
                    RCSAS.HomePage.setVisible(true);
                } else {
                    if(RCSAS.currentStudent != null){
                        setVisible(false);
                        Page2StudentMainPage smp = new Page2StudentMainPage();
                        smp.setVisible(true);
                    } else if (RCSAS.currentAdmin != null) {
                        setVisible(false);
                        RCSAS.AdminSecondPage.setVisible(true);
                    }
                }
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            if (RCSAS.currentLogin == null) {
                setVisible(false);
                RCSAS.HomePage.setVisible(true);
            } else {
                if(RCSAS.currentStudent != null){
                    setVisible(false);
                    Page2StudentMainPage smp = new Page2StudentMainPage();
                    smp.setVisible(true);
                } else if (RCSAS.currentAdmin != null) {
                    setVisible(false);
                    RCSAS.AdminSecondPage.setVisible(true);
                }
            }
        } else if (e.getSource() == schedule){
            setVisible(false);
            Page3SchedulePage sp = new Page3SchedulePage();
            sp.setVisible(true);
        }
    }
}
