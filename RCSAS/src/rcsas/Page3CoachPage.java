
package rcsas;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.*;

public class Page3CoachPage extends JFrame implements ActionListener{
    private final JLabel title, id, name, gender, contact, address, eme_contact, sport, joined, terminated, hourrate, rating;
    private final JLabel coachId, coachName, coachGender, coachContact, coachAddress, coachEme_contact, coachSport, coachJoined, coachTerminated, coachHourrate, coachRating;
    private JButton back, modify, starFeedback, extension, save;
    private JTextField textContact, textAddress, textEme_contact,textName;
    private JComboBox cbGender, cbSport;
    private Panel panelName,panelGender, panelContact, panelAddress, panelEme_contact, panelSport, panelDatejoined;
    private final JPanel header, content, left, labelleft, labelright, footer, right, detailleft, detailright;
    private LocalDate newterminated;
    private boolean error;
    private long duration = 0;
    
    public Page3CoachPage(){
        setSize(1500,800);
        setLocation(200,100);
        setLayout(null);        
        
        //
        //header
        //
        header = new JPanel(new GridBagLayout());
        header.setBackground(new java.awt.Color(197, 215, 214));
        header.setBounds(0,0,1500,100);
        title = new JLabel("-  Coach Profile  -");
        header.add(title);
        title.setFont(RCSAS.HomePage.title);
        title.setForeground(Color.WHITE);
        add(header);
        
        //
        //footer
        //
        footer = new JPanel();
        footer.setBounds(0,700,1500,100);
        footer.setBackground(new java.awt.Color(197, 215, 214));
        back = new JButton();
        setSTButton(back);
        footer.add(back);
        if (RCSAS.currentStudent == null){           
            modify = new JButton("MODIFY");
            extension = new JButton("Contract Extension");           
            setSTButton(modify);
            setSTButton(extension);            
            footer.add(modify);
            footer.add(extension);
        } else if(RCSAS.currentAdmin == null){
            starFeedback = new JButton("Provide feedback and Star");
            setSTButton(starFeedback);
            footer.add(starFeedback);
        }
        add(footer);

        
        //
        //content
        ///
        content = new JPanel(new GridLayout(1,2));
        content.setBounds(0,100,1500,600);
        content.setBackground(new java.awt.Color(197, 215, 214));
        add(content);
        left = new JPanel(new BorderLayout());
        left.setBackground(new java.awt.Color(197, 215, 214));
        labelleft = new JPanel(new GridLayout(0,1));labelright = new JPanel(new GridLayout(0,1));
        labelleft.setBackground(new java.awt.Color(197, 215, 214));labelright.setBackground(new java.awt.Color(197, 215, 214));
        right = new JPanel(new BorderLayout());
        right.setBackground(new java.awt.Color(197, 215, 214));
        detailleft = new JPanel(new GridLayout(0,1));detailright = new JPanel(new GridLayout(0,1));
        detailleft.setBackground(new java.awt.Color(197, 215, 214));detailright.setBackground(new java.awt.Color(197, 215, 214));
        content.add(left);
        content.add(right);
        
        //Create Labels
        id = new JLabel("ID:");
        name = new JLabel("Name:");
        gender = new JLabel("Gender:");
        contact = new JLabel("Contact:");
        address = new JLabel("Address:");
        eme_contact = new JLabel("Emergency Contact:");
        sport = new JLabel("Specialized Sport:");
        joined = new JLabel("Date Joined:");
        terminated = new JLabel("Date Terminated:");
        hourrate = new JLabel("Hourly Rate:");
        rating = new JLabel("Rating:");
        
        coachId = new JLabel(RCSAS.currentCoach.getId());
        coachName = new JLabel(RCSAS.currentCoach.getName());
        coachGender = new JLabel(RCSAS.currentCoach.getGender());
        coachContact = new JLabel(RCSAS.currentCoach.getPhone());
        coachAddress = new JLabel(RCSAS.currentCoach.getAddress());
        coachEme_contact = new JLabel(RCSAS.currentCoach.getEcontact());
        coachSport = new JLabel(RCSAS.currentCoach.getSport().getName());
        coachJoined = new JLabel(RCSAS.currentCoach.getJoined().toString());
        coachTerminated = new JLabel(RCSAS.currentCoach.getTerminated().toString());
        coachHourrate = new JLabel("RM "+String.format("%03d", RCSAS.currentCoach.getHourrate())+".00");
        int un = 0;
//        coachRating = new JLabel("RM "+String.format("%03d", RCSAS.currentCoach.getHourrate())+".00");
        coachRating = new JLabel(String.format("%01d", RCSAS.currentCoach.getRating()));

        
        //Create Text Feild
        textName = new JTextField();
        //cbDatejoined = new JComboBox();
        
        
        //Propertly of Label
        setSTLabel(id);
        setSTLabel(name);
        setSTLabel(gender);
        setSTLabel(contact);
        setSTLabel(address);
        setSTLabel(eme_contact);
        setSTLabel(sport);
        setSTLabel(joined);
        setSTLabel(terminated);
        setSTLabel(hourrate);
        setSTLabel(rating);
        
        setSTLabel(coachId);
        setSTLabel(coachName);
        setSTLabel(coachGender);
        setSTLabel(coachContact);
        setSTLabel(coachAddress);
        setSTLabel(coachEme_contact);
        setSTLabel(coachSport);
        setSTLabel(coachJoined);
        setSTLabel(coachTerminated);
        setSTLabel(coachHourrate);
        setSTLabel(coachRating);
        
        //Add label into panel
        labelleft.add(id);
        labelleft.add(name);
        labelleft.add(gender);
        labelleft.add(contact);
        labelleft.add(address);
        labelleft.add(eme_contact);
        labelright.add(joined);
        labelright.add(terminated);
        labelright.add(hourrate);
        labelright.add(rating);
        labelright.add(sport);
        
        detailleft.add(coachId);
        detailleft.add(coachName);
        detailleft.add(coachGender);
        detailleft.add(coachContact);
        detailleft.add(coachAddress);
        detailleft.add(coachEme_contact);
        detailright.add(coachJoined);
        detailright.add(coachTerminated);
        detailright.add(coachHourrate);
        detailright.add(coachRating);
        detailright.add(coachSport);


        //Combine panel 
        left.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 50));
        left.add(labelleft,BorderLayout.CENTER);
        left.add(detailleft, BorderLayout.LINE_END);
        right.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 100));
        right.add(labelright,BorderLayout.CENTER);
        right.add(detailright, BorderLayout.LINE_END);
        
        
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
                }

            }
        });
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            if (RCSAS.currentLogin == RCSAS.currentAdmin){
                setVisible(false);
                RCSAS.AdminSecondPage.setVisible(true);
            } else if(RCSAS.currentLogin == RCSAS.currentStudent){
                setVisible(false);
                Page2StudentMainPage smp = new Page2StudentMainPage();
                smp.setVisible(true);
            }
        } 
        
        else if (e.getSource() == modify){
            Modify();
            save.addActionListener((ActionEvent ae ) ->{
                checkModify();
            });
            back.addActionListener((ActionEvent ae ) ->{
                int a = JOptionPane.showConfirmDialog(null, "Your change will be discard!");
                if(a==JOptionPane.YES_OPTION){
                    setVisible(false);
                    Page3CoachPage cp = new Page3CoachPage();
                    cp.setVisible(true);
                }
            });
        }
        
        else if (e.getSource() == extension){
            if(LocalDate.now().compareTo(RCSAS.currentCoach.getTerminated()) < 60){
                try{
                    int du = Integer.parseInt(JOptionPane.showInputDialog("Duration:"));
                    RCSAS.currentCoach.setDuration(RCSAS.currentCoach.getDuration()+du);
                }catch(Exception ee){
                    JOptionPane.showMessageDialog(null, "Wrong Input!");
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "You only allow to extend the contract 60 before terminated day.");
            }
            
        }
        
        else if(e.getSource() == starFeedback){
            starfeedback();
        }
    }
    
    private void Modify(){
        detailleft.remove(coachGender);
        detailleft.remove(coachContact);
        detailleft.remove(coachAddress);
        detailleft.remove(coachEme_contact);
        detailright.remove(coachSport);
        footer.remove(back);
        footer.remove(modify);
        footer.remove(extension);
        
        panelGender = new Panel();
        panelContact = new Panel();
        panelAddress = new Panel();
        panelEme_contact = new Panel();
        panelSport = new Panel();
        
        cbGender = new JComboBox();
        cbGender.addItem("Female");
        cbGender.addItem("Male");
        cbGender.setSelectedItem(coachGender.getText());
        textContact = new JTextField(coachContact.getText());
        textAddress = new JTextField(coachAddress.getText());
        textEme_contact = new JTextField(coachEme_contact.getText());
        String sport[] = RCSAS.allSportName.toArray(new String[RCSAS.allSportName.size()]);
        cbSport = new JComboBox(sport);
        cbSport.setSelectedItem(coachSport.getText());
        
        cbGender.setPreferredSize(new Dimension(300, 40));
        textContact.setPreferredSize(new Dimension(300, 40));
        textAddress.setPreferredSize(new Dimension(300, 40));
        textEme_contact.setPreferredSize(new Dimension(300, 40));
        cbSport.setPreferredSize(new Dimension(300, 40));

        cbGender.setFont(RCSAS.HomePage.normal);
        textContact.setFont(RCSAS.HomePage.normal);
        textAddress.setFont(RCSAS.HomePage.normal);
        textEme_contact.setFont(RCSAS.HomePage.normal);
        cbSport.setFont(RCSAS.HomePage.normal);
        
        panelGender.add(cbGender);
        panelContact.add(textContact);
        panelAddress.add(textAddress);
        panelEme_contact.add(textEme_contact);
        panelSport.add(cbSport);
        
        detailleft.add(panelGender);
        detailleft.add(panelContact);
        detailleft.add(panelAddress);
        detailleft.add(panelEme_contact);
        detailright.add(panelSport);
        
        save = new JButton("SAVE");
        RCSAS.setButton(save);
        save.setFont(RCSAS.HomePage.button);
        back = new JButton("BACK");
        RCSAS.setButton(back);
        back.setFont(RCSAS.HomePage.button);
        
        footer.add(save);
        footer.add(back);
        
        validate();
        repaint();

    }
    
    private void checkModify(){
        ArrayList<String> message = new ArrayList<>();
        if(Pattern.compile("^\\d{11}$").matcher(textContact.getText()).matches() &&
                Pattern.compile("^(.+)@(.+)$").matcher(textAddress.getText()).matches() &&
                Pattern.compile("^\\d{11}$").matcher(textEme_contact.getText()).matches()){
            RCSAS.currentCoach.setGender(cbGender.getSelectedItem().toString());
            RCSAS.currentCoach.setPhone(textContact.getText() );
            RCSAS.currentCoach.setAddress(textAddress.getText());
            RCSAS.currentCoach.setEcontact(textEme_contact.getText());
            for(int i=0; i<RCSAS.allSport.size(); i++){
                Sport sp = RCSAS.allSport.get(i);
                if(sp.getName().equals(cbSport.getSelectedItem())){
                    RCSAS.currentCoach.setSport(sp);
                    break;
                }
            }
            message.add("Update Successfully!");
            setVisible(false);
            Page2StudentMainPage reload = new Page2StudentMainPage();
            reload.setVisible(true);
        } else{
            message.add("There is error inside the field!");
            if(!Pattern.compile("^\\d{11}$").matcher(textContact.getText()).matches()){
                message.add("Invalid Phone Number!");
            }
            if(!Pattern.compile("^(.+)@(.+)$").matcher(textAddress.getText()).matches()){
                message.add("Invalid Email Address!");
            }
            if(!Pattern.compile("^\\d{11}$").matcher(textEme_contact.getText()).matches()){
                message.add("Invalid Emergency Number!");
            }
        }
        JOptionPane.showMessageDialog(null, message);
    }
    
    private void extensionJOptionPane(){
        JLabel l1 = new JLabel("Joined Date: \n"+RCSAS.currentCoach.getJoined().toString());
        JLabel l2 = new JLabel("Current Terminated Date: \n"+RCSAS.currentCoach.getTerminated().toString());
        JLabel l3 = new JLabel("Duration extend (in years):");
        JTextField d = new JTextField(20);

        d.getDocument().addDocumentListener((ValidationDocumentListener) e->{
            try{
                duration = Long.parseLong(d.getText());
                newterminated = RCSAS.currentCoach.getTerminated().plusYears(duration);
            }catch(NumberFormatException ex){
                
            }
        });
        JLabel l4 = new JLabel("New Terminated Date:\n");
        
        l1.setFont(new Font("Centaur", Font.PLAIN,20));
        l2.setFont(new Font("Centaur", Font.PLAIN,20));
        l3.setFont(new Font("Centaur", Font.PLAIN,20));
        l3.setFont(new Font("Centaur", Font.PLAIN,20));
        l4.setFont(new Font("Centaur", Font.PLAIN,20));
    }
    
    private void starfeedback(){
        JRadioButton r1=new JRadioButton("1");    
        JRadioButton r2=new JRadioButton("2");
        JRadioButton r3=new JRadioButton("3");
        JRadioButton r4=new JRadioButton("4");
        JRadioButton r5=new JRadioButton("5");
        ButtonGroup bg=new ButtonGroup();    
        bg.add(r1);bg.add(r2);bg.add(r3);bg.add(r4);bg.add(r5);
        JTextField feedback = new JTextField(20);
        JLabel l1 = new JLabel("Star:");
        JLabel l2 = new JLabel("Feedback:");

        r1.setActionCommand("1");
        r2.setActionCommand("2");
        r3.setActionCommand("3");
        r4.setActionCommand("4");
        r5.setActionCommand("5");

        r1.setFont(new Font("Centaur", Font.PLAIN, 20));
        r2.setFont(new Font("Centaur", Font.PLAIN, 20));
        r3.setFont(new Font("Centaur", Font.PLAIN, 20));
        r4.setFont(new Font("Centaur", Font.PLAIN, 20));
        r5.setFont(new Font("Centaur", Font.PLAIN, 20));
        feedback.setFont(new Font("Centaur", Font.PLAIN, 20));
        l1.setFont(new Font("Centaur", Font.BOLD, 20));
        l2.setFont(new Font("Centaur", Font.BOLD, 20));

        JPanel myPanel = new JPanel(new GridLayout(0,1));
        myPanel.add(l1);
        JPanel myyPanel = new JPanel();
        myyPanel.add(r1);myyPanel.add(r2);myyPanel.add(r3);myyPanel.add(r4);myyPanel.add(r5);
        myPanel.add(myyPanel);
        myPanel.add(l2);
        myPanel.add(feedback);
 
        int option = JOptionPane.showConfirmDialog(null, myPanel, "Provide feedback and Star", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (bg.getSelection()!=null) {
                    int c = Integer.parseInt(bg.getSelection().getActionCommand());
                    String d = null;
                    if(feedback.getText() == null){
                        d = "-";
                    }else{
                        d = feedback.getText();
                    }
                    Feedback x = new Feedback(RCSAS.currentCoach,RCSAS.currentStudent,c,d);
                    RCSAS.currentCoach.getMyfeedback().add(x);
                    RCSAS.allFeedback.add(x);
            } else {
                System.out.println("login failed");
            }
        } else {
            System.out.println("Login canceled");
        }
    }
    
    private void setSTButton(JButton but){
        but.setBackground(new java.awt.Color(125, 155, 171));
        but.setForeground(Color.WHITE);
        but.setPreferredSize(new Dimension(200,40));
        but.setFont(RCSAS.HomePage.button);
        but.addActionListener(this);
    }
    
    private void setSTLabel(JLabel label){
        label.setForeground(Color.WHITE);
        label.setPreferredSize(new Dimension(300, 40));
        label.setFont(new Font("Centaur", Font.BOLD, 30));
    }
}
