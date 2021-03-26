package service;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ApiException{
  private int status;
  private String date;
  private String message;

    public ApiException(int status, String date, String message) {
        this.status = status;
        this.date = date;
        this.message = message;
    }

    public ApiException() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public static String getCurrentDate(){
        long ctime = System.currentTimeMillis();
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String date = sd.format(new Date(ctime));
        return date;
    }
}
