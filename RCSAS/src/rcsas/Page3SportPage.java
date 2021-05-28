
package rcsas;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Page3SportPage extends JFrame implements ActionListener{
    
    private JPanel header, content, footer;
    private JPanel desleft, desright;
    private JLabel name, location, no_venue, price, splocation, spno_venue, spprice;
    private JButton modify;
    private final JButton back, schedule;
    private final JLabel title;
    private final JPanel Swimming, Badminton, Football, Archery, Gymnastics, Volleyball, Basketball, Cricket, Tennis, TableTennis ;
    private final JTabbedPane sport;
    
    public Page3SportPage(){
        setSize(1500,800);
        setLocation(200,100);
        setLayout(null);
        setBackground(new java.awt.Color(243, 250, 249));
        
        //
        //header
        //
        header = new JPanel();
        title = new JLabel("- SPORT -");
        title.setFont(RCSAS.HomePage.title);
        header.add(title);
        header.setBounds(0,0,1500,100);
        header.setBackground(new java.awt.Color(243, 250, 249));
        add(header);
        
        //
        //content
        //
        Swimming = new JPanel();
        Badminton = new JPanel();
        Football = new JPanel();
        Archery = new JPanel();
        Gymnastics = new JPanel();
        Volleyball = new JPanel();
        Basketball = new JPanel();
        Cricket = new JPanel();
        Tennis = new JPanel();
        TableTennis = new JPanel();

        Swimming.setBackground(new java.awt.Color(197, 215, 214));
        Badminton.setBackground(new java.awt.Color(197, 215, 214));
        Football.setBackground(new java.awt.Color(197, 215, 214));
        Archery.setBackground(new java.awt.Color(197, 215, 214));
        Gymnastics.setBackground(new java.awt.Color(197, 215, 214));
        Volleyball.setBackground(new java.awt.Color(197, 215, 214));
        Basketball.setBackground(new java.awt.Color(197, 215, 214));
        Cricket.setBackground(new java.awt.Color(197, 215, 214));
        Tennis.setBackground(new java.awt.Color(197, 215, 214));
        TableTennis.setBackground(new java.awt.Color(197, 215, 214));
        
        SettingPane(Swimming, 0);
        SettingPane(Badminton, 1);
        SettingPane(Football, 2);
        SettingPane(Archery, 3);
        SettingPane(Gymnastics, 4);
        SettingPane(Volleyball, 5);
        SettingPane(Basketball, 6);
        SettingPane(Cricket, 7);
        SettingPane(Tennis, 8);
        SettingPane(TableTennis, 9);
                
        UIManager.put("TabbedPane.selected", new Color(125, 155, 171));
        sport = new JTabbedPane(){
          @Override
          public Color getForegroundAt(int index){
            if(getSelectedIndex() == index) return Color.WHITE;
            return Color.BLACK;
          }
        };
        sport.setBackground(new java.awt.Color(197, 215, 214));
        sport.add("Swimming",Swimming);
        sport.add("Badminton",Badminton);
        sport.add("Football",Football);
        sport.add("Archery",Archery);
        sport.add("Gymnastics",Gymnastics);
        sport.add("Volleyball",Volleyball);
        sport.add("Basketball",Basketball);
        sport.add("Cricket",Cricket);
        sport.add("Tennis",Tennis);
        sport.add("Table Tennis",TableTennis);
        
        
        sport.setFont(RCSAS.HomePage.label);
        sport.setBounds(50, 0, 1400, 550);
        content = new JPanel();
        content.setLayout(null);
        content.setBounds(0, 100, 1500, 600);
        content.setBackground(new java.awt.Color(243, 250, 249));
        content.add(sport);
        add(content);
        
        //
        //footer
        //
        footer = new JPanel();
        back = new JButton("BACK");
        schedule = new JButton("SCHEDULE");
        
        RCSAS.setButton(back);
        RCSAS.setButton(schedule);
        back.setFont(RCSAS.HomePage.button);
        schedule.setFont(RCSAS.HomePage.button);
        footer.add(back);
        footer.add(schedule);
        footer.setBounds(0, 700, 1500, 100);
        footer.setBackground(new java.awt.Color(243, 250, 249));
        add(footer);
        
        back.addActionListener(this);
        schedule.addActionListener(this);
        
        if(RCSAS.currentAdmin != null){
            modify = new JButton("Modify");
            RCSAS.setButton(modify);
            modify.setFont(RCSAS.HomePage.button);
            footer.add(modify);
            modify.addActionListener(this);
        }
        
        //
        //WindowListener
        //
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (RCSAS.currentLogin == null) {
                    setVisible(false);
                    RCSAS.HomePage.setVisible(true);
                } else {
                    if(RCSAS.currentStudent != null){
                        setVisible(false);
                        Page2StudentMainPage smp = new Page2StudentMainPage();
                        smp.setVisible(true);
                    } else if (RCSAS.currentAdmin != null) {
                        setVisible(false);
                        RCSAS.AdminSecondPage.setVisible(true);
                    }
                }
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            if (RCSAS.currentLogin == null) {
                setVisible(false);
                RCSAS.HomePage.setVisible(true);
            } else {
                if(RCSAS.currentStudent != null){
                    setVisible(false);
                    Page2StudentMainPage smp = new Page2StudentMainPage();
                    smp.setVisible(true);
                } else if (RCSAS.currentAdmin != null) {
                    setVisible(false);
                    RCSAS.AdminSecondPage.setVisible(true);
                }
            }
        } else if (e.getSource() == schedule){
            setVisible(false);
            Page3SchedulePage sp = new Page3SchedulePage();
            sp.setVisible(true);
        } else if (e.getSource() == modify){
            modify();
        }
    }
    
    private void SettingPane(JPanel panel, int i){
        Sport c = RCSAS.allSport.get(i);
        JPanel left = new JPanel(new BorderLayout());
        JPanel right = new JPanel(new BorderLayout());
        
        left.setBackground(new java.awt.Color(125, 155, 171));
        right.setBackground(new java.awt.Color(125, 155, 171));
        
        name = new JLabel(c.getName());
        name.setFont(new Font("Agency FB", Font.PLAIN, 88));
        name.setForeground(Color.WHITE);
        
        JSeparator s = new JSeparator();
        s.setOrientation(SwingConstants.VERTICAL);
        
        left.setBorder(BorderFactory.createEmptyBorder(50, 100, 100, 100));
        left.add(name,BorderLayout.CENTER);
        left.add(s,BorderLayout.LINE_END);
        panel.add(left);
        
        
        desleft = new JPanel(new GridLayout(0,1));
        desright = new JPanel(new GridLayout(0,1));
        
        desleft.setBackground(new java.awt.Color(125, 155, 171));
        desright.setBackground(new java.awt.Color(125, 155, 171));

        location = new JLabel("Location:");
        no_venue = new JLabel("Number of venue:");
        price = new JLabel("Price per hour:");
        splocation = new JLabel(c.getLocation().toString());
        spno_venue = new JLabel(c.getNo_hall() + " " + c.getVenue()+"s");
        spprice = new JLabel("RM "+String.format("%03d", c.getPrice())+".00 /per hour");
        
        location.setFont(RCSAS.HomePage.label);
        no_venue.setFont(RCSAS.HomePage.label);
        price.setFont(RCSAS.HomePage.label);
        splocation.setFont(RCSAS.HomePage.normal);
        spno_venue.setFont(RCSAS.HomePage.normal);
        spprice.setFont(RCSAS.HomePage.normal);
        
        location.setForeground(Color.WHITE);
        no_venue.setForeground(Color.WHITE);
        price.setForeground(Color.WHITE);
        splocation.setForeground(Color.WHITE);
        spno_venue.setForeground(Color.WHITE);
        spprice.setForeground(Color.WHITE);
       
        desleft.add(location);
        desleft.add(no_venue);
        desleft.add(price);
        
        desright.add(splocation);
        desright.add(spno_venue);
        desright.add(spprice);
       
        right.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        right.add(desleft,BorderLayout.CENTER);
        right.add(desright, BorderLayout.LINE_END);
                
        panel.add(right);
        
        panel.setLayout(new GridLayout(1,0));
    }
    
    private void modify(){
        JPanel label = new JPanel(new GridLayout(0,1));
        JPanel detail = new JPanel(new GridLayout(0,1));
        
        JLabel id = new JLabel("ID");
        JLabel n = new JLabel("Name:");
        JLabel l = new JLabel("Location:");
        JLabel v = new JLabel("Venue:");
        JLabel no = new JLabel("Number of venue:");
        JLabel p = new JLabel("Price:");
        
        Panel PanelID = new Panel();
        Panel Panelna = new Panel();
        Panel Panello = new Panel();
        Panel Panelve = new Panel();
        Panel Panelnov = new Panel();
        Panel Panelpr = new Panel();
        
        ArrayList<String> idno = new ArrayList<>();
        for(int i=0; i<RCSAS.allSport.size();i++){
            Sport b = RCSAS.allSport.get(i);
            idno.add(b.getId());
        }
        String idnoo[] = idno.toArray(new String[idno.size()]);
        
        JPanel contents = new JPanel(new BorderLayout());
        JComboBox ID = new JComboBox(idnoo);
        ID.setSelectedIndex(-1);
        JTextField na = new JTextField();
        JComboBox lo = new JComboBox(SportCentre.values());
        lo.setSelectedIndex(-1);
        JTextField ve = new JTextField();
        JTextField nov = new JTextField();
        JTextField pr = new JTextField();
        
        na.setEditable(false);
        lo.setEditable(false);
        ve.setEditable(false);
        nov.setEditable(false);
        pr.setEditable(false);
        
        setSTLabel(id);
        setSTLabel(n);
        setSTLabel(l);
        setSTLabel(v);
        setSTLabel(no);
        setSTLabel(p);
        
        ID.setPreferredSize(new Dimension(200, 35));
        ID.setFont(new Font("Centaur", Font.PLAIN, 20));
        ID.addItemListener((ItemEvent arg0) -> {
            if(ID.getSelectedItem() != null){
                for(int i=0; i<RCSAS.allSport.size();i++){
                    Sport b = RCSAS.allSport.get(i);
                    if(ID.getSelectedItem().toString().equals(b.getId())){
                        na.setText(b.getName());
                        lo.setSelectedItem(b.getLocation());
                        ve.setText(b.getVenue());
                        nov.setText(String.format("%03d", b.getNo_hall()));
                        pr.setText(String.format("%03d", b.getPrice()));

                        lo.setEditable(true);
                        ve.setEditable(true);
                        nov.setEditable(true);
                        pr.setEditable(true);
                        contents.revalidate();
                        contents.repaint();
                    }
                }
                

            };
        });
        setSTDetails(na);
        lo.setPreferredSize(new Dimension(200, 35));
        lo.setFont(new Font("Centaur", Font.PLAIN, 20));   
        setSTDetails(ve);
        setSTDetails(nov);
        setSTDetails(pr);
        
        label.add(id);
        label.add(n);
        label.add(l);
        label.add(v);
        label.add(no);
        label.add(p);

        PanelID.add(ID);
        Panelna.add(na);
        Panello.add(lo);
        Panelve.add(ve);
        Panelnov.add(nov);
        Panelpr.add(pr);
        
        detail.add(PanelID);
        detail.add(Panelna);
        detail.add(Panello);
        detail.add(Panelve);
        detail.add(Panelnov);
        detail.add(Panelpr);
        
        contents.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contents.add(label,BorderLayout.CENTER);
        contents.add(detail, BorderLayout.LINE_END);
        
        int option = JOptionPane.showConfirmDialog(null, contents, "Modify Schedule", JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION){
            if(ID.getSelectedItem()==null){
                
            } else{
                ArrayList<String> message = new ArrayList<>();
                try{
                    for(int i=0; i<RCSAS.allSport.size();i++){
                        Sport s = RCSAS.allSport.get(i);
                        if (na.getText().equals(s.getName())){
                            s.setLocation(SportCentre.valueOf(lo.getSelectedItem().toString()));
                            s.setVenue(ve.getText());
                            s.setNo_hall(Integer.parseInt(nov.getText()));
                            s.setPrice(Integer.parseInt(pr.getText()));
                            message.add("Update Successfully!");
                            setVisible(false);
                            Page3SportPage reload = new Page3SportPage();
                            reload.setVisible(true);
                            break;
                        }
                    }
                }catch(Exception ex){
                    message.add("Invalid Number!");
                }
                JOptionPane.showMessageDialog(null, message);
            }
        }
    }
    
    private void setSTLabel(JLabel label){
        label.setPreferredSize(new Dimension(200, 35));
        label.setFont(new Font("Centaur", Font.BOLD, 20));
    }
    
    private void setSTDetails(JTextField label){
        label.setPreferredSize(new Dimension(200, 35));
        label.setFont(new Font("Centaur", Font.PLAIN, 20));
    }
}
