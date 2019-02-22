public class SinglyLinkedList {
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

        public set_next(Node<E> n) {
            next = n;
        }
    }
}