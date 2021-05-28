
package rcsas;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.swing.*;

public class Page2RegisterPage extends JFrame implements ActionListener{
    final private JPanel header, content, footer;
    final private JLabel title, name, gender, email, contact, eme_contact, sport, fee;
    final private JLabel errorname, errorgender, erroremail, errorcontact, erroreme_contact, errorsport;
    final private JButton submit, back;
    final private JComboBox gd,s;
    final private JTextField n, em, cn, ec, fs;
    private boolean error;
    private int fees;
    
    public Page2RegisterPage(){
        setSize(1500,800);
        setLocation(200,100);
        
        
        //
        //header
        //
        header = new JPanel();
        header.setPreferredSize(new Dimension(1500,125));
        header.setBackground(new java.awt.Color(197, 215, 214));
        add(header, BorderLayout.NORTH);
        title = new JLabel("--  REGISTER PAGE  --");
        title.setFont(RCSAS.HomePage.title);
        title.setForeground(Color.white);
        header.add(title);
        
        
        //
        //content
        //
        content = new JPanel();
        content.setLayout(null);
        content.setBackground(new java.awt.Color(197, 215, 214));
        add(content, BorderLayout.CENTER);
        
        
        //
        //footer
        //
        footer = new JPanel(new FlowLayout());
        footer.setBackground(new java.awt.Color(197, 215, 214));
        add(footer, BorderLayout.SOUTH);
        submit = new JButton("Submit");
        submit.setBackground(new java.awt.Color(125, 155, 171));
        submit.setForeground(Color.WHITE);
        back = new JButton("Back");
        back.setBackground(new java.awt.Color(125, 155, 171));
        back.setForeground(Color.WHITE);
        submit.addActionListener(this);
        back.addActionListener(this);
        footer.add(submit);
        footer.add(back);
        submit.setFont(new Font("Agency FB", Font.BOLD, 26));
        back.setFont(new Font("Agency FB", Font.BOLD, 26));
        submit.setPreferredSize(new Dimension(150,40));
        back.setPreferredSize(new Dimension(150,40));
        
        
        //Create labels
        name = new JLabel("Name:");
        gender = new JLabel("Gender:");
        email = new JLabel("Email:");
        contact = new JLabel("Contact:");
        JLabel remark = new JLabel("(Please include 60)");
        eme_contact = new JLabel("Emergency Contact:");
        sport = new JLabel("Sport interest:");
        fee = new JLabel("Fee:");
        
        //Create text fields
        n = new JTextField();
        gd = new JComboBox();
        cn = new JTextField();
        em = new JTextField();
        ec = new JTextField();
        s = new JComboBox();
        fs = new JTextField();
        
        //Create ErrorMessage
        errorname = new JLabel();
        errorgender = new JLabel();
        erroremail = new JLabel();
        errorcontact = new JLabel();
        erroreme_contact = new JLabel();
        errorsport = new JLabel();
        
        //Layout labels in a panel.
        content.add(name);
        content.add(gender);
        content.add(contact);
        content.add(remark);
        content.add(email);
        content.add(eme_contact);
        content.add(sport);
        content.add(fee);
        content.add(n);
        content.add(gd);
        content.add(cn);
        content.add(em);
        content.add(ec);
        content.add(s);
        content.add(fs);
        content.add(errorname);
        content.add(errorgender);
        content.add(erroremail);
        content.add(errorcontact);
        content.add(erroreme_contact);
        content.add(errorsport);
        
        
        //Location
        name.setBounds(75,50,250,40);
        gender.setBounds(75,150,250,40);
        contact.setBounds(75,250,250,40);
        remark.setBounds(85,290,250,20);
        email.setBounds(75,350,250,40);
        eme_contact.setBounds(75,450,250,40);
        sport.setBounds(825,50,250,40);
        fee.setBounds(825,150,250,40);
        
        n.setBounds(375, 50, 300, 40);
        gd.setBounds(375, 150, 300, 40);
        cn.setBounds(375, 250, 300, 40);
        em.setBounds(375, 350, 300, 40);
        ec.setBounds(375, 450, 300, 40);
        s.setBounds(1125, 50, 300, 40);
        fs.setBounds(1125, 150, 300, 40);
        
        errorname.setBounds(385, 90, 300, 20);
        errorgender.setBounds(385, 190, 300, 20);
        errorcontact.setBounds(385, 290, 300, 20);
        erroremail.setBounds(385, 390, 300, 20);
        erroreme_contact.setBounds(385, 490, 300, 20);
        errorsport.setBounds(1135, 90, 300, 20);
        
        //Font
        name.setFont(new Font("Centaur", Font.BOLD, 26));
        gender.setFont(new Font("Centaur", Font.BOLD, 26));
        email.setFont(new Font("Centaur", Font.BOLD, 26));
        contact.setFont(new Font("Centaur", Font.BOLD, 26));
        remark.setFont(new Font("Centaur", Font.BOLD, 12));
        eme_contact.setFont(new Font("Centaur", Font.BOLD, 26));
        sport.setFont(new Font("Centaur", Font.BOLD, 26));
        fee.setFont(new Font("Centaur", Font.BOLD, 26));
        
        n.setFont(new Font("Centaur", Font.PLAIN, 26));
        gd.setFont(new Font("Centaur", Font.PLAIN, 26));
        em.setFont(new Font("Centaur", Font.PLAIN, 26));
        cn.setFont(new Font("Centaur", Font.PLAIN, 26));
        ec.setFont(new Font("Centaur", Font.PLAIN, 26));
        s.setFont(new Font("Centaur", Font.PLAIN, 26));
        fs.setFont(new Font("Centaur", Font.PLAIN, 26));
        
        errorname.setFont(new Font("Centaur", Font.BOLD, 12));
        errorgender.setFont(new Font("Centaur", Font.BOLD, 12));
        erroremail.setFont(new Font("Centaur", Font.BOLD, 12));
        errorcontact.setFont(new Font("Centaur", Font.BOLD, 12));
        erroreme_contact.setFont(new Font("Centaur", Font.BOLD, 12));
        errorsport.setFont(new Font("Centaur", Font.BOLD, 12)); 
        
        //ComboBox
        gd.addItem("Female");
        gd.addItem("Male");
        gd.setSelectedIndex(-1);
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
        
        //Editable
        gd.setEnabled(false);
        gd.setEditable(false);
        em.setEditable(false);
        cn.setEditable(false);
        ec.setEditable(false);
        s.setEnabled(false);
        fs.setEditable(false);
        
        
        //Add Listener
        n.getDocument().addDocumentListener((ValidationDocumentListener) e->{
            ValidateName();
        });
        gd.addItemListener((ItemEvent arg0) -> {
            ValidateGender();
        });
        em.getDocument().addDocumentListener((ValidationDocumentListener) e->{
            ValidateEmail();
        });
        cn.getDocument().addDocumentListener((ValidationDocumentListener) e->{
            ValidateContact();
        });
        ec.getDocument().addDocumentListener((ValidationDocumentListener) e->{
            ValidateEmergency();
        });
        s.addItemListener((ItemEvent arg0) -> {
            ValidateSport();
        });
        
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "This action will loss the information key in. \nAre you sure?");
                if(a==JOptionPane.YES_OPTION){
                    setVisible(false);
                    RCSAS.HomePage.setVisible(true);
                    RCSAS.currentStudent = null;
                    RemoveText();
                }else if (a == JOptionPane.NO_OPTION){
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent ev){
        if (ev.getSource() == back){
            int a = JOptionPane.showConfirmDialog(null, "This action will loss the information key in. \nAre you sure?");
            if(a==JOptionPane.YES_OPTION){
                setVisible(false);
                RCSAS.HomePage.setVisible(true);
                RCSAS.currentStudent = null;
                RemoveText();
            }else if (a == JOptionPane.NO_OPTION){
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        }
        
        else if (ev.getSource() == submit){
            if(!error){
                String a = n.getText();
                String c = gd.getSelectedItem().toString();
                String d = cn.getText();
                String e = em.getText();
                String f = ec.getText();
                for(int i=0; i<RCSAS.allSport.size(); i++){
                    Sport sp = RCSAS.allSport.get(i);
                    if(sp.getName().equals(s.getSelectedItem().toString())){
                        Sport g = sp;
                        String b1 = JOptionPane.showInputDialog("There is no error in the information keyin. \nKindly create a pin number for login.\nPin:");
                        if (Pattern.compile("[1-9]{1}\\d{5,10}").matcher(b1).matches()){
                            int b = Integer.parseInt(b1);
                            int idno = 1+RCSAS.allStudent.size();
                            String id = "ST" + String.format("%04d", idno);
                            Student st = new Student(id,a,b,c,d,e,f);
                            int idnoc = 1+RCSAS.allClasses.size();
                            String cid = "C" + String.format("%06d", idnoc);
                            Classes cl = new Classes(cid,st,g,fees,0,0,false, false);
                            RCSAS.allStudent.add(st);
                            RCSAS.allClasses.add(cl);
                            try{
                                PrintWriter p = new PrintWriter("student.txt");
                                for(int in=0; in<RCSAS.allStudent.size(); in++){
                                    Student allst = RCSAS.allStudent.get(in);
                                    p.println(allst.getId());
                                    p.println(allst.getName());
                                    p.println(allst.getPin());
                                    p.println(allst.getGender());
                                    p.println(allst.getPhone());
                                    p.println(allst.getEmail());
                                    p.println(allst.getEm_phone());
                                    p.println();
                                } p.close();
                                //Classes
                                p = new PrintWriter("classes.txt");
                                for(int in=0; in<RCSAS.allClasses.size(); in++){
                                    Classes allb = RCSAS.allClasses.get(in);
                                    p.println(allb.getId());
                                    p.println(allb.getStudent().getName());
                                    p.println(allb.getSport().getName());
                                    p.println(allb.getPrice());
                                    p.println(allb.getHourdone());
                                    p.println(allb.getHasPaid());
                                    p.println(allb.isFinish());
                                    p.println(allb.isPaid());
                                    p.println();
                                } p.close();
                            } catch(FileNotFoundException ex){
                                System.out.println("Error!");
                            }
                            RemoveText();
                            setVisible(false);
                            RCSAS.HomePage.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null,"Invalid pin number! Pin number should match condition below: \n1. Pin number should be numeric. \n2. Length of pin number should be 6-10. \n3. Pin number should not start by 0. \n");
                        }
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,"There is null box!");
            }
        }
    }
    
    private void RemoveText(){
        n.setText(null);
        gd.setSelectedIndex(-1);
        cn.setText(null);
        em.setText(null);
        ec.setText(null);
        s.setSelectedIndex(-1);
        fs.setText(null);
    }
    
    private void ValidateName(){
        boolean flag = true;
        if(n.getText().isEmpty()){
            flag = false;
        } else{
            for(int ix=0; ix<RCSAS.allStudent.size(); ix++){
                Student st = RCSAS.allStudent.get(ix);
                if(n.getText().equals(st.getName())){
                    flag = false;
                    break;
                }   
            }
        }

        if(!flag){
            errorname.setForeground(Color.red);
            errorname.setText("Null box / Name used!");
            error = true;
            gd.setEnabled(false);
            gd.setSelectedIndex(-1);
        } else{
            errorname.setForeground(Color.BLACK);
            errorname.setText("OK! Ready to use!");
            error = false;
            gd.setEnabled(true);
        }
    }
    
    private void ValidateGender(){
        if(gd.getSelectedItem() == null){
            errorgender.setText("Gender box is null!");
            error = true;
            cn.setEnabled(false);
            cn.setText(null);
        }else{
            errorgender.setText("OK! Ready to use!");
            error = false;
            cn.setEditable(true);
        }
    }
    
    private void ValidateContact(){
        if(Pattern.compile("^\\d{11}$").matcher(cn.getText()).matches()){
            errorcontact.setForeground(Color.BLACK);
            errorcontact.setText("OK! Ready to use!");
            error = false;
            em.setEditable(true);
        }else{
            errorcontact.setForeground(Color.red);
            errorcontact.setText("Invalid phone number!");
            error = true;
            em.setEditable(false);
            em.setText(null);
        }
    }
    
    private void ValidateEmail(){
        if(Pattern.compile("^(.+)@(.+)$").matcher(em.getText()).matches()){
            erroremail.setForeground(Color.BLACK);
            erroremail.setText("OK! Ready to use!");
            error = false;
            ec.setEditable(true);
        }else{
            erroremail.setForeground(Color.red);
            erroremail.setText("Invalid email!");
            error = true;
            ec.setEditable(false);
            ec.setText(null);
        }
    }
    
    private void ValidateEmergency(){
        if(Pattern.compile("^\\d{11}$").matcher(ec.getText()).matches()){
            erroreme_contact.setForeground(Color.BLACK);
            erroreme_contact.setText("OK! Ready to use!");
            error = false;
            s.setEnabled(true);
        }else{
            erroreme_contact.setForeground(Color.red);
            erroreme_contact.setText("Invalid emergency contact!");
            error = true;
            s.setEnabled(false);
            s.setSelectedIndex(-1);
        }
    }
    private void ValidateSport(){
        if(s.getSelectedItem() == null){
            errorsport.setText("Sport box is null!");
            error = true;
        }else{
            errorsport.setText("OK! Ready to use!");
            error = false;
            fees = 0;
            for(int i=0; i<RCSAS.allSport.size(); i++){
                Sport sp = RCSAS.allSport.get(i);
                if(sp.getName().equals(s.getSelectedItem().toString())){
                    fees = sp.getPrice()*24;
                }
            }
            fs.setText("RM"+String.format("%04d",fees));
        }
    }
}
