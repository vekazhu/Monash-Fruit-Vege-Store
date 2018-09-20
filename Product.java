
/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    // instance variables - replace the example below with your own
    private String productID;
    private String productName;
    private String shelfLife;
    private double price;
    private String category;
    private String sellingType;

    /**
     * Constructor for objects of class Product
     */
    public Product()
    {
        productID="";
        productName="";
        shelfLife="";
        price=0;
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getProductID()
    {
        // put your code here
        return productID;
    }
}
