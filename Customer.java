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

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String userId,String userName,String userEmail,String userPhoneNumber,
                    String userPassword,String securityAnswer)
    {
        super(userId,userName,userEmail,userPhoneNumber,userPassword,securityAnswer);
        
        status = "active";
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
        
        
    }
    
}
