import java.util.*;
import java.lang.Object;
import java.util.regex.*;
/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User {
    private String userId;// generate automatically
    private String userName; // first three letters of first name + last three number of userID, eg:abc001
    private String userEmail; //include @
    private String userPhoneNumber; // 8 digit
    private String userPassword; //one upper, one lower, maybe number, length >=4
    private static int userNumber = 6; //including 5 customers and one owner
    
    public User() 
    {
        userId = generateUserId(userNumber-1);
        userName = "";
        userEmail = "";
        userPhoneNumber = "";
        userPassword = "";
        userNumber++;
    }

    public User(String userName, String userEmail, String userPhoneNumber, String userPassword) 
    {
        this.userId = generateUserId(userNumber-1);
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.userPassword = userPassword;
        userNumber++;
    }

    public String getUserId() 
    {
        return userId;
    }

    public String getUserName() 
    {
        return userName;
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
    
    /**
     * generate userId, like"u0001"
     */
    private String generateUserId(int i)
    {
        String newUserId = "";
        if (String.valueOf(i+1).length() == 1)
            newUserId = "c000" + (i+1);
        if (String.valueOf(i+1).length() == 2)
            newUserId = "c00" + (i+1);
        if (String.valueOf(i+1).length() == 3)
            newUserId = "c0" + (i+1);
        if (String.valueOf(i+1).length() == 4)
            newUserId = "c" + (i+1);   
        return newUserId;
    }
    
    public void login()
    {
        
    }
    
}
