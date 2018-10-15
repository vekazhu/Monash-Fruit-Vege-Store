import java.util.*;
import java.lang.*;

/**
 * class Customer extends class User and contains additional attributes of customer object and the methods only used by 
 * customers
 *
 * @author (Team 114)
 * @version (a15/OCT/2018)
 */
public class Customer extends User
{
    private String status;
    private Cart cart;
    private Shelf shelf;
    private ArrayList<String> customerTransactions = new ArrayList<String>();

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String userId,String userName,String userEmail,String userPhoneNumber,
    String userPassword,String securityAnswer)
    {
        super(userId,userName,userEmail,userPhoneNumber,userPassword,securityAnswer);
        
        status = "active";
        cart = new Cart();
        shelf = new Shelf();
    }

    /**
     * Constructor for objects of class Customer
     *
     */
    public Customer()
    {
        super();
        
        status = "active";
        cart = new Cart();
        shelf = new Shelf();
        cart.clearCartInfo();
    }

    /**
     * Method getStatus is to get the status of customer
     *
     * @return String: status, the status of customer 
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * Method setStatus is to record the status of customer
     *
     * @param status: the status of customer 
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    /**
     * Method getCustomerInfo  is to get the ID, username, email, phone number, password and security answer of the customer
     *
     * @return String: customerInfo, the mentioned information of the customer
     */
    public String getCustomerInfo()
    {
        String customerInfo = getUserId() + "," + getUserName() + "," + getUserEmail() + "," + getUserPhoneNumber() + "," + getUserPassword() + "," + getSecurityAnswer();
        return customerInfo;
    }
    
    /**
     * Method editProduct is to edit the products that are already in the cart
     *
     */
    public void editProduct()
    {
       if (cart.getCartInfo().size() != 0)     
       {    
            System.out.println("Enter the productID of the product you want to edit");
            String productID = getProductIdAleadyInCart();
            //find productInfo
            String productInfo = cart.findProductInfo(productID);
            //find flagKG--used to validate quantity
            String[] strs = productInfo.split(",");
            int flagKG = Integer.parseInt(strs[5]);
            String productName = strs[1];
            //asking amount
            System.out.println("enter the number you want to change to");
            Scanner input = new Scanner(System.in);
            String amount = input.nextLine().trim();
            while (!isAmountValid(amount,flagKG,productID))
            {
                
                System.out.println("please re-enter the amount");
                amount = input.next().trim();
            }
            int deleted = 0;
            if (Double.parseDouble(amount) == 0)
            {        
                deleteProductFromCart(productID);
            }
            if (deleted == 1 || Double.parseDouble(amount) != 0)
            {   
                double changeAmount = Double.parseDouble(amount);
                System.out.println("The product is " + productName);
                System.out.println("Edit completed! The quantity has changed to " + amount);
                cart.editProductQuantity(productID,changeAmount);
            }   
       }
       else
       {
           System.out.println("You have nothing in your cart, start to add products~");
       }
    }

    /**
     * Method deleteProductFromCart is to delete the products that are already in the cart
     *
     * @param productID, the ID of the product that will be deteled
     * @return int: 1 means the product is deleted
     *              0 means the product is not deleted
     */
    public int deleteProductFromCart(String productID)
    {
        int deleted = 0; // if a product is deleted then is 1, not deleted is 0
        System.out.println("Are you sure you want to delete this ?(y/n)");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        while (!answer.toLowerCase().equals("y") && !answer.toLowerCase().equals("n"))
        {
            System.out.println("please enter y or n only");
            answer = input.nextLine();
        }
        if (answer.toLowerCase().equals("y"))
        {    
            cart.deleteProductInCart(productID);
            System.out.println("Product is deleted");
            deleted = 1;
        }
        else
        {    
            System.out.println("It seems you don't want to delete, check your cart again");
            displayCart();
        }
        return deleted;
    }
    
    /**
     * Method getProductIdAleadyInCart is to get the ID of products already in the cart
     *
     * @return String: productID, the ID of products already in the cart
     */
    public String getProductIdAleadyInCart()
    {
        Scanner input = new Scanner(System.in);
        String productID = input.nextLine();
        while (!cart.isProductExistInCart(productID))
        {
            System.out.println("Please enter a valid productID that already in the cart");
            productID = input.nextLine();
        }
        return productID;
    }

    /**
     * Method addProductToCart is to add product that is not in the cart to the cart
     *
     */
    public void addProductToCart()
    {
        System.out.println("Enter the productID of the product you want to buy");
        Scanner input = new Scanner(System.in);
        String productID = input.nextLine();
        while (!shelf.isProductExistInShelf(productID))
        {
            System.out.println("Please enter a valid productID");
            productID = input.nextLine();
        }
        String productName = shelf.findProductById(productID).getProductName();
        double priceKG = shelf.findProductById(productID).getPriceKG();
        double priceWhole = shelf.findProductById(productID).getPriceWhole();
        double quantityWhole = shelf.findProductById(productID).getQuantityWhole();
        double quantityKG = shelf.findProductById(productID).getQuantityKG();
        int discount = shelf.findProductById(productID).getDiscount();
        System.out.println("choose selling type(1/2)");
        System.out.println("1.purchase by each");
        System.out.println("2.purchase by KG");
        int flagKG = 0; // if 'purchase by KG' is chosen, flagKG will become 1
        String choice = input.nextLine().trim();
        while (!choice.equals("1") && !choice.equals("2"))
        {
            System.out.println("Invalid input, please re-enter");
            choice = input.nextLine().trim();
        }
        if (choice.equals("1")) //purchase by each
        {
            System.out.println("There are " + quantityWhole + " left");
        }
        if (choice.equals("2")) //purchase by KG
        {
            flagKG=1;
            System.out.println("There are " + quantityKG + "KG left");
        }
        if (quantityWhole != 0 && quantityKG != 0)
        {    
            System.out.println("How many do you want to purchase?");
            String amount = input.nextLine();
            
            while (!isAmountValid(amount,flagKG,productID))
            {
                if (Double.parseDouble(amount) == 0)
                    System.out.println("Quantity should be larger than 0");
                System.out.println("please re-enter the Quantity");
                amount = input.next().trim();
            }
            // add product to cartInfo in cart
            double onePrice = 0; // the price of one type of product
            String productInfo = "";//including productID + productName + priceKG/priceWhole + amount 
                                    //  + Price(price of one kind of product) like: 5 apples, each one dollar, onePrice = 5 dollors
                                    // + flagKG (if flagKG=1 then selling by KG, otherwise selling by each)
                                    //seperate by ","
            if (flagKG == 0)
            {    
                onePrice = priceWhole * Double.parseDouble(amount) * (100 - discount)/100;
                productInfo = productID + "," + productName + "," + priceWhole + "/each" + "," + amount + "," + onePrice + "," + flagKG + "," + discount;
                cart.addProductInCart(productInfo);
                cart.addTotalPrice(onePrice);
            }
            else
            {   
                onePrice = priceKG * Double.parseDouble(amount) * (100 - discount)/100;
                productInfo = productID + "," + productName + "," + priceKG + "/KG" + "," + amount + "," + onePrice + "," + flagKG + "," + discount;
                cart.addProductInCart(productInfo);
                cart.addTotalPrice(onePrice);
            }
            System.out.println("You have added it in the cart~");
        }
        else
            System.out.println("Please choose other products to purchase");
    }

    /**
     * Method isAmountValid is to verify whether the amount customers want to buy of a product is valid
     *
     * @param amount: the amount customers want to buy of a product
     * @param flagKG: 1 indicates customers want to buy the product in KG
     *                0 indicates customers want to buy the product as a whole
     * @param productID: the ID of the product that customers want to buy
     * @return boolean: true if the amount entered is valid
     *                  false if the amount entered is invalid
     */
    public boolean isAmountValid(String amount,int flagKG,String productID) //private
    {
        double inventory = 0;
        if (!Validator.isDouble(amount))
        {
            System.out.println("Quantity should be numbers");
            return false;
        }
        
        if (flagKG == 0)
        {
            if (!Validator.isInt(amount))
                return false;
            else
            {
                inventory = shelf.findProductById(productID).getQuantityWhole();
                if (Double.parseDouble(amount) > inventory)
                {    
                    System.out.println("Quantity should be less than " + inventory);
                    return false;
                }
            }
        }
        else
        {
            if (!Validator.isDouble(amount))
                return false;
            else
            {
                inventory = shelf.findProductById(productID).getQuantityKG();
                if (Double.parseDouble(amount) > inventory)
                {    
                    System.out.println("Quantity should be less than " + inventory);
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method displayCart is to display products already in the cart
     *
     */
    public void displayCart()
    {
        if (cart.getCartInfo().size() != 0)
        {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Your cart~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.format("%-13s%-16s%-10s%-16s%-13s%-10s%n","ProductId","Name","Quantity","UnitPrice(AUD)","Price(AUD)","Discount(%off)");
            cart.displayCart();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        else
            System.out.println("You have nothing in your cart, start to add products~");
    }

    /**
     * Method checkOut is to check out and buy products already in the cart
     *
     * @param userId, the ID of the customer that wants to check out
     */
    public void checkOut(String userId)
    {
        if (cart.getCartInfo().size() != 0)
        {
            displayCart();
            System.out.println("Are you sure you want to checkout? (y/n)");
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            while (!answer.toLowerCase().equals("y") && !answer.toLowerCase().equals("n"))
            {
                System.out.println("please enter y or n only");
                answer = input.nextLine();
            }
            if (answer.toLowerCase().equals("y"))
            {
                for (String productInfo : cart.getCartInfo())
                {
                    String[] parts = productInfo.split(",");
                    shelf.reduceInventory(parts[0],Double.parseDouble(parts[3]),Integer.parseInt(parts[5]));
                }
                shelf.updateInventory(); // write updated products info in "products.txt"
                System.out.println("Thank you for shopping at MFVS~");
                double rating = rate();
                customerTransactions = new ArrayList<String>();
                String transaction = userId + "," + status + "," + cart.generateDate() + "," + cart.getTotalPrice() + "," + rating;
                customerTransactions.add(transaction);
                FileManager.writeFile(customerTransactions,"transactions.txt");
                cart.setTotalPrice(0);
                cart.clearCartInfo();
            }
            else
            {
                System.out.println("It seems you don't want to checkout, you can check you cart again");
                displayCart();
            }
        }
        else
            System.out.println("You have nothing in your cart, add products to checkout~");
    }

    /**
     * Method rate is for customers to rate their experience of using the system, from 1 to 5
     *
     * @return double: rating, the rate given by customers
     */
    public double rate()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("We need your advices, please rate our services");
        System.out.println("1. Very disdatified");
        System.out.println("2. Disatisfied");
        System.out.println("3. Ok");
        System.out.println("4. Satisfied");
        System.out.println("5. Very satisfied");
        System.out.println("Enter your rating(e.g.'5')");
        String rating = input.next().trim();
        while (!Validator.isDouble(rating))
        {
            System.out.println("please re-enter your rating");
            rating = input.next().trim();
        }
        System.out.println("Thanks for you rating, we'll improve our services");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return Double.parseDouble(rating);
    }    
}
