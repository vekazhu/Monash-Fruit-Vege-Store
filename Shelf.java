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
    public void setListOfProduct(ArrayList<Product> listOfProduc)
    {
        this.listOfProduct = listOfProduct;
    }
}
