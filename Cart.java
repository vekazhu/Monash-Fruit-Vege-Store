import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;

/**
 * class Cart contains attributes of a cart object and related get set methods and methods to manage the cart
 *
 * @author (Team 114)
 * @version (15/OCT/2018)
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

    /**
     * Method getCartInfo is to get the information of the cart as an Arraylist of String
     *
     * @return ArrayList<String>: cartInfo, the information of the cart
     */
    public ArrayList<String> getCartInfo()
    {
        return cartInfo;
    }

    /**
     * Method setCartInfo is to record the information of the cart, which is an Arraylist of String
     *
     * @param cartInfo: an Arraylist of String of the information of the cart 
     */
    public void setCartInfo(ArrayList<String> cartInfo)
    {
        this.cartInfo = cartInfo;
    }

    /**
     * Method setTotalPrice is to record the total price of products added to cart
     *
     * @param totalPrice: the total price of products added to cart
     */
    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
    /**
     * Method addTotalPrice is to calculate the total price of products added to cart
     *
     * @param price: the price change that needed to be added to the original total price
     */
    public void addTotalPrice(double price)
    {
        totalPrice = Math.round(totalPrice + price);
    }

    /**
     * Method getTotalPrice is to get the total price of products added to cart
     *
     * @return double: totalPrice, the total price of products added to cart
     */
    public double getTotalPrice()
    {
        return totalPrice;
    }

    /**
     * Method displayCart is to display the information of products already in the cart to users
     *
     */
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
            String allPrice = String.format("%.2f",totalPrice);
            System.out.println("Your total price is " + totalPrice + " AUD");
        }
        else
            System.out.println("You have nothing in the cart");
    }

    /**
     * Method generateDate is to generate the transaction date
     *
     * @return String: date, the transaction date generated
     */
    public String generateDate()
    {
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
        return dtf.format(date).toString();
    }
    
    /**
     * Method clearCartInfo is to clear all the previous information of the cart
     *
     */
    public void clearCartInfo()
    {
        cartInfo.clear();
    }
    
    /**
     * Method findProductInfo is to find the product information of products in the cart based on the entered product ID
     *
     * @param productID, the ID of the product
     * @return String: productInfo, the information of products in the cart of the specific product ID
     */
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
    
    /**
     * Method deleteProductInCart is to delete products in the cart based on the entered product ID
     *
     * @param deleteProductId: the ID of products that customers want to delete in the cart
     */
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
    
    /**
     * Method addProductInCart is to add the information of products that customer want to add to the cart to the cartinfo 
     *
     * @param productInfo, the information of products that customer want to add to the cart
     */
    public void addProductInCart(String productInfo)
    {
        cartInfo.add(productInfo);
    }
    
    /**
     * Method editProductQuantity is to edit the quantity of products already in the cart
     *
     * @param changeProductId, the product ID of the product that will be edited
     * @param changeAmount, the changed quantity of this product
     */
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
    
    /**
     * Method isProductExistInCart is to verify whether a product in already in the cart
     *
     * @param userInput, the input of user for product ID
     * @return boolean: true if the product is already in the cart
     *                  false is the product is not in the cart
     */
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
