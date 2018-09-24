import java.util.*;
/**
 * Write a description of class MFVSController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MFVSController
{
    // instance variables - replace the example below with your own
    ArrayList<Customer> listOfCustomer;

    /**
     * Constructor for objects of class MFVSController
     */
    public MFVSController()
    {
        
    }

    /**
     * creat 6 default users, one owner and five customers
     *
     */
    public void createDefaultUsers()
    {
        listOfCustomer = new ArrayList<Customer>();
        listOfCustomer.add(new Customer("19900101","active"));
        listOfCustomer.add(new Customer("19910203","active"));
        listOfCustomer.add(new Customer("19931102","active"));
        listOfCustomer.add(new Customer("19940245","active"));
        listOfCustomer.add(new Customer("19901111","active"));
        Owner owner = new Owner();
    }
    
    public void start()
    {
        createDefaultUsers();
        //UserMenu menu = new UserMenu();
        //menu.displayMenu();
        
    }
    
    public void register()
    {
        System.out.println("Please enter your first Name");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.next();
    }
}
