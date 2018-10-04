
/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Transaction
{
    private double rating;
    private String customerID;
    private String customerStatus;
    private String date;
    private double totalPrice;

    /**
     * Constructor for objects of class Transaction
     */
    public Transaction()
    {
        this.rating = 0;
        this.customerID = "";
        this.customerStatus = "";
        this.date = "";
        this.totalPrice = 0;
    }
    
    public Transaction(double rating, String customerID, String customerStatus, String date,double totalPrice)
    {
        this.rating = rating;
        this.customerID = customerID;
        this.customerStatus = customerStatus;
        this.date = date;
        this.totalPrice = totalPrice;
    }
    
    public String getCustomerID()
    {
        return customerID;
    }
    
    public double getRating()
    {
        return rating;
    }
    
    public String getCustomerStatus()
    {
        return customerStatus;
    }
    
    public String getdate()
    {
        return date;
    }
    
    public double getTotalPrice()
    {
        return totalPrice;
    }
    
    public void setCustomerID(String customerID)
    {
        this.customerID= customerID;
    }
    
    public void setRating(double rating)
    {
        this.rating = rating;
    }
    
    public void setCustomerStatus(String customerStatus)
    {
        this.customerStatus = customerStatus;
    }
    
    public void setdate(String date)
    {
        this.date = date;
    }
    
    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
   
}
