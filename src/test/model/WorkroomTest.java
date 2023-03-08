package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WorkroomTest {

    Workroom wr1;

    @BeforeEach
    public void before(){
        wr1 = new Workroom("My work room");
    }

    @Test
    public void testGetter() {
        assertEquals("My work room",wr1.getName());

    }

    @Test
    public void testaddItem() {
        Item i1;
        i1 = new Item(0, "shirt", Item.Category.topping);
        wr1.addItem(i1);

        ArrayList<Item> l1 = new ArrayList<>();
        l1.add(i1);
        assertEquals(l1,wr1.getItems());

    }

    @Test
    public void testremoveItem() {
        Item i1;
        i1 = new Item(0, "shirt", Item.Category.topping);
        wr1.addItem(i1);
        wr1.removeItem(i1);

        ArrayList<Item> l1 = new ArrayList<>();

        assertEquals(l1,wr1.getItems());
    }

    @Test
    public void testaddCollection() {
        Collection c1 = new Collection("Summer");
        wr1.addCollection(c1);
        ArrayList<Collection> c2 = new ArrayList<>();
        c2.add(c1);
        assertEquals(wr1.getCollections(),c2);
    }

    @Test
    public void testgetNum() {
        Item i1;
        i1 = new Item(0, "shirt", Item.Category.topping);
        wr1.addItem(i1);
        assertEquals(1,wr1.numItems());

        Collection c1 = new Collection("Summer");
        wr1.addCollection(c1);
        assertEquals(1,wr1.numCollections());
    }





}
