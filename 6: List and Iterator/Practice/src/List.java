package src;

/* This interface is to replace the java.util's default List interface */
/* It will be used for other programs */

// list is similar to an array

public interface List<E> {
    int size();

    boolean isEmpty();

    // return the element stored in index i
    E get(int i) throws IndexOutOfBoundsException;

    // replace the element at index i with e, and return the old element
    E set(int i, E e) throws IndexOutOfBoundsException;

    // insert a new element e into the list
    // this method would increase the size by 1
    void add(int i, E e) throws IndexOutOfBoundsException;

    // remove the element stored at index i, and return it
    E remove(int i) throws IndexOutOfBoundsException;
}