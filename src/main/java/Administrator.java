import java.util.ArrayList;
import java.util.List;

public class Administrator extends User{




    private List<Person> userList;

    public Administrator(String name,String pass)
    {
        super(name,pass);

        userList=new ArrayList<Person>();

    }


    public List<Person> GetUserList()
    {
        return userList;
    }

    /**
     * For add user. Only admin can add
     * @param person which is for looking admin or not
     * @param add  course object which will add
     * @return if it is added , it's return true
     */
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

    /**
     * For add course. Only admin can remove
     * @param person which is for looking admin or not
     * @param add  course object which will remove
     * @return if it is removed , it's return true
     */
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
