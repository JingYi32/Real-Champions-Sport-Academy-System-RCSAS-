
package rcsas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Page3SchedulePage extends JFrame implements ActionListener{
    private final JPanel header, footer;
    private final JLabel title;
    private final JScrollPane content;
    private final DefaultTableModel model;
    private final JTable schedule;
    
    public Page3SchedulePage(){
        setSize(1500,800);
        setLocation(200,100);
        
        //
        //HEADER
        //
        header = new JPanel();
        title = new JLabel("- Sport Schedule -");
        title.setFont(new Font("Serif", Font.PLAIN, 32));
        header.add(title);
        add(header, BorderLayout.NORTH);
        
        
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
        schedule.setFont(new Font("Serif", Font.PLAIN, 25));
        schedule.getTableHeader().setFont(new Font("Serif", Font.BOLD, 25));
        schedule.setRowHeight(40);
        content = new JScrollPane(schedule);
        add(content, BorderLayout.CENTER);
        
        //
        //FOOTER
        //
        footer = new JPanel();
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
                } else if (RCSAS.currentLogin == RCSAS.currentAdmin) {
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
        
    }
}
