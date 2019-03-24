import java.util.Map.Entry;

/**
 * Override the original java.util Map interface
 */

public interface Map<K, V> {
    // returns the number of entries
    int size(); 

    // returns if size is 0
    boolean isEmpty();  
    
    // pass in a key k, return the value assigned to this key
    V get(K key);   
    
    // if the map does not have the key k, add (k, v) to the map, return null
    // else, replace the currently existing v with the new v, and return the old v
    V put(K key, V value);
    
    // if the map does not have the key k, returns null and do nothing
    // else remove the value assigned to key k, and return it
    V remove(K key);
    
    // returns an iterable collection containing all the keys stored in M
    Iterable<K> keySet(); Iterable<V> values(); Iterable<Entry<K,V>> entrySet();
}