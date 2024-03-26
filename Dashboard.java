
package canteen.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    
    
    Dashboard(){
     
        super("CONTACLESS COMPUTERIZED CANTEEN MANAGEMENT SYSTEM");
        
        mb = new JMenuBar();
        add(mb);
        
        m1 = new JMenu("CANTEEN MANAGEMENT ");
        m1.setForeground(Color.RED);
        mb.add(m1);
        
        m2 = new JMenu("ADMIN");
        m2.setForeground(Color.BLUE);
        mb.add(m2);
        
        i1 = new JMenuItem("ORDER COUNTER");
        i1.setBackground(Color.BLACK); 
        i1.setForeground(Color.WHITE);
        i1.addActionListener(this);
        m1.add(i1);
        
        i2 = new JMenuItem("ADD EMPLOYEE");
        i2.setBackground(Color.BLACK); 
        i2.setForeground(Color.WHITE);
        i2.addActionListener(this);
        m2.add(i2);
        
        i3 = new JMenuItem("ADD TABLES ");
        i3.setBackground(Color.BLACK); 
        i3.setForeground(Color.WHITE);
        i3.addActionListener(this);
        m2.add(i3);
        
        i4 = new JMenuItem("ADD MENU");
        i4.setBackground(Color.BLACK); 
        i4.setForeground(Color.WHITE);
        i4.addActionListener(this);
        m2.add(i4);
        
       
        
        mb.setBounds(0,0,1920,30);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("canteen/management/system/icons/HOME1.PNG"));
        Image i2 = i1.getImage().getScaledInstance(1950 , 1000 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1950, 1000);
        add(l1);
        
        JLabel l2 = new JLabel("ACADEMIA CANTEEN WELCOMES YOU ");
        
        l2.setBounds(440, 60, 1080, 70);
        l2.setForeground(Color.white);
        l2.setFont(new Font("serif",Font.PLAIN,40));
        l1.add(l2);
        
        getContentPane ().setBackground (Color.WHITE);
        setLayout(null);
        setBounds(0,0,1950,1020);
        setVisible(true);
        
       
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("ORDER COUNTER")){
            new OrderCounter().setVisible(true);
        }else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee().setVisible(true);
            }else if(ae.getActionCommand().equals("ADD TABLES ")){
                new AddItems().setVisible(true);
            }else if(ae.getActionCommand().equals("ADD MENU")){
                new AddMenu().setVisible(true);
            }
    }
     public static void main(String[] args){
         new Dashboard().setVisible(true);
     }
    
}
