package rcsas;
import java.awt.*;
import java.awt.event.*;
<<<<<<< HEAD
<<<<<<< HEAD
import javax.swing.*;
=======
>>>>>>> parent of feee75e (RCSAS)
=======
import java.io.PrintWriter;

>>>>>>> parent of e0fa173 (20210512)

public class Page1HomePage extends JFrame implements ActionListener{
    private Button login, signup, exit;
    
    public Page1HomePage(){
        //Frame Properties
        setSize(1500,900);
        setLocation(200,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        //Panel Properties
        JPanel panel = new JPanel();
        panel.setBounds(0,0,1500,80);
        panel.setBackground(new java.awt.Color(204, 166, 166));
        
        //Creating Button
        login = new Button("Login");
        signup = new Button("Sign up");
        exit = new Button("Exit");
        
        //Properties of Button
        login.setBounds(1240,25,70,25);
        signup.setBounds(1320, 25, 70, 25);
        exit.setBounds(1400, 25, 70, 25);
        
        //Adding Action Listener to Button
        login.addActionListener(this);
        signup.addActionListener(this);
        exit.addActionListener(this);
        
        //Adding item
        add(login);
        add(signup);
        add(exit);
<<<<<<< HEAD
        add(panel);
        
=======
        add(panel);   
>>>>>>> parent of 6f7245d (20210514)
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
<<<<<<< HEAD

=======
       if(e.getSource()==exit){
            String input = JOptionPane.showInputDialog("Password:");
            if(input.equals("12345")){
                try{
                    PrintWriter p = new PrintWriter("admin.txt");
                    for(int i=0; i<RCSAS.allAdmin.size(); i++){
                        Admin c = RCSAS.allAdmin.get(i);
                        p.println(c.getName());
                        p.println(c.getPin());
                        p.println();
                    } 
<<<<<<< HEAD
                    p.close();                    
=======
                    p.close();
                    p = new PrintWriter("student.txt");
                    for(int i=0; i<RCSAS.allStudent.size(); i++){
                        Student st = RCSAS.allStudent.get(i);
                        p.println(st.getName());
                        p.println(st.getPin());
                        p.println(st.getPhone());
                        p.println(st.getEmail());
                        p.println();
                    } 
                    p.close();
>>>>>>> parent of 6f7245d (20210514)
                    p = new PrintWriter("booking.txt");
                    for(int i=0; i<RCSAS.allBooking.size(); i++){
                        Booking b = RCSAS.allBooking.get(i);
                        p.println(b.getId());
                        p.println(b.getHall());
                        p.println(b.getDate());
                        p.println(b.getCode_sp());
                        p.println(b.getCode_sc());
                        p.println(b.getTimeStarted());
                        p.println(b.getDuration());
                        p.println(b.getTimeEnded());                      
                        p.println(b.getPrice());
                        p.println(b.isPaid());
                        p.println(b.getOwner().getName());
                        p.println();               
                    }
                    p.close();      
                    System.exit(0);
                    } catch(Exception ex){
                    System.out.println("Error in stop!");
                }
            } else{
                JOptionPane.showMessageDialog(exit,"Wrong password!");
            }
        } else if(e.getSource()==signup){
            String a = JOptionPane.showInputDialog("Enter name:");
            boolean flag = true;
<<<<<<< HEAD
            for(int i=0; i<RCSAS.allAdmin.size(); i++){
                Admin c = RCSAS.allAdmin.get(i);
                if(a.equals(c.getName())){
=======
            for(int i=0; i<RCSAS.allStudent.size(); i++){
                Student st = RCSAS.allStudent.get(i);
                if(a.equals(st.getName())){
>>>>>>> parent of 6f7245d (20210514)
                    flag = false;
                    break;
                }   
}
            if(flag){
<<<<<<< HEAD
                int pin = Integer.parseInt(JOptionPane.showInputDialog("Pin"));
                Admin c = new Admin(a,pin);
                RCSAS.allAdmin.add(c);
=======
                String b1 = JOptionPane.showInputDialog("Pin:");
                if (Pattern.compile("[1-9]{1}\\d{5,10}").matcher(b1).matches()){
                    int b = Integer.parseInt(b1);
                    String c1 = JOptionPane.showInputDialog("Phone Number(60XXXXXXXXX):");
                    if (Pattern.compile("^\\d{11}$").matcher(c1).matches()){
                        long c = Long.parseLong(c1);
                        String d = JOptionPane.showInputDialog("Email Address:");
                        if(Pattern.compile("^(.+)@(.+)$").matcher(d).matches()){
                            Student st = new Student(a,b,c,d);
                            RCSAS.allStudent.add(st);
                        }else{
                            JOptionPane.showMessageDialog(null, "Invalid email!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid phone number!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid pin number! Pin number should match condition below: \n1. Pin number should be numeric. \n2. Length of pin number should be 6-10. \n3. Pin number should not start by 0. \n");
                }
>>>>>>> parent of 6f7245d (20210514)
            } else{
                JOptionPane.showMessageDialog(signup, "Name has been used!");
            }
        } else{
            String s = JOptionPane.showInputDialog("Username:");
            for(int i=0; i<RCSAS.allAdmin.size(); i++){
                Admin c = RCSAS.allAdmin.get(i);
                if(s.equals(c.getName())){
                    RCSAS.whoLogin = c;
                    break;
                }
            }
<<<<<<< HEAD
            if(RCSAS.whoLogin==null){
                JOptionPane.showMessageDialog(login, "Worng username!");
            } else{
                s = JOptionPane.showInputDialog("Password:");
                if(Integer.parseInt(s) != RCSAS.whoLogin.getPin()){
                    JOptionPane.showMessageDialog(login, "Wrong password!");
                    RCSAS.whoLogin = null;
                } else{
                    setVisible(false);  //same as this.setVisible(false);
<<<<<<< HEAD
                   // RCSAS.second.setVisible(true);
=======
                    RCSAS.SecondPage.setVisible(true);
>>>>>>> parent of e0fa173 (20210512)
=======
            for(int i=0; i<RCSAS.allStudent.size(); i++){
                Student c = RCSAS.allStudent.get(i);
                if(s.equals(c.getName())){
                    RCSAS.current = c;
                    break;
                }
            }
            if((RCSAS.current==null)&&(RCSAS.whoLogin==null)){
                JOptionPane.showMessageDialog(login, "Worng username!");
            } else{
                if(RCSAS.whoLogin!=null){
                    s = JOptionPane.showInputDialog("Password:");
                    if(Integer.parseInt(s) != RCSAS.whoLogin.getPin()){
                        JOptionPane.showMessageDialog(login, "Wrong password!");
                        RCSAS.whoLogin = null;
                    } else{
                        setVisible(false);  //same as this.setVisible(false);
                        RCSAS.AdminSecondPage.setVisible(true);
                    }
                }else if(RCSAS.current!=null){
                    s = JOptionPane.showInputDialog("Password:");
                    if(Integer.parseInt(s) == RCSAS.current.getPin()){
                        setVisible(false);  //same as this.setVisible(false);
                        RCSAS.StudentMainPage.setVisible(true);
                    } else{
                        JOptionPane.showMessageDialog(login, Integer.parseInt(s) == RCSAS.current.getPin());
                        RCSAS.current = null;
                    }
                    boolean a = (Integer.parseInt(s) == RCSAS.current.getPin());
                    System.out.print(a);
>>>>>>> parent of 6f7245d (20210514)
                }
            }
        }
>>>>>>> parent of b850e6d (Page2/booking)
    }
}
