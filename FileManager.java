import java.util.*;
import java.io.*;
/**
 * A class is to read and write file.
 *
 * @author (your name)
 * @version (a version number or a date)
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
     * A method is to read all lines in a file.
     *
     * @param a String: the file name
     * @return an arrayList: an arrayList that include team info
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
                    System.out.println(parts.length);
                    String productID = parts[0];
                    String productName = parts[1];
                    String category = parts[2];
                    String shelfLife = parts[3];
                    double priceKG = Double.parseDouble(parts[4]);
                    double priceWhole = Double.parseDouble(parts[5]);
                    double quantityKG = Double.parseDouble(parts[6]);
                    double quantityWhole = Double.parseDouble(parts[7]);
                    int discount = Integer.parseInt(parts[8]);
                    Product product = new Product(productID,productName,category,shelfLife,priceWhole,priceKG,quantityKG,quantityWhole,discount);
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
     * A method is to write all the lines in a new file.
     *
     * @param a String: contents
     */
    public static void writeFile(String content,String fileName)
    {
        String file = fileName;
        try
        {
            PrintWriter outputFile = new PrintWriter(fileName);
            outputFile.println(content);
            outputFile.close();
        }
        catch(IOException e)
        {
            System.out.println("Unexpected I/O exception occurs.");
        }
    }

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
