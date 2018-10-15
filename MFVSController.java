import java.util.*;
import java.io.*;
/**
 * class MFVSController is a controller class of this system of Monash Fruit and Vege Store
 *
 * @author (Team 114)
 * @version (15/OCT/2018)
 */
public class MFVSController
{
    // instance variables - replace the example below with your own
    private ArrayList<User> listOfUsers;
    private ArrayList<Transaction> listOfTransactions;
    private Customer customer;
    private Owner owner;
    private UserMenu menu;
    private User user;
    private Shelf shelf;
    private String userId;

    /**
     * Default constructor for objects of class MFVSController
     */
    public MFVSController()
    {
        listOfUsers = FileManager.readUserInfo("users.txt");
        listOfTransactions = FileManager.readTransactionsInfo("transactions.txt");
        menu = new UserMenu();
        customer = new Customer();
        owner = new Owner();
        user = new User();
        shelf = new Shelf();
    }

    /**
     * Method start is a method to start the system
     *
     */
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
    
    /**
     * Method deleteUserInFiles is to delete the user from the User Arraylist and the user.txt file when customer unregister
     *
     * @param usersList, the Arraylist of registered users of MFVS
     * @param userId, the unique id number of registered users of MFVS
     */
    public void deleteUserInFiles(ArrayList<User> usersList, String userId)
    {
        for (int i = 0; i < listOfUsers.size(); i++)
        {
            if (userId.equals(listOfUsers.get(i).getUserId())) 
                listOfUsers.remove(i);
        }
        //update users.txt file
        updateUserList();
    }
    

    /**
     * Method updateTransactionInFiles is to update the user status to 'inactive' when a registered user is unregistered
     *
     */
    public void updateTransactionInFiles()
    {
        for (int i = 0; i < listOfTransactions.size(); i++)
        {
            if (userId.equals(listOfTransactions.get(i).getCustomerID())) 
                listOfTransactions.get(i).setCustomerStatus("Inactive");
        }
        //update users.txt file
        updateTransactionList();
    }

    /**
     * Method unregister is for registered users to select when they no longer want to register in MFVS
     *
     */    

    public void unregister()
    {
        System.out.println("Are you sure you want to unregister?(y|Y)");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        
        if(answer.toLowerCase().equals("y"))
        {
            updateTransactionInFiles();
            deleteUserInFiles(listOfUsers,user.getUserId());
            user.setUserNumber(user.getUserNumber()-1);
            System.out.println("You are no longer with MFVS now, wish you will come back :)");
        }
        else if(answer.toLowerCase().equals("n"))
        {
            System.out.println("THANK YOU!! For making the right choice :), Your account is ACTIVE");
        }
        else
        {
            System.out.println("Sorry Wrong choice, Your account is not deactivated");
        }
    }
    

    /**
     * Method getChoice, is to get the input option of all users when the maiMenu is displayed
     *
     * @param option, is the option that users input to the system
     */
    public void getChoice(String option)
    {
        switch (option.toLowerCase())
        {
            case "a":
            System.out.print('\u000C');
            displayAllProducts();
            break;

            case "b":
            System.out.print('\u000C');
            userId = user.login();
            user.setUserId(userId);
            if (userId.equals("")){
                break;
            }
            else {
                if(userId.startsWith("c")){

                    String customerOption = "";
                    do
                    {
                        //System.out.println("Inside Do.................");
                        Scanner input = new Scanner(System.in);
                        //System.out.print('\u000C');
                        menu.displayCustomerMenu();
        
                        customerOption = input.next();
                        
                        getCustomerChoice(customerOption);
                    }
                    while (!customerOption.toLowerCase().equals("h") & !customerOption.toLowerCase().equals("i") & !customerOption.toLowerCase().equals("x"));

                }
                else {
                    String ownerOption = "";
                    while (!ownerOption.toLowerCase().equals("h") & !ownerOption.toLowerCase().equals("x"))
                    {
                        
                        Scanner input = new Scanner(System.in);
                        //System.out.println('\u000C');
                        menu.displayOwnerMenu();
                        ownerOption = input.nextLine();
                        getOwnerChoice(ownerOption);
                    }
                }

            }
            break;
            
            case"c":
            System.out.print('\u000C');
            register();
            break;
            
            case "x":
            System.out.print('\u000C');
            System.out.println("See you next time");
            break;
            default:
            System.out.print('\u000C');
            System.out.println("The entered vaule is unrecognized!");break;
        }
    }

