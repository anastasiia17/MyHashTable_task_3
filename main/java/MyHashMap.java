import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {
    private MyHashTable<K, V> table;

    MyHashMap() {
        table = new MyHashTable();
    }

    @Override
    public boolean isEmpty() {
        return table.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return table.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return table.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return (V) table.get(key);
    }

    @Override
    public V put(K key, V value) {
        return (V) table.put(key, value);
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public V remove(Object o) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }
}
