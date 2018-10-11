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
    private ArrayList<Customer> listOfCustomers;
    private ArrayList<Transaction> listOfTransactions;
    private Customer customer;
    private Owner owner;
    private UserMenu menu;
    private User user;
    private Shelf shelf;

    /**
     * Constructor for objects of class MFVSController
     */
    public MFVSController()
    {
        listOfCustomers = FileManager.readCustomerInfo("users.txt");
        listOfTransactions = FileManager.readTransactionsInfo("transactions.txt");
        menu = new UserMenu();
        customer = new Customer();
        user = new User();
        shelf = new Shelf();
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
            user.setUserId(userId);
            if (userId.equals("")){
                break;
            }
            else {
                if(userId.startsWith("c")){

                    String customerOption = "";
                    do
                    {
                        System.out.println("Inside Do.................");
                        Scanner input = new Scanner(System.in);
                        //System.out.print('\u000C');
                        menu.displayCustomerMenu();
        
                        customerOption = input.next();
                        
                        System.out.println("--------------------------------------------------\n\n");
                        getCustomerChoice(customerOption);
                    }
                    while (!customerOption.toLowerCase().equals("f"));

                }
                else {
                    String ownerOption = "";
                    do
                    {
                        
                        Scanner input = new Scanner(System.in);
                        //System.out.println('\u000C');
                        menu.displayOwnerMenu();
                        ownerOption = input.nextLine();
                        System.out.println("--------------------------------------------------\n\n");
                        getOwnerChoice(ownerOption);
                    }
                    while (!ownerOption.toLowerCase().equals("x") | !ownerOption.toLowerCase().equals("f"));
                }

            }

            break;
            case "x":
            System.out.println("See you next time");
            break;
            default:
            System.out.print('\u000C');
            System.out.println("The entered vaule is unrecognized!");break;
        }
    }

    /**
     * Method getCustomerChoice
     *
     * @param option A parameter
     */
    public void getCustomerChoice(String option)
    {
        System.out.println("Inside get customer choice "+option);
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
            searchForProduct();
            break;
            
            case "c":
            System.out.print('\u000C');
            customer.addProductToCart();
            break;
            
            case "d":
            System.out.print('\u000C');
            customer.displayCart();
            break;
            
            case "e":
            System.out.print('\u000C');
            getCustomerTransaction(user.getUserId());
            menu.displayCustomerMenu();
            break;
            
            case "f":
            System.out.print('\u000C');
            logout();
            System.out.println("Logout Successful!!\n Thank you :)\n");
            break;
            
            case "g":
            System.out.print('\u000C');
            customer.unregister();
            System.out.println("You are no longer with MFVS, wish you will come back :)");
            break;
            
            case "x":
            System.out.print('\u000C');
            System.exit(0);
            System.out.println("You have exited the system, see you.");
            break;

            default:
            System.out.print('\u000C');
            System.out.println("The entered vaule is unrecognized!");break;
        }
    }
    
    public void getCartChoice(String option)
    {
        switch (option.toLowerCase())
        {
            case "a":
            System.out.println("-------------------------------------------------------------------");
            customer.checkOut();
            System.out.println("-------------------------------------------------------------------");
            menu.displayCustomerMenu();
            break;

            case "b":
            customer.editProduct();
            break;
            
            case "c":
            menu.displayCustomerMenu();
            break;
            
            case "x":
            System.exit(0);
            System.out.println("You have exited the system, see you.");
            break;
            

            default:
            System.out.print('\u000C');
            System.out.println("The entered vaule is unrecognized!");break;
        }
    }
    
    
    
    public void getOwnerChoice(String option)
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
            searchForProduct();
            break;
            
            case "c":
            System.out.print('\u000C');
            owner.createProduct();
            break;
            
            case "d":
            System.out.print('\u000C');
            owner.updateProduct();
            break;
            
            case "e":
            System.out.print('\u000C');
            displayAllTransactions();
            break;
            
            case "f":
            System.out.print('\u000C');
            logout();
            System.out.println("Logout Successful!!\n Thank you :)\n");
            break;
            
            case "x":
            menu.displayMainMenu();
            break;
            

            default:
            System.out.print('\u000C');
            System.out.println("The entered vaule is unrecognized!");break;
        }
    }

    public void displayAllProducts()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~All Products~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.format("%-13s%-16s%-14s%-13s%-15s%-10s%-13s%n","ProductID","Name","Category","ShelfLife","SellingType","Price","Discount");
        shelf.sortProductByAlphabet();
        shelf.displayProductsInfo(shelf.getListOfProducts());
    }
    
    public void displayProducts(ArrayList<Product> productList)
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Products~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.format("%-13s%-16s%-14s%-13s%-15s%-10s%-13s%n","ProductID","Name","Category","ShelfLife","SellingType","Price","Discount");
        //shelf.sortProductByAlphabet();
        shelf.displayProductsInfo(productList);
    }
    

    public void displayAllTransactions()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~All Transactions~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // String customerID, String customerStatus, String date,double totalPrice
        System.out.format("%-15s%-20s%-15s%-15s%-10s%n","CustomerID","Customer Status","Transaction Date","Total Amount","Rating");
        for (Transaction transaction : listOfTransactions)
        {
            System.out.format("%-15s%-20s%-15s%-15.2f%-10.1f%n",transaction.getCustomerID(),transaction.getCustomerStatus(),
                transaction.getTransactionDate(),transaction.getTotalPrice(),transaction.getRating());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    
    }
    
    public void displayCustomerTransactions(ArrayList<Transaction> listOfTransactions)
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Your Transactions~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // , String date,double totalPrice
        System.out.println("Customer ID: "+listOfTransactions.get(0).getCustomerID()+"\n\n");
        System.out.format("%-20s%-20s%-15s%n","Transaction Date","Total Amount","Your Rating");
        for (Transaction transaction : listOfTransactions)
        {
            System.out.format("%-20s%-20.2f%-15.1f%n",transaction.getTransactionDate(),transaction.getTotalPrice(),transaction.getRating());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    public void displayAllUsers()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~All Users~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // String customerID, String customerStatus, String date,double totalPrice
        System.out.format("%-15s%-20s%-15s%-15s%-10s%n","UserID","Customer Status","Date","Total Price","Rating");
        listOfTransactions = FileManager.readTransactionsInfo("transactions.txt");
        for (Transaction transaction : listOfTransactions)
        {
            System.out.format("%-15s%-20s%-15s%-15.2f%-10.1f%n",transaction.getCustomerID(),transaction.getCustomerStatus(),
                transaction.getTransactionDate(),transaction.getTotalPrice(),transaction.getRating());
        }
    }

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
     * @return The return value
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
     * @return boolean, true if inputed email already exists
     *                  false if inputed email has not been saved before
     */
    public boolean doesEmailExist(String email)
    {
        for (int i = 0; i < listOfCustomers.size(); i++)
        {
            if (listOfCustomers.get(i).getUserEmail().equals(email))
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
     * @return String userEmail, 
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
     * @return String userPhoneNumber
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
     * @return String enteredToken
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
        //sc.close();
        return enteredToken;
    }

    /**
     * generate userId, like"u0001"
     * 
     * @param int i
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
     * Method generateUserName is to generate the unique user name
     *
     * @param firstName A parameter
     * @param userId A parameter
     * @return The userName
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
    
     public void addUser(Customer customer)
    {
        listOfCustomers.add(customer);
    }

    /**
     * Method register
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
        Customer customer = new Customer(userId,userFirstName,userEmail,userPhoneNumber,userPassWord,userSecurityAnswer);
        System.out.println("Registration has been completed! Please log in and continue shopping.");
        addUser(customer);
        updateUserList();
        user.login();
    }
    
    public void updateUserList()
    {
        String content = "";
        for (Customer customer: listOfCustomers)
        {
            if (content.equals(""))
                content = customer.getCustomerInfo();
            else
                content = content + "\n" + customer.getCustomerInfo();
        }
        FileManager.writeFile(content,"users.txt");
    }
    

    public void searchForProduct()
    {
        Scanner input = new Scanner(System.in);
        System.out.print('\u000C');
        System.out.println("Enter the product name to SEARCH");
        String searchName = input.nextLine();
        ArrayList<Product> foundProducts = shelf.findProductByName(searchName);
        System.out.println("Found"+ foundProducts.size() + " "+searchName);
        if(foundProducts.size() == 0)
        {
            System.out.println("SORRY!! "+searchName + " are unavailable.\n");
        }
        else{
            displayProducts(foundProducts);
        }
    }
    
    public void getCustomerTransaction(String userId){
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
    
    public void logout(){
        user = new User();
    }
    

}
