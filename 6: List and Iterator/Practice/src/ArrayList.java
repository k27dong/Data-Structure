package src;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
    public static final int CAPACITY = 16;  // default array capacity
    private E[] data;   // generic array used for storage
    private int size = 0;   // current number of elements

    // constructors
    public ArrayList() {
        this(CAPACITY);
    }

    public ArrayList(int capacity) {
        // construct a list with given capacity
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        // this is an utility method,
        // checks whether the given index is in the range of [0, n - 1]
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal Index: " + i);
        }
    }

    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);    // throws exception if the index is not valid
        return data[i];
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);    // this step makes sure the required procedure is within the range of this array
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);    // if i exists in between 0 and size + 1
        if (size == data.length) {
            throw new IllegalStateException("Array is full");
        }
        for (int k = size - 1; k >= i; k--) {
            // shifting process
            // every index larger than i is shifted to the right by 1
            data[k + 1] = data[k];
        }
        data[i] = e;    // now there's space, this new element can be placed
        size++;
    }

    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];   // this is the element to be removed, and to be returned
        for (int k = i; k < size - 1; k++) {
            // everything starting at i, until the end of list, is shifted to the left by 1
            data[k] = data[k + 1];
        }
        data[size - 1] = null; // now empty the last element of the array
        size--;
        return temp;
    }

    /**
     * This is an inner class which provide ways to iterate through the overall class
     */
    private class ArrayIterator implements Iterator<E> {
        /**
         * j : index of the next element to report
         *     acts like a pointer to the array
         */
        private int j = 0;
        private boolean removable = false;

        public boolean hasNext() {
            return j < size;
        }

        public E next() throws NoSuchElementException {
            if (j == size) {
                throw new NoSuchElementException("No next element");
            }
            removable = true;
            return data[j++];
        }

        public void remove() throws IllegalStateException {
            if (!removable) {
                throw new IllegalStateException("nothing to remove");
            }
            ArrayList.this.remove(j - 1);
            j--;
            removable = false;  // remove is disabled until next() is called again
        }
    }

    public Iterator<E> iterator() {
        // when the user asks for an iterator on this arraylist class, give
        // them an arrayIterator we just wrote above
        return new ArrayIterator();
    }
}
