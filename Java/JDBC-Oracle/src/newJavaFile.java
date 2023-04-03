
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class newJavaFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
     String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
     //tcp://localhost/
     String USER = "pudur.venu@gmail.com";
     String PASS = "Venu@1234";
     //String QUERY = "CREATE DATABASE TESTING"; 
     Class.forName("oracle.jdbc.OracleDriver");
       try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         String sql = "CREATE DATABASE STUDENTS";
         stmt.executeUpdate(sql);
         System.out.println("Database created successfully...");   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
    }
}

