package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

// Represents a workroom having items and collections
public class Workroom implements Writable {
    private String name;
    private List<Item> items;
    private List<Collection> collections;


    // EFFECTS: constructs workroom with a name, an empty list of items and an
    // empty list of collections
    public Workroom(String name) {
        this.name = name;
        items = new ArrayList<>();
        collections = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    // MODIFIES: this
    // EFFECTS: adds item to this workroom
    public void addItem(Item item) {
        items.add(item);
    }

    // MODIFIES: this
    // EFFECTS: remove item from this workroom
    public void removeItem(Item item) {
        items.remove(item);
    }

    // MODIFIES: this
    // EFFECTS: adds collection to this workroom
    public void addCollection(Collection collection) {
        collections.add(collection);
    }


    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }


    public List<Collection> getCollections() {
        return Collections.unmodifiableList(collections);
    }

    public int numItems() {
        return items.size();
    }


    public int numCollections() {
        return collections.size();
    }


    // EFFECTS: write into a Json document
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("items", itemsToJson());
        json.put("collections",collectionsToJson());
        return json;

    }

    // EFFECTS: return items in this workroom as a JSON array
    private JSONArray itemsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Item t : items) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }

    // EFFECTS: returns collections in this workroom as a JSON array
    private JSONArray collectionsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Collection c : collections) {
            jsonArray.put(c.toJson());
        }
        return jsonArray;
    }




}
