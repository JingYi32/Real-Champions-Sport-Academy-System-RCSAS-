package rcsas;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.*;

public class Page2StudentMainPage extends JFrame implements ActionListener{
    final private JLabel title, name, gender, contact, email, eme_contact;
    public JLabel studentname, studentgender, studentcontact, studentemail, studenteme_contact;
    private Panel panelgender, panelcontact, panelemail, paneleme_contact;
    private JTextField textcontact, textemail, texteme_contact;
    private JComboBox cbgender;
    final private JButton SearchCoach, ModifyRecord, ViewSchedule, Logout;
    private JButton Save;
    final private JPanel header, content, label, detail, below;
    
    public Page2StudentMainPage(){
        setSize(1500,800);
        setLocation(200,100);
        setLayout(null);
        
        //
        //header
        //
        header = new JPanel();
        header.setBackground(new java.awt.Color(197, 215, 214));
        header.setBounds(0,0,1500,100);
        title = new JLabel("Profile");
        header.add(title);
        title.setFont(RCSAS.HomePage.title);
        title.setForeground(Color.WHITE);
        add(header);
        
        //
        //content
        ///

        content = new JPanel(new BorderLayout());
        content.setBackground(new java.awt.Color(197, 215, 214));
        content.setBounds(0,100,1500,500);
        add(content);
        label = new JPanel(new GridLayout(0,1));
        label.setBackground(new java.awt.Color(197, 215, 214));
        detail = new JPanel(new GridLayout(0,1));
        detail.setBackground(new java.awt.Color(197, 215, 214));
        
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
        name.setFont(RCSAS.HomePage.label);
        gender.setFont(RCSAS.HomePage.label);
        email.setFont(RCSAS.HomePage.label);
        contact.setFont(RCSAS.HomePage.label);
        eme_contact.setFont(RCSAS.HomePage.label);
        
        studentname.setFont(RCSAS.HomePage.normal);
        studentgender.setFont(RCSAS.HomePage.normal);
        studentcontact.setFont(RCSAS.HomePage.normal);
        studentemail.setFont(RCSAS.HomePage.normal);
        studenteme_contact.setFont(RCSAS.HomePage.normal);

        name.setForeground(Color.WHITE);
        gender.setForeground(Color.WHITE);
        email.setForeground(Color.WHITE);
        contact.setForeground(Color.WHITE);
        eme_contact.setForeground(Color.WHITE);
        
        studentname.setForeground(Color.WHITE);
        studentgender.setForeground(Color.WHITE);
        studentcontact.setForeground(Color.WHITE);
        studentemail.setForeground(Color.WHITE);
        studenteme_contact.setForeground(Color.WHITE);
        
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
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        content.add(label,BorderLayout.CENTER);
        content.add(detail, BorderLayout.LINE_END);

        //
        //Button Below
        //
        SearchCoach = new JButton("Search Coach Detials");
        ModifyRecord = new JButton("Modify Self Record");
        ViewSchedule = new JButton("View Registered Schedule");
        Logout = new JButton("Log Out");
        
        SearchCoach.setFont(RCSAS.HomePage.button);
        ModifyRecord.setFont(RCSAS.HomePage.button);
        ViewSchedule.setFont(RCSAS.HomePage.button);
        Logout.setFont(RCSAS.HomePage.button);
        
        setSTButton(SearchCoach);
        setSTButton(ModifyRecord);
        setSTButton(ViewSchedule);
        setSTButton(Logout);
        
        SearchCoach.addActionListener(this);
        ModifyRecord.addActionListener(this);
        ViewSchedule.addActionListener(this);
        Logout.addActionListener(this);
        
        
        below = new JPanel(new GridBagLayout());
        below.setBackground(new java.awt.Color(243, 250, 249));
        below.add(SearchCoach);
        below.add(ModifyRecord);
        below.add(ViewSchedule);
        below.add(Logout);
        below.setBounds(0,550,1500,200);
        add(below);
                
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "Do you want to save your change?");
                switch(a){
                    case JOptionPane.YES_OPTION:
                        String input = JOptionPane.showInputDialog("Password:");
                        if (null == input){

                        } else if (Integer.parseInt(input) == RCSAS.currentStudent.getPin()){
                            RCSAS.HomePage.Save();
                            setVisible(false);
                            RCSAS.HomePage.setVisible(true);
                            RCSAS.currentLogin = null;
                            RCSAS.currentStudent = null;
                            RCSAS.currentCoach = null;
                        } else{
                            JOptionPane.showMessageDialog(null,"Wrong password!");
                        }
                    case JOptionPane.NO_OPTION:
                            setVisible(false);
                            RCSAS.HomePage.setVisible(true);
                            RCSAS.currentLogin = null;
                            RCSAS.currentStudent = null;
                            RCSAS.currentCoach = null;
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
        
        if(e.getSource()==Logout){
            String input = JOptionPane.showInputDialog("Password:");
            if (null == input){
                
            } else if (Integer.parseInt(input) == RCSAS.currentStudent.getPin()){
                RCSAS.HomePage.Save();
                setVisible(false);
                RCSAS.HomePage.setVisible(true);
                RCSAS.currentLogin = null;
                RCSAS.currentStudent = null;
                RCSAS.currentCoach = null;
            } else{
                JOptionPane.showMessageDialog(null,"Wrong password!");
            }

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
            ModifySetting();
            this.revalidate();
            Save.addActionListener((ActionEvent ae ) ->{
                CheckModify();
            });
            addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    ModifyClose();
                }
            });
        }
        
        else if (e.getSource() == ViewSchedule){
            setVisible(false);
            Page3SchedulePage sp = new Page3SchedulePage();
            sp.setVisible(true);
        }
    }
    
    private void ModifySetting(){
            detail.remove(studentgender);
            detail.remove(studentcontact);
            detail.remove(studentemail);
            detail.remove(studenteme_contact);
            
            panelgender = new Panel();
            panelcontact = new Panel();
            panelemail = new Panel();
            paneleme_contact = new Panel();
            
            cbgender = new JComboBox();
            cbgender.addItem("Female");
            cbgender.addItem("Male");
            cbgender.setSelectedItem(RCSAS.currentStudent.getGender());
            textcontact = new JTextField(RCSAS.currentStudent.getPhone());
            textemail = new JTextField(RCSAS.currentStudent.getEmail());
            texteme_contact = new JTextField(RCSAS.currentStudent.getEm_phone());
            
            cbgender.setPreferredSize(new Dimension(300, 40));
            textcontact.setPreferredSize(new Dimension(300, 40));
            textemail.setPreferredSize(new Dimension(300, 40));
            texteme_contact.setPreferredSize(new Dimension(300, 40));
            
            cbgender.setFont(RCSAS.HomePage.normal);
            textcontact.setFont(RCSAS.HomePage.normal);
            textemail.setFont(RCSAS.HomePage.normal);
            texteme_contact.setFont(RCSAS.HomePage.normal);
            
            panelgender.add(cbgender);
            panelcontact.add(textcontact);
            panelemail.add(textemail);
            paneleme_contact.add(texteme_contact);
            
            detail.add(panelgender);
            detail.add(panelcontact);
            detail.add(panelemail);
            detail.add(paneleme_contact);
            
            below.remove(SearchCoach);
            below.remove(ModifyRecord);
            below.remove(ViewSchedule);
            below.remove(Logout);
            
            Save = new JButton("Save");
            RCSAS.setButton(Save);
            Save.setFont(RCSAS.HomePage.button);
            
            below.add(Save);
    }
    
    
    private void ModifyClose(){
        JOptionPane.showMessageDialog(null, "Your modify haven't save!");
    }
    
    private void CheckModify(){
        ArrayList<String> message = new ArrayList<>();
        if(Pattern.compile("^\\d{11}$").matcher(textcontact.getText()).matches() &&
                Pattern.compile("^(.+)@(.+)$").matcher(textemail.getText()).matches() &&
                Pattern.compile("^\\d{11}$").matcher(texteme_contact.getText()).matches()){
            RCSAS.currentStudent.setPhone(textcontact.getText() );
            RCSAS.currentStudent.setEmail(textemail.getText());
            RCSAS.currentStudent.setEm_phone(texteme_contact.getText());
            message.add("Update Successfully!");
            setVisible(false);
            Page2StudentMainPage reload = new Page2StudentMainPage();
            reload.setVisible(true);
        } else{
            message.add("There is error inside the field!");
            if(!Pattern.compile("^\\d{11}$").matcher(textcontact.getText()).matches()){
                message.add("Invalid Phone Number!");
            }
            if(!Pattern.compile("^(.+)@(.+)$").matcher(textemail.getText()).matches()){
                message.add("Invalid Email Address!");
            }
            if(!Pattern.compile("^\\d{11}$").matcher(texteme_contact.getText()).matches()){
                message.add("Invalid Emergency Number!");
            }
        }
        JOptionPane.showMessageDialog(null, message);
    }
    
    private void setSTButton(JButton but){
        but.setBackground(new java.awt.Color(125, 155, 171));
        but.setForeground(Color.WHITE);
        but.setPreferredSize(new Dimension(300,40));
    }
}

