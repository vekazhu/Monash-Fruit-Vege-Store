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

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String userId,String userName,String userEmail,String userPhoneNumber,
    String userPassword,String securityAnswer)
    {
        super(userId,userName,userEmail,userPhoneNumber,userPassword,securityAnswer);

        status = "active";
        cart = new Cart();
    }

    public Customer()
    {
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

    /**
     * A method to add product to cart
     *
     * @param  product and amount
     */
    public void addProductToCart(Product product,double amount)
    {
        double onePrice = 0;
        double totalPrice = 0; //total price of all products in cart
        if (product.getQuantityKG()==0)
        {    
            onePrice = product.getPriceWhole()*amount;
            cart.getProductList().add(product.getProductID() + "," + product.getProductName() + "," + product.getPriceWhole()+"/each" + "," + amount + "," + onePrice);
            totalPrice = totalPrice + onePrice;
        }
        else
        {
            onePrice = product.getPriceKG()*amount;
            cart.getProductList().add(product.getProductID() + "," + product.getProductName() + "," + product.getPriceWhole()+"/KG" + "," + amount + "," + onePrice);
            totalPrice = totalPrice + onePrice;
        }
        cart.setTotalPrice(totalPrice);
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
            Transaction transaction = new Transaction(rating,super.getUserId(),status,cart.generateDate(),cart.getTotalPrice());
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
        double rating = input.nextDouble();
        return rating;
    }

}
