
package rcsas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Page3SportPage extends JFrame implements ActionListener{
    
    private Panel header, footer;
    private Button back, schedule;
    private JLabel title;
    private JPanel Swimming, Badminton, Football, Archery, Gymnastics, Volleyball, Basketball, Cricket, Tennis, TableTennis ;
    private JTabbedPane sport;
    
    public Page3SportPage(){
        setSize(1500,800);
        setLocation(200,100);
        setLayout(new BorderLayout());
        
        
        //
        //header
        //
        header = new Panel();
        title = new JLabel("- SPORT -");
        title.setFont(new Font("Serif", Font.PLAIN, 32));
        header.add(title);
        add(header, BorderLayout.NORTH);
        
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
        
        add(sport, BorderLayout.CENTER);
        
        
        //
        //footer
        //
        footer = new Panel();
        back = new Button("BACK");
        schedule = new Button("SCHEDULE");
        back.setPreferredSize(new Dimension(100,40));
        schedule.setFont(new Font("Serif", Font.PLAIN, 18));
        schedule.setPreferredSize(new Dimension(100,40));
        back.setFont(new Font("Serif", Font.PLAIN, 18));
        footer.add(back);
        footer.add(schedule);
        back.addActionListener(this);
        schedule.addActionListener(this);
        add(footer, BorderLayout.SOUTH);
        
        
        //
        //WindowListener
        //
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (RCSAS.currentLogin == RCSAS.currentAdmin){
                    setVisible(false);
                    RCSAS.AdminSecondPage.setVisible(true);
                } else if(RCSAS.currentLogin == RCSAS.currentStudent){
                    setVisible(false);
                    Page2StudentMainPage smp = new Page2StudentMainPage();
                    smp.setVisible(true);
                } else if (RCSAS.currentLogin == null){
                    setVisible(false);
                    RCSAS.HomePage.setVisible(true);
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
            } else if(RCSAS.currentLogin == RCSAS.currentStudent){
                setVisible(false);
                Page2StudentMainPage smp = new Page2StudentMainPage();
                smp.setVisible(true);
            } else if (RCSAS.currentLogin == RCSAS.currentAdmin) {
                setVisible(false);
                RCSAS.AdminSecondPage.setVisible(true);
            }
        }
    }
}
