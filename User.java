
/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User {
    
    private String userId;
    private String userName;
    private String userEmail;
    private String userPhoneNumber;
    private String userPassword;
    private static int userNumber = 1;
    
    public User() 
    {
        userId = generateUserId(userNumber-1);
        userName = "";
        userEmail = "";
        userPhoneNumber = "";
        userPassword = "";
        userNumber++;
    }

    public User(String userId, String userName, String userEmail, String userPhoneNumber, String userPassword) 
    {
        this.userId = userId;
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
            newUserId = "u000" + (i+1);
        if (String.valueOf(i+1).length() == 2)
            newUserId = "u00" + (i+1);
        if (String.valueOf(i+1).length() == 3)
            newUserId = "u0" + (i+1);
        if (String.valueOf(i+1).length() == 4)
            newUserId = "u" + (i+1);   
        return newUserId;
    }
    
    public boolean isNameValid(String name)
    {
        if (name.length() >= 10)
        {
        
        }
        return true;
    }
    
    public boolean isPasswValid(String passw)
    {
        if (passw.length() >= 10)
        {
        
        }
        return true;
    }
}
