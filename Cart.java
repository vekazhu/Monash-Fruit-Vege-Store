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
    private ArrayList<String> cartInfo; // one string: productID + productName + priceKG/priceWhole + amount 
                                        //  + Price(price of one kind of product) like: 5 apples, each one dollar, onePrice = 5 dollors
                                       // + flagKG (if flagKG=1 then selling by KG, otherwise selling by each)
                                       //seperate by ","
    private Date date;
    private double totalPrice; //the total price of whole cart products

    /**
     * Constructor for objects of class Cart
     */
    public Cart()
    {
        cartInfo = new ArrayList<String>();
        date = new Date();
        totalPrice=0;
    }

    public ArrayList<String> getCartInfo()
    {
        return cartInfo;
    }

    public void setCartInfo(ArrayList<String> cartInfo)
    {
        this.cartInfo = cartInfo;
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
        if (cartInfo != null)
        {    
            for (String str: cartInfo)
            {
                String[] parts = str.split(",");
                String productId = parts[0];
                String productName = parts[1];
                String unitPrice = parts[2];
                double amount = Double.parseDouble(parts[3]);
                double price = Double.parseDouble(parts[4]);
                System.out.format("%-13s%-16s%-10.1f%-14s%-10.2f%n",productId,productName,amount,unitPrice,price);
                //ProductId,productName,price,amount,onePrice,totalPrice
            }
            System.out.println("Your total price is " + totalPrice + " AUD");
        }
        else
            System.out.println("You have nothing in the cart");
    }

    public String generateDate()
    {
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
        return dtf.format(date).toString();
    }
    
    public void clearCartInfo()
    {
        cartInfo.clear();
    }
    
    public void deleteProductInCart(String deleteProductId)
    {
        for (String str: cartInfo)
        {
            String[] parts = str.split(",");
            String productId = parts[0];
            if (deleteProductId.equals(productId))
                cartInfo.remove(str);
        }
    }
    
    public void addProductInCart(String productInfo)
    {
        cartInfo.add(productInfo);
    }
    
    public void reduceProductQuantity(String changeProductId,double changeAmount)
    {
        for (String str: cartInfo)
        {
            String[] parts = str.split(",");
            String productId = parts[0];
            String productName = parts[1];
            String unitPrice = parts[2];
            double amount = Double.parseDouble(parts[3]);
            double price = Double.parseDouble(parts[4]);
            int flagKG = Integer.parseInt(parts[5]);
            if (changeProductId.equals(productId))
            {    
                cartInfo.remove(str);
                changePrice = u
                String productInfo = productId + "," + productName + "," + unitPrice + "," + changeAmount + "," + changePrice + flagKG;
                cartInfo.add(productInfo);
            }
        }
    }

}
