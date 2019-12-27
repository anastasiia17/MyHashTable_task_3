import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {
    @Test
    public void testTable() {
        MyHashMap<Integer, String> table = new MyHashMap<>();
        assertTrue(table.isEmpty());
        table.put(1, "world");
        table.put(3, "yess");
        assertEquals("world", table.get(1));
        assertTrue(table.containsKey(3));
        assertTrue(table.containsValue("yess"));
        assertEquals("no", table.put(2, "no"));
    }
}
