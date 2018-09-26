import java.util.*;
/**
 * Write a description of class Shelf here.
 *
 * @author (Team 114)
 * @version (a version number or a date)
 */
public class Shelf
{
    // instance variables - replace the example below with your own
    private ArrayList<Product> listOfProduct;
    private HashMap productQuantity;

    /**
     * Default Constructor for objects of class Shelf
     */
    public Shelf()
    {
        listOfProduct = new ArrayList<Product>();
    }
    
    /**
     * Non-Default Constructor for objects of class Shelf
     */
    public Shelf(ArrayList<Product> listOfProduct)
    {
        this.listOfProduct = listOfProduct;
    }

    /**
     * get ArrayList of product
     *
     * @return    an arraylist of product
     */
    public ArrayList<Product> getListOfProduct()
    {
        return listOfProduct;
    }
    
    /**
     * set a new ArrayList of product
     *
     * @param    an arraylist of product
     */
    public void setListOfProduct(ArrayList<Product> listOfProduct)
    {
        this.listOfProduct = listOfProduct;
    }
    
    public void addProductToShelf()
    {
        Product newProduct = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the product name.");
        String productName = scanner.next();
        System.out.println("Please choose the product category.");
        //choose from categoryMenu();
        System.out.println("Please enter the product shelflife.");
        String shelfLife = scanner.next();
        System.out.println("Please choose two from the three product selling types.");
        //choose from typeMenu();
        System.out.println("Please enter the product price.");
        String price = scanner.next();
        //validation of price.isDigit();
        double productPrice = Double.parseDouble(price);
        System.out.println("Please enter the product discount.");
        String discount = scanner.next();
        //validation of discount.isInt;
        int productDiscount = Integer.parseInt(discount);
        String productID = "productName" + "1";
    }
}
