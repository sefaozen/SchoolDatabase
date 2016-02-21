import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Created by Sefa on 16.2.2016.
 */
public class Teacher extends JFrame implements Person {


    private String surname="surname";
    private String password="password";

    public Teacher ( String s, String p)
    {

        SetSurname(s);
        SetPassword(p);
        SetSurname(s);
        SetPassword(p);

        JPanel panel = initJPanel();
        add(panel);

        setTitle("Teacher Console");
        pack();

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    }
    public JPanel initJPanel() {

        JPanel anaJPanel = new JPanel(new GridLayout(4, 8));

        JButton userAdd = new JButton("Add Users To Courses");
        JButton userRemove = new JButton("Remove Users To Courses");
        JButton tutorAdd = new JButton("Add Tutor To Courses");
        JButton tutorRemove = new JButton("Remove Tutor To Courses");
        JButton addDocument = new JButton("Add Document");
        JButton addAssignment = new JButton("Add Assignment");
        JButton viewCourse = new JButton("View Course");
        JButton cikisButtons = new JButton("Exit");


        anaJPanel.add(userAdd);
        anaJPanel.add(userRemove);
        anaJPanel.add(tutorAdd);
        anaJPanel.add(tutorRemove);
        anaJPanel.add(addDocument);
        anaJPanel.add(addAssignment);
        anaJPanel.add(viewCourse);
        anaJPanel.add(cikisButtons);

        userAdd.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent action) {

                File file = new File("Course.txt");
                java.util.List<String> line =new ArrayList<String>();

                try {
                    Scanner scanner = new Scanner(file);

                    while(scanner.hasNextLine()) {
                        line.add(scanner.nextLine());

                    }
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                String[] temp = new String[line.size()];

                for(int i=0;i <line.size();i++ )
                {
                    temp[i]=line.get(i);
                }
                JList list = new JList(temp);
                JOptionPane.showMessageDialog(null, list, "Course", JOptionPane.PLAIN_MESSAGE);

                String userNo = JOptionPane.showInputDialog("Please Enter User No");

                String write= line.get(list.getSelectedIndex()) + " "+ userNo +"\n";
                File file1 = new File("CourseWithUser.txt");

                try {

                    if(!file1.exists()){
                        file.createNewFile();

                    }
                } catch (IOException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                try {



                    FileWriter fileWriter = new FileWriter(file1,true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write(write);
                    bWriter.close();
                } catch (FileNotFoundException e) {

                    e.printStackTrace();
                } catch (IOException e) {

                    e.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Added successfully");

            }});

        userRemove.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent action) {

                String userNo = JOptionPane.showInputDialog("Please Enter User No");

                File file = new File("CourseWithUser.txt");
                List<String> line =new ArrayList<String>();

                try {
                    Scanner scanner = new Scanner(file);

                    while(scanner.hasNextLine()) {
                        line.add(scanner.nextLine());

                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                String[] lessons=new String[line.size()];

                int ii=0;
                for(int i =0; i< line.size() ; i++)
                {
                        if(line.get(i).contains(userNo))
                        {
                            lessons[ii]=line.get(i).substring(0,line.get(i).indexOf(" "));
                            ii++;
                        }
                }

                JList list = new JList(lessons);
                JOptionPane.showMessageDialog(null, list, "Course", JOptionPane.PLAIN_MESSAGE);

                for(int i =0; i< line.size() ; i++) {

                         if (line.get(i).contains(userNo)) {

                             if(line.get(i).contains(lessons[list.getSelectedIndex()]))
                             {
                                 line.remove(i);
                             }

                    }

                }

                FileWriter fwOb = null;
                try {
                    fwOb = new FileWriter("CourseWithUser.txt", false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PrintWriter pwOb = new PrintWriter(fwOb, false);
                pwOb.flush();
                pwOb.close();
                try {
                    fwOb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String t;

                for(int i =0; i < line.size(); i++) {

                        t = line.get(i);
                        try {

                            t = t + "\n";

                            FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter bWriter = new BufferedWriter(fileWriter);
                            bWriter.write(t);
                            bWriter.close();
                        } catch (FileNotFoundException e) {

                            e.printStackTrace();
                        } catch (IOException e) {

                            e.printStackTrace();
                        }

                }

                JOptionPane.showMessageDialog(null, "Removed Succesfully");
            }});


        tutorAdd.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent action) {

                File file = new File("Course.txt");
                java.util.List<String> line =new ArrayList<String>();

                try {
                    Scanner scanner = new Scanner(file);

                    while(scanner.hasNextLine()) {
                        line.add(scanner.nextLine());

                    }
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                String[] temp = new String[line.size()];

                for(int i=0;i <line.size();i++ )
                {
                    temp[i]=line.get(i);
                }
                JList list = new JList(temp);
                JOptionPane.showMessageDialog(null, list, "Course", JOptionPane.PLAIN_MESSAGE);

                String userNo = JOptionPane.showInputDialog("Please Enter Tutor No");

                String write= line.get(list.getSelectedIndex()) + " "+ userNo +"\n";
                File file1 = new File("CourseWithTutor.txt");

                try {

                    if(!file1.exists()){
                        file.createNewFile();

                    }
                } catch (IOException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                try {



                    FileWriter fileWriter = new FileWriter(file1,true);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write(write);
                    bWriter.close();
                } catch (FileNotFoundException e) {

                    e.printStackTrace();
                } catch (IOException e) {

                    e.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "Added successfully");

            }});

        cikisButtons.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent action) {

                dispose();

            }});


