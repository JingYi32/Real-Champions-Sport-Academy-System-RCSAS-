
package rcsas;

import java.awt.*;
import java.awt.event.*;
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
            
        }
    }
}
