
package rcsas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.*;

public class RegisterPage extends JFrame implements ActionListener {
    private JButton summit,back;
    private JPanel header, content, footer, left, right, label1, field1, label2, field2;
    private JLabel title, name, gender, email, contact, eme_contact, sport, program, fee;
    private JComboBox gd,s,p;
    private TextField n, em, cn, ec, fs;
    
    public RegisterPage(){
        //Properties
        setSize(1500,800);
        setLocation(200,100);
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
        footer.add(summit);
        footer.add(back);
        
        content = new JPanel(new BorderLayout());
        add(content, BorderLayout.CENTER);
        content.setLayout(new GridLayout(1,2));
        
        left = new JPanel(new BorderLayout());
        left.setLayout(new GridLayout(1,2));
        right = new JPanel(new BorderLayout());
        right.setLayout(new GridLayout(1,2));
        
        //Create labels
        name = new JLabel("Name:");
        gender = new JLabel("Gender:");
        email = new JLabel("Email:");
        contact = new JLabel("Contact:");
        eme_contact = new JLabel("Emergency Contact:");
        sport = new JLabel("Sport interest:");
        program = new JLabel("Program:");
        fee = new JLabel("Fee:");
        
        //Create text fields
        n = new TextField(20);
        gd = new JComboBox();
        gd.addItem("Female");
        gd.addItem("Male");
        em = new TextField(20);
        cn = new TextField(20);
        ec = new TextField(20);
        s = new JComboBox();
        s.addItem("Swimming");
        s.addItem("Badminton");
        s.addItem("Football");
        s.addItem("Archery");
        s.addItem("Gymnastics");
        s.addItem("Volleyball");
        s.addItem("Basketball");
        s.addItem("Cricket");
        s.addItem("Tennis");
        
        p = new JComboBox();
        fs = new TextField(20);
        fs.setEditable(false);
        
        //Layout labels in a panel.
        label1 = new JPanel(new GridLayout(0,1));
        label1.add(name);
        label1.add(gender);
        label1.add(email);
        label1.add(contact);
        label1.add(eme_contact);
        label2 = new JPanel(new GridLayout(0,1));
        label2.add(sport);
        label2.add(program);
        label2.add(fee);
        
        //Layout text fields in a panel.
        field1 = new JPanel(new GridLayout(0,1));
        field1.add(n);
        field1.add(gd);
        field1.add(em);
        field1.add(cn);
        field1.add(ec);
        field2 = new JPanel(new GridLayout(0,1));
        field2.add(s);
        field2.add(p);
        field2.add(fs);
        
        left.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        left.add(label1, BorderLayout.CENTER);
        left.add(field1, BorderLayout.LINE_END);
        right.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        right.add(label2, BorderLayout.CENTER);
        right.add(field2, BorderLayout.LINE_END);  
        content.add(left);
        content.add(right);

        //setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource() == summit){
            String a = null;                                //name
            int b = 0;                                      //pin
            String c = gd.getSelectedItem().toString();     //gender
            long d = 0;                                     //contact
            String d1 = cn.getText();                       
            String e = null;                                //email
            String e1 = em.getText();                       
            String f = s.getSelectedItem().toString();                        //sport
            String g = fs.getText();
            ArrayList<String> message = new ArrayList<String>();
            //name
            boolean flag = true;
            boolean flag2 = false;
            for(int ix=0; ix<RCSAS.allStudent.size(); ix++){
                Student st = RCSAS.allStudent.get(ix);
                if(n.getText().equals(st.getName())){
                    flag = false;
                    break;
                }   
            }
            if(flag){
                if(gd.getSelectedIndex()!= 0){
                    //Contact
                    a = n.getText();
                    if ((d1 != null) && (Pattern.compile("^\\d{11}$").matcher(d1).matches())){
                        d = Long.parseLong(d1);
                        //Email
                        if(Pattern.compile("^(.+)@(.+)$").matcher(e1).matches()){
                            e = e1;
                            if(s.getSelectedIndex()!= 0){
                                flag2 = true;
                            }
                        }else{

                            message.add("\nInvalid email!");
                        }
                    }else{
                        message.add("\nInvalid phone number!");
                }
                }else{
                    message.add("\nGender box is null!");
                }

            }else{
                message.add("\nName has been used!");
                }
                        
            if(flag2){
                String b1 = JOptionPane.showInputDialog("There is no error in the information keyin. \nKindly create a pin number for login.\nPin:");
                if (Pattern.compile("[1-9]{1}\\d{5,10}").matcher(b1).matches()){
                    b = Integer.parseInt(b1);
                    Student st = new Student(a,b,c,d,e,f);
                    RCSAS.allStudent.add(st);
                    RCSAS.HomePage.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid pin number! Pin number should match condition below: \n1. Pin number should be numeric. \n2. Length of pin number should be 6-10. \n3. Pin number should not start by 0. \n");
                }
            }else{
                JOptionPane.showMessageDialog(null,"There are error in the information:"+message+"\nKindly replace the invalid information!");
            }
        }
    }
}
