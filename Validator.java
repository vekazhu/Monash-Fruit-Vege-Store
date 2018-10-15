import java.util.regex.*;
import java.util.*;

/**
 * class Validator contains all the validation methods that used to verify the user inputs
 *
 * @author (Team 114)
 * @version (15/OCT/2018)
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
     * Method isFirstNameValid is to verify the user input of firstname
     * 
     * @param enteredToken: the token entered by the user for firstname
     * @return boolean: true if the entered token is valid input
     *                  false if the entered token is invalid input
     */
    public static boolean isFirstNameValid(String enteredToken)
    {
     if (enteredToken.length() < 3 || enteredToken.length() > 20)
     {
         System.out.println("The name should be 3-20 letters long.");
         return false;
     }
     for (int i = 0; i < enteredToken.length(); i++)
         {  
             if (Character.isLetter(enteredToken.charAt(i)) == false)
             {
                 System.out.println("Please enter letters only.");
                 return false;
             }
         }
     return true;
    }
    
    /**
     * Method isPasswordValid is to verify the user input of password
     *
     * @param password: the password entered by the user
     * @return boolean: true if the password entered is valid input
     *                  false if the password enterd is invalid input
     */
    public static boolean isPasswordValid(String password)
    {
        if (password.length() < 4 || password.length() > 15)
        {
            System.out.println("Your password should between 4 and 15 characters.");
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
    
    /**
     * Method isEmailValid is to verify the user input of email
     *
     * @param email: the email entered by the user
     * @return boolean: true if the email entered is valid input
     *                  false if the email enterd is invalid input
     */
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
     
    /**
     * Method isPhoneNumberValid is to verify the user input of phone number
     *
     * @param phoneNumber: the phone number entered by the user
     * @return boolean: true if the phone number entered is valid input
     *                false if the phone number enterd is invalid input
     */
    public static boolean isPhoneNumberValid(String phoneNumber)
    {
        if (phoneNumber.length() != 10 || phoneNumber.startsWith("04") == false)
        {
            System.out.println("Please renter your 10 digits phone number begins with 04.");
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i ++)
        {
            if (Character.isDigit(phoneNumber.charAt(i)) == false)
            {
                System.out.println("Please enter numbers only.");
                return false;
            }
        }
        return true;
    }
    
    /**
     * Method isDouble is to verify whether the user input belongs to datetype 'double'
     *
     * @param str: the user input
     * @return boolean: true if the user input is a double
     *                  false if the user input is not a double
     */
    public static boolean isDouble(String str)
    {
        if (str.startsWith(".") || str.endsWith("."))
        {
            System.out.println("Entered value are not valid");
            return false;
        }
        
        try
        {
            Double.parseDouble(str);
            return true;
        }
        catch(NumberFormatException ex){}
        return false;
    }
    
    /**
     * Method isInt is to verify whether the user input belongs to datetype 'int'
     *
     * @param str: the user input
     * @return boolean: true if the user input is an integer
     *                  false if the user input is not an integer
     */
    public static boolean isInt(String str)
    {
        try
        {
            Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException ex){}
        return false;
    }    
}
