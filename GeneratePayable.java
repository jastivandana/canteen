
package canteen.management.system;

import java.awt.Choice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;



public class GeneratePayable extends JFrame implements ActionListener{

    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;
    
    
    
    GeneratePayable(){
        super("CONTACLESS COMPUTERIZED CANTEEN MANAGEMENT SYSTEM");
        
        
    JLabel l1 = new JLabel("Generate-Amount"); 
    l1.setBounds(90,20, 200, 30); 
    l1.setForeground(Color.BLUE);
    l1.setFont(new Font ("Tahoma",Font.PLAIN,20));
    add(l1);
    
    JLabel l2 = new JLabel("Customer ID"); 
    l2.setBounds(30,80, 100, 20); 
    add(l2);
    
    c1 = new Choice();
    try{
        conn c =new conn();
        
        ResultSet rs = c.s.executeQuery("Select * from customer");
        while(rs.next()){
            c1.add(rs.getString("number"));
            
        }
    }catch(Exception e){}
        c1.setBounds(200,80,150,25);
        add(c1);
    
    
    JLabel l3 = new JLabel("Table Number"); 
    l3.setBounds(30,120, 100, 20); 
    add(l3);
    
    t1 = new JTextField();
    t1.setBounds(200, 120, 150, 25); 
    add(t1);
    
    JLabel l4 = new JLabel("Name"); 
    l4.setBounds(30,160, 100, 20); 
    add(l4);
    
    t2 = new JTextField();
    t2.setBounds(200, 160, 150, 25); 
    add(t2);
    
    
    JLabel l5 = new JLabel("Check-In"); 
    l5.setBounds(30,200, 100, 20); 
    add(l5);
    
    t3 = new JTextField();
    t3.setBounds(200, 200, 150, 25); 
    add(t3);
    
    
    JLabel l6 = new JLabel("Item Amount"); 
    l6.setBounds(30,240, 100, 20); 
    add(l6);
    
    t4 = new JTextField();
    t4.setBounds(200, 240, 150, 25); 
    add(t4);
    
    JLabel l7 = new JLabel("Payable Amount"); 
    l7.setBounds(30,280, 100, 20); 
    add(l7);
    
    t5 = new JTextField();
    t5.setBounds(200, 280, 150, 25); 
    add(t5);
    
    b1 = new JButton("Check");
    b1.setBackground(Color.BLACK); 
    b1.setForeground (Color.WHITE);
    b1.setBounds(30, 340, 100, 30);
    b1.addActionListener(this);
    add(b1);


    b2 = new JButton("Update");
    b2.setBackground(Color.BLACK); 
    b2.setForeground(Color.WHITE); 
    b2.setBounds(150, 340, 100, 30);
    b2.addActionListener(this);
    add(b2);

    b3 = new JButton("Back");
    b3.setBackground(Color.BLACK); 
    b3.setForeground(Color.WHITE); 
    b3.setBounds(270, 340, 100, 30);
    b3.addActionListener(this);
    add(b3);
    
    
    ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("canteen/management/system/icons/food-picky-logo.PNG"));
    JLabel l9 = new JLabel(il); 
    l9.setBounds(400, 70, 530, 300);
    add(l9);
    
    
    getContentPane().setBackground(Color.WHITE);
     
    setLayout(null);
    setBounds(450, 200, 980, 500);
    setVisible(true);
    
    }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == b1){
            
            try{
                String table_number = null;
                String item_amount = null;
                int amountpaid;
                String price = null;
                
                
                conn c = new conn();
                String id = c1.getSelectedItem();
                String str = "select * from customer where number ='"+id+"'";
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next()){
                    t1.setText(rs.getString("table_number"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("item_amount"));
                    table_number = rs.getString("table_number");
                    item_amount = rs.getString("item_amount");
                    
                }
                ResultSet rs2 = c.s.executeQuery("select * from addtables where table_number = '"+table_number+"' ");
                while(rs2.next()){
                    price = rs2.getString("price");
                    amountpaid = Integer.parseInt(price)+Integer.parseInt(item_amount);
                    t5.setText(Integer.toString(amountpaid));
                }
                
            }catch(Exception e){}
            
        }else if(ae.getSource() == b2){
            try{
                conn c =new conn();
                String s1 = c1.getSelectedItem();
		String s2 = t1.getText(); //Table_number;    
                String s3 = t2.getText(); //name    
                String s4 = t3.getText(); //status;    
                String s5 = t4.getText(); //item_amount
                String s6 = t5.getText(); //amountpaid
                
                c.s.executeUpdate("update customer set table_number = '"+s2+"', name = '"+s3+"', status = '"+s4+"', item_amount = '"+s6+"' where number = '"+s1+"'");
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                new OrderCounter().setVisible(true);
                this.setVisible(false);
            }catch(Exception e){}
            
            
        }else if(ae.getSource() == b3){
            new OrderCounter().setVisible(true);
            this.setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
     new GeneratePayable().setVisible(true);
    }
    
}
