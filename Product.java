import java.util.*;
/**
 * class Product contains all attributes of a product object, related get set methods and the method the generate product ID
 * and to dispose products
 *
 * @author (Team 114)
 * @version (15/OCT/2018)
 */
public class Product
{
    // instance variables - replace the example below with your own
    private String productID;
    private String productName;
    private String shelfLife;
    private double priceKG;
    private String category;
    private double priceWhole;
    private int discount;
    private double quantityKG;
    private double quantityWhole;
    private static int productNumber = 5;
    
    /**
     * Default constructor of product
     *
     */
    public Product() 
    {
        productID = "";
        productName = "";
        shelfLife = "";
        priceKG = 0;
        category = "";
        priceWhole = 0;
        quantityKG = 0;
        quantityWhole = 0;
        discount = 0;
        productNumber++;
    }
    
    /**
     * Non default consturctor of product starts with productID
     */
    public Product(String productID,String productName, String category, String shelfLife, double priceWhole, double priceKG,
                    double quantityKG,double quantityWhole,int discount) 
    {
        this.productID = productID;
        this.productName = productName;
        this.shelfLife = shelfLife;
        this.priceKG = priceKG;
        this.category = category;
        this.priceWhole = priceWhole;
        this.quantityKG = quantityKG;
        this.quantityWhole = quantityWhole;
        this.discount = discount;
        productNumber++;
    }
    
    /**
     * Non default consturctor of product starts with generateProductID(String, category)
     */
    public Product(String productName, String category, String shelfLife, double priceWhole, double priceKG,
                    double quantityKG,double quantityWhole,int discount) 
    {
        this.productID = generateProductID(productNumber, category);
        this.productName = productName;
        this.shelfLife = shelfLife;
        this.priceKG = priceKG;
        this.category = category;
        this.priceWhole = priceWhole;
        this.quantityKG = quantityKG;
        this.quantityWhole = quantityWhole;
        this.discount = discount;
        productNumber++;
    }

    /**
     * Method getProductID is to get the product ID of the product
     *
     * @return String: product ID, the ID of the product
     */
    public String getProductID() 
    {
        return productID;
    }

    /**
     * Method getProductName is to get the product name of the product
     *
     * @return String: productName, the name of the product
     */
    public String getProductName() 
    {
        return this.productName;
    }

    /**
     * Method getShelfLife is to get the product shelflife of the product
     *
     * @return String: shelfLife, the shelflife of the product in days
     */
    public String getShelfLife() 
    {
        return shelfLife;
    }

    /**
     * Method getPriceKG is to get the price per KG of the product
     *
     * @return double: priceKG, the price per KG of the product
     */
    public double getPriceKG() 
    {
        return priceKG;
    }

    /**
     * Method getCategory is to get the product category of the product
     *
     * @return String: category, the product category of the product
     */
    public String getCategory() 
    {
        return category;
    }

    /**
     * Method getPriceWhole is to get the price for each of the product
     *
     * @return double: priceWhole, the price for each of the product
     */
    public double getPriceWhole() 
    {
        return priceWhole;
    }
    
    /**
     * Method getDiscount is to get the discount of the product
     *
     * @return int, the discount of the product(e.g. 10 means 10% off)
     */
    public int getDiscount()
    {
        return discount;
    }
    
    /**
     * Method getQuantityKG is to get the remaining KG of the product
     *
     * @return doulbe: quantityKG, the remaining KG of the product
     */
    public double getQuantityKG() 
    {
        return quantityKG;
    }
    
    /**
     * Method getQuantityWhole is to get the remaining quantity of the product
     *
     * @return double: quantityWhole, the remaining quantity of the product
     */
    public double getQuantityWhole() 
    {
        return quantityWhole;
    }
    
    /**
     * Method getProductNumber is to get the number of products we are selling at the MFVS
     *
     * @return int: productNumber, the number of products we are selling at the MFVS
     */
    public int getProductNumber()
    {
        return productNumber;
    }

