import java.util.*;
import java.lang.Object;
import java.util.regex.*;
/**
 * class User contains all attributes of an user object and related get set methods, also methods will be used by users of MFVS
 *
 * @author (Team 114)
 * @version (15/OCT/2018)
 */
public class User 
{
    private String userId;// generate automatically
    private String userName; // first three letters of first name + last three number of userID, eg:abc001
    private String userEmail; //include @
    private String userPhoneNumber; // 10 digit
    private String userPassword; //one upper, one lower, maybe number, length >=4
    private String securityAnswer;
    private static int userNumber = 6;//including 5 customers and one owner
    private ArrayList<User> usersList;

    /**
     * Default constructor of User
     *
     */
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

    /**
     * User Constructor
     */
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

    /**
     * Method getUserId is to get the user ID of the user
     *
     * @return String: userId, the user ID of the user
     */
    public String getUserId() 
    {
        return userId;
    }

    /**
     * Method getUserName is to get the username of the user
     *
     * @return String: userName, the username of the user
     */
    public String getUserName() 
    {
        return userName;
    }

    /**
     * Method getUserEmail is to get the email of the user
     *
     * @return String: userEmail, the email of the user
     */
    public String getUserEmail() 
    {
        return userEmail;
    }

    /**
     * Method getUserPhoneNumber is to get the phone number of the user
     *
     * @return String: userPhoneNumber, the phone number of the user
     */
    public String getUserPhoneNumber() 
    {
        return userPhoneNumber;
    }

    /**
     * Method getUserPassword is to get the password of the user
     *
     * @return String: userPassword the password of the user
     */
    public String getUserPassword() 
    {
        return userPassword;
    }

    /**
     * Method getSecurityAnswer is to get the security answer of the user
     *
     * @return String: securityAnswer, the security answer of the user 
     */
    public String getSecurityAnswer() 
    {
        return securityAnswer;
    }
    
    /**
     * Method getUserNumber is to get the number of registered user in the system
     *
     * @return int: userNumber, the number of registered user in the system
     */
    public int getUserNumber()
    {
        return userNumber;
    }

    /**
     * Method setSecurityAnswer is to record the security answer of the user
     *
     * @param securityAnswer: the security answer of the user 
     */
    public void setSecurityAnswer(String securityAnswer) 
    {
        this.securityAnswer = securityAnswer;
    }

    /**
     * Method setUserId is to record the user ID of the user
     *
     * @param userId: the user ID of the user
     */
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    /**
     * Method setUserName is to record the username of the user
     *
     * @param userName: the username of the user
     */
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    /**
     * Method setUserEmail is to record the email of the user
     *
     * @param userEmail: the email of the user
     */
    public void setUserEmail(String userEmail) 
    {
        this.userEmail = userEmail;
    }

    /**
     * Method setUserPhoneNumber is to record the phone number of the user
     *
     * @param userPhoneNumber: the phone number of the user
     */
    public void setUserPhoneNumber(String userPhoneNumber) 
    {
        this.userPhoneNumber = userPhoneNumber;
    }

    /**
     * Method setUserPassword is to record the password of the user
     *
     * @param userPassword: the password of the user
     */
    public void setUserPassword(String userPassword) 
    {
        this.userPassword = userPassword;
    }

    /**
     * Method getUserInfo is to get all the information recorded in the system of registered user
     *
     * @return String: customerInfo, all the information recorded in the system of registered user
     */
    public String getUserInfo()
    {
        String customerInfo = getUserId() + "," + getUserName() + "," + getUserEmail() + "," + getUserPhoneNumber() + "," + getUserPassword() + "," + getSecurityAnswer();
        return customerInfo;
    }
    
    /**
     * Method login is used for registered users to login to the system
     *
     * @return String: system instructions to inform users of the status of the login process
     */
    public String login()
    {

        //Scanner scan = new Scanner (new File("the\\dir\\myFile.extension"));
        Scanner keyboard = new Scanner (System.in);
        int flag = 0;
        int userExists = 0;
        User user = new User();
        usersList = FileManager.readUserInfo("users.txt");
        
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
                this.setUserId(user.getUserId());
                System.out.println(" User id is "+getUserId());
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
