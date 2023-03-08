package persistence;

import model.Collection;
import model.Item;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import model.Workroom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Workroom wr = new Workroom("My work room");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Workroom wr = new Workroom("My work room");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(wr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            wr = reader.read();
            assertEquals("My work room", wr.getName());
            assertEquals(0, wr.numItems());
            assertEquals(0, wr.numCollections());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Workroom wr = new Workroom("Rachel work room");
            wr.addItem(new Item(0,"jeans", Item.Category.bottom));
            wr.addItem(new Item(1,"shirt", Item.Category.topping));

            wr.addCollection(new Collection("summer"));

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(wr);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            wr = reader.read();
            assertEquals("Rachel work room", wr.getName());
            List<Item> items = wr.getItems();
            assertEquals(2, items.size());
            checkItem("jeans", Item.Category.bottom,0, items.get(0));
            checkItem("shirt", Item.Category.topping,1, items.get(1));

            List<Collection> collections = wr.getCollections();
            assertEquals(1,collections.size());
            checkCollection("summer", collections.get(0));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }



}
