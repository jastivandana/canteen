
package canteen.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class AddMenu extends JFrame implements ActionListener{
    
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;
    
    
    
    
    AddMenu(){
        super("CONTACLESS COMPUTERIZED CANTEEN MANAGEMENT SYSTEM");
        
        JLabel name = new JLabel("Item Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,30,120,30);
        add(name);
    
        t1= new JTextField();
        t1.setBounds(200,30,150,30);
        add(t1);
        
        JLabel Cost = new JLabel("Cost");
        Cost.setFont(new Font("Tahoma",Font.PLAIN,17));
        Cost.setBounds(60,80,120,30);
        add(Cost);
    
        t2= new JTextField();
        t2.setBounds(200,80,150,30);
        add(t2);
        
        
        
        b1 = new JButton("Submit");
        b1.setBounds(200, 420, 150, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("canteen/management/system/icons/food-picky-logo.PNG"));
        Image i2 = i1.getImage().getScaledInstance(200, 50,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(360,60,450,450);
        add(l1);
        
        
        JLabel l2 = new JLabel("ADD NEW MENU DETAILS");
        l2.setForeground(Color.BLUE);
        l2.setBounds(410, 30,400 ,30 );
        l2.setFont(new Font("Tahoma",Font.BOLD,30));
        add(l2);
        
    
        getContentPane().setBackground(Color.WHITE);
        
        
        setLayout(null);
        setBounds(400,200,850,530);
        setVisible(true);
        
    
}
    public void actionPerformed(ActionEvent ae){
        String Item_List = t1.getText();
        String Cost = t2.getText();
                    
                    
                    
                    conn c = new conn();
                    String str = "insert into department values('"+Item_List+"', '"+Cost+"')";
                     
                    try
                    {
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"New Menu Added");
                        this.setVisible(false);
                        
                    }catch(Exception e){
                      System.out.println(e);
		
        
    }
    }
    public static void main(String[] args){
        new AddMenu().setVisible(true);
    }
    
}
