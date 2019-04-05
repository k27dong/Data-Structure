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

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("not valid position type");
        }
        Node<E> node = (Node<E>) p;
        if (node.getElement() == node) {
            throw new IllegalArgumentException("p is no longer in the tree");
        }
        return node;
    }

    public int sizE() {
        return size;
    }

    public Position<E> root() {
        return root;
    }

    public Position<E> parent(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return node.getParent();
    }

    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node;
    }

    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node;
    }

    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree is not empty");
        }
        root = createNode(e, null, null, null); // a root has no parent, no left and no right
        size = 1;
        return root;
    }

    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) {
            // the node already has a left
            throw new IllegalArgumentException("p already has a left child");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) {
            // the node already has a right
            throw new IllegalArgumentException("p already has a right child");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /* Attaches trees t1 and t2 as left and right subtress of external p */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) {
            throw new IllegalArgumentException("p must be a leaf");
        }
        size += t1.size() + t2.size();
        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    /* Removes the node at Position p, and replaces it with its child, if any */
    public E remove(Position<E> p) throws IllegalArgumentException { 
        
    }
}