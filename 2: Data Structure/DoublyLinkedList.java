public class DoublyLinkedList<E> {
    private static class Node<E> {
        private Node<E> prev;
        private Node<E> next;
        private E element;

        public Node(E e) {
            prev = null;
            next = null;
            element = e;
        }

        public void set_prev(Node<E> n) {
            prev = n;
        }

        public void set_next(Node<E> n) {
            next = n;
        }

        public E get_element() {
            return element;
        }

        public Node<E> get_next() {
            return next;
        }

        public Node<E> get_prev() {
            return prev;
        }
    }

    // Doubly Linked List using sentinels
    // the header and trailer nodes never change, only the 
    // nodes between them change.

    private Node<E> header;     // header sentinel
    private Node<E> trailer;    // trailer sentinel
    private int size;

    public DoublyLinkedList() {
       header = new Node<>(null);
       trailer = new Node<>(null); 
       size = 0;
       header.set_next(trailer);
       trailer.set_prev(header);
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

    public Node<E> first() {
        if (size == 0) {
            return null;
        }
        else {
            return header.get_next();
        }
    }

    public Node<E> last() {
        if (size == 0) {
            return null;
        }
        else {
            return trailer.get_prev;
        }
    }

    public void addBetween(Node<E> h, Node<E> n, Node<E> t) {
        n.set_next(t);
        n.set_prev(h);
        h.set_next(n);
        t.set_prev(n);
        size++;
    }

    public void addFirst(E e) {
        Node newest = new Node<>(e);
        addBetween(header, newest, header.get_next());
    }

    public void addLast(E e) {
        Node newest = new Node<>(e);
        addBetween(trailer.get_prev(), newest, trailer);
    }

    public void removeFirst() {
        Node prec = header.get_next().get_next();
        header.set_next(prec);
        prec.set_prev(header);
    }

    public void removeLast() {
        Node succ = trailer.get_prev().get_prev();
        succ.set_next(trailer);
        trailer.set_prev(succ);
    }

    public void print_array() {
        Node n = header;
        while(n.get_next() != trailer) {
            n = n.get_next();
            System.out.println(n.get_element());
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList a = new DoublyLinkedList();
        // 30, 20, 10, 20, 30
        a.addFirst(10);
        a.addFirst(20);
        a.addFirst(30);
        a.addLast(20);
        a.addLast(30);

        // 20, 10, 20
        a.removeFirst();
        a.removeLast();

        a.print_array();
    }
}