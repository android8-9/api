package service;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
 private static Connection con = null;
 public static Connection getConnection(){
     try{
        // step :- load the driver
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensedb","root","root");
     }
     catch(Exception e){
         e.printStackTrace();
     }
     return con;
 }
}
