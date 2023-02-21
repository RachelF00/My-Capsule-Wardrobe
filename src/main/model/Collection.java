package model;

import java.util.LinkedList;


public class Collection {
    private String collectionName;
    private int num;
    private LinkedList<Item> itemList;
    public static final int MAX = 4;

    public Collection(String collectionName) {
        this.num = 0;
        this.collectionName = collectionName;
        itemList = new LinkedList<Item>();
    }

    public String getName() {
        return this.collectionName;
    }

    public int getNum() {
        return this.num;
    }




    public boolean addtoCollection(Item i) {
        if (!this.isFull()) {
            this.num += 1;
            itemList.add(i);
            return true;
        } else {
            return false;
        }
    }

    public boolean removefromCollection(Item i) {
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
        if (itemList.size() == MAX) {
            return true;
        } else {
            return false;
        }
    }


}
