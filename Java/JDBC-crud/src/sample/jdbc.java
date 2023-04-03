package sample;

import java.util.*;
import java.sql.*;
import com.connection;
import java.util.ListIterator;

public class jdbc {
    
    Connection con;
    Statement stmt;
    PreparedStatement ps;
    Scanner inp;
    //List<info> list = new ArrayList<info>();

    public void connect() throws Exception {
        
        //create connection ------------------------------
        con = connection.connect();
        
        if(!con.equals(null)){       
        //Representation or Display ------------------------------
        System.out.println("Connection successful !");
        }
        
        //closing connection ---------------------
        //con.close();
    }
    
    public void createTb() throws Exception{
          
        //create query string and statement -----------------------
        stmt = con.createStatement();
        //ps = con.prepareStatement("drop table ratings if exists");
        stmt.executeUpdate("drop table ratings if exists");
        String sql = "CREATE TABLE IF NOT EXISTS ratings(serial INT NOT NULL, StName VARCHAR(45) NOT NULL, subject VARCHAR(45) NOT NULL, assCat VARCHAR(45) NOT NULL, DoS VARCHAR(45) NOT NULL, points INT NOT NULL)";       
        stmt.executeUpdate(sql);
        
        stmt.executeUpdate("drop table distribution if exists");
        String sqll = "CREATE TABLE IF NOT EXISTS distribution(assignCat VARCHAR(45) NOT NULL, weights INT NOT NULL)";       
        stmt.executeUpdate(sqll);
        
        //Representation or Display ------------------------------
        System.out.println("DB created successfully");
        
    }
    
    public void preloadInserTb(int[] sr, String[] name, String[] sub, String[] asses, String[] dos, int[] pts, String[] assCatDist, int[] weights) throws Exception{
        String sql="insert into ratings VALUES(?, ?, ?, ?, ?, ?)";
        String sqll="insert into distribution VALUES(?, ?)";
        ps = con.prepareStatement(sql);
        for(int i=0;i<sr.length; i++){
            ps.setInt(1, sr[i]);
            ps.setString(2, name[i]);
            ps.setString(3, sub[i]);
            ps.setString(4, asses[i]);
            ps.setString(5, dos[i]);
            ps.setInt(6, pts[i]);
            ps.executeUpdate();
        }
        ps = con.prepareStatement(sqll);
        for(int i=0;i<assCatDist.length; i++){
            //ps.setString(1, null);
            ps.setString(1, assCatDist[i]);
            ps.setInt(2, weights[i]);
            ps.executeUpdate();
        }
        System.out.println("Sample Data has been preloaded in table.\n");
    }
    
        
    public boolean inserTb(int sr, String name, String sub, String asses, String dos, int pts ){
        boolean sts=false;
        String sql="insert into ratings VALUES(?, ?, ?, ?, ?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, sr);
            ps.setString(2, name);
            ps.setString(3, sub);
            ps.setString(4, asses);
            ps.setString(5, dos);
            ps.setInt(6, pts);
            ps.executeUpdate();
            sts=true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return sts;
    }
    
    public boolean insertDist(String str, int marks){
        boolean sts=false;
        String sql="insert into distribution VALUES(?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, str);
            ps.setInt(2, marks);
            ps.executeUpdate();
            sts=true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return sts;
    }
    
    public boolean updateTb(int id){
        boolean sts=false;
        try{
        inp=new Scanner(System.in);
        String sql="update ratings "+
                "SET StName=?, "+
                "subject=?, "+
                "assCat=?, "+
                "DoS=?, "+
                "points=? "+
                "WHERE serial=?";
        ps = con.prepareStatement(sql);
        System.out.print("Enter Student Name :");
        String name=inp.nextLine();
        System.out.print("Enter Subject Name :");
        String sub=inp.nextLine();
        System.out.print("Enter Assignment Category Name :");
        String asses=inp.nextLine();
        System.out.print("Enter Date of Submission (dd-mm-yy) :");
        String dos=inp.nextLine();
        System.out.print("Enter Points :");
        int pts=inp.nextInt();
        while(pts > 100){
            System.out.println("Points cannot be greater than 100 & Less than 0\nPlease enter again :");
            pts = inp.nextInt();
        }
        while(pts < 0){
            System.out.println("Points cannot be greater than 100 & Less than 0\nPlease enter again :");
            pts = inp.nextInt();
        }
        ps.setString(1, name);
        ps.setString(2, sub);
        ps.setString(3, asses);
        ps.setString(4, dos);
        ps.setInt(5, pts);
        ps.setInt(6, id);
        ps.executeUpdate();
        sts=true;
        
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return sts;
    }
    
        
    public boolean deleteTb(){
        boolean sts=false;
        try{
        String sql="delete from ratings";
        ps = con.prepareStatement(sql);   
        ps.executeUpdate();
        sts=true; 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return sts;
    }
  
    public boolean deleteAssesAll(){
        boolean sts=false;
        try{
        String sql="delete from distribution";
        ps = con.prepareStatement(sql);
        ps.executeUpdate();
        sts=true; 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return sts;
    }    
           
    public boolean deleteDist(String dell){
        boolean sts=false;
        try{
        String sql="delete from distribution where assignCat=?";
        ps = con.prepareStatement(sql);
        ps.setString(1, dell);
        ps.executeUpdate();
        sts=true; 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return sts;
    }
    
       
    public boolean deleteById(int id){
        boolean sts=false;
        try{
        String sql="delete from ratings where serial=?";
        ps = con.prepareStatement(sql); 
        ps.setInt(1, id);
        ps.executeUpdate();
        sts=true; 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return sts;
    }
    
    public void displayTb() throws Exception{
        //ps=con.prepareStatement("SELECT * FROM RATINGS");
        ResultSet rs = stmt.executeQuery("SELECT * FROM RATINGS");
        if(rs != null){
            System.out.printf("%-10s %-15s %-25s %-15s %-15s %-10s%n --------------------------------------------------------------------------------------%n", "S.No.","St Name","Subject","Assg. Categ.","DoS","Marks");
            while(rs.next()){       
                System.out.printf("%-10d %-15s %-25s %-15s %-15s %-10d%n", rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5),rs.getInt(6));
            }
        }
        ResultSet rss = stmt.executeQuery("SELECT * FROM distribution");
        if(rss != null){
            System.out.println("");
            System.out.printf("%-15s %-25s%n --------------------------------------------------------------------------------------%n", "Assg. Categ.","Marks");
            while(rss.next()){       
                System.out.printf("%-15s %-25s%n", rss.getString(1),rss.getString(2));
            }
            System.out.println("");
        }
    }

    
    
    
    
    
    
  //updating objects with real time data remaining. hence the calculation change;
/*    
    public void retrieve(){
        try{
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM RATINGS");
        rs.next();
        int size = rs.getInt("COUNT(*)");
        int 
        rs = stmt.executeQuery("select * from ratings");
        while(rs.next()){
            serial[i], StName[i], subject[i], assCat[i], DoS[i], points[i]      
        }
        System.out.println(list);
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }*/
}
