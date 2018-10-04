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

    UserMenu menu;

    Shelf shelf;

    User user;

    /**
     * Constructor for objects of class MFVSController
     */
    public MFVSController()
    {
        listOfUsers = FileManager.readUserInfo("users.txt");
        listOfTransactions = FileManager.readTransactionsInfo("transactions.txt");
        menu = new UserMenu();
        shelf = new Shelf();
        user = new User();

    }

    public void start()
    {

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
            displayAllProducts();

            break;
            case "b":
            String userId = user.login();
            if (userId.equals("")){
                break;
            }
            else {
                if(userId.startsWith("c"))
                    System.out.println("Customer Logged In");
                else
                    System.out.println("Owner Logged In");
            }

            break;
            case "x":
            System.out.println("See you next time");
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

    

    
    
}
