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
    //private HashMap productQuantity;

    /**
     * Default Constructor for objects of class Shelf
     */
    public Shelf()
    {
        listOfProducts = FileManager.readProductsInfo("products.txt");
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

    public void addProduct(Product product)
    {
        listOfProducts.add(product);
    }
    
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
    
    public void updateInventory()
    {
        String content = "";
        for (Product product: listOfProducts)
        {
            if (content.equals(""))
                content = product.getProductInfo();
            else
                content = content + "\n" + product.getProductInfo();
        }
        FileManager.writeFile(content,"products.txt");
    }

    public void sortProductByAlphabet()
    {
        Product temp = new Product();
        for (int i = 0; i < listOfProducts.size(); i++)
        {
            for (int j = i + 1; j < listOfProducts.size(); j++)
            {
                if (listOfProducts.get(i).getProductName().toLowerCase().compareTo(listOfProducts.get(j).getProductName().toLowerCase())>0)
                {
                    temp = listOfProducts.get(i);
                    listOfProducts.set(i,listOfProducts.get(j));
                    listOfProducts.set(i+1,temp);
                }
            }
        }
    }

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

    public void displayProductsInfo(ArrayList<Product> listOfProduct)
    {
        for ( Product product: listOfProduct)
        {
            System.out.format("%-13s%-16s%-14s%-13s%-15s%-10s%-13s%n",product.getProductID(),product.getProductName(),
                product.getCategory(),product.getShelfLife(),product.getPriceWhole(),product.getPriceKG(),product.getDiscount());
        }
        
    }
    
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
    
    public void displayProductsInfo()
    {
        for ( Product product: listOfProducts)
        {
            System.out.format("%-13s%-16s%-14s%-13s%-15s%-10s%-13s%n",product.getProductID(),product.getProductName(),
                product.getCategory(),product.getShelfLife(),product.getPriceWhole(),product.getPriceKG(),product.getDiscount());
        }
        
    }
    
    /**
     * This method is to find the Product object that has the specific productID
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
}
