import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args){

        Administrator admin = new Administrator("admin","1111");
        Teacher te=new Teacher("erdo","1");
        List <Person> user =new ArrayList<Person>();

        Course course=new Course();

        admin.AddUser(admin,te);
        course.AddCourse(admin,new Course("Data","CSE 222",2016));
        course.RemoveCourse(te,new Course("Data","CSE 222",2016));
        course.ViewCurrentCourse(te);

        //System.out.println("Asdas"+course.GetCourseList().get(0).toString() );



    }
}
