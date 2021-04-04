/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Electricity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Himansu Hansda
 */

public class EnterConsumerComplaints extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1,b2;
    EnterConsumerComplaints(){
        setLocation(600,200);
        setSize(700,500);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        p.setBackground(new Color(173,216,230));
        
        JLabel title = new JLabel("New Employee");
        title.setBounds(180, 10, 200, 26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(title);
        
        l1 = new JLabel("Consumer Name:");
        l1.setBounds(100, 80, 100, 20);
        
        t1 = new JTextField();
        t1.setBounds(240, 80, 200, 20);
        p.add(l1);
        p.add(t1);
        
        l2 = new JLabel("Complaint");
        l2.setBounds(100, 120, 100, 20);
        
        t2 = new JTextField();
        t2.setBounds(240, 120, 200, 70);
        p.add(l2);
        p.add(t2);
        
        
        b1 = new JButton("Submit");
        b1.setBounds(120, 390, 100, 25);
        b2 = new JButton("Cancel");
        b2.setBounds(250, 390, 100, 25);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        p.add(b1);
        p.add(b2);
        setLayout(new BorderLayout());
        
        add(p,"Center");
        
        /*ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(150, 300,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);*/
        
        
       // add(l8,"West");
        //for changing the color of the whole Frame
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        /*Random ran = new Random();
        long first = (ran.nextLong() % 1000000);
        l11.setText(""+Math.abs(first));*/
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String name = t1.getText();
            String complain = t2.getText();
            //String address = t3.getText();
            //String state = t4.getText();
            //String city = t5.getText();
            //String email = t6.getText();
            //String phone = t7.getText();
            //String username = t8.getText();
            //String password = t9.getText();

            String q1 = "insert into complaint values('"+name+"','"+complain+"')";
            System.out.println(q1);
            //String q2 = "insert into login values('"+meter+"', '', '', '', '')";
            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(q1);
                //c1.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Your Feedback has been submitted.");
                this.setVisible(false);
                //new MeterInfo(meter).setVisible(true);

            }catch(Exception ex){
                 ex.printStackTrace();
            }
        }else if(ae.getSource() ==b2){
                this.setVisible(false);
                }
    }
    
    
    public static void main(String[] args){
        new EnterConsumerComplaints().setVisible(true);
    }
}

