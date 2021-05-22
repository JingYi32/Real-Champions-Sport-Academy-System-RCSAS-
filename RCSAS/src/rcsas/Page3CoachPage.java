
package rcsas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Page3CoachPage extends JFrame implements ActionListener{
    private final JLabel title, id, name, gender, contact, address, eme_contact, sport, joined, terminated, hourrate, rating;
    private final JLabel coachId, coachName, coachGender, coachContact, coachAddress, coachEme_contact, coachSport, coachJoined, coachTerminated, coachHourrate, coachRating;
    private final Button back;
    private Button modify, starFeedback, extension;
    private final JPanel header, content, left, labelleft, labelright, footer, right, detailleft, detailright;
    
    public Page3CoachPage(){
        setSize(1500,800);
        setLocation(200,100);
        setLayout(new BorderLayout());
        
        //
        //header
        //
        header = new JPanel(new GridBagLayout());
        title = new JLabel("Coach Profile");
        header.add(title);
        title.setFont(new Font("Serif", Font.PLAIN, 32));
        add(header, BorderLayout.NORTH);
        
        //
        //footer
        //
        footer = new JPanel(new GridBagLayout());
        back = new Button("BACK");
        footer.add(back);
        back.addActionListener(this);
        if (RCSAS.currentLogin == RCSAS.currentAdmin){
            modify = new Button("MODIFY");
            extension = new Button("Contract Extension");
            footer.add(modify);
            footer.add(extension);
            modify.addActionListener(this);
            extension.addActionListener(this);
        } else if(RCSAS.currentLogin == RCSAS.currentStudent){
            starFeedback = new Button("Provide feedback and Star");
            footer.add(starFeedback);
            starFeedback.addActionListener(this);
        }
        add(footer, BorderLayout.SOUTH);
        back.setPreferredSize(new Dimension(100,40));
        back.setFont(new Font("Serif", Font.PLAIN, 18));
        
        //
        //content
        ///
        content = new JPanel(new GridLayout(1,2));
        add(content, BorderLayout.CENTER);
        left = new JPanel(new BorderLayout());
        labelleft = new JPanel(new GridLayout(0,1));labelright = new JPanel(new GridLayout(0,1));
        right = new JPanel(new BorderLayout());
        detailleft = new JPanel(new GridLayout(0,1));detailright = new JPanel(new GridLayout(0,1));
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
        coachSport = new JLabel(RCSAS.currentCoach.getSport().toString());
        coachJoined = new JLabel(RCSAS.currentCoach.getJoined().toString());
        coachTerminated = new JLabel(RCSAS.currentCoach.getId());
        coachHourrate = new JLabel(RCSAS.currentCoach.getId());
        coachRating = new JLabel(RCSAS.currentCoach.getId());
        
        //Propertly of Label
        id.setFont(new Font("Serif", Font.BOLD, 20));
        name.setFont(new Font("Serif", Font.BOLD, 20));
        gender.setFont(new Font("Serif", Font.BOLD, 20));
        contact.setFont(new Font("Serif", Font.BOLD, 20));
        address.setFont(new Font("Serif", Font.BOLD, 20));
        eme_contact.setFont(new Font("Serif", Font.BOLD, 20));
        sport.setFont(new Font("Serif", Font.BOLD, 20));
        joined.setFont(new Font("Serif", Font.BOLD, 20));
        terminated.setFont(new Font("Serif", Font.BOLD, 20));
        hourrate.setFont(new Font("Serif", Font.BOLD, 20));
        rating.setFont(new Font("Serif", Font.BOLD, 20));
        
        coachId.setFont(new Font("Serif", Font.PLAIN, 20));
        coachName.setFont(new Font("Serif", Font.PLAIN, 20));
        coachGender.setFont(new Font("Serif", Font.PLAIN, 20));
        coachContact.setFont(new Font("Serif", Font.PLAIN, 20));
        coachAddress.setFont(new Font("Serif", Font.PLAIN, 20));
        coachEme_contact.setFont(new Font("Serif", Font.PLAIN, 20));
        coachSport.setFont(new Font("Serif", Font.PLAIN, 20));
        coachJoined.setFont(new Font("Serif", Font.PLAIN, 20));
        coachTerminated.setFont(new Font("Serif", Font.PLAIN, 20));
        coachHourrate.setFont(new Font("Serif", Font.PLAIN, 20));
        coachRating.setFont(new Font("Serif", Font.PLAIN, 20));
        
        //Add label into panel
        labelleft.add(id);
        labelleft.add(name);
        labelleft.add(gender);
        labelleft.add(contact);
        labelleft.add(address);
        labelleft.add(eme_contact);
        labelright.add(sport);
        labelright.add(joined);
        labelright.add(terminated);
        labelright.add(hourrate);
        labelright.add(rating);
        
        detailleft.add(coachId);
        detailleft.add(coachName);
        detailleft.add(coachGender);
        detailleft.add(coachContact);
        detailleft.add(coachAddress);
        detailleft.add(coachEme_contact);
        detailright.add(coachSport);
        detailright.add(coachJoined);
        detailright.add(coachTerminated);
        detailright.add(coachHourrate);
        detailright.add(coachRating);

        //Combine panel 
        left.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        left.add(labelleft,BorderLayout.CENTER);
        left.add(detailleft, BorderLayout.LINE_END);
        right.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
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
    }
}
