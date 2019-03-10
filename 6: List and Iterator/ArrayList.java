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
}