
package rcsas;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.*;

public class Page2RegisterPage extends JFrame implements ActionListener{
    final private JPanel header, content, footer;
    final private JLabel title, name, gender, email, contact, eme_contact, sport, program, fee;
    final private JLabel errorname, errorgender, erroremail, errorcontact, erroreme_contact, errorsport, errorprogram;
    final private Button submit, back;
    final private JComboBox gd,s,p;
    final private JTextField n, em, cn, ec, fs;
    private boolean error;
    
    public Page2RegisterPage(){
        setSize(1500,800);
        setLocation(200,100);
        
        header = new JPanel();
        header.setPreferredSize(new Dimension(1500,100));
        add(header, BorderLayout.NORTH);
        title = new JLabel("- Register Page -");
        title.setFont(new Font("Serif", Font.PLAIN, 48));
        header.add(title);
        
        content = new JPanel();
        content.setLayout(null);
        add(content, BorderLayout.CENTER);
        
        footer = new JPanel(new FlowLayout());
        add(footer, BorderLayout.SOUTH);
        submit = new Button("SUBMMIT");
        back = new Button("BACK");
        submit.addActionListener(this);
        back.addActionListener(this);
        footer.add(submit);
        footer.add(back);
        submit.setFont(new Font("Serif", Font.BOLD, 26));
        back.setFont(new Font("Serif", Font.BOLD, 26));
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
        program = new JLabel("Program:");
        fee = new JLabel("Fee:");
        
        //Create text fields
        n = new JTextField();
        gd = new JComboBox();
        cn = new JTextField();
        em = new JTextField();
        ec = new JTextField();
        s = new JComboBox();
        p = new JComboBox();
        fs = new JTextField();
        
        //Create ErrorMessage
        errorname = new JLabel();
        errorgender = new JLabel();
        erroremail = new JLabel();
        errorcontact = new JLabel();
        erroreme_contact = new JLabel();
        errorsport = new JLabel();
        errorprogram = new JLabel();
        
        //Layout labels in a panel.
        content.add(name);
        content.add(gender);
        content.add(contact);
        content.add(remark);
        content.add(email);
        content.add(eme_contact);
        content.add(sport);
        content.add(program);
        content.add(fee);
        content.add(n);
        content.add(gd);
        content.add(cn);
        content.add(em);
        content.add(ec);
        content.add(s);
        content.add(p);
        content.add(fs);
        content.add(errorname);
        content.add(errorgender);
        content.add(erroremail);
        content.add(errorcontact);
        content.add(erroreme_contact);
        content.add(errorsport);
        content.add(errorprogram);
        
        
        //Location
        name.setBounds(75,50,250,40);
        gender.setBounds(75,150,250,40);
        contact.setBounds(75,250,250,40);
        remark.setBounds(85,290,250,20);
        email.setBounds(75,350,250,40);
        eme_contact.setBounds(75,450,250,40);
        sport.setBounds(825,50,250,40);
        program.setBounds(825,150,250,40);
        fee.setBounds(825,250,250,40);
        
        n.setBounds(375, 50, 300, 40);
        gd.setBounds(375, 150, 300, 40);
        cn.setBounds(375, 250, 300, 40);
        em.setBounds(375, 350, 300, 40);
        ec.setBounds(375, 450, 300, 40);
        s.setBounds(1125, 50, 300, 40);
        p.setBounds(1125, 150, 300, 40);
        fs.setBounds(1125, 250, 300, 40);
        
        errorname.setBounds(385, 90, 300, 20);
        errorgender.setBounds(385, 190, 300, 20);
        errorcontact.setBounds(385, 290, 300, 20);
        erroremail.setBounds(385, 390, 300, 20);
        erroreme_contact.setBounds(385, 490, 300, 20);
        errorsport.setBounds(1135, 90, 300, 20);
        errorprogram.setBounds(1135, 190, 300, 20);
        
        //Font
        name.setFont(new Font("Serif", Font.BOLD, 26));
        gender.setFont(new Font("Serif", Font.BOLD, 26));
        email.setFont(new Font("Serif", Font.BOLD, 26));
        contact.setFont(new Font("Serif", Font.BOLD, 26));
        remark.setFont(new Font("Serif", Font.BOLD, 12));
        eme_contact.setFont(new Font("Serif", Font.BOLD, 26));
        sport.setFont(new Font("Serif", Font.BOLD, 26));
        program.setFont(new Font("Serif", Font.BOLD, 26));
        fee.setFont(new Font("Serif", Font.BOLD, 26));
        
        n.setFont(new Font("Serif", Font.PLAIN, 26));
        gd.setFont(new Font("Serif", Font.PLAIN, 26));
        em.setFont(new Font("Serif", Font.PLAIN, 26));
        cn.setFont(new Font("Serif", Font.PLAIN, 26));
        ec.setFont(new Font("Serif", Font.PLAIN, 26));
        s.setFont(new Font("Serif", Font.PLAIN, 26));
        p.setFont(new Font("Serif", Font.PLAIN, 26));
        fs.setFont(new Font("Serif", Font.PLAIN, 26));
        
        errorname.setFont(new Font("Serif", Font.BOLD, 12));
        errorgender.setFont(new Font("Serif", Font.BOLD, 12));
        erroremail.setFont(new Font("Serif", Font.BOLD, 12));
        errorcontact.setFont(new Font("Serif", Font.BOLD, 12));
        erroreme_contact.setFont(new Font("Serif", Font.BOLD, 12));
        errorsport.setFont(new Font("Serif", Font.BOLD, 12)); 
        errorprogram.setFont(new Font("Serif", Font.BOLD, 12));
        
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
        p.setEnabled(false);
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
//        p.addItemListener((ItemEvent arg0) -> {
//            ValidateProgram();
//        });
        
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "This action will loss the information key in. \nAre you sure?");
                if(a==JOptionPane.YES_OPTION){
                    setVisible(false);
                    RCSAS.HomePage.setVisible(true);
                    RCSAS.currentStudent = null;
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
                Sport g = Sport.valueOf(s.getSelectedItem().toString());
                String b1 = JOptionPane.showInputDialog("There is no error in the information keyin. \nKindly create a pin number for login.\nPin:");
                if (Pattern.compile("[1-9]{1}\\d{5,10}").matcher(b1).matches()){
                    int b = Integer.parseInt(b1);
                    int idno = 10001+RCSAS.allStudent.size();
                    String id = "ST" + idno;
                    Student st = new Student(id,a,b,c,d,e,f);
                    int idnoc = 1000001+RCSAS.allClasses.size();
                    String cid = "C" + idnoc;
                    Classes cl = new Classes(cid,st, g,0,0,false, false);
                    RCSAS.allStudent.add(st);
                    RCSAS.allClasses.add(cl);
                    setVisible(false);
                    RCSAS.HomePage.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid pin number! Pin number should match condition below: \n1. Pin number should be numeric. \n2. Length of pin number should be 6-10. \n3. Pin number should not start by 0. \n");
                }
            } else {
                JOptionPane.showMessageDialog(null,"There is null box!");
            }
        }
    }
    
    
    private void ValidateName(){
        boolean flag = true;
        for(int ix=0; ix<RCSAS.allStudent.size(); ix++){
            Student st = RCSAS.allStudent.get(ix);
            if(n.getText().equals(st.getName())){
                flag = false;
                break;
            }   
        }
        if(!flag){
            errorname.setForeground(Color.red);
            errorname.setText("Name used!");
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
            p.setEnabled(false);
            p.setSelectedIndex(-1);
        }else{
            errorsport.setText("OK! Ready to use!");
            error = false;
            p.setEnabled(true);
        }
    }
    private void ValidateProgram(){
        if(p.getSelectedItem() == null){
            errorprogram.setText("Program box is null!");
            error = true;
        }else{
            errorprogram.setText("OK! Ready to use!");
            error = false;
        }
    }
}
