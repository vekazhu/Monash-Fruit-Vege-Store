import java.util.*;
import java.lang.*;

/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer extends User
{
    private String status;
    private Cart cart;
    private Shelf shelf;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String userId,String userName,String userEmail,String userPhoneNumber,
    String userPassword,String securityAnswer)
    {
        super(userId,userName,userEmail,userPhoneNumber,userPassword,securityAnswer);
        status = "active";
        cart = new Cart();
        shelf = new Shelf();
    }

    public Customer()
    {
        super();
        status = "active";
        cart = new Cart();
        shelf = new Shelf();
    }

    /**
     */
    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void deleteProductFromCart()
    {
        System.out.println("Enter the productID of the product you want to delete");
        String productID = getProductIdAleadyInCart();
        System.out.println("Are you sure you want to delete this ?(y/n)");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if (answer.startsWith("y"))
            cart.deleteProductInCart(productID);
        else
            cart.displayCart();
    }
    
    public String getProductIdAleadyInCart()
    {
        Scanner input = new Scanner(System.in);
        String productID = input.nextLine();
        while (!cart.isProductExistInCart(productID))
        {
            System.out.println("Please enter a valid productID that already in the cart");
            productID = input.nextLine();
        }
        return productID;
    }

    public void addProductToCart()
    {
        System.out.println("Enter the productID of the product you want to buy");
        Scanner input = new Scanner(System.in);
        String productID = input.nextLine();
        while (!shelf.isProductExistInShelf(productID))
        {
            System.out.println("Please enter a valid productID");
            productID = input.nextLine();
        }
        String productName = shelf.findProductById(productID).getProductName();
        double priceKG = shelf.findProductById(productID).getPriceKG();
        double priceWhole = shelf.findProductById(productID).getPriceWhole();
        double quantityWhole = shelf.findProductById(productID).getQuantityWhole();
        double quantityKG = shelf.findProductById(productID).getQuantityKG();
        System.out.println("choose selling type(1/2)");
        System.out.println("1.purchase by each");
        System.out.println("2.purchase by KG");
        int flagKG = 0; // if 'purchase by KG' is chosen, flagKG will become 1
        String choice = input.nextLine().trim();
        while (!choice.equals("1") && !choice.equals("2"))
        {
            System.out.println("Invalid input, please re-enter");
            choice = input.nextLine().trim();
        }
        if (choice.equals("1")) //purchase by each
        {
            System.out.println("There are " + quantityWhole + " left");
        }
        if (choice.equals("2")) //purchase by KG
        {
            flagKG=1;
            System.out.println("There are " + quantityKG + "KG left");
        }
        if (quantityWhole != 0 && quantityKG != 0)
        {    
            System.out.println("How many do you want to purchase?");
            String amount = input.nextLine();
            while (!isAmountValid(amount,flagKG,productID))
            {
                System.out.println("please re-enter the amount");
                amount = input.next().trim();
            }
            // add product to cartInfo in cart
            double onePrice = 0; // the price of one type of product
            double totalPrice = 0; //total price of all products in cart
            String productInfo = "";//including productID + productName + priceKG/priceWhole + amount 
                                    //  + Price(price of one kind of product) like: 5 apples, each one dollar, onePrice = 5 dollors
                                    // + flagKG (if flagKG=1 then selling by KG, otherwise selling by each)
                                    //seperate by ","
            if (flagKG == 0)
            {    
                onePrice = priceWhole * Double.parseDouble(amount);
                productInfo = productID + "," + productName + "," + priceWhole +"/each" + "," + amount + "," + onePrice + flagKG;
                cart.addProductInCart(productInfo);
                totalPrice = totalPrice + onePrice;
            }
            else
            {   
                onePrice = priceKG * Double.parseDouble(amount);
                productInfo = productID + "," + productName + "," + priceKG +"/KG" + "," + amount + "," + onePrice + flagKG;
                cart.addProductInCart(productInfo);
                totalPrice = totalPrice + onePrice;
            }
            cart.setTotalPrice(totalPrice);
            System.out.println("You have added it in the cart~");
        }
        else
            System.out.println("Please choose other products to purchase");
    }

    public boolean isAmountValid(String amount,int flagKG,String productID) //private
    {
        double inventory = 0;
        if (flagKG == 0)
        {
            if (!Validator.isInt(amount))
                return false;
            else
            {
                inventory = shelf.findProductById(productID).getQuantityWhole();
                if (Double.parseDouble(amount) > inventory)
                    return false;
            }
        }
        else
        {
            if (!Validator.isDouble(amount))
                return false;
            else
            {
                inventory = shelf.findProductById(productID).getQuantityKG();
                if (Double.parseDouble(amount) > inventory)
                return false;
            }
        }
        return true;
    }

    public void displayCart()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~Your cart~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.format("%-13s%-16s%-10s%-14s%-10s%n","ProductId","Name","Amount","UnitPrice","Price");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        cart.displayCart();
    }

    public void checkOut()
    {
        if (cart.getCartInfo()!= null )
        {
            displayCart();
            System.out.println("Are you sure you want to checkout? (y/n)");
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            if (answer.toLowerCase().startsWith("y"))
            {
                for (String productInfo : cart.getCartInfo())
                {
                    String[] parts = productInfo.split(",");
                    shelf.reduceInventory(parts[0],Double.parseDouble(parts[3]),Integer.parseInt(parts[5]));
                }
                shelf.updateInventory(); // write updated products info in "products.txt"
                System.out.println("Thank you for shopping at MFVS~");
                double rating = rate();
                String transaction = super.getUserId() + "," + status + "," + cart.generateDate() + "," + cart.getTotalPrice() + "," + rating;
                FileManager.writeFile(transaction,"transactions.txt");
                cart.clearCartInfo();
            }
            else
            {
                displayCart();
            }
        }
        else
            System.out.println("You have nothing in your cart, add products to checkout~");
    }

    public double rate()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("We need your advices, please rate our services");
        System.out.println("1. Very disdatified");
        System.out.println("2. Disatisfied");
        System.out.println("3. Ok");
        System.out.println("4. Satisfied");
        System.out.println("5. Very satisfied");
        System.out.println("Enter your rating(e.g.'5')");
        String rating = input.next().trim();
        while (!Validator.isDouble(rating))
        {
            System.out.println("please re-enter your rating");
            rating = input.next().trim();
        }
        System.out.println("Thanks for you rating, we'll improve our services");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return Double.parseDouble(rating);
    }

    
}
