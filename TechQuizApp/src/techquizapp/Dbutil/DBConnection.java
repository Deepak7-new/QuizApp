
package techquizapp.Dbutil;    

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DBConnection {
    private static Connection conn;
    
    static {            //Because it will run only one time and at first
          try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/onlineexam?useSSL=false", "root", "Deepak@123");
            //JOptionPane.showMessageDialog(null, "Connected Successfully");
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cannot connect to the DB!!");
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection() {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "Disconnected Successfully");
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "!!Unable to close Connection!!");
        }
    }           
}