    /**
     * Method getCustomerChoice, is to get the input option of all customers when the customerMenu is displayed
     *
     * @param option, is the option that customers input to the system
     */
    public void getCustomerChoice(String option)
    {
        
        switch (option.toLowerCase())
        {
            case "a":
            System.out.print('\u000C');
            displayAllProducts();
            
            break;

            case "b":
            System.out.print('\u000C');
            searchForProduct();
            break;
            
            case "c":
            System.out.print('\u000C');
            displayAllProducts();
            customer.addProductToCart();
            break;
            
            case "d":
            System.out.print('\u000C');
            customer.displayCart();
            break;
            
            case "e":
            System.out.print('\u000C');
            customer.displayCart();
            customer.editProduct();
            break;
            
            case "f":
            System.out.print('\u000C');
            customer.checkOut(user.getUserId());
            break;
            
            case "g":
            System.out.print('\u000C');
            getCustomerTransaction(user.getUserId());
            break;
            
            case "h":
            System.out.print('\u000C');
            logout();
            System.out.println("Logout Successful!!\n Thank you :)\n");
            break;
            
            case "i":
            System.out.print('\u000C');
            unregister();
            logout();
            break;

            case "x":
            System.out.print('\u000C');
            //System.exit(0);
            System.out.println("You have exited the system, see you.");
            break;

            default:
            System.out.print('\u000C');
            System.out.println("The entered vaule is unrecognized!");break;
        }
    }
    
    
    /**
     * Method getOwnerChoice, is to get the input option of the owner when the ownerMenu is displayed
     *
     * @param option, is the option that the owner inputs to the system
     */
    public void getOwnerChoice(String option)
    {
        switch (option.toLowerCase())
        {
            case "a":
            System.out.print('\u000C');
            displayAllProductsForOwner();
            break;

            case "b":
            System.out.print('\u000C');
            searchForProduct();
            break;
            
            case "c":
            System.out.print('\u000C');
            owner.createProduct();
            displayAllProductsForOwner();
            break;
            
            case "d":
            System.out.print('\u000C');
            displayAllProductsForOwner();
            owner.updateProduct();
            break;
            
            case "e":
            System.out.print('\u000C');
            displayAllProductsForOwner();
            owner.disposeProductFromShelf();
            break;
            
            case "f":
            System.out.print('\u000C');
            displayAllTransactions();
            break;
            
            case "g":
            System.out.print('\u000C');
            displayAllUsers();
            break;
            
            case "h":
            System.out.print('\u000C');
            logout();
            System.out.println("Logout Successful!!\n Thank you :)\n");
            break;
            
            case "x":
            System.out.print('\u000C');
            //System.exit(0);
            System.out.println("You have exited the system, see you.");
            break;
            

            default:
            System.out.print('\u000C');
            System.out.println("The entered vaule is unrecognized!");break;
        }
    }

