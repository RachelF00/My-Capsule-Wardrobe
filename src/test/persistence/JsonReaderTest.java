package persistence;

import model.Collection;
import model.Item;
import model.Workroom;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Workroom wr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
        try {
            Workroom wr = reader.read();
            assertEquals("My work room", wr.getName());
            assertEquals(0, wr.numItems());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralWorkRoom.json");
        try {
            Workroom wr = reader.read();
            assertEquals("Rachel", wr.getName());
            List<Item> items = wr.getItems();
            assertEquals(2, items.size());
            checkItem("jeans", Item.Category.bottom,0, items.get(0));
            checkItem("shirt", Item.Category.topping,1, items.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }




}