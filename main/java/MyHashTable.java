import java.util.Arrays;
import java.util.Map;

class MyHashTable<K, V> {

    private static final int INTEGER_MAX = (int) Math.pow(2, 32) - 1;
    private static final int START_CAPACITY = 10;
    private static final int INCREASES_CAPACITY = 2;

    private Pair[] table;
    private int size;
    private int capacity;

    MyHashTable() {
        size = 0;
        capacity = START_CAPACITY;
        table = new Pair[0];
    }

    private static int hash(Object key) {
        return key == null ? 0 : key.hashCode();
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    V put(K key, V value) {

        if (increaseSizeOfTable()) {
            size++;
        }
        int hash = hash(key);
        int i = (capacity - 1) & hash;
        Object k;

        if (table[i] == null) {
            table[i] = new Pair(hash, key, value, null);
            return value;
        }

        for (Pair p = table[i]; p != null; p = p.next) {
            if (p.hash == hash && ((k = p.getKey()) == key || key.equals(k))) {
                V oldValue = (V) p.value;
                p.value = value;
                return oldValue;
            }
        }

        for (Pair p = table[i]; p != null; p = p.next) {
            if (p.next == null) {
                p.next = new Pair<K, V>(hash, key, value, null);
                break;
            }
        }

        return value;
    }

    public V get(Object key) {
        int hash = hash(key);
        int i = (capacity - 1) & hash;
        Object k;

        for (Pair p = table[i]; p != null; p = p.next) {
            if (p.hash == hash && ((k = p.getKey()) == key || key.equals(k))) {
                return (V) p.getValue();
            }
        }
        return null;
    }


    boolean containsKey(Object key) {
        int hash = hash(key);
        int i = (capacity - 1) & hash;
        Object k;

        for (Pair p = table[i]; p != null; p = p.next) {
            if (p.hash == hash && ((k = p.getKey()) == key || key.equals(k))) {
                return true;
            }
        }
        return false;
    }

    boolean containsValue(Object value) {
        Object v;
        for (Pair p : table) {
            for (; p != null; p = p.next) {
                if ((v = p.getValue()) == value || value.equals(v)) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean increaseSizeOfTable() {
        if (size == 0) {
            table = Arrays.copyOf(table, capacity);
            return true;
        }
        if (size < capacity) {
            return true;
        }
        if (size * INCREASES_CAPACITY >= capacity) {
            if (size * INCREASES_CAPACITY < INTEGER_MAX) {
                capacity *= INCREASES_CAPACITY;
            } else {
                capacity = INTEGER_MAX;
            }
            table = Arrays.copyOf(table, capacity);
            return true;
        }
        if (size >= INTEGER_MAX) {
            return false;
        }
        return false;
    }

    private static class Pair<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Pair<K, V> next;

        Pair(int hash, K key, V value, Pair<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public V setValue(V value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                V oldValue = this.value;
                this.value = value;
                return oldValue;
            }
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }


    }
}