import java.util.ArrayList;

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
    private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    public UnsortedTableMap() {
        
    }

    private int findIndex(K key) {
        // return the index of an entry, or -1 if unfound
        int n = table.size();
        for (int i = 0; i < n; i++) {
            if (table.get(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }

    public int size() {
        return table.size();
    }

    public V get(K key) {
        int i = findIndex(key);
        if (i == -1) {
            return null;    // -1 -> not found
        }
        return table.get(i).getValue();
    }

    public V put(K key, V value) {
        int i = findIndex(key);
        if (i == -1) {
            // if this key is not found
            table.add(new MapEntry<> (key, value));
            return null;
        }
        else {
            return table.get(i).setValue(value);
        }
    }

    public V remove(K key) {
        int i = findIndex(key);
        int n = size();
        if (i == -1) {
            return null;
        }
        V answer = table.get(i).getValue();
        if (i != n - 1) {
            table.set(i, table.get(n - 1));
        }
        table.remove(n - 1);
        return answer;
    }

}