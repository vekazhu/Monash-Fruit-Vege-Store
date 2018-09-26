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
    private ArrayList<Product> listOfProducts;
    private HashMap productQuantity;

    /**
     * Default Constructor for objects of class Shelf
     */
    public Shelf()
    {
        listOfProducts = new ArrayList<Product>();
    }

    /**
     * Non-Default Constructor for objects of class Shelf
     */
    public Shelf(ArrayList<Product> listOfProducts)
    {
        this.listOfProducts = listOfProducts;
    }

    /**
     * get ArrayList of product
     *
     * @return    an arraylist of product
     */
    public ArrayList<Product> getListOfProducts()
    {
        return listOfProducts;
    }

    /**
     * set a new ArrayList of product
     *
     * @param    an arraylist of product
     */
    public void setListOfProduct(ArrayList<Product> listOfProducts)
    {
        this.listOfProducts = listOfProducts;
    }
<<<<<<< HEAD
    
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
=======

    public void sortProductByAlphebet()
    {
        Product temp = new Product();
        for (int i = 0; i < listOfProducts.size(); i++)
        {
            for (int j = i + 1; j < listOfProducts.size(); j++)
            {
                if (listOfProducts.get(i).getProductName().compareTo(listOfProducts.get(j).getProductName())>0)
                {
                    temp = listOfProducts.get(i);
                    listOfProducts.set(i,listOfProducts.get(j));
                    listOfProducts.set(i+1,temp);
                }
            }
        }
    }
    
    public void sortProductByCategory()
    {
        
    }
    
    
>>>>>>> 8b78f801e5f0ea3438ce7e420de39f22a2e3de80
}
