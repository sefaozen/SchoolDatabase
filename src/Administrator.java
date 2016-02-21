import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sefa on 16.2.2016.
 */
public class Administrator extends JFrame implements Person  {


    private String surname="surname";
    private String password="password";

    public Administrator( String s, String p)
    {
        SetSurname(s);
        SetPassword(p);

        JPanel panel = initJPanel();
        add(panel);

        setTitle("Admin Console");
        pack();

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    }


    @Override
    public void PrintScreen() {

    }
    public JPanel initJPanel() {

        JPanel anaJPanel = new JPanel(new GridLayout(4,8 ));

        JButton courseAdd = new JButton("Course Add");
        JButton courseRemove = new JButton("Course Remove");
        JButton userAdd = new JButton("User Add");
        JButton userRemove = new JButton("User Remove");
        JButton cikisButtons = new JButton("Exit");


        anaJPanel.add(courseAdd);
        anaJPanel.add(courseRemove);
        anaJPanel.add(userAdd);
        anaJPanel.add(userRemove);
        anaJPanel.add(cikisButtons);

        courseAdd.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent action) {

                int temp=0;
                while(temp==0) {
                    String coursename = JOptionPane.showInputDialog("Please Enter Course Name");
                    File file = new File("Course.txt");
                    try {
                        Scanner scanner = new Scanner(file);

                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();

                            if (line.equals(coursename))
                                temp = 1;
                        }
                        if (temp == 0) {
                            if(!coursename.equals(null)){
                                        AddCourse(coursename);
                                        JOptionPane.showMessageDialog(null, "Added successfully");
                            }
                            temp=1;
                        } else{
                            JOptionPane.showMessageDialog(null, "Course added before. Please Enter Different Course");
                            temp=0;
                        }


                        scanner.close();
                    } catch (FileNotFoundException e) {

                        e.printStackTrace();
                        System.out.println("File Not Found..");
                    }
                }
            }
        });

        userAdd.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent action) {


                    String username = JOptionPane.showInputDialog("Please Enter User Name");
                    String password = JOptionPane.showInputDialog("Please Enter Password Name");

                    String[] who= { "Admin", "Teacher" , "Tutor", "Student"};

                    JList list = new JList(who);
                     JOptionPane.showMessageDialog(null, list, "Multi-Select Example", JOptionPane.PLAIN_MESSAGE);

                    if(list.getSelectedIndex()==0)
                        AddUser(username+" "+password+" "+"admin");
                    if(list.getSelectedIndex()==1)
                        AddUser(username+" "+password+" "+ "teacher");
                    if(list.getSelectedIndex()==2)
                        AddUser(username+" "+password+" "+ "tutor");
                    if(list.getSelectedIndex()==3)
                        AddUser(username+" "+password+" "+ "student");

                     JOptionPane.showMessageDialog(null, "Added successfully");

            }
        });

        courseRemove.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent action) {

                File file = new File("Course.txt");
                List <String> line =new ArrayList<String>();

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

                line.remove(list.getSelectedIndex());

                FileWriter fwOb = null;
                try {
                    fwOb = new FileWriter("Course.txt", false);
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
                    t=line.get(i);
                        try {

                            t = t + "\n";

                            FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter bWriter = new BufferedWriter(fileWriter);
                            bWriter.write(t);
                            bWriter.close();
                        }
                        catch (FileNotFoundException e) {

                            e.printStackTrace();
                        }
                        catch (IOException e) {

                            e.printStackTrace();
                        }

                }
            }});

        userRemove.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent action) {

                File file = new File("Users.txt");
                List <String> line =new ArrayList<String>();

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
                    temp[i]=line.get(i).substring(0,line.get(i).indexOf(" "));
                }
                JList list = new JList(temp);
                JOptionPane.showMessageDialog(null, list, "Users", JOptionPane.PLAIN_MESSAGE);

                line.remove(list.getSelectedIndex());

                FileWriter fwOb = null;
                try {
                    fwOb = new FileWriter("Users.txt", false);
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
                    t=line.get(i);
                    try {

                        t = t + "\n";

                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bWriter = new BufferedWriter(fileWriter);
                        bWriter.write(t);
                        bWriter.close();
                    }
                    catch (FileNotFoundException e) {

                        e.printStackTrace();
                    }
                    catch (IOException e) {

                        e.printStackTrace();
                    }

                }
            }});

        cikisButtons.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent action) {


                dispose();

            }});


        return  anaJPanel;

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



    public void AddUser(String t)
    {
        File file = new File("Users.txt");
        try {
            if(!file.exists()){
                file.createNewFile();

            }
        } catch (IOException e) { // hata yakalama

            e.printStackTrace();
        }
        try {

            t = t +"\n";

            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(t);
            bWriter.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    public void AddCourse(String t)
    {
        File file = new File("Course.txt");
        try {
            if(!file.exists()){
                file.createNewFile();

            }
        } catch (IOException e) { // hata yakalama
            // TODO: handle exception
            e.printStackTrace();
        }
        try {

            t = t +"\n";

            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(t);
            bWriter.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
