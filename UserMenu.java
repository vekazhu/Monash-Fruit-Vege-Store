
/**
 * class UserMenu contains all the menu the system will display to users
 *
 * @author (Team 114)
 * @version (15/OCT/2018)
 */
public class UserMenu
{
    
    /**
     * Default constructor for objects of class UserMenu
     */
    public UserMenu()
    {
        
    }

    /**
     * A method to display main menu, the menu displayed before users have logged in
     */
    public void displayMainMenu()
    {
        System.out.println("Welcome to The MFVS :)");
        System.out.println("~~~~~~~~~~Main Menu~~~~~~~~~~");
        System.out.println("A. View All products");
        System.out.println("B. Login");
        System.out.println("C. Register");
        System.out.println("X. Exit");
        System.out.println("Enter your choice(A/a)");
    }
    
    /**
     * A method to display menu when a customer has logged in
     */
    public void displayCustomerMenu()
    {
        System.out.println("Hello :)");
        System.out.println("~~~~~~~~~~Your Menu~~~~~~~~~~");
        System.out.println("A.View All Products"); 
        System.out.println("B. Search Product");
        System.out.println("C. Add Product to Cart"); 
        System.out.println("D. View Cart");
        System.out.println("E. Edit Cart");
        System.out.println("F. Checkout");
        System.out.println("G. View My Transactions");
        System.out.println("H. Log Out");
        System.out.println("I. Unregister");
        System.out.println("X. Exit");
        System.out.println("Enter your choice(A/a)");
    }
    
    /**
     * A method to display menu when the owner has logged in
     *
     */
    public void displayOwnerMenu()
    {
        System.out.println("~~~~~~~~~~Your Menu~~~~~~~~~~");
        System.out.println("A.View All Products"); 
        System.out.println("B. Search Product"); 
        System.out.println("C. Create Products"); 
        System.out.println("D. Edit Products");
        System.out.println("E. Delete Product");
        System.out.println("F. View All Transactions");
        System.out.println("G. View All Customers");
        System.out.println("H. Log Out");
        System.out.println("X. Exit");
        System.out.println("Enter your choice(A/a)");
        
    }

    /**
     * A method to display menu when 'search product' option is selected 
     *
     */
    public void displaySearchMenu()
    {
        System.out.println("Choose the Search Type");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("A. Search By Product Name");
        System.out.println("B. Search By Product Category");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Enter your choice(A/a)");
     
    }
    
}
