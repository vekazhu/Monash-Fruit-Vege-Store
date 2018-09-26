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
    
    
}
