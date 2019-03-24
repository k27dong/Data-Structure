import java.util.Iterator;

/**
 * The default tree interface
 */

public interface Tree<E> extends Iterable {
    Position<E> root();
    Position<E> parent(Position<E> p) throws IllegalArgumentException;
    
    boolean isInternal(Position<E> p) throws IllegalArgumentException;
    boolean isExternal(Position<E> p) throws IllegalArgumentException;
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    int size();
    int numChildren(Position<E> p) throws IllegalArgumentException;
    boolean isEmpty();
    
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    Iterator<E> iterator();
    Iterable<Position<E>> position();
    
}