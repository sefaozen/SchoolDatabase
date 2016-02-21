import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sefa on 21.2.2016.
 */
public class Course {

    private String courseName;
    private String courseId;
    private int courseDeadline;

    private List<Person> takeCourse;
    private List<Course> courseList;



    public Course ()
    {

        takeCourse=new ArrayList<Person>();
        courseList= new ArrayList<Course>();

    }
    public Course (String name, String courseId,int dead)
    {

        takeCourse=new ArrayList<Person>();
        courseList= new ArrayList<Course>();

        SetCourseDeadline(dead);
        SetCourseId(courseId);
        SetCourseName(name);

        courseList.add(this);

    }

    /**
     * Take a string and change courseName
     * @param other is a string parameter for change username
     */
    public void SetCourseName(String other) {

        courseName=other;
    }

    /**
     * Take a string and change courseId
     * @param other is a string parameter for change courseId
     */
    public void SetCourseId(String other) {

        courseId=other;
    }
    /**
     * Take a integer and change courseDeadline
     * @param other is a integer parameter for change courseDeadline
     */
    public void SetCourseDeadline(int other) {

        courseDeadline=other;
    }

    /**
     * Get the courseName
     * @return String which is courseName
     */
    public String GetCourseName() {
        return courseName;
    }
    /**
     * Get the courseId
     * @return String which is courseId
     */
    public String GetcourseId() {
        return courseId;
    }
    /**
     * Get the courseDeadline
     * @return String which is courseDeadline
     */
    public int GetCourseDeadline() {
        return courseDeadline;
    }

    /**
     * For get the arraylist
     * @return arraylist which is courseList
     */
    public List<Course>  GetCourseList() {

        return  courseList;
    }



    public boolean AddCourse(Person person, Course course)
    {
        if(person instanceof Administrator)
        {

            for(int i=0; i < courseList.size() ; i++)
            {
                if(courseList.get(i).equals(course))
                {

                    return false;
                }

            }
            courseList.add(course);
            return true;
        }
        else
            return false;

    }

    public boolean RemoveCourse(Person person, Course course)
    {
        if(person instanceof Administrator)
        {
            for(int i=0; i < courseList.size() ; i++)
            {
                if(courseList.get(i).equals(course))
                {
                    courseList.remove(i);
                    return true;
                }

            }
            return false;
        }
        else
            return false;

    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Course){
            Course temp= (Course) obj;
            if( temp.courseName != this.courseName)
                return false;
            if( temp.courseId != this.courseId)
                return false;
            if( temp.courseDeadline != this.courseDeadline)
                return false;

            return true;
        }

        else
            return false;
    }

}
