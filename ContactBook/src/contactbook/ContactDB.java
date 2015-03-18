package contactbook;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author leonard
 */
public class ContactDB {
    
    static Connection dbConnect = null;
    static String dbUrl = null;
    static String dbHost = null;
    static String adminName = null;
    static String adminpass = null;
    
    /**
     *create connection to the contactbook sqlite database
     * @return
     */
    public static Connection createConnection ()   {
        dbHost = "org.sqlite.JDBC";
        dbUrl = "jdbc:sqlite:ContactBook.sqlite";
        try {
            Class.forName(dbHost);
            dbConnect = DriverManager.getConnection( dbUrl, adminName, adminpass );
            return dbConnect;
        }
        catch(SQLException | ClassNotFoundException ae){
            JOptionPane.showMessageDialog(null, "Could not load contacts. " +ae);
            return null;
        } 
    }  

    /**
     *close the connnection to the contactbook database 
     */
    public static void closeConnection () {
        try   {
            if(dbConnect != null)
                dbConnect.close();
        }
        catch(SQLException ae){
            JOptionPane.showMessageDialog(null, ae);
        }
    }    
}
