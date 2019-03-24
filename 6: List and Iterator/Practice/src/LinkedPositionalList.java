package src;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E> {
    
    private static class Node<E> implements Position<E> {
        // just a simple Node class, with all the features identical as perviously created ones
        private E element;
        private Node<E> prev;
        private Node<E> next;
        
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() throws IllegalStateException {
            if (next == null) {
                throw new IllegalStateException("Position invalid");
            }
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);   // trailer's prev is header
        header.setNext(trailer);    // header's next is trailer

        // default: [header -> trailer]
    }

    private Node<E> validate (Position<E> p) throws IllegalArgumentException {
        // validate the current position and return it as a node
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("invalid p");
        }
        Node<E> node = (Node<E>) p; // safe cast, from position to node
        
        if (node.getNext() == null) {
            throw new IllegalArgumentException("p is not in the list");
        }
        return node;
    }

    private Position<E> position(Node<E> node) {
        // return the input node as a position
        if (node == header || node == trailer) {
            return null;
        }
        return node;
    }

    /* public accessor methods */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Position<E> first() {
        return position(header.getNext());
    }

    public Position<E> last() {
        return position(trailer.getPrev());
    }

    public Position<E> before (Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    public Position<E> after (Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    // some private utilities
    // these functions have also been covered in previous programs
    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }

    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    public E set (Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }   

    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();

        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;

        E answer = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return answer;
    }

    private class PositionIterator implements Iterator<Position<E>> {

        // position of the next element to report, default set to the first position
        private Position<E> cursor = first();
        // position of the last reported element, default set to null
        private Position<E> recent = null;

        public boolean hasNext() {
            return (cursor != null);    // if cursor is null, first is null, which means the who thing is empty
        }

        public Position<E> next() throws NoSuchElementException {
            if (cursor == null) {
                throw new NoSuchElementException("nothing is left");
            }
            recent = cursor;
            cursor = after(cursor); // move the cursor to the next one
            return recent;
        }

        public void remove() throws IllegalStateException {
            if (recent == null) {
                throw new IllegalStateException("nothing to remove");
            }
            LinkedPositionalList.this.remove(recent);
            recent = null; // an item can only be removed once
        }
    }

    private class PositionIterable implements Iterable<Position<E>> {
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }

    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }

    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = new PositionIterator();
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        public E next() {
            return posIterator.next().getElement();
        }

        public void remove() {
            posIterator.remove();
        }
    }

    public Iterator<E> iterator() {
        return new ElementIterator();
    }

}