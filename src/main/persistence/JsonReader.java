package persistence;

import model.Collection;
import model.Item;
import model.Workroom;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Workroom read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkRoom(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private Workroom parseWorkRoom(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Workroom wr = new Workroom(name);
        addItems(wr, jsonObject);
        addCollections(wr,jsonObject);
        return wr;
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addItems(Workroom wr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addItem(wr, nextItem);
        }
    }


    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addItem(Workroom wr, JSONObject jsonObject) {
        String itemName = jsonObject.getString("itemName");
        int itemID = jsonObject.getInt("itemID");

        Item.Category category = Item.Category.valueOf(jsonObject.getString("itemCategory"));
        Item item = new Item(itemID,itemName, category);
        wr.addItem(item);
    }

    // MODIFIES: wr
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addCollections(Workroom wr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("collections");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addCollection(wr, nextItem);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addCollection(Workroom wr, JSONObject jsonObject) {
        String collectionName = jsonObject.getString("collectionName");
        Collection collection = new Collection(collectionName);
        wr.addCollection(collection);
    }




}