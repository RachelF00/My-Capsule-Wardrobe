package model;

import java.util.LinkedList;
/*
Collection is a class that represents a collection of different items.
Items in same collection should have something in common.
Collection has 4 fields: collectionName in string, num in int, itemList which is a linkedlist with Item,
and a MAX of 4.
 */

public class Collection {
    private String collectionName;
    private int num;
    private LinkedList<Item> itemList;
    public static final int MAX = 4;

    // MODIFIES: this
    // EFFECTS: a constructor to create a new Collection object
    public Collection(String collectionName) {
        this.num = 0;
        this.collectionName = collectionName;
        itemList = new LinkedList<Item>();
    }

   // REQUIRES: itemList is not full
   // MODIFIES: this
   // EFFECTS: add an Item to collection;
   //          return true if add is successful, false otherwise
    public boolean addtoCollection(Item i) {
        if (!this.isFull()) {
            this.num += 1;
            itemList.add(i);
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: Item i is already in itemList
    // MODIFIES: this
    // EFFECTS: remove an Item from collection
    //       return true if remove is successful, false otherwise
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

    public String getName() {
        return this.collectionName;
    }

    public int getNum() {
        return this.num;
    }


}
