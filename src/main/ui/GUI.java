package ui;

import model.Collection;
import model.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


import persistence.JsonReader;
import persistence.JsonWriter;

import model.Workroom;

public class GUI {

    private static final String JSON_STORE = "./data/workroom.json";
    static Workroom workRoom;
    static JsonWriter jsonWriter;
    static JsonReader jsonReader;
    static int itemID = 0;
    static Item.Category c1;
    static String s1;


    public static void main(String[] args) {
        JFrame frame = new JFrame("User Panel");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

      //  placeComponents(panel);

        addItem(panel);
        displayItem(panel);
        quit(panel);
        load(panel);
        save(panel);

        frame.setVisible(true);
    }

    public static void addItem(JPanel panel) {
        // Add Button
        JButton addButton = new JButton("add item");
        addButton.setBounds(50,20,100,25);
        panel.add(addButton);

        class NewFrame1 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j2 = addNewHelper1();
                addName(j2);
                addTop(j2);
                addBottom(j2);
                addCoat(j2);
                addOthers(j2);
                back(j2);
                add(j2);
            }
        }

        addButton.addActionListener(new NewFrame1());
    }

    public static JFrame addNewHelper1() {
        JFrame j2 = new JFrame("Add Item");
        j2.setSize(350, 220);
        j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j2.setVisible(true);
        j2.setLayout(null);
        return j2;
    }

    public static void addName(JFrame j2) {
        JLabel itemname = new JLabel("Name:");
    //    JTextField item = new JTextField();
        JLabel classification = new JLabel("Category: ");
        itemname.setBounds(15, 10, 50, 50);
    //    item.setBounds(60, 20, 120, 30);
        classification.setBounds(15, 50, 100, 50);
        j2.add(itemname);
     //   j2.add(item);
        j2.add(classification);

    }

    public static void addTop(JFrame j2) {
        JButton b1 = new JButton("top");
        b1.setBounds(15, 100, 45, 20);
        class TopSelect implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                c1 = Item.Category.top;
            }
        }

        b1.addActionListener(new TopSelect());
        j2.add(b1);
    }

    public static void addBottom(JFrame j2) {
        JButton b2 = new JButton("bottom");
        b2.setBounds(80, 100, 60, 20);
        class BottomSelect implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1 = Item.Category.bottom;
            }
        }

        b2.addActionListener(new BottomSelect());
        j2.add(b2);

    }

    public static void addCoat(JFrame j2) {

        JButton b3 = new JButton("coat");
        b3.setBounds(160, 100, 45, 20);
        class CoatSelect implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1 = Item.Category.coat;
            }
        }

        b3.addActionListener(new CoatSelect());
        j2.add(b3);
    }

    public static void addOthers(JFrame j2) {

        JButton b4 = new JButton("others");

        b4.setBounds(225, 100, 60, 20);


        class OtherSelect implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                c1 = Item.Category.others;
            }
        }

        b4.addActionListener(new OtherSelect());
        j2.add(b4);
    }

    public static void back(JFrame j2) {

        JButton back = new JButton("Back");
        back.setBounds(180,140,60,30);

        class BackExecute implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                j2.dispose();
            }

        }

        back.addActionListener(new BackExecute());
        j2.add(back);
    }

    public static void add(JFrame j2) {
        JTextField item = new JTextField();
        item.setBounds(60, 20, 120, 30);
        j2.add(item);
        JButton add = new JButton("Add Item");
        add.setBounds(40,140,100,30);

        class AddExecute implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = item.getText();
                Item i1 = new Item(itemID,s,c1);
                itemID += 1;
              //  System.out.println(s);
                workRoom.addItem(i1);
                System.out.println("Item added successfully!");
                j2.dispose();
            }
        }

        add.addActionListener(new AddExecute());
        j2.add(add);
    }

    public static void displayItem(JPanel panel) {
        // Display Button
        JButton displayButton = new JButton("display items");
        displayButton.setBounds(200,20,120,25);
        class DisplayHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                display();
            }
        }

        displayButton.addActionListener(new DisplayHandler());
        panel.add(displayButton);
    }

    public static void display() {
        JFrame j2 = new JFrame("Display Items");
        j2.setSize(350, 220);
        j2.setVisible(true);
        j2.setLayout(null);

        JPanel panel = new JPanel(new BorderLayout());

        Object[][] columns = {{"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""}
        };
        int i = 0;
        List<Item> items = workRoom.getItems();
        for (Item t:items) {
            columns[i][0] = t.getID();
            columns[i][1] = t.getItemName();
            columns[i][2] = t.getItemCategory();
            i++;
        }

        Object[] columnNames = {"Item ID", "Item name", "Category"};
        JTable table = new JTable(columns, columnNames);

        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);

        j2.setContentPane(panel);
        j2.pack();
        j2.setLocationRelativeTo(null);

    }

    public static void quit(JPanel panel) {
        // Quit Button
        JButton quitButton = new JButton("quit");
        quitButton.setBounds(20,80,80,25);
        panel.add(quitButton);

        class QuitHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }

        quitButton.addActionListener(new QuitHandler());

    }

    public static void load(JPanel panel) {
        // Load Button
        JButton loadButton = new JButton("load data");
        loadButton.setBounds(120,80,100,25);
        panel.add(loadButton);
        class LoadHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    workRoom = jsonReader.read();
                    //System.out.println("Loaded " + workRoom.getName() + " from " + JSON_STORE);
                    java.util.List<Item> items = workRoom.getItems();
                    for (Item t : items) {
                        if (t.getID() > itemID) {
                            itemID = t.getID();
                            itemID += 1;
                        }
                    }
                    List<Collection> collections = workRoom.getCollections();
                    JOptionPane.showMessageDialog(panel,"Load Successfully!");
                } catch (IOException e1) {
                    System.out.println("Unable to read from file: " + JSON_STORE);
                }
            }
        }

        loadButton.addActionListener(new LoadHandler());
    }

    public static void save(JPanel panel) {
        // Save Button
        JButton saveButton = new JButton("save data");
        saveButton.setBounds(240,80,100,25);
        panel.add(saveButton);

        class SaveHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(workRoom);
                    jsonWriter.close();
                    //System.out.println("Saved " + workRoom.getName() + " to " + JSON_STORE);
                    JOptionPane.showMessageDialog(panel,"Save Successfully!");
                } catch (FileNotFoundException e2) {
                    System.out.println("Unable to write to file: " + JSON_STORE);
                }
            }
        }

        saveButton.addActionListener(new SaveHandler());
    }


    public static void placeComponents(JPanel panel) {
        panel.setLayout(null);
        // Create a quit Button
        JButton quitButton = new JButton("quit");
        quitButton.setBounds(50,80,80,25);
        panel.add(quitButton);

        // Create a Create Account button
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(150,80,150,25);
        panel.add(createAccountButton);
    }


}
