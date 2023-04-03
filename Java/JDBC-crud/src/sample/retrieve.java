package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.connection;

public class retrieve {

    public static List<info> retrieve() {
        List<info> dbInfo = new ArrayList<info>();
        try {
            Connection con = connection.connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM RATINGS");
            if (rs != null) {
                while (rs.next()) {
                    
                    dbInfo.add(new info(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbInfo;
    }
    
    public static List<info> retrieveWeights() {
        List<Integer> weights = new ArrayList<Integer>();
        try {
            Connection con = connection.connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM distribution");
            if (rs != null) {
                while (rs.next()) {
                    
                    dbInfo.add(new info(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbInfo;
    }
}
