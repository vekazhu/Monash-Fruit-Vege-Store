import java.util.*;
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
    private double quantityKG;
    private double quantityWhole;
    private static int productNumber = 5;
    
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


    public String getProductID() 
    {
        return productID;
    }

    public String getProductName() 
    {
        return this.productName;
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
    
    public double getQuantityKG() 
    {
        return quantityKG;
    }
    
    public double getQuantityWhole() 
    {
        return quantityWhole;
    }
    
    public int getProductNumber()
    {
        return productNumber;
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

    public void setPriceKG(double priceKG) 
    {
        this.priceKG = priceKG;
    }
    
    public void setQuantityKG(double quantityKG) 
    {
        this.quantityKG = quantityKG;
    }
    
    public void setQuantityWhole(double quantityWhole) 
    {
        this.quantityWhole = quantityWhole;
    }

    public void setCategory(String category) 
    {
        this.category = category;
    }

    public void setPriceWhole(double priceWhole) 
    {
        this.priceWhole = priceWhole;
    }
    
    public void setDiscount(int discount)
    {
        this.discount = discount;
    }
    
    public String getProductInfo()
    {
        String productInfo = productID + "," + productName + "," + category + "," + shelfLife + "," + priceWhole + "," + priceKG
        + "," + quantityKG + "," + quantityWhole + "," + discount;
        return productInfo;
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
