import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
/**
 * class Shelf contains an Arraylist of products in the MFVS, and to manage the inventory of these products
 *
 * @author (Team 114)
 * @version (15/OCT/2018)
 */
public class Shelf
{
    // instance variables - replace the example below with your own
    private ArrayList<Product> listOfProducts;
    private LocalDate today = LocalDate.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
    //private HashMap productQuantity;

    /**
     * Default Constructor for objects of class Shelf
     */
    public Shelf()
    {
        listOfProducts = FileManager.readProductsInfo("products.txt");
    }

    /**
     * Method checkexpiry is to check the expiry date of the products and notify owner about the expiry products
     *
     * 
     */
    public ArrayList<Product> checkExpiry()
    {
        LocalDate productDate;
        ArrayList<Product> expiredProducts = new ArrayList<Product>();
        for(Product product: listOfProducts)
        {
            
            productDate = convertStringToDate(product.getProductDate());
            int daysBetween = (int)(ChronoUnit.DAYS.between(productDate,today));
            
            if(daysBetween > Integer.parseInt(product.getShelfLife()))
            {
                expiredProducts.add(product);
            }
        }
        return expiredProducts;
    }

    /**
     * Non-Default Constructor for objects of class Shelf
     */
    public Shelf(ArrayList<Product> listOfProducts)
    {
        this.listOfProducts = listOfProducts;
    }

    /**
     * get ArrayList of products that are in the MFVS
     *
     * @return an arraylist of product, all products in the MFVS
     */
    public ArrayList<Product> getListOfProducts()
    {
        listOfProducts = FileManager.readProductsInfo("products.txt");
        return listOfProducts;
    }

    /**
     * set a new ArrayList of product is to record products that are in the MFVS
     *
     * @param an arraylist of product, the products will be added to the MFVS
     */
    public void setListOfProduct(ArrayList<Product> listOfProducts)
    {
        this.listOfProducts = listOfProducts;
    }

    /**
     * Method addProduct is to add new created product to the Arraylist of products in the MFVS
     *
     * @param product, the new created product will be added to the list
     */
    public void addProduct(Product product)
    {
        listOfProducts.add(product);
    }

    /**
     * Method doesProductExist is to verify whether the product will be created is already in the store
     *
     * @param productName, the product name inputed by the owner of the product will be created
     * @return boolean: true if the MFVS already has this product
     *                  false if the MFVS does not have this product
     */
    public boolean doesProductExist(String productName)
    {
        for (int i = 0; i < listOfProducts.size(); i++)
        {
            if (listOfProducts.get(i).getProductName().equals(productName))
            {
                System.out.println("This product already exists, please enter another one or update it.");
                return true;
            }
        }
        return false;
    }

    /**
     * Method editInventory is to reduce the inventory in the store
     * and return an arrayList with updated inventory
     * for all product,1 each = 0.25KG
     *
     *@param productID, amount, flagKG: product ID is the id of the product needed to be reduced, and amount is the number
     *that inventory will be reduced by, and the flagKG is 1 indicates quantity KG will be reduced, 
     *                                           flagKG is 0 indicates quantity Whole will be reduced
     */
    public void reduceInventory(String productID, double amount, int flagKG)
    {
        for (Product product: listOfProducts)
        {
            if (productID.equals(product.getProductID()))
            {
                if (flagKG==0)
                {    
                    product.setQuantityWhole(product.getQuantityWhole() - amount);
                    product.setQuantityKG(product.getQuantityKG() - amount * 0.25);
                }
                else
                {
                    product.setQuantityKG(product.getQuantityKG() - amount);
                    product.setQuantityWhole(product.getQuantityWhole() - amount * 4);
                }
            }
        }

    }

    /**
     * Method updateInventory is to update the new inventory quantity of products in MFVS
     *
     */
    public void updateInventory()
    {
        ArrayList<String> content = new ArrayList<String>();
        for (Product product: listOfProducts)
        {
            //if (content.equals(""))
            content.add(product.getProductInfo());
            //else
            //content.add(content + "\n" + product.getProductInfo());
        }  

        File f = new File("products.txt");
        if (f.exists())
        {
            //delete if exists
            f.delete();
        }
        FileManager.writeFile(content,"products.txt");
    }

    /**
     * Method sortProductByAlphabet is to sort the displayed products in alphabetical order
     *
     */
    public void sortProductByAlphabet()
    {
        Product temp = new Product();
        for (int i = 0; i < listOfProducts.size(); i++)
        {
            for (int j = i + 1; j < listOfProducts.size(); j++)
            {
                if (listOfProducts.get(i).getProductName().toLowerCase().compareTo(listOfProducts.get(j).getProductName().toLowerCase())>0)
                {
                    temp = listOfProducts.get(j);
                    listOfProducts.remove(listOfProducts.get(j));
                    listOfProducts.add(i,temp);
                }
            }
        }
    }

