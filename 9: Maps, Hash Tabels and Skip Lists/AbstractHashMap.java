import java.util.ArrayList;
import java.util.Random;
import java.util.Map.Entry;

public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
    protected int n = 0;    // # of entries
    protected int capacity; // length of the table
    private int prime;      // prime factor
    private long scale, shift;

    public AbstractHashMap(int cap, int p) {
        prime = p;
        capacity = cap;
        Random rand = new Random();

        scale = rand.nextInt(prime - 1) + 1;
        shift = rand.nextInt(prime);

        createTable();
    }

    public AbstractHashMap(int cap) {
        // the default prime number used for this program
        this(cap, 109345121);
    }

    public AbstractHashMap() {
        // the default capacity
        this(17);
    }

    /* public methods */
    public int size() {
        return n;
    }

    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }

    /* private utilities */
    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }

    private void resize(int newCap) {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(n);

        for (Entry<K, V> e : entrySet()) {
            // add all the value from the entry set to this buffer
            buffer.add(e);
        }

        capacity = newCap;
        createTable();  // this is now based on the updated capacity
        n = 0;  // this will be recomputed while reinserting entries

        for (Entry<K, V> e : buffer) {
            put(e.getKey(), e.getValue());
        }
    }


    /**
     * createTable: create an initially empty table, having size equal to a designated capacity instance variable
     * bucketGet: mimic the semantics of the public get method
     * bucketPut: mimic the semantics of the public put method
     * bucketRemove: mimic the semantics of the public remove method
     */

    protected abstract void createTable();
    protected abstract V bucketGet(int h, K k);
    protected abstract V bucketPut(int h, K k, V v);
    protected abstract V bucketRemove(int h, K k);
}