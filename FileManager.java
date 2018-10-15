import java.util.*;
import java.io.*;
/**
 * FileManager class is to read and write file.
 *
 * @author (Team 114)
 * @version (15/OCT/2018)
 */
public class FileManager
{
    /**
     * Default constructor for objects of class FileController
     */
    public FileManager()
     {

     }

    
    /**
     * Method readProductsInfo is to read information of all products in the MFVS and build an Arraylist of products 
     *
     * @param fileName, the name of the text file the method reads from
     * @return ArrayList<Product>: listOfProducts, the Arraylist of products in MFVS
     */
    public static ArrayList<Product> readProductsInfo(String fileName)
    {
        ArrayList<Product> listOfProducts = new ArrayList<Product>();
        try
        {
            FileReader inputFile = new FileReader(fileName);
            try
            {
                Scanner parser = new Scanner(inputFile);
                while(parser.hasNextLine())
                {
                    String str = parser.nextLine();
                    String[] parts = str.split(",");
                    //System.out.println(parts.length);
                    String productID = parts[0];
                    String productName = parts[1];
                    String category = parts[2];
                    String shelfLife = parts[3];
                    double priceKG = Double.parseDouble(parts[5]);
                    double priceWhole = Double.parseDouble(parts[4]);
                    double quantityKG = Double.parseDouble(parts[6]);
                    double quantityWhole = Double.parseDouble(parts[7]);
                    int discount = Integer.parseInt(parts[8]);
                    String productDate = parts[9];
                    Product product = new Product(productID,productName,category,shelfLife,priceWhole,priceKG,quantityKG,quantityWhole,discount,productDate);
                    listOfProducts.add(product);
                }
            }
            finally
            {
                inputFile.close();
            }
        }
        catch(FileNotFoundException exception)
        {    
            System.out.println(fileName + " not found.");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O exception occurs.");
        }
        return listOfProducts;
    }

    
    /**
     * Method writeFile is to write the content of an Arraylist of String to a text file
     *
     * @param content: the Arraylist of String we are going to write to the text file
     * @param fileName: the name of the text file the method writes to
     */
    public static void writeFile(ArrayList<String> content,String fileName)
    {
        //String file = fileName;
        try
        {
            BufferedWriter outputFile;
            outputFile = new BufferedWriter(new FileWriter(fileName, true));
            
            
            for(String str: content){
                outputFile.write(str);
                outputFile.newLine();
            }
            outputFile.close();
        }
        
        
        catch(IOException e)
        {
            System.out.println("Unexpected I/O exception occurs.");
        }
    }

    /**
     * Method readTransactionsInfo is to read information of all transactions commenced and build an Arraylist of transcation 
     *
     * @param fileName, the name of the text file the method reads from
     * @return ArrayList<Transaction>: listOfTransactions, the Arraylist of transactions commenced
     */
    public static ArrayList<Transaction> readTransactionsInfo(String fileName)
    {
        ArrayList<Transaction> listOfTransactions = new ArrayList<Transaction> ();
        try
        {
            FileReader inputFile = new FileReader(fileName);
            try
            {
                Scanner parser = new Scanner(inputFile);
                while(parser.hasNextLine())
                {
                    String str = parser.nextLine();
                    String[] parts = str.split(",");

                    String customerID = parts[0];
                    String customerStatus = parts[1];
                    String date = parts[2];
                    double totalPrice = Double.parseDouble(parts[3]);
                    double rating = Double.parseDouble(parts[4]);
                    Transaction transaction = new Transaction(customerID,customerStatus,date,totalPrice,rating);
                    listOfTransactions.add(transaction);
                }
            }
            finally
            {
                inputFile.close();
            }
        }
        catch(FileNotFoundException exception)
        {    
            System.out.println(fileName + " not found.");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O exception occurs.");
        }
        return listOfTransactions;
    }
   
    /**
     * Method readUserInfo is to read information of all registered users and build an Arraylist of user 
     *
     * @param fileName, the name of the text file the method reads from
     * @return ArrayList<User>: listOfUsers, the Arraylist of all registered users of MFVS
     */
    public static ArrayList<User> readUserInfo(String fileName)
    {
        ArrayList<User> listOfUsers = new ArrayList<User> ();
        try
        {
            FileReader inputFile = new FileReader(fileName);
            try
            {
                Scanner parser = new Scanner(inputFile);
                while(parser.hasNextLine())
                {
                    String str = parser.nextLine();
                    String[] parts = str.split(",");
                    String userID = parts[0];
                    String userName = parts[1];
                    String userEmail = parts[2];
                    String userPhoneNumber = parts[3];
                    String userPassword = parts[4];
                    String securityAnswer = parts[5];
                    User user = new User(userID, userName,userEmail,userPhoneNumber,userPassword, securityAnswer);
                    listOfUsers.add(user);
                }
            }
            finally
            {
                inputFile.close();
            }
        }
        catch(FileNotFoundException exception)
        {    
            System.out.println(fileName + " not found.");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O exception occurs.");
        }
        return listOfUsers;
    }    
}
