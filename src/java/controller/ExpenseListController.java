package controller;

import com.google.gson.Gson;
import dao.ExpenseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ApiException;

public class ExpenseListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
        try{
           int userId = Integer.parseInt(request.getParameter("userId"));
           response.setStatus(200);
           out.print(new Gson().toJson(ExpenseDAO.getUserExpenseList(userId)));
       }
       catch(Exception e){
             response.setStatus(500);
             out.print(new Gson().toJson(new ApiException(500, ApiException.getCurrentDate(), "Internal server error")));
       }
       
    }

}
