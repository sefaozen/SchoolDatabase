/**
 * Created by Sefa on 16.2.2016.
 */
public class Student implements Person {

    private String surname="surname";
    private String password="password";

    public Student (String n, String s, String p)
    {

        SetSurname(s);
        SetPassword(p);
    }

    @Override
    public void PrintScreen() {

    }



    @Override
    public void SetSurname(String e) {
        surname=e;
    }

    @Override
    public void SetPassword(String e) {
        password =e;
    }

    @Override
    public String GetPassword(String e) {
        return password;
    }

    @Override
    public String GetSurname(String e) {
        return  surname;
    }


}
