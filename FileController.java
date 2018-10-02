import java.util.*;
import java.io.*;
/**
 * A class is to read and write file.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileController
{
    /**
     * Default constructor for objects of class FileController
     */
    public FileController()
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
                    String productID = parts[0];
                    String productName = parts[1];
                    String category = parts[2];
                    String shelfLife = parts[3];
                    double priceKG = Double.parseDouble(parts[4]);
                    double priceWhole = Double.parseDouble(parts[5]);
                    int discount = Integer.parseInt(parts[6]);
                    Product product = new Product(productName,category,shelfLife,priceKG,priceWhole,discount);
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
    public static void writeFile(String content)
    {
        String fileName = "statistics.txt";
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
        return listOfTransactions;
    }
    
    
}
