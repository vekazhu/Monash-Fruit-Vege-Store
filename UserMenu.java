
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
        System.out.println("A.All products");
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
        System.out.println("A.All products");
        System.out.println("B.View cart");
        System.out.println("C.My transactions");
        System.out.println("X.Exit");
        System.out.println("Enter your choice(A/a)");
    }
    
    /**
     * A method to display menu after user chooses 'All product' in the main menu
     */
    public void displayProductActionMenu()
    {
        System.out.println("~~~~~~~~~~Your Menu~~~~~~~~~~");
        System.out.println("A.Add product to cart");
        System.out.println("B.Back to main menu"); // show main menu
        System.out.println("X.Exit");
        System.out.println("Enter your choice(A/a)");
    }
    
    /**
     * A method to display menu after user chooses 'View cart' in the main menu
     */
    public void displayCartActionMenu()
    {
        System.out.println("~~~~~~~~~~Your Menu~~~~~~~~~~");
        System.out.println("A.Checkout");
        System.out.println("B.All product");
        System.out.println("C.Back to my menu"); //show user login menu
        System.out.println("X.Exit");
        System.out.println("Enter your choice(A/a)");
    }
    
    /**
     * A method to display menu after user chooses 'My transactions' in the main menu
     */
    public void displayTransactionActionMenu()
    {
        System.out.println("~~~~~~~~~~Your Menu~~~~~~~~~~");
        System.out.println("A.Back to my menu");  //show user login menu
        System.out.println("X.Exit");
        System.out.println("Enter your choice(A/a)");
    }
    
    public void displayOwnerMenu()
    {
        
    }
    
    
    
    
}
