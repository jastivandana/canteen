
package canteen.management.system;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;


public class AddItems extends JFrame implements ActionListener{
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;
   
    AddItems(){
        
        super("CONTACLESS COMPUTERIZED CANTEEN MANAGEMENT SYSTEM");
        JLabel l1 = new JLabel("ADD TABLES");
        l1.setBounds(140,20,120,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,18));
        add(l1);
        
        JLabel table = new JLabel("Table Number");
        table.setBounds(60, 80, 120, 30);
        table.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(table);
        
        t1 = new JTextField();
	t1.setBounds(200, 80, 150, 30);
	add(t1);
        
        JLabel available = new JLabel("Available");
	available.setFont(new Font("Tahoma", Font.PLAIN, 16));
	available.setBounds(64, 130, 120, 30);
	add(available);
        
        c1 = new JComboBox(new String[] { "Available", "Occupied" });
	c1.setBounds(200, 130, 150, 30);
        c1.setBackground(Color.WHITE);
	add(c1);
        
        JLabel status = new JLabel("Cleaning status");
        status.setBounds(60, 180, 120, 30);
        status.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(status);
        
        c2 = new JComboBox(new String[] { "Sanitized", "UnSanitized" });
	c2.setBounds(200, 180, 150, 30);
        c2.setBackground(Color.WHITE);
	add(c2);
        
        JLabel price = new JLabel("Service Charges");
        price.setBounds(60, 230, 120, 30);
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(price);
        
        t2 = new JTextField();
	t2.setBounds(200, 230, 150, 30);
	add(t2);
        
        JLabel type = new JLabel("Table type");
        type.setBounds(60, 280, 120, 30);
        type.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(type);
        
        c3 = new JComboBox(new String[] { "Single Table 8/4", "Double Table 16/8" });
        c3.setBackground(Color.WHITE);
	c3.setBounds(200, 280, 150, 30);
	add(c3);
        
        b1 = new JButton("Add Table");
        b1.setBounds(60, 350,130 ,30 );
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBounds(220, 350,130 ,30 );
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        
        //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("canteen/management/system/icons/CMS22.jpg "));
         //JLabel l5 = new JLabel(i1);
         //l5.setBounds(400, 30 , 500 , 350 );
         //add(l5);        
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setBounds(570,200,500,500);
        setLayout(null);
        setVisible(true);
        
    }   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            
            String table = t1.getText();
            String available = (String)c1.getSelectedItem();
            String status = (String)c2.getSelectedItem();
            String price = t2.getText();
            String type = (String)c3.getSelectedItem();
            
            conn c =new conn();
            try{
                
                String str = "insert into addtables values('"+table+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Table Added");
                this.setVisible(false);
                
            }catch(Exception e){
             System.out.println(e);   
            }
            
            
        }else if(ae.getSource()==b2){
            new Dashboard().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddItems().setVisible(true);

    }
    
}
