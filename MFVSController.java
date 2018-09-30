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
    Shelf shelf;
    Cart cart;
    /**
     * Constructor for objects of class MFVSController
     */
    public MFVSController()
    {
        listOfUsers = new ArrayList<User>();
        listOfTransactions = new ArrayList<Transaction>();
        shelf = new Shelf();
        cart = new Cart();
    }

    public void start()
    {
        UserMenu menu = new UserMenu();
        String option="";
        do
        {
            Scanner input = new Scanner(System.in);
            menu.displayMainMenu();
            option = input.nextLine();
            getChoice(option);
        }
        while (!option.toLowerCase().equals("x"));
        /*
        listOfUsers = new ArrayList<User>();
        listOfUsers.add(new Customer("u0001","yzz001","yzz@gmail.com","12345678","Passw","08031990"));
        listOfUsers.add(new Customer("u0002","yzz001","yzz@gmail.com","12345678","Passw","08031990"));
        listOfUsers.add(new Customer("u0003","yzz001","yzz@gmail.com","12345678","Passw","08031990"));
        listOfUsers.add(new Customer("u0004","yzz001","yzz@gmail.com","12345678","Passw","08031990"));
        listOfUsers.add(new Customer("u0005","yzz001","yzz@gmail.com","12345678","Passw","08031990"));
        // System.out.println(listOfUsers.get(0).getClass().getName());
        UserMenu menu = new UserMenu();
        menu.displayMenu();
         */
    }
    
    public void getChoice(String option)
    {
        switch (option.toLowerCase())
        {
            case "a":
            break;
            default:
            System.out.println("The entered vaule is unrecognized!");break;
        }
    }

    public void displayAllProducts()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~All Products~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.format("%-15s%-10s%-13s%-15s%-10s%-10s%-13s%n","ProductID","Name","Category","ShelfLife","SellingType","Price","Discount");
        shelf.sortProductByAlphabet();
        shelf.displayProductsInfo(shelf.getListOfProducts());
    }
    
    public void displayCart()
    {
        System.out.println("~~~~~~~~~~~~~~~Your cart~~~~~~~~~~~~~~~~~~~~~~");
        System.out.format("%-15s%-10s%-10d%-10d%-10d%n","ProductId","Name","Amount","Price","Total Price");
        cart.displayCart();
    }

}
