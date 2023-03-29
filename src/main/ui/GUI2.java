package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI2 {

    public static void createAccount(JPanel panel) {
        JButton createButton = new JButton("Create New Account");
        createButton.setBounds(240,120,120,25);

        panel.add(createButton);

        class CreateHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j2 = createHelper1();
                createHelper2(j2);
            }
        }
    }

    public static JFrame createHelper1() {
        JFrame j2 = new JFrame("Create Account");
        j2.setSize(350, 220);
        j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j2.setVisible(true);
        j2.setLayout(null);
        return j2;
    }

    public static void createHelper2(JFrame j2) {
        JLabel name = new JLabel("Name:");
        //      JTextField item = new JTextField();
        JLabel gender = new JLabel("Gender: ");
        name.setBounds(15, 10, 50, 50);
        //    item.setBounds(60, 20, 120, 30);
        gender.setBounds(15, 50, 100, 50);
        j2.add(name);
        //   j2.add(item);
        j2.add(gender);
    }



    public static void initialQuit(JPanel panel1) {
        // Quit Button
        JButton quitButton = new JButton("quit");
        quitButton.setBounds(20,80,80,25);
        panel1.add(quitButton);

        class QuitHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }

        quitButton.addActionListener(new QuitHandler());

    }

    public static void initialCreate(JPanel panel1) {
        // Create a Create Account button
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(150,80,150,25);
        panel1.add(createAccountButton);

        class CreateHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPanel();
            }
        }
    }

    public static void createPanel() {


    }
}
