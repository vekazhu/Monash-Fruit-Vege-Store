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
    Cart cart;
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
        cart = new Cart();
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
            System.out.println("--------------------------------------------------\n\n");
            getChoice(option);
        }
        while (!option.toLowerCase().equals("x"));

    }

    public void getChoice(String option)
    {
        switch (option.toLowerCase())
        {
            case "a":
            System.out.print('\u000C');
            System.out.println("-------------------------------------------------------------------");
            displayAllProducts();
            System.out.println("-------------------------------------------------------------------");

            break;
            
            case "b":
            System.out.print('\u000C');
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
                if (userId.equals("")){
                    break;
                }
                else {
                    if(userId.startsWith("c")){
                    
                        String customerOption = "";
                        do
                        {
                            Scanner input = new Scanner(System.in);
                            menu.displayCustomerMenu();
                            customerOption = input.nextLine();
                            System.out.println("--------------------------------------------------\n\n");
                            getCustomerChoice(customerOption);
                        }
                        while (!customerOption.toLowerCase().equals("x"));
                        
                    }
                    else {
                        //System.out.println("Owner Logged In");
                        menu.displayOwnerMenu();
                    }
                }
            
            break;
            case "x":
            System.out.println("See you next time");
            default:
            System.out.print('\u000C');
            System.out.println("The entered vaule is unrecognized!");break;
        }
    }

    public void getCustomerChoice(String option)
    {
        switch (option.toLowerCase())
        {
            case "a":
            System.out.print('\u000C');
            System.out.println("-------------------------------------------------------------------");
            displayAllProducts();
            System.out.println("-------------------------------------------------------------------");
            break;
            
            case "b":
            System.out.print('\u000C');
            break;
            
            default:
            System.out.print('\u000C');
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
    
    public void displayAllTransactions()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~All Transactions~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //double rating, String customerID, String customerStatus, String date,double totalPrice
        System.out.format("%-15s%-10s%-13s%-15s%-10s%-10s%-13s%n","Rating","Name","Category","ShelfLife","SellingType","Price","Discount");
        shelf.sortProductByAlphabet();
        shelf.displayProductsInfo(shelf.getListOfProducts());
    }

    public void addProductToCart()
    {
        System.out.println("Enter the productID of the product you want to buy");
        Scanner input = new Scanner(System.in);
        String productID = input.nextLine();  //no validation
        
    }
    
<<<<<<< HEAD
    public String nameScanner()
    {
        System.out.println("Please enter your first Name between 3-20 letters and only letters are allowed.");
        Scanner sc = new Scanner(System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isFirstNameValid(enteredToken) == false)
        {
            System.out.println("Please renter your first name.");
            enteredToken = sc.next().trim();
        }
        System.out.println("Your first name is " + enteredToken + ".");
        String firstName = enteredToken;
        sc.close();
        return firstName;
    }
=======
    

>>>>>>> 4b3ba06296e0e7bd039c8eeb2eb9075a8e88989e
    
    
     public String passwordScanner()
    {
        System.out.println("Please set your password between 4 and 15 with at least one uppercase and one lowercase letters, but no special characters are allowed.");
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isPasswordValid(enteredToken) == false)
        {
            System.out.println("Please renter your password between 4 and 15 with at least one uppercase and one lowercase letters, but no special characters are allowed.");
            enteredToken = sc.next().trim();
        }       
        System.out.println("Your password has been set successfully.");
        String passWord = enteredToken;
        sc.close(); 
        return passWord;
    }
    
    public boolean doesEmailExist(String email)
    {
        for (int i = 0; i < listOfUsers.size(); i++)
        {
            if (listOfUsers.get(i).getUserEmail().equals(email))
            {
                System.out.println("This email already exists, please enter another one.");
                return true;
            }
        }
        return false;
    }
    
    public String emailScanner()
    {
        System.out.println("Please enter your email address.");
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isEmailValid(enteredToken) == false || doesEmailExist(enteredToken) == true)
        {
            enteredToken = sc.next().trim();
        }
        System.out.println("Your email address is " + enteredToken + ".");
        String userEmail = enteredToken;
        sc.close();
        return userEmail;
    }
    
    public String phoneNumberScanner()
    {
        System.out.println("Please enter your 10 digits phone number begins with 04.");
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isPhoneNumberValid(enteredToken) == false)
        {
            enteredToken = sc.next().trim();
        }
        System.out.println("You phone number is " + enteredToken + ".");
        String userPhoneNumber = enteredToken;
        sc.close();            
        return userPhoneNumber;
    }
    
    public String securityAnswerScanner()
    {
        System.out.println("Now we are going to ask you a security question.");
        System.out.println("Your answer will be saved and used when you enter your password incorrecly 3 times at login.");
        System.out.println("Please make sure you will remember the answer of the security question.");
        System.out.println("Security Question: Who is your favourite singer?");
        Scanner sc = new Scanner (System.in);
        String securityAnswer = sc.next().trim();
        System.out.println("Your answer is " + securityAnswer + ".");
        sc.close();
        return securityAnswer;
    }
    
    /**
     * generate userId, like"u0001"
     */
    public String generateUserId(int i)
    {
        String newUserId = "";
        if (String.valueOf(i+1).length() == 1)
            newUserId = "c000" + (i+1);
        if (String.valueOf(i+1).length() == 2)
            newUserId = "c00" + (i+1);
        if (String.valueOf(i+1).length() == 3)
            newUserId = "c0" + (i+1);
        if (String.valueOf(i+1).length() == 4)
            newUserId = "c" + (i+1);   
        System.out.println("Your userID is " + newUserId + ".");
        return newUserId;
    }
    
    public String generateUserName(String firstName, String userId)
    {
        String userName = "";
        String firstThreeLetter = firstName.substring(0, 3);
        String lastThreeNumber = userId.substring(userId.length()-3);
        userName = firstThreeLetter + lastThreeNumber;
        System.out.println("Your username is " + userName + ".");
        return userName;    
    }
    
    public void register()
    {
        System.out.println("Welcome to join Monash Fruit and Vege Store, please follow the registration instructions :)");
        nameScanner();
        String userFirstName = nameScanner();
        System.out.println("___________________________________________________________________________________");
        passwordScanner();
        String userPassWord = passwordScanner();
        System.out.println("___________________________________________________________________________________");
        emailScanner();
        System.out.println("___________________________________________________________________________________");
        phoneNumberScanner();
        System.out.println("___________________________________________________________________________________");
        securityAnswerScanner();
        System.out.println("___________________________________________________________________________________");
        generateUserId(user.getUserNumber());
        String userId = generateUserId(user.getUserNumber());
        System.out.println("___________________________________________________________________________________");
        generateUserName(userFirstName, userId);
    }
    
}
