import java.util.regex.*;
import java.util.*;

/**
 * Write a description of class Validator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Validator
{
    
    /**
     * Constructor for objects of class Validator
     */
    public Validator()
    {
        
    }

    /**
     * 
     */
    public static boolean isNameValid(String name)
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
    
    public static boolean isPasswordValid(String password)
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
    
    public static boolean isEmailValid(String email)
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
}
