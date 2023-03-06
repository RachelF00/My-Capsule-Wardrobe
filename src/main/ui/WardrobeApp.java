package ui;

/*
WardrobeApp Application
 */
// import jdk.jfr.Category;
// import model.Collection;

import model.Item;
//import model.Collection;
import model.UserAccount;

// import java.util.LinkedList;
import java.util.Scanner;

public class WardrobeApp {
    private UserAccount u1;
    private UserAccount u2;
    private Item i1;

    private Scanner input;
    private int itemID = 0;

    // EFFECTS: runs the teller application
    public WardrobeApp() {
        runWardrobe();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    public void runWardrobe() {
        boolean keepGoing = true;
        String command;
        String command1;

        init();
        displayMenu();
        command = input.nextLine();
        command = command.toLowerCase();
        if (command.equals("q")) {
            System.out.println("\nGoodbye!");
        } else {
            processCommand(command);
            while (keepGoing) {
                displayOperation();
                input = new Scanner(System.in);
                command1 = input.nextLine().toLowerCase();

                if (command1.equals("q")) {
                    keepGoing = false;
                } else {
                    processOperation(command1);
                }
            }
            System.out.println("\nGoodbye!");
        }
    }


    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("--------------------------- ");
        System.out.println("\nSelect from:");
        System.out.println("\tc -> create a new user account");
    //    System.out.println("\tl -> log in your account");
        System.out.println("\tq -> quit");

    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        u1 = new UserAccount("Rachel", UserAccount.Gender.female,0);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("c")) {
            createAccount();

        } else if (command.equals("l")) {
            logIn();

        }  else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: displays menu of operations to user
    private void displayOperation() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add an item to my item list");
        System.out.println("\tr -> remove an item to my item list");
        System.out.println("\tc -> create a new collection");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user operation
    private void processOperation(String command) {
        if (command.equals("a")) {
            addItem();
            itemID += 1;
            displayItems();
        } else if (command.equals("r")) {
            displayItems();
            removeItem();
            displayItems();
        } else if (command.equals("c")) {
            newCollection();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: displays genders for user to select
    private void displayGender() {
        System.out.println("Please input your gender:");
        System.out.println("\t1 -> female");
        System.out.println("\t2 -> male");
        System.out.println("\t3 -> X");
    }

    // EFFECTS: displays account information
    private void displayAccount() {
        System.out.println("A new UserAccount was created!");
        System.out.println("Username: " + u2.getName());
        System.out.println("Gender: " + u2.getGender());
        System.out.println("UserID: " + u2.getUserId());
        System.out.println("*** Please always remember your UserID to log in ***");
        System.out.println("--------------------------- ");
    }

    // MODIFIES: this
    // EFFECTS: create a new account
    private void createAccount() {
        System.out.println("--------------------------- ");
        System.out.println("Please input your Username: ");
        String username = input.nextLine();
        displayGender();
        UserAccount.Gender usergender;
        int gender = input.nextInt();
        System.out.println("--------------------------- ");

        while (!(gender == 1 || gender == 2 || gender == 3)) {
            displayGender();
            gender = input.nextInt();
        }

        if (gender == 1) {
            usergender = UserAccount.Gender.female;
        } else if (gender == 2) {
            usergender = UserAccount.Gender.male;
        } else {
            usergender = UserAccount.Gender.X;
        }
        int userid = 1;
        u2 = new UserAccount(username,usergender,userid);
        displayAccount();

    }

    // EFFECTS: for user to log in
    private void logIn() {
        System.out.println("Welcome to Wardrobe App!");
        System.out.println("Please input your UserID: ");
        int id = input.nextInt();
        if (u1.getUserId() == id) {
            System.out.println("Hi, " + u1.getName() + "!");

        } else if (u2.getUserId() == id) {
            System.out.println("Hi, " + u2.getName() + "!");
        } else {
            System.out.println("User cannot be found!");
        }
        System.out.println("--------------------------- ");
    }

    // MODIFIES: this
    // EFFECTS: add an item to a UserAccount's itemList
    private void addItem() {
        System.out.println("Please input the name of the item: ");
        String name = input.nextLine();
        System.out.println("Please input the category of the item: )");
        System.out.println("\t1 -> topping");
        System.out.println("\t2 -> bottom");
        System.out.println("\t3 -> coat");
        System.out.println("\t4 -> others");
        Item.Category c1;
        int cate = input.nextInt();
        if (cate == 1) {
            c1 = Item.Category.topping;
        } else if (cate == 2) {
            c1 = Item.Category.bottom;
        } else if (cate == 3) {
            c1 = Item.Category.coat;
        } else   {
            c1 = Item.Category.others;
        }

        i1 = new Item(itemID,name,c1);
        u2.addItem(i1);
    }

    // REQUIRES: the Item which itemID represents already exist in itemList
    // MODIFIES: this
    // EFFECTS: remove an Item from a UserAccount's itemList
    private void removeItem() {
        System.out.println("Please input itemID you want to remove:");
        int id = input.nextInt();
        int j;
        for (j = 0;j < u2.getItemList().size();j++) {
            if (u2.getItemList().get(j).getID() == id) {
                u2.removeItem(u2.getItemList().get(j));
            }
        }
    }

    // EFFECTS: display the list of item information
    private void displayItems() {
        System.out.println("-------This is your item list:--------");
        for (int i = 0;i < u2.getItemList().size(); i++) {
            System.out.println("ItemID:" + u2.getItemList().get(i).getID() + "," + "ItemName" + ":"
                    + u2.getItemList().get(i).getItemName());
        }
        System.out.println("---------------------------------------");
    }

    // MODIFIES: this
    // EFFECTS: create a new collection
    private void newCollection() {
        System.out.println("Please input the name of your collection:");
        input = new Scanner(System.in);
        String s1 = input.nextLine();
        u1.createCollection(s1);
        System.out.println("Your collection " + s1 + " is successfully created!");
    }





}
