package DAO;
import java.sql.*;
/**
 * Connect
 */
public class Connect {

    
    // public Connection connecter0()throws Exception,ClassNotFoundException{
    //     try {
    //         Class.forName("oracle.jdbc.driver.OracleDriver");
    //         Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","star","star");
    //     // System.out.println(c);
    //     return c;
            
    //     } catch (Exception e) {
    //     System.out.println(e);
    //         // TODO: handle exception
    //     }
    //     return null;
    // }

    public Connection connecter()throws Exception,ClassNotFoundException{
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/datameuble";
            Connection c=DriverManager.getConnection(url,"postgres","0000");
            c.setAutoCommit(false);
            return c;
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
        return null;
    }

    public static Connection obtenirConnexion() {
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/datameuble";
            Connection c=DriverManager.getConnection(url,"postgres","0000");
            c.setAutoCommit(false);
            return c;
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }
        return null;
    }
    
    
}