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
        if (name.trim().length() > 10)
        {
            System.out.println("Your name should be within 10 characters.");
            return false;
        }
        for (int i = 0; i < name.length(); i++)
        {
            if (!Character.isLetter(name.charAt(i)))
                return false;
        }
        return true;
    }
    
    public boolean isPasswordValid(String password)
    {
        if (password.length() < 4)
        {
            System.out.println("Your password should be at least 4 characters.");
            return false;
        }
        
        int countUpper = 0;
        int countLower = 0;
        for (int i = 0; i < password.length(); i++)
        {  
             if (Character.isUpperCase(password.charAt(i)))
                countUpper++;
             if (Character.isLowerCase(password.charAt(i)))
                countLower++;
             if (!Character.isLetterOrDigit(password.charAt(i)))
                {
                    System.out.println("Your password should only contain letters or numbers.");
                    return false;
                }
        }
        if (countUpper == 0 || countLower == 0)
        {    
            System.out.println("Your password should contain at least one uppercase and one lowercase.");
            return false;
        }
        return true;
    }
    
    public boolean isEmailValid(String email)
    {
        Pattern regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        Matcher regMatcher = regexPattern.matcher(email);
        if(regMatcher.matches()) 
        {
            return true;
        } 
        else 
        {
            System.out.println("Please enter a valid email address.");
            return false;
        }
    }
    
    public void register()
    {
        System.out.println("Please enter your first Name.");
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.next();
        /**
         * while (isNameValid(firstName) == true)
        {
            System.out.println("Please enter your email address.");
            String email = scanner.next();
            while (isEmailValid(email) == true)
            {
                System.out.println("Please enter your password.");
                String passWord = scanner.next();
                while (isPasswordValid(passWord) == true)
                {
                    scanner.close();
                }
            }
        }
         * 
         */
        isNameValid(firstName);
        
      

    }
    
    public void login()
    {
        
    }
}
