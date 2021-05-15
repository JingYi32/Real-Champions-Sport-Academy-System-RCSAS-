
package rcsas;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.regex.Pattern;
import javax.swing.*;

public class Page3RegisterPage extends JFrame implements ActionListener{
    final private JButton summit,back;
    final private JPanel header, content, footer, left, right, label1, field1, label2, field2;
    final private JLabel title, name, gender, email, contact, eme_contact, sport, program, fee;
    final private JComboBox gd,s,p;
    final private TextField n, em, cn, ec, fs;    
    
    public Page3RegisterPage(){
        //Properties
        setSize(1500,800);
        setLocation(200,100);
        
        header = new JPanel();
        header.setPreferredSize(new Dimension(1500,100));
        add(header, BorderLayout.NORTH);
        title = new JLabel("Register Page");
        title.setFont(new Font("Serif", Font.PLAIN, 32));
        header.add(title);
       
        footer = new JPanel();
        footer.setPreferredSize(new Dimension(1500,100));
        add(footer, BorderLayout.SOUTH);
        summit = new JButton("Summit");
        summit.setFont(new Font("Serif", Font.PLAIN, 26));
        summit.setPreferredSize(new Dimension(150,40));
        summit.addActionListener(this);
        back = new JButton("Back");
        back.setFont(new Font("Serif", Font.PLAIN, 26));
        back.setPreferredSize(new Dimension(150,40));
        back.addActionListener(this);
        footer.add(summit);
        footer.add(back);
        
        content = new JPanel(new GridLayout(1,2));
        add(content, BorderLayout.CENTER);
        
        left = new JPanel(new GridLayout(1,2));
        right = new JPanel(new GridLayout(1,2));
        
        //Create labels
        name = new JLabel("Name:");
        gender = new JLabel("Gender:");
        email = new JLabel("Email:");
        contact = new JLabel("Contact(60XXXXXXXXX):");
        eme_contact = new JLabel("Emergency Contact:");
        sport = new JLabel("Sport interest:");
        program = new JLabel("Program:");
        fee = new JLabel("Fee:");
        
        //Propertly of labels
        name.setFont(new Font("Serif", Font.PLAIN, 26));
        gender.setFont(new Font("Serif", Font.PLAIN, 26));
        email.setFont(new Font("Serif", Font.PLAIN, 26));
        contact.setFont(new Font("Serif", Font.PLAIN, 26));
        eme_contact.setFont(new Font("Serif", Font.PLAIN, 26));
        sport.setFont(new Font("Serif", Font.PLAIN, 26));
        program.setFont(new Font("Serif", Font.PLAIN, 26));
        fee.setFont(new Font("Serif", Font.PLAIN, 26));
        
        //Create text fields
        n = new TextField(40);
        gd = new JComboBox();
        cn = new TextField(40);
        em = new TextField(40);
        ec = new TextField(40);
        s = new JComboBox();
        p = new JComboBox();
        fs = new TextField(40);
        
        //Properly of Input Fields
        n.setFont(new Font("Serif", Font.PLAIN, 26));
        gd.setFont(new Font("Serif", Font.PLAIN, 26));
        gd.setPreferredSize(new Dimension(350,40));
        gd.addItem("Female");
        gd.addItem("Male");
        gd.setSelectedIndex(-1);
        em.setFont(new Font("Serif", Font.PLAIN, 26));
        cn.setFont(new Font("Serif", Font.PLAIN, 26));
        ec.setFont(new Font("Serif", Font.PLAIN, 26));
        s.setFont(new Font("Serif", Font.PLAIN, 26));
        s.setPreferredSize(new Dimension(350,40));
        s.addItem("Swimming");
        s.addItem("Badminton");
        s.addItem("Football");
        s.addItem("Archery");
        s.addItem("Gymnastics");
        s.addItem("Volleyball");
        s.addItem("Basketball");
        s.addItem("Cricket");
        s.addItem("Tennis");
        s.setSelectedIndex(-1);
        p.setFont(new Font("Serif", Font.PLAIN, 26));
        p.setPreferredSize(new Dimension(350,40));
        fs.setFont(new Font("Serif", Font.PLAIN, 26));
        fs.setEditable(false);
        
        //Layout labels in a panel.
        label1 = new JPanel(new GridLayout(0,1));
        label1.add(name);
        label1.add(gender);
        label1.add(contact);
        label1.add(email);
        label1.add(eme_contact);
        label2 = new JPanel(new GridLayout(0,1));
        label2.add(sport);
        label2.add(program);
        label2.add(fee);
        
        //Layout text fields in a panel.
        JPanel pn = new JPanel(new GridBagLayout());
        pn.add(n);
        JPanel pgd = new JPanel(new GridBagLayout());
        pgd.add(gd);
        JPanel pcn = new JPanel(new GridBagLayout());
        pcn.add(cn);
        JPanel pem = new JPanel(new GridBagLayout());
        pem.add(em);
        JPanel pec = new JPanel(new GridBagLayout());
        pec.add(ec);
        JPanel ps = new JPanel(new GridBagLayout());
        ps.add(s);
        JPanel pp = new JPanel(new GridBagLayout());
        pp.add(p);
        JPanel pfs = new JPanel(new GridBagLayout());
        pfs.add(fs);
        
        field1 = new JPanel(new GridLayout(0,1));
        field1.add(pn, new GridBagConstraints());
        field1.add(pgd);
        field1.add(pcn);
        field1.add(pem);
        field1.add(pec);
        field2 = new JPanel(new GridLayout(0,1));
        field2.add(ps);
        field2.add(pp);
        field2.add(pfs);
        
        left.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        left.add(label1, BorderLayout.CENTER);
        left.add(field1, BorderLayout.LINE_END);
        right.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        right.add(label2, BorderLayout.CENTER);
        right.add(field2, BorderLayout.LINE_END);  
        content.add(left);
        content.add(right);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int a = JOptionPane.YES_NO_OPTION;
                JOptionPane.showConfirmDialog(null, "This action will loss the information key in. \nAre you sure?","WARNING", a);
                if(a==JOptionPane.YES_OPTION){
                    setVisible(false);
                    RCSAS.HomePage.setVisible(true);
                    RCSAS.current = null;
                }else{
                    remove(a);
                }
            }
        });
    }
    public void windowClosing(WindowEvent e) {
        int a=JOptionPane.showConfirmDialog(null,"Are you sure?");
        if(a==JOptionPane.YES_OPTION){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource() == summit){
            ArrayList<String> message = new ArrayList<>();
            
            boolean flag = true;
            boolean flag2 = true;
            
            //
            //name
            //
            String a = null;
            if(n.getText() == null){
                message.add("\nName field cannot be blank!");
            }else{
                a = n.getText();
                for(int ix=0; ix<RCSAS.allStudent.size(); ix++){
                    Student st = RCSAS.allStudent.get(ix);
                    if(a.equals(st.getName())){
                        flag = false;
                        break;
                    }   
                }
                for(int ix=0; ix<RCSAS.allAdmin.size(); ix++){
                    Admin ad = RCSAS.allAdmin.get(ix);
                    if(a.equals(ad.getName())){
                        flag = false;
                        break;
                    }   
                }
            }
            if(!flag){
                message.add("\nName has been used!");
                flag2 = false;
            }
            
            //
            //gender
            //
            String c = null;
            try{
                c = gd.getSelectedItem().toString();
            }catch(NullPointerException npe){
                message.add("\nGender box is null!");
                flag2 = false;
            }

            
            //
            //contact
            //
            
            String d1 = cn.getText();
            String d = null;
            if(Pattern.compile("^\\d{11}$").matcher(d1).matches()){
                d = d1;
            }else{
                message.add("\nInvalid phone number!");
                flag2 = false;
            }
            
            //
            //email
            //
            String e = em.getText();
            if(!Pattern.compile("^(.+)@(.+)$").matcher(e).matches()){
                message.add("\nInvalid email!");
                flag2 = false;
            }
            
            //
            //Emergency Contact
            //
            String f = ec.getText();
            if(!Pattern.compile("^\\d{11}$").matcher(d1).matches()){
                message.add("\nInvalid emergency contact!!");
                flag2 = false;
            }
            
            
            //sport
            //
            Sport g = null;
            try{
                g = Sport.valueOf(s.getSelectedItem().toString());
            }catch(NullPointerException npe){
                message.add("\nSport box is null!");
                flag2 = false;
            }
            
            //
            //program
            //
            
            //
            //Location
            //
            
            //
            //Fee
            //
            
            
            if(flag2){
                String b1 = JOptionPane.showInputDialog("There is no error in the information keyin. \nKindly create a pin number for login.\nPin:");
                if (Pattern.compile("[1-9]{1}\\d{5,10}").matcher(b1).matches()){
                    int b = Integer.parseInt(b1);
                    Student st = new Student(a,b,c,d,e,f,g);
                    RCSAS.allStudent.add(st);
                    setVisible(false);
                    RCSAS.HomePage.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid pin number! Pin number should match condition below: \n1. Pin number should be numeric. \n2. Length of pin number should be 6-10. \n3. Pin number should not start by 0. \n");
                }
            }else{
                JOptionPane.showMessageDialog(null,"There are error in the information:"+message+"\nKindly replace the invalid information!");
            }
        }
        
        else if(ev.getSource() == back){
            int a = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog(null, "This action will loss the information key in. \nAre you sure?","WARNING", a);
            if(a==JOptionPane.YES_OPTION){
                setVisible(false);
                RCSAS.HomePage.setVisible(true);
                RCSAS.current = null;
            }else{
                remove(a);
            }
        }
    }
}
