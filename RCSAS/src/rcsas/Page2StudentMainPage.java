package rcsas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Page2StudentMainPage extends JFrame implements ActionListener{
    final private JLabel title, name, gender, contact, email, eme_contact;
    public JLabel studentname, studentgender, studentcontact, studentemail, studenteme_contact;
    final private Button SearchCoach, ModifyRecord, ViewSchedule, Logout;
    final private JPanel a, b, above, label, below;
    public JPanel detail;
    
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
        
        studentname = new JLabel(RCSAS.currentStudent.getName());
        studentgender = new JLabel(RCSAS.currentStudent.getGender());
        studentcontact = new JLabel(RCSAS.currentStudent.getPhone());
        studentemail = new JLabel(RCSAS.currentStudent.getEmail());
        studenteme_contact = new JLabel(RCSAS.currentStudent.getEm_phone());
        
        //Propertly of Labels
        name.setFont(new Font("Serif", Font.BOLD, 26));
        gender.setFont(new Font("Serif", Font.BOLD, 26));
        email.setFont(new Font("Serif", Font.BOLD, 26));
        contact.setFont(new Font("Serif", Font.BOLD, 26));
        eme_contact.setFont(new Font("Serif", Font.BOLD, 26));
        
        studentname.setFont(new Font("Serif", Font.PLAIN, 26));
        studentgender.setFont(new Font("Serif", Font.PLAIN, 26));
        studentcontact.setFont(new Font("Serif", Font.PLAIN, 26));
        studentemail.setFont(new Font("Serif", Font.PLAIN, 26));
        studenteme_contact.setFont(new Font("Serif", Font.PLAIN, 26));

        
        //Add label into panel
        label.add(name);
        label.add(gender);
        label.add(contact);
        label.add(email);
        label.add(eme_contact);
        
        detail.add(studentname);
        detail.add(studentgender);
        detail.add(studentcontact);
        detail.add(studentemail);
        detail.add(studenteme_contact);

        //Combine panel 
        above.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        above.add(label,BorderLayout.CENTER);
        above.add(detail, BorderLayout.LINE_END);

        //
        //Button Below
        //
        SearchCoach = new Button("Search Coach Detials");
        SearchCoach.setPreferredSize(new Dimension(350,40));
        SearchCoach.setFont(new Font("Serif", Font.PLAIN, 32));
        ModifyRecord = new Button("Modify Self Record");
        ModifyRecord.setPreferredSize(new Dimension(350,40));
        ModifyRecord.setFont(new Font("Serif", Font.PLAIN, 32));
        ViewSchedule = new Button("View Registered Schedule");
        ViewSchedule.setPreferredSize(new Dimension(350,40));
        ViewSchedule.setFont(new Font("Serif", Font.PLAIN, 32));
        Logout = new Button("Log Out");
        Logout.setPreferredSize(new Dimension(350,40));
        Logout.setFont(new Font("Serif", Font.PLAIN, 32));
        
        SearchCoach.addActionListener(this);
        ModifyRecord.addActionListener(this);
        ViewSchedule.addActionListener(this);
        Logout.addActionListener(this);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 5.0;
        
        below = new JPanel(new GridBagLayout());
        below.add(SearchCoach, gbc);
        below.add(ModifyRecord, gbc);
        below.add(ViewSchedule, gbc);
        below.add(Logout, gbc);
        b.add(below,gbc);
        add(b,BorderLayout.CENTER);
                
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                setVisible(false);
                RCSAS.HomePage.setVisible(true);
                RCSAS.currentStudent = null;
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==Logout){
            setVisible(false);
            RCSAS.HomePage.setVisible(true);
            RCSAS.currentStudent = null;
        }
        
        else if(e.getSource()==SearchCoach){
            String coach[] = RCSAS.allCoachName.toArray(new String[RCSAS.allCoachName.size()]);
            String s = (String)JOptionPane.showInputDialog(
                null,
                "Kindly Select the Name of Coach to Search",
                "Searching Coach",
                JOptionPane.PLAIN_MESSAGE,
                null,
                coach,
                null);
        }
        
        else if(e.getSource()==ModifyRecord){
            
        }
        
        else{
            
        }
    }
}
