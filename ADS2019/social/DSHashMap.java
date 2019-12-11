import java.util.ArrayList;
import java.util.Arrays;

/**
 * DSHashMap
 */
public class DSHashMap<E> {

    ArrayList<KeyValuePair>[] values;

    public DSHashMap() {
        values = new ArrayList[8];
        System.out.println(hash("jyamauchi"));
        System.out.println(hash("andrews"));
        System.out.println(hash("hochberg"));
    }

    private int hash(String key) {
        long rv = (int)key.charAt(0) - 97;
        for(int i=1; i<key.length(); i++) {
            rv = rv * 26 + ((int)key.charAt(i) - 97);
        }
        return (int)(rv % values.length);
    }

    public E get(String key) {
        ArrayList<KeyValuePair> entries = values[hash(key)];
        for(KeyValuePair entry : entries) {
            if(entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void put(String key, E value) {
        int hashValue = hash(key);
        if(values[hashValue] == null) {
            values[hashValue] = new ArrayList<>();
        }
        values[hashValue].add(new KeyValuePair(key, value));
        System.out.println(Arrays.toString(values));
    }

    private class KeyValuePair {
        String key;
        E value;

        public KeyValuePair(String key, E value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return "Pair(" + key + ", " + value + ")";
        }
    }
}