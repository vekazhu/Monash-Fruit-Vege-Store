import java.util.*;
import java.lang.*;

/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer extends User
{
    // instance variables - replace the example below with your own

    private String status;
    private Cart cart;
    private Shelf shelf;

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

    public Customer()
    {
        status = "active";
        cart = new Cart();
        shelf = new Shelf();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

    public String getStatus()
    {
        // put your code here
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void nameScanner()
    {
        System.out.println("Please enter your first Name between 3-20 letters and only letters are allowed.");
        Scanner sc = new Scanner(System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isFirstNameValid(enteredToken) == false)
        {
            System.out.println("Please renter your first name.");
            enteredToken = sc.next().trim();
        }
        if (Validator.isFirstNameValid(enteredToken) == true)
        {
            System.out.println("Your first name is " + enteredToken + ".");
            String firstName = enteredToken;
            sc.close();
        }
    }
    
    public void addProductToCart()
    {
        System.out.println("Enter the productID of the product you want to buy");
        Scanner input = new Scanner(System.in);
        String productID = input.nextLine();
        while (!isProductExist(productID))
        {
            System.out.println("Please enter a valid productID");
            productID = input.nextLine();
        }
        String productName = shelf.findProduct(productID).getProductName();
        double priceKG = shelf.findProduct(productID).getPriceKG();
        double priceWhole = shelf.findProduct(productID).getPriceWhole();
        int quantityWhole = shelf.findProduct(productID).getQuantityWhole();
        double quantityKG = shelf.findProduct(productID).getQuantityKG();
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
                System.out.println("please re-enter the amount");
                amount = input.next().trim();
            }
            // add product to productList in cart
            double onePrice = 0; // the price of one type of product
            double totalPrice = 0; //total price of all products in cart
            if (flagKG == 0)
            {    
                onePrice = priceWhole * Double.parseDouble(amount);
                cart.getProductList().add(productID + "," + productName + "," + priceWhole +"/each" + "," + amount + "," + onePrice);
                totalPrice = totalPrice + onePrice;
            }
            else
            {   
                onePrice = priceKG * Double.parseDouble(amount);
                cart.getProductList().add(productID + "," + productName + "," + priceKG +"/KG" + "," + amount + "," + onePrice);
                totalPrice = totalPrice + onePrice;
            }
            cart.setTotalPrice(totalPrice);
            System.out.println("You have added it in the cart~");
        }
        else
            System.out.println("Please choose other products to purchase");
    }
    
    public boolean isAmountValid(String amount,int flagKG,String productID)
    {
        if (!Validator.isDouble(amount))
        {
            return false;
        }
        else
        {
            double inventory = 0;
            if (flagKG==0)
                inventory = shelf.findProduct(productID).getQuantityWhole();
            else
                inventory = shelf.findProduct(productID).getQuantityKG();
            if (Double.parseDouble(amount) > inventory)
               return false;
            else
                return true;
        }
    }
    
    public boolean isProductExist(String productID)
    {
        for (int i=0; i<shelf.getListOfProducts().size();i++)
        {
            if (productID.equalsIgnoreCase(shelf.getListOfProducts().get(i).getProductID()))
            {
                return true;
            }
        }
        return false;
    }

    public void passwordScanner()
    {
        System.out.println("Please set your password between 4 and 15 with at least one uppercase and one lowercase letters, but no special characters are allowed.");
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isPasswordValid(enteredToken) == false)
        {
            System.out.println("Please renter your password.");
            enteredToken = sc.next().trim();
        }
        if (Validator.isPasswordValid(enteredToken) == true)
        {
            String password = enteredToken;
            sc.close();
        }
    }

    public void emailScanner()
    {
        System.out.println("Please enter your email address.");
    }

    public void register()
    {
        System.out.println("Welcome to join Monash Fruit and Vege Store, please follow the registration instructions :)");
        nameScanner();
        System.out.println("___________________________________________________________________________________");
        passwordScanner();
        System.out.println("___________________________________________________________________________________");
    }

    public void displayCart()
    {
        System.out.println("~~~~~~~~~~~~~~~Your cart~~~~~~~~~~~~~~~~~~~~~~");
        System.out.format("%-15s%-10s%-10d%-10d%-10d%n","ProductId","Name","Amount","Price","Total Price");
        cart.displayCart();
    }

    public void checkOut()
    {
        displayCart();
        System.out.println("Are you sure you want to checkout? (y/n)");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if (answer.toLowerCase().startsWith("y"))
        {
            System.out.println("Thank you for shopping at MFVS~");
            double rating = rate();
            String transaction = super.getUserId() + "," + status + "," + cart.generateDate() + "," + cart.getTotalPrice() + "," + rating;
            FileManager.writeFile(transaction,"transactions.txt");
        }
        else
        {
            displayCart();
        }
    }

    public double rate()
    {
        Scanner input = new Scanner(System.in);
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
        return Double.parseDouble(rating);
    }

}
