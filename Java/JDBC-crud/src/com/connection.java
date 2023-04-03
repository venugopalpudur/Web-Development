package com;
import java.sql.*;

public class connection {
    public static Connection connect(){
        Connection con = null;
        String Driver = "org.h2.Driver";
        String DB_Url = "jdbc:h2:~/test";
        String Username = "sa";
        String Pass = "";
          
        try {
            Class.forName(Driver);
            con = DriverManager.getConnection(DB_Url, Username, Pass);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
