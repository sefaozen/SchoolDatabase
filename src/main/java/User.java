import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sefa on 21.2.2016.
 */
public class User {


    private List<Person> userList;

    public User ()
    {
        userList=new ArrayList<Person>();
    }




    public boolean AddUser(Person person, Person add)
    {
        if(person instanceof Administrator)
        {

            for(int i=0; i < userList.size() ; i++)
            {
                if(userList.get(i).GetUsername() != add.GetUsername())
                {

                    return false;
                }
            }
            userList.add(add);
            return true;
        }
        else
            return false;

    }

    public boolean RemoveUser(Person person, Person add)
    {
        if(person instanceof Administrator)
        {
            for(int i=0; i < userList.size() ; i++)
            {
                if(userList.get(i).GetUsername()== add.GetUsername())
                {
                    userList.remove(i);
                    return true;
                }

            }
            return false;
        }
        else
            return false;

    }

}
