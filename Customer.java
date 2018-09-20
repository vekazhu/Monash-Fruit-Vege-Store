
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer extends User
{
    // instance variables - replace the example below with your own
    private String securityAnswer;
    private String status;

    /**
     * Constructor for objects of class Customer
     */
    public Customer()
    {
        // initialise instance variables
        securityAnswer = "";
        status = "";
    }
    
    public Customer(String securityAnswer, String status)
    {
        // initialise instance variables
        this.securityAnswer = securityAnswer;
        this.status = status;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getSecurityAnswer()
    {
        // put your code here
        return securityAnswer;
    }
    
    public void setSecurityAnswer(String securityAnswer)
    {
        this.securityAnswer = securityAnswer;
    }
    
    public String getStatus()
    {
        // put your code here
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
}
