
package rcsas;

import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Page3DisplayPage extends JFrame implements ActionListener {
    private DefaultTableModel model;
    private final JLabel title;
    private final JPanel header, footer;
    private JScrollPane content;
    private JTable schedule;
    private final JTextField seacrh;
    private JComboBox comboBox, seacrhch;
    private final JButton back,seacrhbut, adding;
    private String[][] data;
    private String[] columnNames;
    private JRadioButton s1, s2;
    private ButtonGroup bg;
    private ArrayList<Student> SeacrhStudent = new ArrayList<>();
    private ArrayList<Coach> SeacrhCoach = new ArrayList<>();
    private ArrayList<Sport> SeacrhSport = new ArrayList<>();
    
    public Page3DisplayPage(){
        setSize(1500,800);
        setLocation(200,100);
        setLayout(null);
        
        //
        //header
        //
        header = new JPanel();
        title = new JLabel("- Display Page -");
        title.setFont(RCSAS.HomePage.title);
        header.add(title);
        header.setBounds(0, 0, 1500, 100);
        add(header);
        
        
        //
        //FOOTER
        //
        back = new JButton("Back");
        adding = new JButton("Add");
        RCSAS.setButton(back);
        RCSAS.setButton(adding);
        adding.setFont(RCSAS.HomePage.button);
        back.setFont(RCSAS.HomePage.button);
        back.addActionListener(this);
        
        footer = new JPanel();
        footer.setBounds(0, 700, 1500, 100);
        footer.add(back);
        footer.add(adding);
        add(footer);
        
        seacrh = new JTextField();
        seacrh.setBounds(100, 140, 1200, 40);
        add(seacrh);
        seacrhbut = new JButton("Seacrh");
        seacrhbut.setBounds(1300, 140, 100, 40);
        add(seacrhbut);
        
        Object[] selection = {"Coach", "Student", "Sport"};
        comboBox = new JComboBox(selection);
        JOptionPane.showMessageDialog(null, comboBox, "Fav Sports",JOptionPane.QUESTION_MESSAGE);
        DisSetting();
        
        schedule = new JTable(data, columnNames);
        schedule.setCellSelectionEnabled(false);
        schedule.setFont(RCSAS.HomePage.normal);
        schedule.getTableHeader().setFont(RCSAS.HomePage.label);
        schedule.setRowHeight(40);
        schedule.setAutoCreateRowSorter(true);
        content = new JScrollPane(schedule);
        content.setBounds(100, 185, 1300, 500);
        add(content);
        
        MouseListener tableMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = schedule.rowAtPoint(e.getPoint());
                int col = schedule.columnAtPoint(e.getPoint());
                String y = schedule.getValueAt(row,0).toString();
                //Coach
                for(int i=0; i<RCSAS.allCoach.size(); i++){
                    Coach c = RCSAS.allCoach.get(i);
                    if(y.equals(c.getId())){
                        RCSAS.currentCoach = c;
                        setVisible(false);
                        Page3CoachPage ch = new Page3CoachPage();
                        ch.setVisible(true);
                    }
                }
                //Sport
                for(int i=0; i<RCSAS.allSport.size(); i++){
                    Sport c = RCSAS.allSport.get(i);
                    if(y.equals(c.getId())){
                        setVisible(false);
                        Page3SportPage ch = new Page3SportPage();
                        ch.setVisible(true);
                    }
                }

           }
        };
        schedule.addMouseListener(tableMouseListener);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(back)){
            setVisible(false);
            RCSAS.AdminSecondPage.setVisible(true);
        }
    }
    
    private void DisSetting(){
        String s = comboBox.getSelectedItem().toString();
        if(s.equals("Coach")){
            int size = RCSAS.allCoach.size();
            data = new String[size][5];
            for(int i=0; i<size; i++){
                Coach c = RCSAS.allCoach.get(i);
                data[i][0] = c.getId();
                data[i][1] = ""+c.getName();
                data[i][2] = ""+c.getSport().getName();
                data[i][3] = ""+"RM "+String.format("%03d", c.getHourrate())+".00";
                data[i][4] = ""+String.format("%01d", c.getRating());
            }
            
            String[] column = {"ID", "Coach Name", "Sport", "HourRate","Rating"};
            columnNames = column;
            
            seacrhbut.addActionListener((ActionEvent ae ) ->{
                SeacrhCoachSetting();
            });
            
            adding.addActionListener((ActionEvent aet ) ->{
                addCoach();
            });
        } else if(s.equals("Student")){
            int size = RCSAS.allStudent.size();
            data = new String[size][4];
            for(int i=0; i<size; i++){
                Student c = RCSAS.allStudent.get(i);
                data[i][0] = c.getId();
                data[i][1] = ""+c.getName();
                data[i][2] = ""+c.getPhone();
                data[i][3] = ""+c.getEmail();
            }
            String[] column = {"ID", "Student Name", "Phone", "Email"};
            columnNames = column;
            
            seacrhbut.addActionListener((ActionEvent ae ) ->{
                SeacrhStudentSetting();
            });
           
        } else if(s.equals("Sport")){
            int size = RCSAS.allSport.size();
            data = new String[size][5];
            for(int i=0; i<size; i++){
                Sport c = RCSAS.allSport.get(i);
                data[i][0] = c.getId();
                data[i][1] = ""+c.getName();
                data[i][2] = ""+c.getLocation().toString();
                data[i][3] = ""+String.format("%02d", c.getNo_hall()) + c.getVenue() + "s";
                data[i][4] = ""+String.format("%03d", c.getPrice());
            }
            String[] column = {"ID", "Sport Name", "Location", "Venue","Price"};
            columnNames = column;
            
            seacrhbut.addActionListener((ActionEvent ae ) ->{
                SeacrhSportSetting();
            });
            
            adding.addActionListener((ActionEvent aet ) ->{
                AddSport();
            });
        }
    }
    
    private void SeacrhCoachSetting(){
        boolean flag = false;
        for(int ix=0; ix<RCSAS.allCoach.size(); ix++){
            Coach st = RCSAS.allCoach.get(ix);
            if(st.getId().equals(seacrh.getText())){
                SeacrhCoach.add(st);
                flag = true;
            }  
        }
        for(int ix=0; ix<RCSAS.allCoach.size(); ix++){
            Coach st = RCSAS.allCoach.get(ix);
            try{
                if(st.getRating() == Integer.parseInt(seacrh.getText())){
                    SeacrhCoach.add(st);
                    flag = true;
                }
            } catch(Exception ex){
                
            }
        }
        
        int size = SeacrhCoach.size();
        data = new String[size][5];
        for(int i=0; i<size; i++){
            Coach c = SeacrhCoach.get(i);
            data[i][0] = c.getId();
            data[i][1] = c.getName();
            data[i][2] = c.getSport().getName();
            data[i][3] = "RM "+String.format("%03d", c.getHourrate())+".00";
            data[i][4] = String.format("%01d", c.getRating());
        }

        String[] column = {"ID", "Coach Name", "Sport", "HourRate","Rating"};
        columnNames = column;
        

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
        content.setBounds(100, 185, 1300, 500);
        add(content);
        SeacrhCoach.clear();
    }
    
    private void SeacrhStudentSetting(){
        for(int ix=0; ix<RCSAS.allStudent.size(); ix++){
            Student st = RCSAS.allStudent.get(ix);
            if(st.getId().equals(seacrh.getText())){
                SeacrhStudent.add(st);
            }  
        }
        
        int size = SeacrhStudent.size();
        data = new String[size][4];
        for(int i=0; i<size; i++){
            Student c = SeacrhStudent.get(i);
            data[i][0] = c.getId();
            data[i][1] = ""+c.getName();
            data[i][2] = ""+c.getPhone();
            data[i][3] = ""+c.getEmail();
        }
        String[] column = {"ID", "Student Name", "Phone", "Email"};
        columnNames = column;

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
        content.setBounds(100, 185, 1300, 500);
        add(content);

        SeacrhStudent.clear();
    }
    
    private void SeacrhSportSetting(){
        remove(content);
        for(int ix=0; ix<RCSAS.allSport.size(); ix++){
            Sport sp = RCSAS.allSport.get(ix);
            if(sp.getId().equals(seacrh.getText())){
                SeacrhSport.add(sp);
            }  
        }
        
        try{
            int size = SeacrhSport.size();
            data = new String[size][5];
            for(int i=0; i<size; i++){
                Sport c = SeacrhSport.get(i);
                data[i][0] = c.getId();
                data[i][1] = ""+c.getName();
                data[i][2] = ""+c.getLocation().toString();
                data[i][3] = ""+String.format("%02d", c.getNo_hall()) + c.getVenue() + "s";
                data[i][4] = ""+String.format("%03d", c.getPrice());
            }
            String[] column = {"ID", "Sport Name", "Location", "Venue","Price"};
            columnNames = column;

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
            content.setBounds(100, 185, 1300, 500);
            add(content);

            this.revalidate();
            this.repaint();
            SeacrhSport.clear();
        }catch(Exception ex){
            System.out.println("Errow");
        }
    }
    
    private void addCoach(){
        try{
            String a = JOptionPane.showInputDialog("Name:");
            String[] gender = {"Female","Male"};
            String b = (String)JOptionPane.showInputDialog(
                null,
                "Gender:",
                "Selecting gender",
                JOptionPane.PLAIN_MESSAGE,
                null,
                gender,
                null);
            String c = JOptionPane.showInputDialog("Contact Number:");
            if(!Pattern.compile("^\\d{11}$").matcher(c).matches()){
                throw new Exception();
            }
            String d = JOptionPane.showInputDialog("Address:");
            String e = JOptionPane.showInputDialog("Emergency Contact:");
            if(!Pattern.compile("^\\d{11}$").matcher(e).matches()){
                throw new Exception();
            }
            String sport[] = RCSAS.allSportName.toArray(new String[RCSAS.allSportName.size()]);
            String f1 = (String)JOptionPane.showInputDialog(
                null,
                "Sport:",
                "Selecting Sport",
                JOptionPane.PLAIN_MESSAGE,
                null,
                sport,
                null);
            Sport f = null;
            for(int i=0; i<RCSAS.allSport.size(); i++){
                Sport sp = RCSAS.allSport.get(i);
                if(f1.equals(sp.getName())){
                    f = sp;
                }
            }
            
            int h = Integer.parseInt(JOptionPane.showInputDialog("Duration:"));
            
            int idno = 1+RCSAS.allCoach.size();
            String id = "C-"+ String.format("%03d", idno);
            
            LocalDate g = LocalDate.now();            
            
            Coach ch = new Coach(id,a,b,c,d,e,f,g,h);
            RCSAS.allCoach.add(ch);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Wrong input!");
        }
    }
    
    private void AddSport(){
        boolean flag = true;
        String a = JOptionPane.showInputDialog("Name:");
        for(int ix=0; ix<RCSAS.allStudent.size(); ix++){
            Student st = RCSAS.allStudent.get(ix);
            if(a.equals(st.getName())){
                flag = false;
                break;
            }   
        }
        if(flag){
            try{
                    comboBox = new JComboBox(SportCentre.values());
                    JOptionPane.showMessageDialog(null, comboBox, "Fav Sports",JOptionPane.QUESTION_MESSAGE);
                    SportCentre b = SportCentre.valueOf(comboBox.getSelectedItem().toString());
                    String c = JOptionPane.showInputDialog("Name:");
                    int d = Integer.parseInt(JOptionPane.showInputDialog("Number of"+c+": "));
                    int e = Integer.parseInt(JOptionPane.showInputDialog("Price per hour: "));
                    
                    int idno = 1+RCSAS.allCoach.size();
                    String id = "SP"+ String.format("%03d", idno);
                    Sport sp = new Sport(id, a, b, c, d, e);
                    RCSAS.allSport.add(sp);
                    RCSAS.allSportName.add(sp.getName());
                }
            catch(Exception e){
                 JOptionPane.showMessageDialog(null,"Wrong Input!");
            }
        }

    }
    
    
}
