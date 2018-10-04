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
        listOfUsers = FileManager.readUserInfo("users.txt");
        listOfTransactions = FileManager.readTransactionsInfo("transactions.txt");
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
    
    public void addProductToCart()
    {
        System.out.println("Enter the productID of the product you want to buy");
        Scanner input = new Scanner(System.in);
        String productID = input.nextLine();
    }
    
    public void checkOut()
    {
        ArrayList<String> cartInfo = new ArrayList<String>();
        displayCart();
        System.out.println("Are you sure you want to checkout? (y/n)");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if (answer.toLowerCase().startsWith("y"))
        {
            cart.displayCart();//get cartInfo(ArrayList<String>)
        }
        
    }

}
