package controller;

import com.google.gson.Gson;
import dao.ExpenseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Expense;
import service.ApiException;

public class AddExpenseController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
        try{
           int categoryId = Integer.parseInt(request.getParameter("categoryId"));
           int userId = Integer.parseInt(request.getParameter("userId"));
           float amount = Float.parseFloat(request.getParameter("amount"));
           String edate = request.getParameter("edate");
           String paymentMode = request.getParameter("paymentMode");
           String tag = request.getParameter("tag");
       
           Expense expense = new Expense();
           expense.setAmount(amount);
           expense.setCategoryId(categoryId);
           expense.setEdate(edate);
           expense.setPaymentMode(paymentMode);
           expense.setTag(tag);
           expense.setUserId(userId);
           
           Expense e = ExpenseDAO.save(expense);
           if(e.getId()!=0){
              response.setStatus(200);
              out.print(new Gson().toJson(e));
           }
           else{
               response.setStatus(500);
               ApiException apiException = new ApiException(500, ApiException.getCurrentDate(), "Internal server error");
               out.print(new Gson().toJson(apiException));
           }
       }
       catch(Exception e){
               response.setStatus(500);
               ApiException apiException = new ApiException(500, ApiException.getCurrentDate(), "Internal server error");
               out.print(new Gson().toJson(apiException));
       }
    }

}
