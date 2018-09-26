import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Write a description of class Cart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cart
{
    // instance variables - replace the example below with your own
    private ArrayList<String> productList; // productID + amount
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    /**
     * Constructor for objects of class Cart
     */
    public Cart()
    {
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void sampleMethod(int y)
    {
        // put your code here
        
    }
    
    public String generateDate()
    {
        LocalDate localDate = LocalDate.now();
        System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate));
        return DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate).toString();
    }
}
