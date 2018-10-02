
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
    private double priceKG;
    private String category;
    private double priceWhole;
    private int discount;
    private static int productNumber = 0;
    
    public Product() 
    {
        productID = generateProductID(productNumber,category);
        productName = "";
        shelfLife = "";
        priceKG = 0;
        category = "";
        priceWhole = 0;
        discount = 0;
        productNumber++;
    }
    
    public Product(String productName, String category, String shelfLife, double priceWhole, double priceKG, int discount) 
    {
        this.productID = generateProductID(productNumber,category);
        this.productName = productName;
        this.shelfLife = shelfLife;
        this.priceKG = priceKG;
        this.category = category;
        this.priceWhole = priceWhole;
        this.discount = discount;
        productNumber++;
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

    public double getPriceKG() 
    {
        return priceKG;
    }

    public String getCategory() 
    {
        return category;
    }

    public double getPriceWhole() 
    {
        return priceWhole;
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

    public void setPrice(double priceKG) 
    {
        this.priceKG = priceKG;
    }

    public void setCategory(String category) 
    {
        this.category = category;
    }

    public void setSellingType(double priceWhole) 
    {
        this.priceWhole = priceWhole;
    }
    
    public void setDiscount(int discount)
    {
        this.discount = discount;
    }
    
    /**
     * generate ProductId, like Fruit is f001, vege is v002
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

}