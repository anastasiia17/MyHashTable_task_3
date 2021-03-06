import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashTableTest {
    @Test
    public void testTable() {
        MyHashTable<Integer, String> table = new MyHashTable<>();
        assertTrue(table.isEmpty());
        table.put(2, "hello");
        table.put(3, "yess");
        assertEquals("hello", table.get(2));
        assertTrue(table.containsKey(3));
        assertTrue(table.containsValue("yess"));
    }


}
