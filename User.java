import java.util.*;
import java.lang.Object;
import java.util.regex.*;
/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User 
{
    private String userId;// generate automatically
    private String userName; // first three letters of first name + last three number of userID, eg:abc001
    private String userEmail; //include @
    private String userPhoneNumber; // 8 digit
    private String userPassword; //one upper, one lower, maybe number, length >=4
    private String securityAnswer;
    private static int userNumber = 6;//including 5 customers and one owner
    private ArrayList<Customer> usersList;

    public User() 
    {
        userId = "";
        userName = "";
        userEmail = "";
        userPhoneNumber = "";
        userPassword = "";
        securityAnswer = "";
        userNumber++;
    }

    public User(String userID,String userName, String userEmail, String userPhoneNumber, String userPassword, String securityAnswer) 
    {
        this.userId = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.userPassword = userPassword;
        this.securityAnswer = securityAnswer;
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

    public String getSecurityAnswer() 
    {
        return securityAnswer;
    }
    
    public int getUserNumber()
    {
        return userNumber;
    }

    public void setSecurityAnswer(String securityAnswer) 
    {
        this.securityAnswer = securityAnswer;
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

    public String login()
    {

        //Scanner scan = new Scanner (new File("the\\dir\\myFile.extension"));
        Scanner keyboard = new Scanner (System.in);
        int flag = 0;
        int userExists = 0;
        User user = new User();
        usersList = FileManager.readCustomerInfo("users.txt");
        System.out.println("Enter your UserId");
        String inpUser = keyboard.nextLine();
        System.out.println("Enter your Password");
        String inpPass = keyboard.nextLine(); // gets input from user
        System.out.print('\u000C');

        for(int i=0; i<usersList.size();i++)
        {
            user = usersList.get(i);
            String userId = usersList.get(i).getUserId();
            String password = usersList.get(i).getUserPassword();
            if (inpUser.equals(userId) ) {
                userExists = 1;

                for(int j= 0;j<2;j++) {
                    if(inpPass.equals(password)) {
                        flag = 1;
                        break;
                    } 
                    else {
                        System.out.println("Invalid Password!! TRY AGAIN");
                        System.out.println("Re-Enter your Password, This is your " +(j+2) + "attempt");
                        inpPass = keyboard.nextLine();
                    }
                }
                break;
            }
        }

        if (userExists == 1){

            if (flag == 1){
                System.out.println("Hi! ,you are successfully logged in. ");
                return user.getUserId();
            }
            else {
                System.out.println("3 attempts are done!!, Do you wish to Answer your security questions to login?(s|n)");
                String status = keyboard.nextLine();
                switch (status.toLowerCase())
                {
                    case "s":
                    System.out.println("Who is your favourite Singer?");
                    String answer = keyboard.nextLine();
                    if(user.getSecurityAnswer().equals(answer)) {
                        System.out.println("Hi! ,you are successfully logged in. ");
                        return user.getUserId();
                    }
                    else{
                        return "";
                    }

                    case "n":
                    return "";

                    default:
                    System.out.println("The entered vaule is unrecognized!");
                    return "";

                }
            }
        }
        else {
            System.out.println("User Doesnot Exists");
            return "";
        }
    }

}
