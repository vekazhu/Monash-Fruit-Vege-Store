/**
 * class Transaction contains all attributes of one transaction object and their get set methods
 *
 * @author (Team 114)
 * @version (15/OCT/2018)
 */
public class Transaction
{
    private double rating;
    private String customerID;
    private String customerStatus;
    private String transactionDate;
    private double totalPrice;

    /**
     * Default constructor for objects of class Transaction
     */
    public Transaction()
    {
        this.rating = 0;
        this.customerID = "";
        this.customerStatus = "";
        this.transactionDate = "";
        this.totalPrice = 0;
    }
    
    /**
     * Non-default constructor for objects of class Transaction
     */
    public Transaction(String customerID, String customerStatus, String date,double totalPrice,double rating)
    {
        this.rating = rating;
        this.customerID = customerID;
        this.customerStatus = customerStatus;
        this.transactionDate = date;
        this.totalPrice = totalPrice;
    }
    
    /**
     * Method getCustomerID is to get the customer ID on transaction records
     *
     * @return String: customerID, the customer ID on transaction records
     */
    public String getCustomerID()
    {
        return customerID;
    }
    
    /**
     * Method getRating is to get the rating of on transaction records
     *
     * @return double: rating, the rating on trsaction records
     */
    public double getRating()
    {
        return rating;
    }
    
    /**
     * Method getCustomerStatus is to get the customer status on transaction records
     *
     * @return String: customerStatus, the customer status on the transaction records
     */
    public String getCustomerStatus()
    {
        return customerStatus;
    }
    
    /**
     * Method getTransactionDate is to get the transaction date on transaction records
     *
     * @return String: transactionDate, the date that the transaction was recorded 
     */
    public String getTransactionDate()
    {
        return transactionDate;
    }
    
    /**
     * Method getTotalPrice is to get the transaction amount($) on transaction records
     *
     * @return doulbe: totalPrice, the transaction amount($) of the transaction
     */
    public double getTotalPrice()
    {
        return totalPrice;
    }
    
    public String getTransactionInfo()
    {
        String transactionInfo = getCustomerID() + "," + getCustomerStatus() + "," + getTransactionDate() + "," + getTotalPrice()+","+ getRating();
        return transactionInfo;
    }
    
     /**
     * Method setCustomerID is to record the user ID of the customer commenced the transaction
     *
     * @param customerID, the user ID of the customer commenced the transaction
     */
    public void setCustomerID(String customerID)
    {
        this.customerID= customerID;
    }
    
    /**
     * Method setRating is to record the rating of customers give to the whole system functions, 5 is the best and 1 is the
     * worst
     *
     * @param rating, the rating given by customers
     */
    public void setRating(double rating)
    {
        this.rating = rating;
    }
    
    /**
     * Method setCustomerStatus is to record the customer status of the customer commenced the transaction, 'active' means the
     * customer is still registered in MFVS, 'inactive' means the customer is already unregistered
     *
     * @param customerStatus, the customer status of the customer commenced the transaction
     */
    public void setCustomerStatus(String customerStatus)
    {
        this.customerStatus = customerStatus;
    }
    
    /**
     * Method setTransactionDate is to record the date when the transaction is commenced
     *
     * @param date, the date when the transaction is commenced
     */
    public void setTransactionDate(String date)
    {
        this.transactionDate = date;
    }
    
    /**
     * Method setTotalPrice is to record the transaction amount($) made by customers
     *
     * @param totalPrice, transaction amount($) made by customers
     */
    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }       
}
