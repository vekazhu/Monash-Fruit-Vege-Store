
/**
 * Write a description of class UserMenu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserMenu
{
    
    /**
     * Constructor for objects of class UserMenu
     */
    public UserMenu()
    {
        
    }

    /**
     * A method to display main menu
     */
    public void displayMainMenu()
    {
        System.out.println("Welcome to The MFVS :)");
        System.out.println("~~~~~~~~~~Main Menu~~~~~~~~~~");
        System.out.println("A.View All products");
        System.out.println("B.Login");
        System.out.println("C.Register");
        System.out.println("X.Exit");
        System.out.println("Enter your choice(A/a)");
    }
    
    /**
     * A method to display menu when a customer has logined
     */
    public void displayCustomerMenu()
    {
        System.out.println("Hello :)");
        System.out.println("~~~~~~~~~~Your Menu~~~~~~~~~~");
        System.out.println("A.View All Products"); 
        System.out.println("B. Search Product");
        System.out.println("C. Add Product to Cart"); 
        System.out.println("D. View Cart");
        System.out.println("E. View My Transactions");
        System.out.println("F. Log Out");
        System.out.println("G. Unregister");
        System.out.println("H.Checkout");
        System.out.println("I.Edit Cart");
        System.out.println("X.Exit");
        System.out.println("Enter your choice(A/a)");
    }
    
    public void displayOwnerMenu()
    {
        System.out.println("~~~~~~~~~~Your Menu~~~~~~~~~~");
        System.out.println("A.View All Products"); 
        System.out.println("B. Search Product"); 
        System.out.println("C. Create Products"); 
        System.out.println("D.Edit Products");
        System.out.println("E. View All Transactions");
        System.out.println("F. View All Customers");
        System.out.println("G. Log Out");
        System.out.println("X. Exit");
        System.out.println("Enter your choice(A/a)");
        
    }

}
