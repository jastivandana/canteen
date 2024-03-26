
package canteen.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CanteenManagementSystem extends JFrame implements ActionListener {
    
    CanteenManagementSystem(){
                super("CONTACLESS COMPUTERIZED CANTEEN MANAGEMENT SYSTEM");

      
        setBounds(120,150,1366,565);
   //     setSize(400,400);
        setVisible(true);
    //    setLocation(300,300);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("canteen/management/system/icons/first.jpeg "));
         JLabel l1 = new JLabel(i1);
         l1.setBounds(0, 0 , 1366 , 565 );
         add(l1);
         
         ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("canteen/management/system/icons/food-picky-logo.png "));
         JLabel c1 = new JLabel(a1);
         c1.setBounds(300, 300, 1000, 50);
         l1.add(c1);        
         
         JLabel l2 = new JLabel("Contactless Computerized Canteen Management System");
         l2.setBounds(100, 430 , 950 , 90);
         l2.setForeground(Color.WHITE);
         l2.setFont(new Font("serif",Font.PLAIN,40));
         l1.add(l2);
         
         JButton b1 = new JButton ("NEXT");
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(1200 , 470 , 150 , 50 );
         b1.addActionListener(this);
         l1.add(b1);
         
         getContentPane ().setBackground (Color.WHITE);
         
         setLayout(null);
         setVisible(true);
         
         while(true){
             l2.setVisible(false);
             try{
                 Thread.sleep(500);
             }catch(Exception e){
                 
             }
             l2.setVisible(true);
             try{
                 Thread.sleep(500);
             }catch(Exception e){}
             
         }
         
    }

    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);
    }
    
    public static void main(String[] args) {
       
       new CanteenManagementSystem();
       
    }
    
}
