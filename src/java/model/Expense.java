package model;

public class Expense {
  private int id;
  private int categoryId;
  private int userId;
  private String tag;
  private String edate;
  private float amount;
  private String paymentMode;
  private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
  

    public Expense() {
    }

    public Expense(int id, int categoryId, int userId, String tag, String edate, float amount, String paymentMode) {
        this.id = id;
        this.categoryId = categoryId;
        this.userId = userId;
        this.tag = tag;
        this.edate = edate;
        this.amount = amount;
        this.paymentMode = paymentMode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
  
}
