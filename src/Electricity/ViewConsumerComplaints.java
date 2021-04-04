package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ViewConsumerComplaints extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1;
    String x[] = {"Customer Name","Complain"};
    String y[][] = new String[40][200];
    int i=0, j=0;
    ViewConsumerComplaints(){
        super("Consumer Complaints");
        setSize(1200,650);
        setLocation(400,150);
        
        try{
            Conn c1  = new Conn();
            String s1 = "select * from complaint";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("comlaint");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new ViewConsumerComplaints().setVisible(true);
    }
    
}
