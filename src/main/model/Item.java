package model;

/*
Item is a class that represents each single item in useraccounts.
Each item has a unique integer to identify,
*/

public class Item {
 //   private int itemID; // a unique integer
    final int itemID;
 //   private String itemName;
    final String itemName;

    public enum Category {
        topping, bottom, coat, others
    }

//    private Category itemCategory;// 1 for toppings, 2 for bottoms, 3 for coats, 4 for others
    final Category itemCategory;

   // private String purchaseDate; // a six-digit date, e.g. 201806 represents June in 2018


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


}