    /**
     * Method sortProductByCategory is to sort the displayed products in based on their categories 
     *
     * @param str A parameter
     */
    public void sortProductByCategory(String str)
    {
        ArrayList<Product> vege = new ArrayList<Product>();
        ArrayList<Product> fruit = new ArrayList<Product>();
        for ( Product product: listOfProducts)
        {
            if (product.getCategory().equals("fruit"))
                fruit.add(product);
            else
                vege.add(product);
        }
        if (str.toLowerCase().startsWith("f"))
        {
            displayProductsInfo(fruit);
            displayProductsInfo(vege);
        }
        else
        {
            displayProductsInfo(vege);
            displayProductsInfo(fruit);
        }
    }

    /**
     * Method displayProductsInfo is to display the ID, name, category, shelflife, price each, price per kg and discount of
     * products in the Arraylist of products for all users
     *
     * @param listOfProduct, the Arraylist of products in the MFVS
     */
    public void displayProductsInfo(ArrayList<Product> listOfProduct)
    {
        
        for ( Product product: listOfProduct)
        {
            
            System.out.format("%-13s%-16s%-14s%-15s%-10s%-13s%-20s%n",product.getProductID(),product.getProductName(),
                product.getCategory(),product.getPriceWhole(),product.getPriceKG(),product.getDiscount(),product.getExpiryDate());
        }

    }

    /**
     * Method displayProductsInfo is to display the ID, name, category, shelflife, price each, price per kg and discount of
     * products in the Arraylist of products for all users
     *
     * 
     */
    public void displayProductsInfo()
    {
        for ( Product product: listOfProducts)
        {
            
            System.out.format("%-13s%-16s%-14s%-17s%-15s%-10s%-13s%-20s%n",product.getProductID(),product.getProductName(),
                product.getCategory(),product.getShelfLife(),product.getPriceWhole(),product.getPriceKG(),product.getDiscount(),product.getExpiryDate());
        }

    }
    
    /**
     * Method displayOwnerProductsInfo is to display the ID, name, category, shelflife, price each, price per kg, discount, 
     * remaining quantity and remaining KG of products in the Arraylist of products for the owner
     *
     * @param listOfProduct, the Arraylist of products in the MFVS
     */
    public void displayOwnerProductsInfo(ArrayList<Product> listOfProduct)
    {
        for ( Product product: listOfProduct)
        {
            System.out.format("%-13s%-16s%-14s%-17s%-15.1f%-15.1f%-13.2f%-15.2f%-13d%-20s%n",product.getProductID(),product.getProductName(),
                product.getCategory(),product.getShelfLife(),product.getPriceWhole(),product.getQuantityWhole(),product.getPriceKG(),product.getQuantityKG(),product.getDiscount(),product.getExpiryDate());
        }

    }

    /**
     * Method deleteProductInShelf is to delete the disposed products from the shelf and also the Arraylist of products
     *
     * @param deleteProductId, the product ID of the disposed products
     */
    public void deleteProductInShelf(String deleteProductId)
    {
        for (int i = 0; i < listOfProducts.size(); i++)
        {
            if (deleteProductId.equals(listOfProducts.get(i).getProductID()))
            {    
                listOfProducts.remove(i);
            }
        }
    }

    
    /**
     * This method is to find the Product object of the specific productID
     */
    public Product findProductById(String productId)
    {
        Product product = new Product();
        for ( Product pdct: listOfProducts)
        {
            if (productId.equalsIgnoreCase(pdct.getProductID()))
            {
                product = pdct;
                break;
            }
        }
        return product;
    }

    /**
     * This method is to find the Product object of the specific category
     */
    public ArrayList<Product> findProductByCategory(String productType)
    {
        ArrayList<Product> foundProductList = new ArrayList<Product>();
        for ( Product pdct: listOfProducts)
        {
            if (productType.equalsIgnoreCase(pdct.getCategory()))
            {
                foundProductList.add(pdct);

            }
        }
        return foundProductList;
    }

    /**
     * This method is to find the Product object that has the specific productID
     */
    public ArrayList<Product> findProductByName(String name)
    {
        ArrayList<Product> foundProductList = new ArrayList<Product>();
        for ( Product pdct: listOfProducts)
        {
            if (name.equalsIgnoreCase(pdct.getProductName()))
            {
                foundProductList.add(pdct);
            }
        }
        return foundProductList;
    }

    public boolean isProductExistInShelf(String productID)
    {
        for (Product pdct: listOfProducts)
        {
            if (productID.equalsIgnoreCase(pdct.getProductID()))
            {
                return true;
            }
        }
        return false;
    }

    public String getProductIdAleadyInShelf()
    {
        Scanner input = new Scanner(System.in);
        String productID = input.nextLine();
        while (!isProductExistInShelf(productID))
        {
            System.out.println("Please enter a valid productID that already in the shelf.");
            productID = input.nextLine();
        }
        return productID;
    }

    public LocalDate convertStringToDate(String dateInString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate localDate = LocalDate.parse(dateInString, formatter);
        return localDate;
    }
    
    public String getCurrentDate(){
        
        LocalDate localDate = LocalDate.now();
        return localDate.format(formatter);
    }
}
