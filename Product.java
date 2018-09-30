
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
    private static int userNumber = 0;
    
    public Product() 
    {
        productID = generateProductID(userNumber,category);
        productName = "";
        shelfLife = "";
        price = 0;
        category = "";
        sellingType = "";
        discount = 0;
        userNumber++;
    }
    
    public Product(String productName, String category, String shelfLife, String sellingType, double price, int discount) 
    {
        this.productID = generateProductID(userNumber,category);
        this.productName = productName;
        this.shelfLife = shelfLife;
        this.price = price;
        this.category = category;
        this.sellingType = sellingType;
        this.discount = discount;
        userNumber++;
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