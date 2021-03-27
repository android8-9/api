package controller;

import com.google.gson.Gson;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import service.ApiException;
import service.GetConnection;

public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            String mobile = request.getParameter("mobile");
            String password = request.getParameter("password");
            User user = new User();
            user.setMobile(mobile);
            user.setPassword(password);
            user = UserDAO.authenticate(user);
            if(user.getId()!=0){
                response.setStatus(200);
                out.print(new Gson().toJson(user));
            }
            else{
                response.setStatus(404);
                ApiException exception = new ApiException(404,ApiException.getCurrentDate(),"Resource not found");
                out.print(new Gson().toJson(exception));
            }
                
        }
        catch(Exception e){
              e.printStackTrace();
        }
        
    }

}
