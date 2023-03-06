package model;

import java.util.LinkedList;
/*
UserAccount is a class to represent user info.
Each user of this app should have a unique UserAccount.
 */

public class UserAccount {
    private int userId;
    private String name;

    public enum Gender {
        female, male, X;
    }

    private Gender gender;
    private int itemnum;
    private LinkedList<Item> itemList;
    public static final int MAX_SIZE = 5;
    private LinkedList<Collection> collectionList;

    // MODIFIES: this
    // EFFECTS: constructor to create a new UserAccount object
    public UserAccount(String username, Gender gen, int id) {
        this.name = username;
        this.gender = gen;
        this.itemnum = 0;
        this.userId = id;

        itemList = new LinkedList<Item>();

        collectionList = new LinkedList<Collection>();
    }

    // MODIFIES: this
    // EFFECTS: create a new Collection
    public Collection createCollection(String name) {
        Collection c1 = new Collection(name);
        collectionList.add(c1);
        return c1;
    }

    // REQUIRES: Collection c already exists in collectionList
    // MODIFIES: this
    // EFFECTS: remove a Collection
    public boolean removeCollection(Collection c) {
        int j;
        for (j = 0;j < collectionList.size();j++) {
            if (collectionList.get(j).getName() == c.getName()) {
                collectionList.remove(c);
                return true;
            }
        }
        return false;
    }

    // REQUIRES: Item i already exists in itemList
    // MODIFIES: this
    // EFFECTS: add an item to a collection
    public boolean addtoCollection(Item i, Collection c) {
        int j;
        for (j = 0;j < itemList.size();j++) {
            if (itemList.get(j).getID() == i.getID()) {
                return c.addtoCollection(i);
            }
        }
        return false;
    }

    // REQUIRES: Item i already exists in Collection C
    // MODIFIES: this
    // EFFECTS: remove and item from a collection
    public boolean removefromCollection(Item i, Collection c) {
        return c.removefromCollection(i);
    }


   // Requires: itemList in UserAccount doesn't contain Item i
   // Modifies: this
   // Effects: add a new item to UserAccount
    public boolean addItem(Item i) {
        if (!this.isFull()) {
            this.itemnum += 1;
            itemList.add(i);
            return true;
        } else {
            return false;
        }

    }

    // REQUIRES: Item i already existts in itemList
    // MODIFIES: this
    // EFFECTS: remove an item from itemList
    public boolean  removeItem(Item i) {
        int j;
        for (j = 0;j < itemList.size();j++) {
            if (itemList.get(j).getID() == i.getID()) {
                itemList.remove(i);
                return true;
            }
        }
        return false;

    }

    // EFFECTS: return true if the itemList is full, false otherwise
    public boolean isFull() {
        if (itemList.size() == MAX_SIZE) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return this.gender;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getNum() {
        return this.itemnum;
    }

    public  LinkedList<Item> getItemList() {
        return this.itemList;
    }

    public  LinkedList<Collection> getCollectionList() {
        return this.collectionList;
    }




}
