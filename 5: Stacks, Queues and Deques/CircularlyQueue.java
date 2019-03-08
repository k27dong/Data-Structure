/**
 * This is a class of CircularlyQueue using array to store elements
 * 
 * logic:
 * 
 * an array of certain length is initialized to store all element
 * size shows the number of the non-null index in the array
 * now is a reference number, represents the element pointed by the program at this time
 * 
 * enqueue (E e): find the first null index of the array, set the 
 * dequeue: find the first index of the array, set it to null, and rotate to the left, until the first
 *          index is not null
 * 
 * rotate: 
 * - left: temp = data[0], data[n] = data[n-1], data[n] = temp; ++
 * - right: temp = data[n], data[n] = data[n+1]; data[0] = temp; -- 
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

    public int length() {
        return data.length;
    }

    public int size() {
        return size;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[0];
    }

    public E dequeue() throws IllegalStateException{    // remove and return an element from the queue
        if (size > 0) {
            rotate(-1);
            E temp = data[size - 1];
            data[size - 1] = null;
            size --;
            return temp;
        }
        else {
            throw new IllegalStateException("Nothing to delete.");
        }
    }

    public void enqueue(E e) throws IllegalStateException{  // add e to the queue
        if (size == data.length) {
            throw new IllegalStateException("Queue full.");
        }
        else {
            data[size] = e;
            size++;
        }
    }

    public void rotate(int n) {  // rotate the array
        if (size < 2) {
            // do nothing
            // this method only works for arrays that has more than one element
        }
        else {
            if (n > 0) {
                for (int j = 0; j < n; j++) {
                    E temp = data[0];
                    for (int i = 0; i < size - 1; i++) { 
                        // - 1 because the last element in this array has nothing to copy
                        data[i] = data[i+1];
                    }
                    data[size - 1] = temp;
                }
            }
            else {
                for (int i = 0; i < Math.abs(n); i++) {
                    E temp = data[size - 1];    // temporaly store the last element of the array
                    for (int j = size - 1; j > 0; j--) {
                        data[j] = data[j - 1];
                    }
                    data[0] = temp;
                }
            }
        }
    }

    public void print() {
        // print the array

        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                System.out.print("null ");
            }
            else {
                System.out.print(data[i] + " ");
            }
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        CircularlyQueue<Integer> c = new CircularlyQueue<>(10);
        c.enqueue(10);
        c.enqueue(20);
        c.enqueue(30);
        c.dequeue();
        c.dequeue();

        c.print();
    }
}