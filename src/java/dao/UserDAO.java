package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;
import service.GetConnection;

public class UserDAO {
  public static User save(User u){
      Connection con = null;
      try{
          con = GetConnection.getConnection();
          String sql = "insert into user(mobile,password) values(?,?)";
          
          // Get prepared statement
          PreparedStatement ps  = con.prepareStatement(sql);
          ps.setString(1, u.getMobile());
          ps.setString(2, u.getPassword());
          
          int x = ps.executeUpdate();
      
          if(x!=0){
              sql = "select id from user where mobile=? and password=?";
              PreparedStatement ps2 =con.prepareStatement(sql);
              ps2.setString(1, u.getMobile());
              ps2.setString(2, u.getPassword());
              ResultSet rs = ps2.executeQuery();
              if(rs.next()){
                  int id = rs.getInt(1);
                  u.setId(id);
              }
          }
      }
      catch(Exception e){
          e.printStackTrace();
      }
      finally{
          try{
              con.close();
          }
          catch(Exception e){
              e.printStackTrace();
          }
      }
      return u;
  }    
}
