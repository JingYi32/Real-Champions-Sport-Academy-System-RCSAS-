
package rcsas;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Page3SchedulePage extends JFrame implements ActionListener{
    private final DefaultTableModel model;
    private final JLabel title;
    private final JPanel header, footer;
    private final JScrollPane content;
    private final JTable schedule;
    private JButton back, modify;
    
    public Page3SchedulePage(){
        setSize(1500,800);
        setLocation(200,100);
        setLayout(null);
        //
        //HEADER
        //
        header = new JPanel();
        title = new JLabel("- Sport Schedule -");
        title.setFont(RCSAS.HomePage.title);
        header.add(title);
        header.setBounds(0, 0, 1500, 100);
        add(header);
        
        
        //
        //CONTENT
        //
        String[][] data = null;
        if(RCSAS.currentStudent != null){
            int size = RCSAS.currentStudent.getMyBooking().size();
            data = new String[size][7];
            for(int i=0; i<size; i++){
                Booking b = RCSAS.currentStudent.getMyBooking().get(i);
                data[i][0] = b.getId();
                data[i][1] = ""+b.getOwner().getName();
                data[i][2] = ""+b.getSport().toString();
                data[i][3] = ""+b.getVenue();
                data[i][4] = ""+b.getDate().toString();
                data[i][5] = ""+b.getTimeStarted().toString();
                data[i][6] = ""+b.getTimeEnded().toString();
            }
        }else{
            int size = RCSAS.allBooking.size();
            data = new String[size][7];
            for(int i=0; i<size; i++){
                Booking b = RCSAS.allBooking.get(i);
                data[i][0] = b.getId();
                data[i][1] = ""+b.getOwner().getName();
                data[i][2] = ""+b.getSport().toString();
                data[i][3] = ""+b.getVenue();
                data[i][4] = ""+b.getDate().toString();
                data[i][5] = ""+b.getTimeStarted().toString();
                data[i][6] = ""+b.getTimeEnded().toString();
            }
        }

        
        String[] columnNames = {"ID", "Student Name", "Sport", "Venue", "Date", "Started", "Ended"};
        model = new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
        schedule = new JTable(model);
        schedule.setFont(RCSAS.HomePage.normal);
        schedule.getTableHeader().setFont(RCSAS.HomePage.label);
        schedule.setRowHeight(40);
        content = new JScrollPane(schedule);
        content.setBounds(100, 100, 1300, 500);
        add(content);
        
        
        //
        //FOOTER
        //
        footer = new JPanel();
        back = new JButton("Back");
        RCSAS.setButton(back);
        back.setFont(RCSAS.HomePage.button);
        footer.add(back);
        back.addActionListener(this);
        if(RCSAS.currentAdmin != null){
            modify = new JButton("Modify");
            RCSAS.setButton(modify);
            modify.setFont(RCSAS.HomePage.button);
            footer.add(modify);
            modify.addActionListener(this);
        }
        footer.setBounds(0, 700, 1500, 100);
        add(footer, BorderLayout.SOUTH);
        
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
        } else if(e.getSource() == modify){
            modify();
        }
    }
    
    private void modify(){
        JPanel label = new JPanel(new GridLayout(0,1));
        JPanel detail = new JPanel(new GridLayout(0,1));
        
        JLabel id = new JLabel("ID");
        JLabel student = new JLabel("Student:");
        JLabel sport = new JLabel("Sport:");
        JLabel teacher = new JLabel("Coach:");
        JLabel date = new JLabel("Date:");
        JLabel timeStarted = new JLabel("Time Started:");
        JLabel duration = new JLabel("Duration:");
        JLabel venue = new JLabel("Venue");
        
        Panel PanelID = new Panel();
        Panel PanelSTU = new Panel();
        Panel PanelSPO = new Panel();
        Panel PanelTEAC = new Panel();
        Panel PanelDATE = new Panel();
        Panel PanelSTART = new Panel();
        Panel PanelDURA = new Panel();
        Panel PanelVENUE = new Panel();
        
        ArrayList<String> idno = new ArrayList<>();
        for(int i=0; i<RCSAS.allBooking.size();i++){
            Booking b = RCSAS.allBooking.get(i);
            idno.add(b.getId());
        }
        String idnoo[] = idno.toArray(new String[idno.size()]);
        
        JComboBox ID = new JComboBox(idnoo);
        ID.setSelectedIndex(-1);
        JTextField STU = new JTextField();
        JTextField SPO = new JTextField();
        JTextField TEAC = new JTextField();
        JTextField DATE = new JTextField();
        JTextField START = new JTextField();
        JTextField DURA = new JTextField();
        JTextField VENUE = new JTextField();
        
        STU.setEditable(false);
        SPO.setEditable(false);
        START.setEditable(false);
        TEAC.setEditable(false);
        DATE.setEditable(false);
        DURA.setEditable(false);
        VENUE.setEditable(false);
        
        setSTLabel(id);
        setSTLabel(student);
        setSTLabel(sport);
        setSTLabel(teacher);
        setSTLabel(date);
        setSTLabel(timeStarted);
        setSTLabel(duration);
        setSTLabel(venue);
        
        JPanel contents = new JPanel(new BorderLayout());
        ID.setPreferredSize(new Dimension(200, 35));
        ID.setFont(new Font("Centaur", Font.PLAIN, 20));
        ID.addItemListener((ItemEvent arg0) -> {
            if(ID.getSelectedItem() != null){
                for(int i=0; i<RCSAS.allBooking.size();i++){
                    Booking b = RCSAS.allBooking.get(i);
                    if(ID.getSelectedItem().toString().equals(b.getId())){
                        STU.setText(b.getOwner().getName());
                        SPO.setText(b.getSport().getName());
                        START.setText(b.getTimeStarted().toString());
                        TEAC.setText(b.getTeacher().getName());
                        DATE.setText(b.getDate().toString());
                        DURA.setText(String.format("%1d", b.getDuration()));
                        VENUE.setText(b.getVenue());

                        STU.setEditable(true);
                        SPO.setEditable(true);
                        START.setEditable(true);
                        TEAC.setEditable(true);
                        DATE.setEditable(true);
                        DURA.setEditable(true);
                        VENUE.setEditable(true);
                        contents.revalidate();
                        contents.repaint();
                    }
                }
                

            };
        });
        setSTDetails(STU);
        setSTDetails(SPO);
        setSTDetails(TEAC);
        setSTDetails(DATE);
        setSTDetails(START);
        setSTDetails(DURA);
        setSTDetails(VENUE);
        
        label.add(id);
        label.add(student);
        label.add(sport);
        label.add(teacher);
        label.add(date);
        label.add(timeStarted);
        label.add(duration);
        label.add(venue);

        PanelID.add(ID);
        PanelSTU.add(STU);
        PanelSPO.add(SPO);
        PanelTEAC.add(TEAC);
        PanelDATE.add(DATE);
        PanelSTART.add(START);
        PanelDURA.add(DURA);
        PanelVENUE.add(VENUE);
        
        detail.add(PanelID);
        detail.add(PanelSTU);
        detail.add(PanelSPO);
        detail.add(PanelTEAC);
        detail.add(PanelDATE);
        detail.add(PanelSTART);
        detail.add(PanelDURA);
        detail.add(PanelVENUE);
               
        contents.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contents.add(label,BorderLayout.CENTER);
        contents.add(detail, BorderLayout.LINE_END);
        
        int option = JOptionPane.showConfirmDialog(null, contents, "Modify Schedule", JOptionPane.OK_CANCEL_OPTION);
        if(option == JOptionPane.OK_OPTION){
            if(ID.getSelectedItem()==null){
                
            } else{
                ArrayList<String> message = new ArrayList<>();
                try{
                    for(int i=0; i<RCSAS.allBooking.size();i++){
                        Booking b = RCSAS.allBooking.get(i);
                        if (STU.getText().equals(b.getOwner().getName())){ 
                            
                            for(int o=0; o<RCSAS.allSport.size();o++){ 
                            Sport s = RCSAS.allSport.get(o);                               
                            if (SPO.getText().equals(s.getName())){   
                                
                            for(int p=0; p<RCSAS.allCoach.size();p++){                                                            
                            Coach c = RCSAS.allCoach.get(p);                            
                            if (TEAC.getText().equals(c.getName())&& (c.getSport().equals(s))){
                                
                                b.setSport(s);   
                                b.setTeacher(c);
                                b.setDate(LocalDate.parse(DATE.getText()));
                                b.setTimeStarted(LocalTime.parse(START.getText()));
                                b.setDuration(Integer.parseInt(DURA.getText()));
                                b.setVenue(VENUE.getText());
                                
                                message.add("Update Successfully!");
                                setVisible(false);
                                Page3SchedulePage reload = new Page3SchedulePage();
                                reload.setVisible(true);
                                break;
                                                       
                                    }
                                }                                                  
                            }
                        }
                    }
                           
                   }       
                } catch(Exception ex){              
                    message.add("Invalid Number!");
                }
                JOptionPane.showMessageDialog(null, message);
            }
        }
    }
       
    
//    private void CheckModify(){
 //       ArrayList<String> message = new ArrayList<>();
        
    
    
    private void setSTLabel(JLabel label){
        label.setPreferredSize(new Dimension(200, 35));
        label.setFont(new Font("Centaur", Font.BOLD, 20));
    }
    
    private void setSTDetails(JTextField label){
        label.setPreferredSize(new Dimension(200, 35));
        label.setFont(new Font("Centaur", Font.PLAIN, 20));
    }
}
