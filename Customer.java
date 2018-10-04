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
      
    public void register()
    {
        System.out.println("Please enter your first Name.");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.next();
        /**
         * while (isNameValid(firstName) == true)
        {
            System.out.println("Please enter your email address.");
            String email = scanner.next();
            while (isEmailValid(email) == true)
            {
                System.out.println("Please enter your password.");
                String passWord = scanner.next();
                while (isPasswordValid(passWord) == true)
                {
                    scanner.close();
                }
            }
        }
         * 
         */
        
        Validator.isNameValid(firstName);
    }
    
    public void addProductToCart()
    {
        
    }
}
