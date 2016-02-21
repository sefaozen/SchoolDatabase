import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;


public class Course {

    private String courseName;
    private String courseId;
    private int courseDeadline;

    //the person who take course keep in takeCourse
    //the person's course keep in userCourse.
    //the teachers who give lesson, keep in teacherList
    private List<Person> takeCourse;
    private List<Course> userCourse;
    private List<Teacher> teacherList;

    private List<Course> courseList;

    //the tutor who take course keep in tutorList
    //the tutor's course keep in tutorCourse.
    private List<Person> tutorList;
    private List<Course> tutorCourse;




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


    /**
     * For add course. Only admin can add
     * @param person which is for looking admin or not
     * @param course  course object which will add
     * @return if it is added , it's return true
     */
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

    /**
     * For remove course. Only admin can remove
     * @param person which is for looking admin or not
     * @param course course object which will remove
     * @return if it is removed , it's return true
     */
    public boolean RemoveCourse(Person person, Course course)
    {
        if(person instanceof Administrator)
        {
            for(int i=0; i < courseList.size() ; i++)
            {
                if(courseList.get(i).equals(course))
                {
                    courseList.remove(i);
                    teacherList.remove(i);
                    return true;
                }

            }
            return false;
        }
        else
            return false;

    }


    /**
     * For add user to course. Only teacher can add
     * @param person which is for looking teacher or not
     * @param user which will add
     * @param userList is user or not
     * @param course added course
     * @return if it is added , it's return true
     */
    public boolean AddUserToCourse(Person person, Person user,List<Person> userList,Course course)
    {
        if(person instanceof Teacher)
        {
            for(int i =0; i < userList.size(); i++)
            {
                if( userList.get(i).GetUsername()==user.GetUsername() &&userList.get(i).GetPassword()==user.GetPassword() ){
                    takeCourse.add(user);
                    userCourse.add(course);
                    teacherList.add((Teacher)person);
                    return true;
                }
            }

            return false;
        }
        return false;
    }

    /**
     * For remove user to course. Only teacher can remove
     * @param person which is for looking teacher or not
     * @param user which will remove
     * @param userList is user or not
     * @return if it is removed , it's return true
     */
    public boolean RemoveUserToCourse(Person person, Person user,List<Person> userList)
    {
        if(person instanceof Teacher)
        {
            for(int i =0; i < userList.size(); i++)
            {
                if( userList.get(i).GetUsername()==user.GetUsername() && userList.get(i).GetPassword()==user.GetPassword() ){

                    for(int ii=0;ii < takeCourse.size(); ii++)
                    {
                        if(takeCourse.get(ii).GetUsername()==user.GetUsername() && takeCourse.get(ii).GetPassword()==user.GetPassword())
                        {
                            takeCourse.remove(ii);
                            userCourse.remove(ii);
                            return true;
                        }
                    }
                }

            }

            return false;

        }
        return false;
    }

    /**
     * For add tutor to course. Only teacher can add
     * @param person which is for looking teacher or not
     * @param user which will add
     * @param userList is user or not
     * @param course added course
     * @return if it is added , it's return true
     */
    public boolean AddTutorToCourse(Person person, Person user,List<Person> userList,Course course)
    {
        if(person instanceof Teacher)
        {
            if(user instanceof Tutor)
            {
                for(int i =0; i < userList.size(); i++)
                {
                    if( userList.get(i).GetUsername()==user.GetUsername() &&userList.get(i).GetPassword()==user.GetPassword() ){
                        tutorList.add(user);
                        tutorCourse.add(course);
                        return true;
                    }
                }
            }

            return false;
        }
        return false;
    }

    /**
     * For remove tutor to course. Only teacher can remove
     * @param person which is for looking teacher or not
     * @param user which will remove
     * @param userList is user or not
     * @return if it is removed , it's return true
     */
    public boolean RemoveTutorToCourse(Person person, Person user,List<Person> userList)
    {
        if(person instanceof Teacher)
        {
            if(user instanceof Tutor) {
                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).GetUsername() == user.GetUsername() && userList.get(i).GetPassword() == user.GetPassword()) {

                        for (int ii = 0; ii < takeCourse.size(); ii++) {
                            if (takeCourse.get(ii).GetUsername() == user.GetUsername() && takeCourse.get(ii).GetPassword() == user.GetPassword()) {
                                tutorList.remove(ii);
                                tutorCourse.remove(ii);
                                return true;
                            }
                        }
                    }

                }
            }

            return false;

        }
        return false;
    }

    public boolean ViewCurrentCourse(Person person)
    {
        if(person instanceof Teacher)
        {
            for(int i=0; i < courseList.size() ; i++)
                if(courseList.get(i).GetCourseDeadline()>2015)
                        System.out.println("Course "+(i+1)+": "+courseList.get(i).toString());


            return true;
        }

        return false;

    }
    public boolean ViewOldCourse(Person person)
    {
        if(person instanceof Teacher)
        {
            for(int i=0; i < courseList.size() ; i++)
            {
                if(courseList.get(i).GetCourseDeadline() < 2016)
                      System.out.println("Course "+(i+1)+": "+courseList.get(i).toString());
            }

            return true;
        }

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


    @Override
    public String toString() {

        String temp = GetcourseId()+" "+ GetCourseName() +" "+ GetCourseDeadline();
        return temp;

    }
}
