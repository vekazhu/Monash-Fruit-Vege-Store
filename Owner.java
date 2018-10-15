import java.util.*;
/**
 * Owner class stores the information of the default MFVSowner and the method will
 * be used by the owner
 * 
 * super("o0000","owner","MFVowner@gmail.com","01234567","Mfvs")
 *
 * @author (Team 114)
 * @version (15/OCT/2018)
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
     * Method productNameScanner is to save the owner input of name of the product will be created
     *
     * @return String: newProductName, the name of the product will be created
     */
    public String productNameScanner()
    {
        System.out.println("Please enter the name of the new product.");
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isFirstNameValid(enteredToken) == false || shelf.doesProductExist(enteredToken)==true)
        {
            enteredToken = sc.next().trim();
        }
        System.out.println("The name of new product is " + enteredToken + ".");
        String newProductName = enteredToken;
        sc.close();
        return newProductName;
    }
    
    /**
     * Method quantityWholeScanner is to save the owner input of how much of this product as a whole will be created
     *
     * @return double: quantityWhole, how much of this product as a whole will be created
     */
    public double quantityWholeScanner()
    {
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isInt(enteredToken) == false)
        {
            System.out.println("Please enter integers only.");
            enteredToken = sc.next().trim();
        }
        double quantityWhole = Double.parseDouble(enteredToken);
        sc.close();
        return quantityWhole;    
    }
    
    /**
     * Method shelfLifeScanner is to save the owner input of shelflife of the product will be created
     *
     * @return String: newProductShelfLife, shelflife of the product will be created
     */
    public String shelfLifeScanner()
    {
        System.out.println("Please enter a number for the shelf life (in days) of the new product, only integers are allowed.");
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isInt(enteredToken) == false)
        {
            System.out.println("Invalid input, please enter again.");
            enteredToken = sc.next().trim();
        }
        System.out.println("Product life is " + enteredToken + " days.");
        String newProductShelfLife = enteredToken;
        sc.close();
        return newProductShelfLife;
    }
    
    /**
     * Method doubleInputScanner is to save the owner input of datatype 'double'
     *
     * @return double: newProductPrice, price selling as a whole and price per KG of the product will be created
     */
    public double doubleInputScanner()
    {
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isDouble(enteredToken) == false)
        {
            System.out.println("Please enter numbers only.");
            enteredToken = sc.next().trim();
        }
        double newProductPrice = Double.parseDouble(enteredToken);
        sc.close();
        return newProductPrice;
    }
    
    /**
     * Method intInputScanner is to save the owner input of datatype 'int'
     *
     * @return int: newProductDiscount, discount of the product will be created
     */
    public int intInputScanner()
    {
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        while (Validator.isInt(enteredToken) == false)
        {
            System.out.println("Please enter integers only.");
            enteredToken = sc.next().trim();
        }
        int newProductDiscount = Integer.parseInt(enteredToken);
        sc.close();
        return newProductDiscount;
    }
       
    /**
     * Method productCategoryScanner is to save the owner input of category of the product will be created
     *
     * @return String: productCategory, category of the product will be created
     */
    public String productCategoryScanner()
    {
        System.out.println("Please select the product category from the menu:");
        System.out.println("1. fruit");
        System.out.println("2. vegetable");
        Scanner sc = new Scanner (System.in);
        String enteredToken = sc.next().trim();
        String productCategory = "";
        while (!enteredToken.equals("1") && !enteredToken.equals("2"))
        {
            System.out.println("Invalid input, please re-enter");
            enteredToken = sc.nextLine().trim();
        }
        if (Integer.parseInt(enteredToken) == 1)
        {
            productCategory = "fruit"; 
            System.out.println("This is categorised as " + productCategory + ".");
        }
        if (Integer.parseInt(enteredToken) == 2)
        {
            productCategory = "vegetable"; 
            System.out.println("This is categorised as " + productCategory + ".");
        }
        sc.close();
        return productCategory;
    }
 
    /**
     * Method createProduct is for owner to create a new product and add the new product to the Arraylist of the products in the
     * MFVS
     *
     */
    public void createProduct()
    {
        
        String newProductName = productNameScanner(); 
        System.out.println("________________________________________________________________________________________________");
        
        String newProductCategory = productCategoryScanner();
        System.out.println("________________________________________________________________________________________________");
        
        String newProductShelfLife = shelfLifeScanner();        
        System.out.println("________________________________________________________________________________________________");
        
        System.out.println("Please enter the price for selling it per KG.");
        double priceKG = doubleInputScanner();
        System.out.println("Price per KG is $" + priceKG + ".");        
        System.out.println("________________________________________________________________________________________________");
        
        System.out.println("Please enter the total KG of this product.");
        double quantityKG = doubleInputScanner();
        System.out.println("There are total " + quantityKG + "KG of this product.");
        System.out.println("________________________________________________________________________________________________");
        
        System.out.println("Please enter the price for selling it as a whole.");
        double priceWhole = doubleInputScanner();
        System.out.println("Price as a whole is $" + priceWhole + ".");
        System.out.println("________________________________________________________________________________________________");
        
        System.out.println("Please enter the total quantity of this product.");
        double quantityWhole = quantityWholeScanner();
        System.out.println("There are total " + quantityWhole + " this product.");
        System.out.println("________________________________________________________________________________________________");
        
        System.out.println("Please enter the discount (e.g. 20 means 20% off) of the new product, only integers are allowed.");
        int productDiscount = intInputScanner();
        System.out.println("The discount for the product is " + productDiscount + "% off.");
        System.out.println("________________________________________________________________________________________________");
        
        Product product = new Product(newProductName,newProductCategory,newProductShelfLife, priceWhole, 
        priceKG, quantityKG, quantityWhole, productDiscount);         
        System.out.println("The new product ID is " + product.getProductID() + ".");
        
        shelf.addProduct(product);
        shelf.updateInventory();      
    }
       
    /**
     * Method disposeProductFromShelf is for owner to dispose expired product or any products to the charity or bin
     *
     */
    public void disposeProductFromShelf()
    {
        System.out.println("Enter the productID of the product you want to disposal: ");
        String productID = shelf.getProductIdAleadyInShelf();
        System.out.println("Are you sure you want to disposal this product?(y/n)");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if (answer.startsWith("y"))
        {
            shelf.deleteProductInShelf(productID);
            System.out.println("Choose disposal way");
            System.out.println("1.Charity");
            System.out.println("2.Rubbish bin");
            String choice = input.nextLine();
            while (!choice.equals("1") && !choice.equals("2"))
            {
                System.out.println("Invalid input, please re-enter");
                choice = input.nextLine().trim();
            }
            if (choice.equals("1"))
            {
                System.out.println("Thank You for your kind heart!!");
            }
            if (choice.equals("2"))
            {
                System.out.println("The product will be put in rubbish bin");
            }
            shelf.deleteProductInShelf(productID);
            shelf.updateInventory();
        }
        else
        {
            shelf.displayProductsInfo();
        }        
    }
    
    /**
     * Method updateProduct is for owner to edit products in MFVS, and change their product information
     *
     */
    public void updateProduct()
    {
        int flag = 0;
        System.out.println("Please enter the ID of the product you want to update: ");
        Scanner scan = new Scanner (System.in);
        String id = scan.nextLine();
        ArrayList<Product> updatedProduct = new ArrayList<Product>();
        int tryAgainFlag = 0;
        for(int i = 0; i < shelf.getListOfProducts().size(); i++)
        {
            if(shelf.getListOfProducts().get(i).getProductID().equals(id))
            {
                flag = 1;
                Product product = shelf.getListOfProducts().get(i);
                while(tryAgainFlag == 0) 
                {  
                    System.out.println("What attribute you want to change about this product: ");
                    System.out.println("1. Name");
                    System.out.println("2. Shelf life");
                    System.out.println("3. Price per KG");
                    System.out.println("4. Price per whole");
                    System.out.println("5. Discount");
                    System.out.println("6. Quantity per KG");
                    System.out.println("7. Quantity per whole");
                    String option = scan.nextLine();
                    switch (option)
                    {
                        case "1":
                        System.out.println("Please enter a new name for this product: ");
                        String name = scan.nextLine();
                        product.setProductName(name);
                        break;
                        
                        case "2":
                        System.out.println("Please enter a new shelf life for this product: ");
                        product.setShelfLife(scan.nextLine());
                        break;
                        
                        case "3":
                        System.out.println("Please enter a new price per kg for this product: ");
                        product.setPriceKG(Double.parseDouble(scan.nextLine()));
                        break;
                        
                        case "4":
                        System.out.println("Please enter a new price per whole for this product: ");
                        product.setPriceWhole(Double.parseDouble(scan.nextLine()));
                        break;
                        
                        case "5":
                        System.out.println("Please enter a new discount for this product: ");
                        product.setDiscount(Integer.parseInt(scan.nextLine()));
                        break;
                        
                        case "6":
                        System.out.println("Please enter a new quantity of the product measured with KG: ");
                        product.setQuantityKG(Double.parseDouble(scan.nextLine()));
                        break;
                        
                        case "7":
                        System.out.println("Please enter a new quantity of the product measured with a whole: ");
                        product.setQuantityWhole(Double.parseDouble(scan.nextLine()));
                        break;
                        
                    }
                    updatedProduct.add(product);
                    System.out.println("Do you wish to update any other information about this product?(Y/N)");
                    Scanner scanner = new Scanner (System.in);
                    String tryAgain = scanner.nextLine();
                    if (tryAgain.toLowerCase().equals("n"))
                    {
                        tryAgainFlag += 1;
                        break;
                    }
                    else if (tryAgain.toLowerCase().equals("y"))
                        continue;
                    else 
                    {
                        System.out.println("Sorry!! You entered a wrong choice");
                        break;
                    }
                } 
                break;
            }
            else
            {
                flag = 0;
                
            }

        }
        if (flag == 0) {
            System.out.println("There is no product with Id "+ id);
        }
        else {
            Product product = updatedProduct.get(updatedProduct.size()-1);
            System.out.println("Updated inventory");
            shelf.updateInventory();
            System.out.println("Product updated successfully");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Updated Product Info~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.format("%-13s%-16s%-14s%-17s%-15s%-30s%-10s%-25s%-13s%n","ProductID","Name","Category","ShelfLife(days)","Price/each","Total quantity(in Whole)","Price/KG","Total quantity(in KG)","Discount");
            System.out.format("%-13s%-16s%-14s%-17s%-15s%-30s%-10s%-25s%-13s%n",product.getProductID(),product.getProductName(),
                product.getCategory(),product.getShelfLife(),product.getPriceWhole(),product.getQuantityWhole(),product.getPriceKG(),product.getQuantityKG(),product.getDiscount());
        
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

    }
}
    
   

