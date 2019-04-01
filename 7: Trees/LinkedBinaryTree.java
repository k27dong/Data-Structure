public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        // accessor methods
        public E getElement() {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setLeft(Node<E> l) {
            left = l;
        }

        public void setRight(Node<E> r) {
            right = r;
        }

        public void setParent(Node<E> p) {
            parent = p;
        }
    }

    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E> (e, parent, left, right);
    }

    protected Node<E> root = null;
    private int size = 0;

    public LinkedBinaryTree() {
        
    }

    public void addRoot(E e) {
        
    }
}