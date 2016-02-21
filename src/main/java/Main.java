import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sefa on 21.2.2016.
 */
public class Main {


    public static void main(String[] args){

        Administrator admin = new Administrator("admin","1111");
        Teacher te=new Teacher("erdo","1");
        List <Person> user =new ArrayList<Person>();

        Course course=new Course();

        user.add(admin);
        course.AddCourse(admin,new Course("Data","CSE 222",2016));
        course.RemoveCourse(te,new Course("Data","CSE 222",2016));

        System.out.println("Asdas"+course. );



    }
}
