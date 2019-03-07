/**
 * This file is here because of the LinkedQueue class
 */

public class SinglyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E get_element() {
            return element;
        }

        public Node<E> get_next() {
            return next;
        }

        public void set_next(Node<E> n) {
            next = n;
        }
    }
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
        
    }
    
    public boolean isEmpty() {
        if (size() == 0) return true;
        return false;
    }

    public E first() {
        if (head == null) {
            return null;
        }
        return head.get_element();
    }

    public E last() {
        if (tail == null) {
            return null;
        }
        return tail.get_element();
    }

    public int size() {
        return size;
    }

    public void addFirst(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
            tail = newest;
        }
        else {
            newest.set_next(head);
            head = newest;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node(e, null);
        if (isEmpty()) {
            head = newest;
            tail = newest;
        }
        else {
            tail.set_next(newest);
            tail = newest;
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {

        }
        else {
            head = head.get_next();
        }
        size--;
    }

    public void removeLast() {  /* FIX ME */
        if (isEmpty()) {

        }
        else {
            if (size() == 1) {
                head.set_next(null);
                tail = head;
            }
            else {
                Node ref = head;
                while(ref.get_next() != tail) {
                    ref = ref.get_next();
                }
                
            }
        }
        size--;
    }

    public void print_array() {
        System.out.println("size: " + size());
        Node<E> ref = head;
        System.out.println(ref.get_element() + " (head)");
        while(ref.get_next() != tail) {
            ref = ref.get_next();
            System.out.println(ref.get_element());
        }
        System.out.println(ref.get_next().get_element() + " (tail)");
    }

    public static void main(String[] args) {
        SinglyLinkedList a = new SinglyLinkedList();

        a.addFirst(10);
        a.addLast(20);
        a.addLast(30);
        a.addFirst(0);

        a.removeFirst();
        a.removeFirst();

        a.print_array();
    }
}