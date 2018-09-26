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
    
    ArrayList<User> listOfUsers;
    ArrayList<Transaction> listOfTransactions;
    /**
     * Constructor for objects of class MFVSController
     */
    public MFVSController()
    {
        
    }
    
    public void start()
    {
        listOfUsers = new ArrayList<User>();
        listOfUsers.add(new Customer("u0001","yzz001","yzz@gmail.com","12345678","Passw","08031990"));
        listOfUsers.add(new Customer("u0002","yzz001","yzz@gmail.com","12345678","Passw","08031990"));
        listOfUsers.add(new Customer("u0003","yzz001","yzz@gmail.com","12345678","Passw","08031990"));
        listOfUsers.add(new Customer("u0004","yzz001","yzz@gmail.com","12345678","Passw","08031990"));
        listOfUsers.add(new Customer("u0005","yzz001","yzz@gmail.com","12345678","Passw","08031990"));
        // System.out.println(listOfUsers.get(0).getClass().getName());
        UserMenu menu = new UserMenu();
        menu.displayMenu();
    }
    
    
    
}
