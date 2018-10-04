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
<<<<<<< HEAD
    UserMenu menu;
=======
    
>>>>>>> 1731787fe56a679a9d26705143496cc3a577ac1b
    Shelf shelf;
<<<<<<< HEAD
=======
    Cart cart;
    User user;
>>>>>>> 1731787fe56a679a9d26705143496cc3a577ac1b
    /**
     * Constructor for objects of class MFVSController
     */
    public MFVSController()
    {
        listOfUsers = FileManager.readUserInfo("users.txt");
        listOfTransactions = FileManager.readTransactionsInfo("transactions.txt");
        menu = new UserMenu();
        shelf = new Shelf();
<<<<<<< HEAD
=======
        cart = new Cart();
        user = new User();
>>>>>>> 1731787fe56a679a9d26705143496cc3a577ac1b
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
<<<<<<< HEAD
=======
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
            
>>>>>>> 1731787fe56a679a9d26705143496cc3a577ac1b
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
    
<<<<<<< HEAD
    public void logIn()
    {
        
=======
    public void addProductToCart()
    {
        System.out.println("Enter the productID of the product you want to buy");
        Scanner input = new Scanner(System.in);
        String productID = input.nextLine();
    }
    
<<<<<<< HEAD
    
=======
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
>>>>>>> bf19ac81feb774de2835c2ea18319fdbf68db8f0
        
    }
>>>>>>> 1731787fe56a679a9d26705143496cc3a577ac1b

}
