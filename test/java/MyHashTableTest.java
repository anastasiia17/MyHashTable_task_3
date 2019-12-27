import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashTableTest {
    @Test
    public void testTable1() {
        MyHashTable<Integer, String> table = new MyHashTable<>();
        assertTrue(table.isEmpty());
        table.put(2, "hello");
        table.put(3, "yess");
        assertEquals("hello", table.get(2));
        assertTrue(table.containsKey(3));
        assertTrue(table.containsValue("yess"));
    }

    @Test
    public void testTable2() {
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
