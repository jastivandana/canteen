
package canteen.management.system;

import java.sql.*;
import java.sql.DriverManager;


public class conn {
    Connection c;
    Statement s;
    
    public conn(){
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///projectcms","root","avishkar");
            System.out.println("Connected successfully");
            
            s = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
