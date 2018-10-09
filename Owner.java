import java.util.*;
/**
 * Owner class stores the information of the default MFVSowner and the method will
 * be used by the owner
 * 
 * super("o0000","owner","MFVowner@gmail.com","01234567","Mfvs")
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Owner extends User
{
    private Shelf shelf;
    /**
     * Constructor for objects of class Owner
     */
    public Owner()
    {
        shelf = new Shelf();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String productNameScanner()
    {
        System.out.println("Please enter the name of the new product.");
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isFirstNameValid(enteredToken) == false)
        {
            enteredToken = sc.next().trim();
        }
        System.out.println("The name of new product is " + enteredToken + ".");
        String newProductName = enteredToken;
        sc.close();
        return newProductName;
    }
    
    public String shelfLifeScanner()
    {
        System.out.println("Please enter the shelf life (in weeks) of the new product, only integers are allowed.");
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isInt(enteredToken) == false)
        {
            System.out.println("Please enter integers only.");
            enteredToken = sc.next().trim();
        }
        System.out.println("Product life is " + enteredToken + " weeks.");
        String newProductShelfLife = enteredToken;
        sc.close();
        return newProductShelfLife;
    }
    
    public String priceScanner()
    {
        System.out.println("Please enter the price per KG of the new product, only numbers are allowed.");
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isDouble(enteredToken) == false)
        {
            System.out.println("Please enter numbers only.");
            enteredToken = sc.next().trim();
        }
        System.out.println("Price per KG is " + enteredToken + ".");
        String newProductShelfLife = enteredToken;
        sc.close();
        return newProductShelfLife;
    }
    
    public int discountScanner()
    {
        System.out.println("Please enter the discount (e.g. 20 means 20% off) of the new product, only integers are allowed.");
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isInt(enteredToken) == false)
        {
            System.out.println("Please enter integers only.");
            enteredToken = sc.next().trim();
        }
        System.out.println("Product discount is " + enteredToken + "% off.");
        int newProductDiscount = Integer.parseInt(enteredToken);
        sc.close();
        return newProductDiscount;
    }
    
    
    
    
        
    
    
    
    
   
}
