package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class Workroom implements Writable {
    private String name;
    private List<Item> items;
    private List<Collection> collections;

    public Workroom(String name) {
        this.name = name;
        items = new ArrayList<>();
<<<<<<< HEAD
        collections = new ArrayList<>();
=======
>>>>>>> origin/main
    }

    public String getName() {
        return name;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

<<<<<<< HEAD
    public void addCollection(Collection collection) {
        collections.add(collection);
=======
    public void addCollection() {
>>>>>>> origin/main

    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

<<<<<<< HEAD
    public List<Collection> getCollections() {
        return Collections.unmodifiableList(collections);
    }

=======
>>>>>>> origin/main
    public int numItems() {
        return items.size();
    }

<<<<<<< HEAD
    public int numCollections() {
        return collections.size();
    }

=======
>>>>>>> origin/main
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("items", itemsToJson());
<<<<<<< HEAD
        json.put("collections",collectionsToJson());
=======
>>>>>>> origin/main
        return json;

    }

    private JSONArray itemsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Item t : items) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }

<<<<<<< HEAD
    private JSONArray collectionsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Collection c : collections) {
            jsonArray.put(c.toJson());
        }
        return jsonArray;
    }

=======
>>>>>>> origin/main



}
