package model;

/*
Item is a class that represents each single item in UserAccount and in Collection.
Each item has a unique integer to identify (ItemID), a name and a Category.
*/

import org.json.JSONObject;
import persistence.Writable;

public class Item implements Writable {
    final int itemID;          //unique ID
    final String itemName;    //itemName

    public enum Category {    // Category in enumerate
        topping, bottom, coat, others
    }

    final Category itemCategory;


    // MODIFIES: this
    // EFFECTS:  constructor which is used to create a new Item object
    public Item(int itemID,String itemName, Category itemCategory) {
        this.itemID = itemID;
        this.itemName = itemName;
        this. itemCategory = itemCategory;
     //   this.purchaseDate = purchaseDate;

    }

    public int getID() {
        return this.itemID;
    }

    public String getItemName() {
        return this.itemName;
    }

    public Category getItemCategory() {
        return this.itemCategory;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("itemID", itemID);
        json.put("itemName", itemName);
        json.put("itemCategory", itemCategory);
        return json;
    }


}
