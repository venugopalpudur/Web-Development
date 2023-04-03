//start create tables and database for simple apps
package jdbcproject4;
//create table or database or simple query

import com.connection;
import java.sql.*;

public class JDBCproject4 {
 public static void main(String args[]) throws Exception {
        
        //create connection ------------------------------
        Connection con = connection.connect();
        
        //create query string and statement -----------------------
        Statement stmt = con.createStatement();
        String sql = "drop TABLE gamert";       
        stmt.executeUpdate(sql);
        
        //Representation or Display ------------------------------
        System.out.println("Table created successfully");
        
        //closing connection ---------------------
        con.close();
    }
}
