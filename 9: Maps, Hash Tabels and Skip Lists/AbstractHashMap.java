public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
    protected int n = 0;    // # of entries
    protected int capacity; // length of the table
    private int prime;      // prime factor
    private long scale, shift;
}