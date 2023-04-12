package ui;

// This is the class for app's GUI

import model.Item;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.swing.ImageIcon;


import model.UserAccount;
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

    static UserAccount.Gender g1;
    static int userid = 1;
    static String username;
    static UserAccount u1;


    // EFFECTS: provide an entry for app
    public static void main(String[] args) {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        JFrame frame = new JFrame("User Panel");
        frame.setSize(360, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        addItem(panel);
        displayItem(panel);
        quit(panel);
        load(panel);
        save(panel);

        removeItem(panel);
        showTops(panel);
        createAccount(panel);
        frame.setVisible(true);
    }

    // EFFECTS: add a button for creating a new account
    public static void createAccount(JPanel panel) {
        JButton createButton = new JButton("Create New Account");
        createButton.setBounds(130,200,160,25);

        panel.add(createButton);

        class CreateHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j2 = createHelper1();
                createHelper2(j2);
                initialQuit(j2);
                initialCreate(j2);
            }
        }

        createButton.addActionListener(new CreateHandler());
    }

    // EFFECTS: helper function 1 for creating user account
    public static JFrame createHelper1() {
        JFrame j2 = new JFrame("Create Account");
        j2.setSize(350, 220);
        j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j2.setVisible(true);
        j2.setLayout(null);
        return j2;
    }

    // EFFECTS: helper function 2 for creating user account
    public static void createHelper2(JFrame j2) {
        JLabel name = new JLabel("Name:");
     //   JLabel gender = new JLabel("Gender: ");
        name.setBounds(15, 10, 80, 50);
 //       gender.setBounds(15, 50, 80, 50);
        j2.add(name);
    //    j2.add(gender);
    }

    // EFFECTS: add a button for quiting
    public static void initialQuit(JFrame panel1) {
        // Quit Button
        JButton quitButton = new JButton("quit");
        quitButton.setBounds(180,120,80,25);
        panel1.add(quitButton);

        class QuitHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {

               // System.exit(0);
                Workroom.close();
            }
        }

        quitButton.addActionListener(new QuitHandler());

    }

    // EFFECTS: add a button in account creating interface
    public static void initialCreate(JFrame panel1) {
        // Create a Create Account button
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(50,120,120,25);
        panel1.add(createAccountButton);
        JTextField name = new JTextField();
        name.setBounds(100,20,100,30);
        panel1.add(name);

        class CreateHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = name.getText();
                createPanel();
                JOptionPane.showMessageDialog(panel1,"Create Successfully!");

                panel1.dispose();
            }
        }

        createAccountButton.addActionListener(new CreateHandler());
    }

    // EFFECTS: helper function to create a new work room
    // MODIFIES: workRoom
    public static void createPanel() {
      //  u1 = new UserAccount(username,g1,userid);
        workRoom = new Workroom(username);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // EFFECTS: add a button for showing all the tops in itemlist
    public static void showTops(JPanel panel) {
        // ShowTops Button
        JButton showButton = new JButton("Show Tops");
        showButton.setBounds(200,140,120,25);
        panel.add(showButton);

        class ShowHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTops();
                Workroom.displayTops();
            }
        }

        showButton.addActionListener(new ShowHandler());


    }

    // EFFECTS: display all the items which are tops
    // MODIFIES: JFrame
    public static void displayTops() {
        JFrame j2 = new JFrame("Display Items");
        j2.setSize(350, 220);
        j2.setVisible(true);
        j2.setLayout(null);

        JPanel panel = new JPanel(new BorderLayout());
        JTable table = displayTopHelper();

        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);

        j2.setContentPane(panel);
        j2.pack();
        j2.setLocationRelativeTo(null);
    }

    // EFFECTS: return a JTable of all the top items
    public static JTable  displayTopHelper() {
        Object[][] columns = {{"",""},
                {"",""},
                {"",""},
                {"",""}
        };
        int i = 0;
        List<Item> items = workRoom.getItems();
        for (Item t:items) {
            if (t.getItemCategory() == Item.Category.top) {
                columns[i][0] = t.getID();
                columns[i][1] = t.getItemName();
                i++;
            }
        }

        Object[] columnNames = {"Item ID", "Item name"};
        JTable table = new JTable(columns, columnNames);
        return table;
    }

    // EFFECTS: add a button for removing an item
    public static void removeItem(JPanel panel) {
        //Remove Button
        JButton removeButton = new JButton("remove item");
        removeButton.setBounds(50,140,140,25);
        panel.add(removeButton);

        class NewRemoveFrame implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame j3 = removeHelper1();
                addId(j3);
                inputID(j3);
                back(j3);
            }
        }

        removeButton.addActionListener(new NewRemoveFrame());
    }

    // EFFECTS: add a JTextField to input the ID of the item
    // MODIFIES: workRoom
    public static void inputID(JFrame j2) {
        JTextField item = new JTextField();
        item.setBounds(60, 50, 80, 30);
        j2.add(item);
        JButton r1 = new JButton("Remove Item");
        r1.setBounds(40,140,120,30);
        j2.add(r1);

        class RemoveHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {

                String m = item.getText();
                int id = Integer.parseInt(m);
                int j;
                for (j = 0;j < workRoom.numItems();j++) {
                    if (workRoom.getItems().get(j).getID() == id) {
                        Item i = workRoom.getItems().get(j);
                        workRoom.removeItem(i);
                    }
                }
                JOptionPane.showMessageDialog(j2,"Remove Successfully!");
                j2.dispose();
            }
        }

        r1.addActionListener(new RemoveHandler());
    }


    // EFFECTS: add a new JFrame for removing an item
    public static JFrame removeHelper1() {
        JFrame j2 = new JFrame("Remove Item");
        j2.setSize(350, 220);
        j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j2.setVisible(true);
        j2.setLayout(null);
        return j2;
    }

   // EFFECTS: add a JLabel for prompt
    public static void addId(JFrame j2) {
        JLabel classification = new JLabel("Please input the item ID: ");
        classification.setBounds(15, 10, 250, 50);
        j2.add(classification);
    }

    // EFFECTS: add a button for adding an item
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


    // EFFECTS: helper function 1 to add an item
    public static JFrame addNewHelper1() {
        JFrame j2 = new JFrame("Add Item");
        j2.setSize(350, 220);
        j2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j2.setVisible(true);
        j2.setLayout(null);
        return j2;
    }

    // EFFECTS: add JLabels for item name and category
    public static void addName(JFrame j2) {
        JLabel itemname = new JLabel("Name:");
        JLabel classification = new JLabel("Category: ");
        itemname.setBounds(15, 10, 50, 50);
        classification.setBounds(15, 50, 100, 50);
        j2.add(itemname);
        j2.add(classification);

    }

   // EFFECTS: button for top
    // MODIFIES: c1
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

    // EFFECTS: button for bottom
    // MODIFIES: c1
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

    // EFFECTS: button for coat
    // MODIFIES: c1
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

    // EFFECTS: button for others
    // MODIFIES: c1
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

    // EFFECTS: add a button for going back to the initial interface
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

    // EFFECTS: add a new item
    // MODIFIES: workRoom
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
                workRoom.addItem(i1);
                addHelper(j2);
                j2.dispose();
            }
        }

        add.addActionListener(new AddExecute());
        j2.add(add);
    }

    // EFFECTS: helper function for adding an item
    public static void addHelper(JFrame j2) {
        ImageIcon icon = new ImageIcon("./data/pic.png");

        Image image = icon.getImage(); //icon--->Image

        float scale = 0.05f; //

        int width = Math.round(icon.getIconWidth() * scale);
        int height = Math.round(icon.getIconHeight() * scale);

        Image miniIcon = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        ImageIcon smallIcon = new ImageIcon(miniIcon);// Image--->icon
        JOptionPane.showMessageDialog(j2,"Add Successfully!","Add Item",0,smallIcon);

    }

    // EFFECTS: add a display button
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

    // EFFECTS: display all the items in the workRoom
    public static void display() {
        JFrame j2 = new JFrame("Display Items");
        j2.setSize(350, 220);
        j2.setVisible(true);
        j2.setLayout(null);

        JPanel panel = new JPanel(new BorderLayout());

        JTable table = displayhelper();

        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);

        j2.setContentPane(panel);
        j2.pack();
        j2.setLocationRelativeTo(null);

    }

    // EFFECTS: helper function for display items
    public static JTable displayhelper() {
        Object[][] columns = {{"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
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
        Workroom.displayItems();
        JTable table = new JTable(columns, columnNames);
        return table;
    }

    // EFFECTS: add a quit button
    public static void quit(JPanel panel) {
        // Quit Button
        JButton quitButton = new JButton("quit");
        quitButton.setBounds(20,80,80,25);
        panel.add(quitButton);

        class QuitHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {

                //System.exit(0);
                Workroom.close();
            }
        }

        quitButton.addActionListener(new QuitHandler());

    }

    // EFFECTS: add a button for loading date
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
                    java.util.List<Item> items = workRoom.getItems();
                    for (Item t : items) {
                        if (t.getID() >= itemID) {
                            itemID = t.getID();
                            itemID += 1;
                        }
                    }
                    JOptionPane.showMessageDialog(panel,"Load Successfully!");
                } catch (IOException e1) {
                    System.out.println("Unable to read from file: " + JSON_STORE);
                }
            }
        }

        loadButton.addActionListener(new LoadHandler());
    }

    // EFFECTS: add a button for save data
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
                    JOptionPane.showMessageDialog(panel,"Save Successfully!");
                } catch (FileNotFoundException e2) {
                    System.out.println("Unable to write to file: " + JSON_STORE);
                }
            }
        }

        saveButton.addActionListener(new SaveHandler());
    }

    // EFFECTS: add a button for female
    public static void addFemale(JFrame j2) {
        JButton b1 = new JButton("Female");
        b1.setBounds(10,70,50,50);

        class AddFemale implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                g1 = UserAccount.Gender.female;
            }
        }

        b1.addActionListener(new AddFemale());
        j2.add(b1);

    }

    // EFFECTS: add a button for male
    public static void addMale(JFrame j2) {
        JButton b1 = new JButton("Male");
        b1.setBounds(70,70,50,50);

        class AddMale implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                g1 = UserAccount.Gender.male;
            }
        }

        b1.addActionListener(new AddMale());
        j2.add(b1);
    }


    // EFFECTS: add a button for gender X
    public static void addX(JFrame j2) {
        JButton b1 = new JButton("X");
        b1.setBounds(10,70,50,50);

        class AddX implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                g1 = UserAccount.Gender.X;
            }
        }

        b1.addActionListener(new AddX());
        j2.add(b1);

    }



}
