package controller;

import com.google.gson.Gson;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import service.ApiException;
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     PrintWriter out = response.getWriter();
     try{
        String mobile =  request.getParameter("mobile");
        String password = request.getParameter("password");
        System.out.println(mobile);
        System.out.println(password);
        User user = new User();
        user.setMobile(mobile);
        user.setPassword(password);
        User u = UserDAO.save(user);
        if(u.getId()!=0){
         out.print(new Gson().toJson(u));
         response.setStatus(200);
        }
        else{
         response.setStatus(500);
         ApiException apiException = new ApiException(500,ApiException.getCurrentDate(),"Internal server error");
         out.print(new Gson().toJson(apiException));
        }
     }
     catch(Exception e){
         response.setStatus(500);
         ApiException apiException = new ApiException(500,ApiException.getCurrentDate(),"Internal server error");
         out.print(new Gson().toJson(apiException));
     }
    }

}
