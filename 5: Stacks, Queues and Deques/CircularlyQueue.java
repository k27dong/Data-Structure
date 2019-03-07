/**
 * This is a class of CircularlyQueue using array to store elements
 * 
 * logic:
 * 
 * an array of certain length is initialized to store all element
 * size shows the number of the non-null index in the array
 * now is a reference number, represents the element pointed by the program at this time
 * 
 */

public class CircularlyQueue<E> implements Queue<E> {
    private E[] data;
    private int size;   // the size of this queue
    private int now;    // the current pointing element


    public CircularlyQueue(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
        now = 0;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[now];
    }

    public E dequeue() {    // remove and return an element from the queue
        
    }

    public void enqueue(E e) {  // add e to the queue
        
    }

    public void rotate() {  // rotate the array

    }

}