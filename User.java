
/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User {
    
    private String userId;
    private String userName;
    private String userAddress;
    private String userEmail;
    private String userPhoneNumber;
    private String userPassword;
    
    public User() 
    {
        userId = "";
        userName = "";
        userAddress = "";
        userEmail = "";
        userPhoneNumber = "";
        userPassword = "";
    }

    public User(String userId, String userName, String userAddress, String userEmail, String userPhoneNumber, String userPassword) 
    {
        this.userId = userId;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.userPassword = userPassword;
    }

    public String getUserId() 
    {
        return userId;
    }

    public String getUserName() 
    {
        return userName;
    }

    public String getUserAddress() 
    {
        return userAddress;
    }

    public String getUserEmail() 
    {
        return userEmail;
    }

    public String getUserPhoneNumber() 
    {
        return userPhoneNumber;
    }

    public String getUserPassword() 
    {
        return userPassword;
    }

    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public void setUserAddress(String userAddress) 
    {
        this.userAddress = userAddress;
    }

    public void setUserEmail(String userEmail) 
    {
        this.userEmail = userEmail;
    }

    public void setUserPhoneNumber(String userPhoneNumber) 
    {
        this.userPhoneNumber = userPhoneNumber;
    }

    public void setUserPassword(String userPassword) 
    {
        this.userPassword = userPassword;
    }
    
    
    
}
