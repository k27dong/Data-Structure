/**
 * this is the interafce for dequeue, it uses modules to get the right index
 * to store new elements
 * 
 * except for that, it's similar to a linkedlist
 */

public interface Deque<E> {
    int size();
    boolean isEmpty();

    E first();
    E last();

    void addFirst(E e);
    void addLast(E e);

    E removeFirst();
    E removeLast();
}