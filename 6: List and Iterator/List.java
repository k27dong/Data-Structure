/* This interface is to replace the java.util's default List interface */
/* It will be used for other programs */

public interface List<E> {
    int size();

    boolean isEmpty();

    E get(int i) throws IndexOutOfBoundsException;

    E set(int i, E e) throws IndexOutOfBoundsException;

    void add(int i, E e) throws IndexOutOfBoundsException;

    E remove(int i) throws IndexOutOfBoundsException;
}