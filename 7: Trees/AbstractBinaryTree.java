import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    
    public Position<E> sibling(Position<E> p) {
        // return the position of p's sibling
        // if no sibling exists, return null
        Position<E> parent = parent(p);
        if (parent == null) {
            return null;    // root has no sibling
        }
        if (p == left(parent)) {
            return right(parent);
        }
        else {
            return left(parent);
        }
    }

    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null) {
            snapshot.add(left(p));
        }
        if (right(p) != null) {
            snapshot.add(right(p));
        }
        return snapshot;
    }
}