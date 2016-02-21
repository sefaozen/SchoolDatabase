/**
 * Created by Sefa on 21.2.2016.
 */
public class Administrator implements Person {

    private String userName;
    private String password;
    private String whoIAm;

    public Administrator(String name,String pass)
    {
        userName=name;
        password=pass;
        whoIAm="administrator";
    }

    /**
     * Take a string and change username
     * @param other is a string parameter for change username
     */
    public void SetUsername(String other) {

        userName=other;
    }

    /**
     * Take a string and change password
     * @param other is a string parameter for change password
     */
    public void SetPassword(String other) {

        password=other;
    }

    /**
     * Get the password
     * @return String which is password
     */
    public String GetPassword() {
        return password;
    }
    /**
     * Get the userName
     * @return String which is userName
     */
    public String GetUsername() {
        return userName;
    }
    /**
     * Get the whoIAm
     * @return String which is whoIAm
     */
    public String GetWhoIAm() {
        return whoIAm;
    }
}
