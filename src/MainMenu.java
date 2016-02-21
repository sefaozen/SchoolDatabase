import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

/**
 * Created by Sefa on 17.2.2016.
 */
public class MainMenu extends JFrame {



    public MainMenu() {
        File f = new File("Users.txt");
        try {
            if(!f.exists()){
                f.createNewFile();
               DosyaYazma("Users.txt","admin 1111 admin");
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
         f = new File("Course.txt");
        try {
            if(!f.exists()){
                f.createNewFile();
                DosyaYazma("Users.txt","admin 1111 admin");
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        MainWindow();
    }

    public void MainWindow() {
        JPanel panel = initJPanel();
        add(panel);

        setTitle("GTU SCHOOL DATABASE");
        pack();

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    }

    public JPanel initJPanel() {

        JPanel anaJPanel = new JPanel(new GridLayout(4, 2));

        JLabel username = new JLabel("User Name");
        final JTextField usernameString = new JTextField(20);
        JLabel password = new JLabel("Password");
        final JPasswordField passwordString = new JPasswordField(20);

        passwordString.setEchoChar('*');
        JButton girisButton = new JButton("Join");
        JButton cikisButtons = new JButton("Exit");
        anaJPanel.add(username);
        anaJPanel.add(usernameString);
        anaJPanel.add(password);
        anaJPanel.add(passwordString);
        anaJPanel.add(girisButton);
        anaJPanel.add(cikisButtons);
        girisButton.addActionListener( new ActionListener() {

            public void actionPerformed(ActionEvent action) {

                File file = new File("Users.txt");
                int temp=0;
                try {
                    Scanner scanner = new Scanner(file);

                    while(scanner.hasNextLine()){
                    String line= scanner.nextLine();

                        if(line.substring(0,line.indexOf(" ")).equals(usernameString.getText()))
                        {


                           if( line.substring(line.indexOf(" ")+1,line.lastIndexOf(" ")).equals(passwordString.getText()))
                           {
                                temp=1;

                               if(line.substring(line.lastIndexOf(" ")+1,line.length()).equals("admin"))
                               {
                                   //admin paneli
                                   JOptionPane.showMessageDialog(null, "Welcome Admin");

                                   Administrator ad=new Administrator(usernameString.getText(),passwordString.getText());
                                   usernameString.setText(" ");
                                   passwordString.setText(" ");

                                   break;

                               }
                               if(line.substring(line.lastIndexOf(" ")+1,line.length()).equals("teacher"))
                               {
                                   JOptionPane.showMessageDialog(null, "Welcome Teacher");
                                   Teacher t= new Teacher(usernameString.getText(),passwordString.getText());
                                   //teacher paneli
                                   usernameString.setText(" ");
                                   passwordString.setText(" ");

                                   break;
                               }
                               if(line.substring(line.lastIndexOf(" ")+1,line.length()).equals("tutor"))
                               {
                                   JOptionPane.showMessageDialog(null, "Welcome Tutor");
                                   //tutor paneli

                                   break;
                               }
                               if(line.substring(line.lastIndexOf(" ")+1,line.length()).equals("student"))
                               {
                                   JOptionPane.showMessageDialog(null, "Welcome Student");
                                   //student paneli

                                   break;
                               }
                           }

                        }


                    }
                    if(temp==0)
                            JOptionPane.showMessageDialog(null, "User Name Or Password is wrong");
                    scanner.close();
                } catch (FileNotFoundException e) {

                    e.printStackTrace();
                    System.out.println("File Not Found..");
                }

                }
            });



        cikisButtons.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                dispose();

            }
        });

        return anaJPanel;
    }




    public static void DosyaOlustur(String URL){
        File f = new File(URL);
        try {
            if(!f.exists()){                                     // eğer dosya yoksa
                f.createNewFile();                           // dosyamızı oluşturur.
                System.out.println(f.getName()+ " adlı dosya Oluşturuldu..");
            }
        } catch (IOException e) { // hata yakalama

            e.printStackTrace();
        }
    }
    public static void DosyaOku(String URL){
        File file = new File(URL);

        try {
            FileInputStream fis = new FileInputStream(file);


            fis.close();
        } catch (FileNotFoundException e) {

            System.out.println("Dosya Bulunamadı..");
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    public static void DosyaYazma(String URL,String Sent){
        File file = new File(URL);
        try {

            FileOutputStream fos = new FileOutputStream(file);

            Sent = Sent +"\n";

            fos.write(Sent.getBytes());
            fos.flush();

            fos.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
