
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
    private int discount;
    
    public Product() 
    {
        productID = "";
        productName = "";
        shelfLife = "";
        price = 0;
        category = "";
        sellingType = "";
    }
    
    public Product(String productID, String productName, String shelfLife, double price, String category, String sellingType) 
    {
        this.productID = productID;
        this.productName = productName;
        this.shelfLife = shelfLife;
        this.price = price;
        this.category = category;
        this.sellingType = sellingType;
    }

    public String getProductID() 
    {
        return productID;
    }

    public String getProductName() 
    {
        return productName;
    }

    public String getShelfLife() 
    {
        return shelfLife;
    }

    public double getPrice() 
    {
        return price;
    }

    public String getCategory() 
    {
        return category;
    }

    public String getSellingType() 
    {
        return sellingType;
    }
    
    public int getDiscount()
    {
        return discount;
    }

    public void setProductID(String productID) 
    {
        this.productID = productID;
    }

    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public void setShelfLife(String shelfLife) 
    {
        this.shelfLife = shelfLife;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    public void setCategory(String category) 
    {
        this.category = category;
    }

    public void setSellingType(String sellingType) 
    {
        this.sellingType = sellingType;
    }
    
    public void setDiscount(int discount)
    {
        this.discount = discount;
    }

}