package model;

import java.util.LinkedList;

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




    public UserAccount(String username, Gender gen, int id) {
        this.name = username;
        this.gender = gen;
        this.itemnum = 0;
        this.userId = id;

        itemList = new LinkedList<Item>();

        collectionList = new LinkedList<Collection>();
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

    public Collection createCollection(String name) {
        Collection c1 = new Collection(name);
        collectionList.add(c1);
        return c1;
    }

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

    public boolean addtoCollection(Item i, Collection c) {
        int j;
        for (j = 0;j < itemList.size();j++) {
            if (itemList.get(j).getID() == i.getID()) {
                return c.addtoCollection(i);
            }
        }
        return false;
    }

    public boolean removefromCollection(Item i, Collection c) {
        return c.removefromCollection(i);
    }




    /*
    Requires: itemList in UserAccount doesn't contain Item i
    Modifies: this
    Effects: add a new item to UserAccount
   */
    public boolean addItem(Item i) {
        if (!this.isFull()) {
            this.itemnum += 1;
            itemList.add(i);
            return true;
        } else {
            return false;
        }

    }

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



}