        tutorRemove.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent action) {

                String userNo = JOptionPane.showInputDialog("Please Enter User No");

                File file = new File("CourseWithTutor.txt");
                List<String> line =new ArrayList<String>();

                try {
                    Scanner scanner = new Scanner(file);

                    while(scanner.hasNextLine()) {
                        line.add(scanner.nextLine());

                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                String[] lessons=new String[line.size()];

                int ii=0;
                for(int i =0; i< line.size() ; i++)
                {
                    if(line.get(i).contains(userNo))
                    {
                        lessons[ii]=line.get(i).substring(0,line.get(i).indexOf(" "));
                        ii++;
                    }
                }

                JList list = new JList(lessons);
                JOptionPane.showMessageDialog(null, list, "Course", JOptionPane.PLAIN_MESSAGE);

                for(int i =0; i< line.size() ; i++) {

                    if (line.get(i).contains(userNo)) {

                        if(line.get(i).contains(lessons[list.getSelectedIndex()]))
                        {
                            line.remove(i);
                        }

                    }

                }

                FileWriter fwOb = null;
                try {
                    fwOb = new FileWriter("CourseWithTutor.txt", false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                PrintWriter pwOb = new PrintWriter(fwOb, false);
                pwOb.flush();
                pwOb.close();
                try {
                    fwOb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String t;

                for(int i =0; i < line.size(); i++) {

                    t = line.get(i);
                    try {

                        t = t + "\n";

                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bWriter = new BufferedWriter(fileWriter);
                        bWriter.write(t);
                        bWriter.close();
                    } catch (FileNotFoundException e) {

                        e.printStackTrace();
                    } catch (IOException e) {

                        e.printStackTrace();
                    }

                }

                JOptionPane.showMessageDialog(null, "Removed Succesfully");
            }});


        viewCourse.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent action) {

                File file = new File("Course.txt");
                java.util.List<String> line =new ArrayList<String>();

                try {
                    Scanner scanner = new Scanner(file);

                    while(scanner.hasNextLine()) {
                        line.add(scanner.nextLine());

                    }
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                String[] temp = new String[line.size()];

                for(int i=0;i <line.size();i++ )
                {
                    temp[i]=line.get(i);
                }
                JList list = new JList(temp);
                JOptionPane.showMessageDialog(null, list, "Course", JOptionPane.PLAIN_MESSAGE);


            }});




        return anaJPanel;
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


