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
    
    public double getQuantityKG() 
    {
        return quantityKG;
    }
    
    public double getQuantityWhole() 
    {
        return quantityWhole;
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

    public void setSellingType(double priceWhole) 
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
    
    public void createProduct()
    {
        Product newProduct = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the product name.");
        String productName = scanner.next();
        System.out.println("Please choose the product category.");
        //choose from categoryMenu();
        System.out.println("Please enter the product shelflife.");
        String shelfLife = scanner.next();
        System.out.println("Please choose two from the three product selling types.");
        //choose from typeMenu();
        System.out.println("Please enter the product price.");
        String price = scanner.next();
        //validation of price.isDigit();
        double productPrice = Double.parseDouble(price);
        System.out.println("Please enter the product discount.");
        String discount = scanner.next();
        //validation of discount.isInt;
        int productDiscount = Integer.parseInt(discount);
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
        }
        
        System.out.println("The Product is not found.");
    }
    
    public void updateProduct(ArrayList<Product> listOfProducts)
    {
        System.out.println("Please enter the ID of the product you want to update: ");
        Scanner scan = new Scanner (System.in);
        String ID = scan.nextLine();
        for(int i = 0; i < listOfProducts.size(); i++)
        {
            Product product = listOfProducts.get(i);
            if(product.productID == ID)
            {
                System.out.println("Please enter the ");
            }
        }
    }

}
