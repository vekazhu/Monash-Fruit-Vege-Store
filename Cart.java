import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Cart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cart
{
    // instance variables - replace the example below with your own
    private ArrayList<String> productList; // one string: productID + productName + priceKG/priceWhole + amount 
    //  + onePrice(price of one kind of product) like: 5 apples, each one dollar, onePrice = 5 dollors
    //seperate by ","
    private Date date;
    private double totalPrice; //the total price of whole cart products

    /**
     * Constructor for objects of class Cart
     */
    public Cart()
    {
        productList = new ArrayList<String>();
        date = new Date();
        totalPrice=0;
    }

    public ArrayList<String> getProductList()
    {
        return productList;
    }

    public void setProductList(ArrayList<String> productList)
    {
        this.productList = productList;
    }

    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public void displayCart()
    {
        for (String str: productList)
        {
            String[] parts = str.split(",");
            String productId = parts[0];
            String productName = parts[1];
            String price = parts[2];
            double amount = Double.parseDouble(parts[3]);
            double onePrice = Double.parseDouble(parts[4]);
            System.out.format("%-15s%-10s%-10d%-10d%-10d%n",productId,productName,price,amount,onePrice);
            //ProductId,productName,price,amount,onePrice
        }
    }

    public String generateDate()
    {
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
        return dtf.format(date).toString();
    }

}
