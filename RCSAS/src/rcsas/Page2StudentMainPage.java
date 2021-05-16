package rcsas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Page2StudentMainPage extends JFrame implements ActionListener{
    private JLabel title, name, gender, contact, email, eme_contact, studentname, studentgender, studentcontact, studentemail, studenteme_contact;
    private Button SearchCoach, ViewRecord, ViewSchedule, Logout;
    private JPanel a, b, above, label, detail, below;
    
    public Page2StudentMainPage(){
        setSize(1500,800);
        setLocation(200,100);
        setLayout(new BorderLayout());
        
        //
        //header
        //
        a = new JPanel(new GridBagLayout());
        title = new JLabel("Profile");
        a.add(title);
        title.setFont(new Font("Serif", Font.PLAIN, 32));
        add(a, BorderLayout.NORTH);
        
        //
        //content
        ///
        b = new JPanel(new GridLayout(2,1));
        
        //
        //Details above
        //
        above = new JPanel(new BorderLayout());
        b.add(above);
        label = new JPanel(new GridLayout(0,1));
        detail = new JPanel(new GridLayout(0,1));
        
        //Create Labels
        name = new JLabel("Name:");
        gender = new JLabel("Gender:");
        email = new JLabel("Email:");
        contact = new JLabel("Contact:");
        eme_contact = new JLabel("Emergency Contact:");
        
        //Propertly of Labels
        name.setFont(new Font("Serif", Font.PLAIN, 26));
        gender.setFont(new Font("Serif", Font.PLAIN, 26));
        email.setFont(new Font("Serif", Font.PLAIN, 26));
        contact.setFont(new Font("Serif", Font.PLAIN, 26));
        eme_contact.setFont(new Font("Serif", Font.PLAIN, 26));
        
        //Add label into panel
        label.add(name);
        label.add(gender);
        label.add(email);
        label.add(contact);
        label.add(eme_contact);

        
        



//        studentname = new JLabel(RCSAS.current.getName().toString());
//        studentname = new JLabel(RCSAS.current.getName().toString());
//        studentgender = new JLabel(RCSAS.current.getGender().toString());
//        studentcontact = new JLabel(RCSAS.current.getPhone().toString());
//        studentemail = new JLabel(RCSAS.current.getEmail().toString());
//        studenteme_contact = new JLabel();

        above.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        above.add(label,BorderLayout.CENTER);
        above.add(detail, BorderLayout.LINE_END);



        //
        //Button Below
        //
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
        
        below = new JPanel(new GridBagLayout());
        below.add(SearchCoach, gbc);
        below.add(ViewRecord, gbc);
        below.add(ViewSchedule, gbc);
        below.add(Logout, gbc);
        b.add(below,gbc);
        add(b,BorderLayout.CENTER);
        
        setVisible(true);
        
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