    /**
     * Method displayAllProducts will display all available products in the MFVS in default alphabetical order
     *
     */
    public void displayAllProducts()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~All Products~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.format("%-13s%-16s%-14s%-17s%-15s%-10s%-13s%n","ProductID","Name","Category","ShelfLife(days)","Price/each","Price/KG","Discount");
        shelf.sortProductByAlphabet();
        shelf.displayProductsInfo(shelf.getListOfProducts());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    /**
     * Method displayAllProductsForOwner will display all products in the MFVS for the store owner in default alphabetical order
     *
     */
    public void displayAllProductsForOwner()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~All Products~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.format("%-13s%-16s%-14s%-17s%-15s%-15s%-13s%-15s%-13s%n","ProductID","Name","Category","ShelfLife(days)","Price/each","Quantity/each","Price/KG","Quantity/Kg","Discount");
        shelf.sortProductByAlphabet();
        shelf.displayOwnerProductsInfo(shelf.getListOfProducts());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    /**
     * Method displayProducts will display all available products found according to the search condition inputed by users
     *
     * @param productList, an Arraylist of products that meet the search condition
     */
    public void displayProducts(ArrayList<Product> productList)
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Products~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.format("%-13s%-16s%-14s%-17s%-15s%-10s%-13s%n","ProductID","Name","Category","ShelfLife(days)","Price/each","Price/KG","Discount");
        //shelf.sortProductByAlphabet();
        shelf.displayProductsInfo(productList);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    
    }
    
    /**
     * Method displayAllTransactions will sort all recorded transactions in the MFVS
     *
     */
    public void sortAllTransactions()
    {
        Transaction temp = new Transaction();
        for (int i = 0; i < listOfTransactions.size(); i++)
        {
            for (int j = i + 1; j < listOfTransactions.size(); j++)
            {
                if (listOfTransactions.get(i).getTransactionDate().compareTo(listOfTransactions.get(j).getTransactionDate())>0)
                {
                    temp = listOfTransactions.get(i);
                    listOfTransactions.set(i,listOfTransactions.get(j));
                    listOfTransactions.set(i+1,temp);
                }
            }
        }
    }

    /**
     * Method displayAllTransactions will display all recorded transactions in the MFVS for the store owner to view
     *
     */
    public void displayAllTransactions()
    {
        sortAllTransactions();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~All Transactions~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.format("%-15s%-20s%-20s%-20s%-10s%n","CustomerID","Customer Status","Transaction Date","Total Amount","Rating");
        for (Transaction transaction : listOfTransactions)
        {
            System.out.format("%-15s%-20s%-20s%-20.2f%-10.1f%n",transaction.getCustomerID(),transaction.getCustomerStatus(),
                transaction.getTransactionDate(),transaction.getTotalPrice(),transaction.getRating());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    /**
     * Method displayCustomerTransactions will display all recorded transactions of the current logged in customer for this customer
     * to view
     *
     * @param listOfTransactions, an Arraylist of transcation of this current logged in customer
     */
    public void displayCustomerTransactions(ArrayList<Transaction> listOfTransactions)
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Your Transactions~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Customer ID: "+listOfTransactions.get(0).getCustomerID());
        System.out.format("%-20s%-20s%-15s%n","Transaction Date","Total Amount","Your Rating");
        for (Transaction transaction : listOfTransactions)
        {
            System.out.format("%-20s%-20.2f%-15.1f%n",transaction.getTransactionDate(),transaction.getTotalPrice(),transaction.getRating());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    /**
     * Method displayAllUsers will display all registered users in the MFVS for the store owner to view
     *
     */
    public void displayAllUsers()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~All Users~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.format("%-15s%-20s%-30s%-15s%n","CustomerID","Customer Name","Email","Phone Number");
        listOfUsers = FileManager.readUserInfo("users.txt");
        for (User customer : listOfUsers)
        {
            if(customer.getUserId().startsWith("c"))
                System.out.format("%-15s%-20s%-30s%-15s%n",customer.getUserId(),customer.getUserName(),
                    customer.getUserEmail(),customer.getUserPhoneNumber());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    
    }

    /**
     * Method nameScanner is to scan the input of user firstname
     *
     * @return String: firstName, the firstname inputed by the user
     */
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

    /**
     * Method passwordScanner is to scan the input of user password
     *
     * @return String: passWord, the password inputed by the user
     */
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

    /**
     * Method doesEmailExist is to validate the existence of inputed email address
     *
     * @param String email,the inputed email address
     * @return boolean, true if inputed email does exist
     *                  false if inputed email does not exist
     */
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

    /**
     * Method emailScanner is to scan the input of user email address
     *
     * @return String: userEmail, the email inputed by the user
     */
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

    /**
     * Method phoneNumberScanner is to scan the input of user phone number
     *
     * @return String: userPhoneNumber, the phone number inputed by the user
     */
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

    /**
     * Method securityAnswerScanner is to scan theinput of user sercurity answer
     * of security question
     *
     * @return String: enteredToken, the sercurity answer inputed by the user
     */
    public String securityAnswerScanner()
    {
        System.out.println("Now we are going to ask you a security question.");
        System.out.println("Your answer will be saved and used when you enter your password incorrecly 3 times at login.");
        System.out.println("Please make sure you will remember the answer of the security question.");
        System.out.println("Security Question: Who is your favourite singer?");
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        System.out.println("Your answer is " + enteredToken + ".");
        //String securityAnswer = enteredToken;
        sc.close();
        return enteredToken;
    }

    /**
     * Method generateUserId is to generate userId, like"c0001" for new registered users and it's unique for each user.
     * It starts with 'o' for the store owner (but there is only one owner), and starts with 'c' for customers.                  
     * 
     * @param int i is the current user number of the system
     * @return String: newUserId, the user ID of the new registered user
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

    /**
     * Method generateUserName is to generate the unique user name based on the user ID and the firstname of the user
     *
     * @param firstName, the firstname of the user
     * @param userId, the user ID of the user
     * @return String: userName, the generated user name for the new registered user
     */
    public String generateUserName(String firstName, String userId)
    {
        String userName = "";
        String firstThreeLetter = firstName.substring(0, 3);
        String lastThreeNumber = userId.substring(userId.length()-3);
        userName = firstThreeLetter + lastThreeNumber;
        System.out.println("Your username is " + userName + ".");
        return userName;    
    }
    
     /**
      * Method addUser is to add the new registered user into the Arraylist of the registered users of the MFVS
      *
      * @param user, the new registered user of the MFVS
      */
     public void addUser(User user)
    {
        listOfUsers.add(user);
    }

    /**
     * Method register is to create a new registered user of the MFVS 
     *
     */
    public void register()
    {
        System.out.println("Welcome to join Monash Fruit and Vege Store, please follow the registration instructions :)");
        String userFirstName = nameScanner();
        System.out.println("___________________________________________________________________________________");
        
        String userPassWord = passwordScanner();
        
        System.out.println("___________________________________________________________________________________");
        
        String userEmail = emailScanner();
        
        System.out.println("___________________________________________________________________________________");
        
        String userPhoneNumber = phoneNumberScanner();
        
        System.out.println("___________________________________________________________________________________");
        
        String userSecurityAnswer = securityAnswerScanner();
        
        System.out.println("___________________________________________________________________________________");
        
        String userId = generateUserId(user.getUserNumber());
        
        System.out.println("___________________________________________________________________________________");
        
        String userName = generateUserName(userFirstName, userId);
        user.setUserName(userName);
        User user = new User(userId,userFirstName,userEmail,userPhoneNumber,userPassWord,userSecurityAnswer);
        System.out.println("Registration has been completed! Please log in and continue shopping.");
        addUser(user);
        updateUserList();
        //user.login();
    }
    
    /**
     * Method updateUserList is to update the users.txt file of registered users of the MFVS when there is a new registered user
     * has been added into the Arraylist of registered users of MFVS
     *
     */
    public void updateUserList()
    {
        ArrayList<String> content = new ArrayList<String>();
        for (User user: listOfUsers)
        {
            content.add(user.getUserInfo());
        }
        File f = new File("users.txt");
        if (f.exists())
        {
          //delete if exists
           f.delete();
        }
        FileManager.writeFile(content,"users.txt");
    }
    
    /**
     * Method updateTransactionList is to update the user text file when a registered user is unregistered
     *
     */


    /**
     * Method searchForProduct is to search products by product name in the store
     *
     */


    public void updateTransactionList()
    {
        ArrayList<String> content = new ArrayList<String>();
        for (Transaction transaction: listOfTransactions)
        {
            content.add(transaction.getTransactionInfo());
        }
        File f = new File("transactions.txt");
        if (f.exists())
        {
          //delete if exists
           f.delete();
        }
        FileManager.writeFile(content,"transactions.txt");
    }



    /**
     * Method searchForProduct is to search products by product name in the store
     *
     */

    public void searchForProduct()
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Product> foundProducts = new ArrayList<Product>();
        System.out.print('\u000C');
        menu.displaySearchMenu();
        String searchType = (input.nextLine());
        
        switch (searchType.toLowerCase())
        {
            case "a":
            System.out.println("Enter the product name to SEARCH");
            String searchName = input.nextLine();
            foundProducts = shelf.findProductByName(searchName);
            System.out.println("Found "+ foundProducts.size() + " "+searchName);
            if(foundProducts.size() == 0)
            {
                System.out.println("SORRY!! the product is  unavailable.\n");
            }
            else{
                displayProducts(foundProducts);
            }
            break;

            case "b":
            System.out.println("Enter the product name to SEARCH");
            String searchCategory = input.nextLine();
            foundProducts = shelf.findProductByCategory(searchCategory);
            System.out.println("Found "+ foundProducts.size() + " "+searchCategory);
            if(foundProducts.size() == 0)
            {
                System.out.println("SORRY!! the product is  unavailable.\n");
            }
            else{
                displayProducts(foundProducts);
            }
            break;
           
            default:
            System.out.print('\u000C');
            System.out.println("The entered vaule is unrecognized!");break;
        }
                        
    }
    
    /**
     * Method getCustomerTransaction is to display the transaction of one customer for the store owner according to the 
     * user ID inputed by the owner
     *
     * @param userId, is the user ID inputed by the owner
     */
    public void getCustomerTransaction(String userId)
    {
        listOfTransactions = FileManager.readTransactionsInfo("transactions.txt");
        ArrayList<Transaction> customerTransactionList = new ArrayList<Transaction>() ;
        if (listOfTransactions.size() !=0)
        {
            for (Transaction transaction : listOfTransactions) {
                if (userId.equalsIgnoreCase(transaction.getCustomerID()))
                {
                    customerTransactionList.add(transaction);
                }     
            }
        }
        if(customerTransactionList.size() == 0) {
            System.out.println("You havent made any transactions yet.\n ");
        }
        else {
            displayCustomerTransactions(customerTransactionList);
        }       
    }
    
    /**
     * Method logout is for the logged in user to log out the system
     *
     */
    public void logout(){
        user = new User();
    }
    

}
