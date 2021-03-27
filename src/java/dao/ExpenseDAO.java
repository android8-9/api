package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Expense;
import service.GetConnection;

public class ExpenseDAO {
  public static ArrayList<Expense> getUserExpenseList(int userId){
      ArrayList<Expense>al = new ArrayList<>();
      Connection con = null;
      try{
          con  = GetConnection.getConnection();
          String sql ="select *,category.category_name from expense inner join category on expense.category_id = category.id where expense.user_id =?";
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setInt(1, userId);
          ResultSet rs = ps.executeQuery();
          while(rs.next()){
            int id = rs.getInt("id");
            int cid = rs.getInt("category_id");
            String tag =rs.getString("tag");
            float amount =rs.getFloat("amount");
            String paymentMode = rs.getString("payment_mode");
            String edate = rs.getString("edate");
            String cname = rs.getString("category_name");
            Expense e = new Expense(id, cid, userId, tag, edate, amount, paymentMode);
            e.setCategoryName(cname);
            al.add(e);
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
      return al;
  }  
  public static int maxId(){
      Connection con = null;
      int id=0;
      try{
          con = GetConnection.getConnection();
          String sql = "select max(id) from expense";
          PreparedStatement ps = con.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          if(rs.next())
              id = rs.getInt(1);
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
      return id;
  }  
  public static Expense save(Expense expense){
      
      Connection con = null;
      try{
          con = GetConnection.getConnection();
          String sql = "insert into expense(category_id,tag,amount,payment_mode,edate,user_id,id)"
                  + " values(?,?,?,?,?,?,?)";
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setInt(1, expense.getCategoryId());
          ps.setString(2, expense.getTag());
          ps.setFloat(3, expense.getAmount());
          ps.setString(4, expense.getPaymentMode());
          ps.setString(5, expense.getEdate());
          ps.setInt(6, expense.getUserId());
          int id = maxId()+1;
          ps.setInt(7, id);
          int x = ps.executeUpdate();
          if(x!=0){
             expense.setId(id);
          }
      }
      catch(Exception ee){
          
      }
      finally{
          try{
              con.close();
          }
          catch(Exception ee){
              ee.printStackTrace();
          }
      }
      return expense;
      
  }    
}
