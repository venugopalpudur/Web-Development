
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
     String DB_URL = "jdbc:h2:~/test";
     //tcp://localhost/
     String USER = "sa";
     String PASS = "";
     //String QUERY = "CREATE DATABASE TESTING"; 
     Class.forName("org.h2.Driver");
       try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         String sql = "CREATE TABLE student";
         stmt.executeUpdate(sql);
         System.out.println("Table created successfully...");   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
    }
}
