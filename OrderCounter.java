
package canteen.management.system;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class OrderCounter  extends JFrame implements ActionListener{
    
    JButton b1, b2, b3, b4, b5, b6, b7,b8,b9;    
    
    OrderCounter(){
        
    super("CONTACLESS COMPUTERIZED CANTEEN MANAGEMENT SYSTEM");
    
    b1 = new JButton ("Order Food Here");
    b1.setBackground (Color.BLACK);
    b1.setForeground (Color.WHITE);
    b1.setBounds (10, 30, 200, 30);
    b1. addActionListener(this);
    add(b1);
    
    b2 =new JButton ("Table Status");
    b2.setBackground (Color.BLACK);
    b2.setForeground (Color.WHITE); 
    b2.setBounds (10, 70, 200, 30);
    b2. addActionListener(this);
    add(b2);
    
    b3 = new JButton("Menu");
    b3.setBackground (Color.BLACK);
    b3.setForeground (Color.WHITE); 
    b3.setBounds (10, 110, 200, 30);
    b3. addActionListener(this);
    add(b3);
    
    b4 = new JButton ("All Employee Info"); 
    b4.setBackground (Color.BLACK);
    b4.setForeground (Color.WHITE);  
    b4.setBounds (10, 150, 200, 30);
    b4. addActionListener(this);
    add(b4);  
    
    b5 = new JButton ("Diner Info");
    b5.setBackground (Color.BLACK);
    b5.setForeground (Color.WHITE); 
    b5.setBounds (10, 190, 200, 30);
    b5. addActionListener(this);
    add(b5);
    
    b6 = new JButton ("Check Out Diner");
    b6.setBackground (Color.BLACK);
    b6.setForeground (Color.WHITE);
    b6.setBounds (10, 230, 200, 30);
    b6. addActionListener(this);
    add (b6);
    
    b7 = new JButton ("Generate Payable Amount"); 
    b7.setBackground (Color.BLACK);
    b7.setForeground (Color.WHITE); 
    b7.setBounds (10, 270, 200, 30);
    b7.addActionListener (this);
    add( b7);
    
    b8 = new JButton ("Update Table Status"); 
    b8.setBackground (Color.BLACK);
    b8.setForeground (Color.WHITE);
    b8.setBounds (10, 310, 200, 30);
    b8.addActionListener(this);
    add (b8);
    
    b9 = new JButton ("logout");
    b9.setBackground (Color.BLACK); 
    b9.setForeground (Color.WHITE);
    b9.setBounds (10, 350, 200, 30);
    b9.addActionListener(this);
    add (b9);
         
    ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("canteen/management/system/icons/food-picky-logo.PNG"));
    JLabel l1 = new JLabel (i1);
    l1.setBounds (250, 0, 500, 450);
    add (l1);
    
    getContentPane ().setBackground (Color.white);
   
    
    
    setLayout(null);
    setBounds (420, 200, 800, 470);
    setVisible(true);
    
    } 
    
     public void actionPerformed (ActionEvent ae){

      if(ae.getSource()== b1){
          new AddCustomer().setVisible(true);
          this.setVisible(false); 
      }else if(ae.getSource()==b2){
          new Items().setVisible(true);
          this.setVisible(false);
      }else if(ae.getSource()==b3){
          new Menu().setVisible(true);
          this.setVisible(false);
          
      }else if(ae.getSource()==b4){
          new Employee().setVisible(true);
            this.setVisible(false);
          
      }else if(ae.getSource()==b5){
          new CustomerInfo().setVisible(true);
            this.setVisible(false);
          
      }else if(ae.getSource()==b6){
          new CheckOut().setVisible(true);
            this.setVisible(false);
          
      }else if(ae.getSource()==b7){
          new GeneratePayable().setVisible(true);
            this.setVisible(false);
          
      }else if(ae.getSource()==b8){
          new UpdateTable().setVisible(true);
            this.setVisible(false);
          
      }else if(ae.getSource()==b9){
          setVisible(false);
      }
}
   
     
     public static void main (String[] args) 
 {
     new OrderCounter().setVisible(true);
 } 
}


