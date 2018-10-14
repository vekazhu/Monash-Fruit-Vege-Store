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
    private ArrayList<String> cartInfo; // one string: productID + productName + priceKG/priceWhole + amount 
                                        //  + Price(price of one kind of product) like: 5 apples, each one dollar, onePrice = 5 dollors
                                       // + flagKG (if flagKG=1 then selling by KG, otherwise selling by each)
                                       // + discount
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
    
    public void addTotalPrice(double price)
    {
        totalPrice = totalPrice + price;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public void displayCart()
    {
        if (cartInfo.size() != 0)
        {    
            for (String str: cartInfo)
            {
                String[] parts = str.split(",");
                String productId = parts[0];
                String productName = parts[1];
                String unitPrice = parts[2];
                double amount = Double.parseDouble(parts[3]);
                double price = Double.parseDouble(parts[4]);
                int discount = Integer.parseInt(parts[6]);
                System.out.format("%-13s%-16s%-10.1f%-16s%-13.2f%-10d%n",productId,productName,amount,unitPrice,price,discount);
                //ProductId,productName,price,amount,onePrice,totalPrice,discount
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
    
    public String findProductInfo(String productID)
    {
        String productInfo = "";
        for (String str: cartInfo)
        {
            String[] parts = str.split(",");
            String productId = parts[0];
            if (productID.equals(productId))
                productInfo = str;
        }
        return productInfo;
    }
    
    public void deleteProductInCart(String deleteProductId)
    {
        for (int i = 0; i < cartInfo.size(); i++)
        {
            String[] parts = cartInfo.get(i).split(",");
            String productId = parts[0];
            if (deleteProductId.equals(productId))
            {    
                double price = Double.parseDouble(parts[4]);
                cartInfo.remove(i);
                totalPrice = totalPrice - price;
            }
        }
    }
    
    public void addProductInCart(String productInfo)
    {
        cartInfo.add(productInfo);
    }
    
    public void editProductQuantity(String changeProductId,double changeAmount)
    {
        for (int i = 0; i < cartInfo.size(); i++)
        {
            String[] parts = cartInfo.get(i).split(",");
            String productId = parts[0];
            if (changeProductId.equals(productId))
            {    
                String productName = parts[1];
                String unitPrice = parts[2];
                //double amount = Double.parseDouble(parts[3]);
                double price = Double.parseDouble(parts[4]);
                int flagKG = Integer.parseInt(parts[5]);
                int discount = Integer.parseInt(parts[6]);
                //extract int from String unitprice
                String[] strs = unitPrice.split("/");
                double priceNumber = Double.parseDouble(strs[0]);
                //calculate new product price
                double changePrice = priceNumber * changeAmount * (100 - discount)/100;
                //remove old product information
                cartInfo.remove(i);
                //add new productInfo
                String productInfo = productId + "," + productName + "," + unitPrice + "," + changeAmount + "," + changePrice + "," + flagKG + "," + discount;
                cartInfo.add(productInfo);
                totalPrice = totalPrice - price + changePrice;
            }
        }
        
    }
    
    public boolean isProductExistInCart(String userInput)
    {
        for (String str: cartInfo)
        {
            String[] parts = str.split(",");
            String productId = parts[0];
            if (userInput.toLowerCase().equals(productId))
            {
                return true;
            }
        }
        return false;
    }        
}
