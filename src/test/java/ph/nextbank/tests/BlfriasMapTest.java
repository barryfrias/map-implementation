package ph.nextbank.tests;

import org.junit.jupiter.api.Test;
import ph.nextbank.BlfriasMap;

import static org.junit.jupiter.api.Assertions.*;

class BlfriasMapTest {

    @Test
    void size() {
        BlfriasMap map = new BlfriasMap();
        map.put("1", 1);
        map.put("2", 3);
        map.put("3", 3);
        assertEquals(3, map.size());
    }

    @Test
    void isEmpty() {
        BlfriasMap map = new BlfriasMap();
        map.put("1", 1);
        map.put("2", 3);
        map.put("3", 3);
        assertFalse(map.isEmpty());
    }

    @Test
    void containsKey() {
        BlfriasMap map = new BlfriasMap();
        map.put("1", 1);
        assertTrue(map.containsKey("1"));
        assertFalse(map.containsKey("none existent key"));
    }

    @Test
    void get() {
        BlfriasMap map = new BlfriasMap();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        assertEquals(2, map.get("2"));
        assertEquals(1, map.get("1"));
        assertEquals(3, map.get("3"));
        assertNull(map.get("4"));
        map.put("3", 4);
        assertEquals(4, map.get("3"));
    }

    @Test
    void put() {
        BlfriasMap map = new BlfriasMap();
        map.put("3", 3);
        assertEquals(3, map.get("3"));
    }

    @Test
    void remove() {
        BlfriasMap map = new BlfriasMap();
        map.put("3", 3);
        map.remove("3");
        assertFalse(map.containsKey("3"));
        assertTrue(map.isEmpty());
    }

    @Test
    void clear() {
        BlfriasMap map = new BlfriasMap();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.clear();
        assertTrue(map.isEmpty());
    }
}