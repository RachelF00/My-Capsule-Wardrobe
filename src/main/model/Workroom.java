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

        collections = new ArrayList<>();

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


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("items", itemsToJson());
        json.put("collections",collectionsToJson());

        return json;

    }

    private JSONArray itemsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Item t : items) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }

    private JSONArray collectionsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Collection c : collections) {
            jsonArray.put(c.toJson());
        }
        return jsonArray;
    }




}
