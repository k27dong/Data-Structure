public class ArrayQueue<E> implements Queue<E> {
    // this is an array-based implementation of Queue

    // instance variables
    private E[] data;
    private int f = 0;
    private int sz = 0;

    // constructors

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        else {
            return data[f];
        }
    }

    public int size() {
        return sz;
    }

    public  boolean isEmpty() {
        return sz == 0;
    }

    public void enqueue(E e) throws IllegalStateException {
        if (sz == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int avail = (f + sz) % data.length;
        data[avail] = e;
        sz++;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }
}