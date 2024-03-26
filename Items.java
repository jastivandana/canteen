
package canteen.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;


public class Items extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1, b2;
    Items(){
        
        
     //ImageIcon il = new ImageIcon (ClassLoader.getSystemResource("canteen/management/system/icons/CMS23.jpg"));
     //Image i2 = il.getImage().getScaledInstance (600, 600, Image.SCALE_DEFAULT); 
     //ImageIcon i3 = new ImageIcon(i2);
     //JLabel icon= new JLabel(i3);
     //icon.setBounds(500, 0, 600, 600);
     //add(icon);


    JLabel l1 = new JLabel("Table Number"); 
    l1.setBounds(50,10, 100, 20); 
    add(l1);

    JLabel l2 = new JLabel("Availability"); 
    l2.setBounds(280,10, 80, 20); 
    add(l2);

    JLabel l3 = new JLabel("status"); 
    l3.setBounds(500,10, 80, 20);
    add(l3);

    JLabel l4 = new JLabel("Price"); 
    l4.setBounds(700,10, 60, 20);
    add(l4);

    JLabel l5 = new JLabel("Table Type");
    l5.setBounds(900, 10, 100, 20);
    add (l5);
        
     t1 = new JTable();
     t1.setBounds(0, 40, 1050, 400); 
     add(t1);
     
     b1 = new JButton("Load Data");
     b1.setBackground(Color.BLACK);
     b1.setBounds(400, 460, 120, 30);
     b1.setForeground(Color.WHITE);
     b1.addActionListener(this);
     add(b1);

     b2 = new JButton("Back");
     b2.setBackground(Color.BLACK); 
     b2.setForeground(Color.WHITE);
     b2.setBounds(550, 460, 120, 30); 
     b2.addActionListener(this);
     add(b2);
     
     getContentPane().setBackground(Color.WHITE);
     
     setLayout(null);
     setBounds(300, 200, 1050, 600);
     setVisible(true);
     
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                conn c = new conn();
                String str = "Select *from addtables";
                        
                ResultSet rs = c.s.executeQuery(str);  
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                
            }
        }else if(ae.getSource() == b2){
            new OrderCounter().setVisible(true);
            this.setVisible(false);
        }
        
    }
    public static void main(String[] args){
     new Items().setVisible(true);
    }
}
