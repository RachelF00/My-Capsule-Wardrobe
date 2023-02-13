package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserCollectionTest {
    UserAccount u1;

    @BeforeEach
    public void before() {
        u1 = new UserAccount("Rachel","female",0);
    }

    @Test
    public void testaddtoCollection() {
        Item  i1;
        i1 = new Item(1,"jeans1",2,"202005");
        assertTrue(u1.addItem(i1));
        Collection c1;
        c1 = u1.createCollection("summer wardrobe");
        assertEquals(0,c1.getNum());

        u1.addtoCollection(i1,c1);
        assertEquals(1,c1.getNum());

    }

    @Test
    public void testaddtoCollection1() {
        Item  i1,i2,i3,i4,i5;
        i1 = new Item(1,"jeans1",2,"202005");
        i2 = new Item(2,"shirt1",1,"202108");
        i3 = new Item(3,"jeans2",2,"202002");
        i4 = new Item(4,"jeans3",2,"201108");
        i5 = new Item(5,"tshirt1",1,"201805");
        u1.addItem(i1);
        u1.addItem(i2);
        u1.addItem(i3);
        u1.addItem(i4);
        //u1.addItem(i5);

        Collection c1;
        c1 = u1.createCollection("summer wardrobe");

        u1.addtoCollection(i1,c1);
        u1.addtoCollection(i2,c1);
        assertTrue(u1.addtoCollection(i3,c1));
        assertFalse(c1.isFull());
        assertTrue(u1.addtoCollection(i4,c1));
        assertTrue(c1.isFull());
        assertFalse(u1.addtoCollection(i5,c1));

    }

    @Test
    public void testaddtoCollection2() {
        Item  i1,i2,i3,i4,i5;
        i1 = new Item(1,"jeans1",2,"202005");
        i2 = new Item(2,"shirt1",1,"202108");
        i3 = new Item(3,"jeans2",2,"202002");
        i4 = new Item(4,"jeans3",2,"201108");
        i5 = new Item(5,"tshirt1",1,"201805");
        u1.addItem(i1);
        u1.addItem(i2);
        u1.addItem(i3);
        u1.addItem(i4);
        u1.addItem(i5);

        Collection c1;
        c1 = u1.createCollection("summer wardrobe");

        u1.addtoCollection(i1,c1);
        u1.addtoCollection(i2,c1);
        u1.addtoCollection(i3,c1);
        u1.addtoCollection(i4,c1);
        assertTrue(c1.isFull());
        assertFalse(c1.addtoCollection(i5));
        assertFalse(u1.addtoCollection(i5,c1));

    }


    @Test
    public void testremovefromCollection(){
        Item  i1;
        i1 = new Item(1,"jeans1",2,"202005");
        assertTrue(u1.addItem(i1));
        Collection c1;
        c1 = u1.createCollection("summer wardrobe");
        assertEquals(0,c1.getNum());

        u1.addtoCollection(i1,c1);
        assertEquals(1,c1.getNum());

        assertTrue(u1.removefromCollection(i1,c1));

    }

    @Test
    public void testremovefromCollection1(){
        Item  i1;
        i1 = new Item(1,"jeans1",2,"202005");
        assertTrue(u1.addItem(i1));
        Collection c1;
        c1 = u1.createCollection("summer wardrobe");
        assertEquals(0,c1.getNum());

        u1.addtoCollection(i1,c1);
        assertEquals(1,c1.getNum());
        assertTrue(u1.removefromCollection(i1,c1));
        assertFalse(u1.removefromCollection(i1,c1));

    }



    @Test
    public void testremoveCollection(){
        Item  i1;
        i1 = new Item(1,"jeans1",2,"202005");
        assertTrue(u1.addItem(i1));
        Collection c1;
        c1 = u1.createCollection("summer wardrobe");

        assertTrue(u1.removeCollection(c1));
    }

    @Test
    public void testremoveCollection1(){
        Item  i1;
        i1 = new Item(1,"jeans1",2,"202005");
        assertTrue(u1.addItem(i1));
        Collection c1;
        c1 = u1.createCollection("summer wardrobe");

        assertTrue(u1.removeCollection(c1));
        assertFalse(u1.removeCollection(c1));
    }

    @Test
    public void testaddItem() {
        Item  i1;
        i1 = new Item(1,"jeans1",2,"202005");
        assertTrue(u1.addItem(i1));
    }

    @Test
    public void testremoveItem() {
        Item  i1,i2;
        i1 = new Item(1,"jeans1",2,"202005");
        i2 = new Item(2,"shirt1",1,"202108");
        u1.addItem(i1);
        assertTrue(u1.removeItem(i1));
        assertFalse(u1.removeItem(i2));
    }

    @Test
    public void testisfull() {
        Item  i1,i2,i3,i4,i5,i6;
        i1 = new Item(1,"jeans1",2,"202005");
        i2 = new Item(2,"shirt1",1,"202108");
        i3 = new Item(3,"jeans2",2,"202002");
        i4 = new Item(4,"jeans3",2,"201108");
        i5 = new Item(5,"tshirt1",1,"201805");
        i6 = new Item(6,"shirt2",1,"202204");

        u1.addItem(i1);
        u1.addItem(i2);
        u1.addItem(i3);
        u1.addItem(i4);
        u1.addItem(i5);
        assertTrue(u1.isFull());
        assertFalse(u1.addItem(i6));
    }

    @Test
    public void testgetters() {
        Item  i1;
        i1 = new Item(1,"jeans1",2,"202005");
        assertEquals(1,i1.getID());
        assertEquals("jeans1",i1.getItemName());
        assertEquals(2,i1.getItemCategory());
        assertEquals("202005",i1.getItemDate());

    }

    @Test
    public void testgetters2() {
        assertEquals("Rachel",u1.getName());
        assertEquals("female",u1.getGender());
        assertEquals(0,u1.getUserId());

        Item  i1,i2;
        i1 = new Item(1,"jeans1",2,"202005");
        i2 = new Item(2,"shirt1",1,"202108");
        u1.addItem(i1);
        u1.addItem(i2);

        assertEquals(2,u1.getNum());
    }




}