    /**
     * Method setProductID is to record the ID of the product
     *
     * @param productID, the product ID of the product
     */
    public void setProductID(String productID) 
    {
        this.productID = productID;
    }

    /**
     * Method setProductName is to record the name of the product
     *
     * @param productName, the name of the product
     */
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    /**
     * Method setShelfLife is to record the shelflife of the product
     *
     * @param shelfLife: the shelflife of the product
     */
    public void setShelfLife(String shelfLife) 
    {
        this.shelfLife = shelfLife;
    }

    /**
     * Method setPriceKG is to record the price per KG of the product
     *
     * @param priceKG: the price per KG of the product
     */
    public void setPriceKG(double priceKG) 
    {
        this.priceKG = priceKG;
    }
    
    /**
     * Method setQuantityKG is to record the remaining KG of the product
     *
     * @param quantityKG: the remaining KG of the product
     */
    public void setQuantityKG(double quantityKG) 
    {
        this.quantityKG = quantityKG;
    }
    
    /**
     * Method setQuantityWhole is to record the remaining quantity as a whole of the product
     *
     * @param quantityWhole: remaining quantity as a whole of the product
     */
    public void setQuantityWhole(double quantityWhole) 
    {
        this.quantityWhole = quantityWhole;
    }

    /**
     * Method setCategory is to record the category of the product
     *
     * @param category: the category of the product
     */
    public void setCategory(String category) 
    {
        this.category = category;
    }

    /**
     * Method setPriceWhole is to record the price when the product is selling as a whole
     *
     * @param priceWhole: the price when the product is selling as a whole
     */
    public void setPriceWhole(double priceWhole) 
    {
        this.priceWhole = priceWhole;
    }
    
    /**
     * Method setDiscount is to record the discount of the product
     *
     * @param discount: the discount of the product
     */
    public void setDiscount(int discount)
    {
        this.discount = discount;
    }
    
    /**
     * Method getProductInfo is to get the ID, name, category, shelflife, price selling as a whole, price per KG, remaining KG,
     * remaining amount and the discount of the product
     *
     * @return String: productInfo, the mentioned information above of the product
     */
    public String getProductInfo()
    {
        String productInfo = productID + "," + productName + "," + category + "," + shelfLife + "," + priceWhole + "," + priceKG
        + "," + quantityKG + "," + quantityWhole + "," + discount;
        return productInfo;
    }
    
    /**
     * generate ProductId, like Fruit is f001, vege is v002
     * 
     * @param i, category: i is the integer of number of products in MFVS, category is the category of the created product
     */
    public String generateProductID(int i,String category)
    {
        String productID = "";
        if (category != null)
            if (category.toLowerCase().equals("fruit") && category != null)
            {
                if (String.valueOf(i+1).length() == 1)
                    productID = "f00" + (i+1);
                if (String.valueOf(i+1).length() == 2)
                    productID = "f0" + (i+1);
                if (String.valueOf(i+1).length() == 3)
                    productID = "f" + (i+1);
            }
            else
            {
                if (String.valueOf(i+1).length() == 1)
                    productID = "v00" + (i+1);
                if (String.valueOf(i+1).length() == 2)
                    productID = "v0" + (i+1);
                if (String.valueOf(i+1).length() == 3)
                    productID = "v" + (i+1);
            } 
        else
            System.out.println("missing information of product.");
        return productID;
    }
    
    public void disposalProduct(ArrayList<Product> listOfProducts)
    {
        System.out.println("Please enter the ID of the product: ");
        Scanner scan = new Scanner(System.in);
        String ID = scan.nextLine();
        for(int i = 0; i< listOfProducts.size(); i++)
        {
            Product product = listOfProducts.get(i);
            if(product.productID == ID)
            {
                listOfProducts.remove(i);
                System.out.println("The product has been removed.");
                return;
            }
            productNumber--;
            
        }
        
        System.out.println("The Product is not found.");
    }
}
