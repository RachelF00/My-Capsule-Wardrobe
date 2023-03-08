package persistence;

import model.Item;
import model.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkItem(String name, Item.Category category,  int id, Item i) {
        assertEquals(name, i.getItemName());
        assertEquals(category, i.getItemCategory());
        assertEquals(id,i.getID());
    }

    protected void checkCollection(String name, Collection c) {
        assertEquals(name, c.getName());
    }
}