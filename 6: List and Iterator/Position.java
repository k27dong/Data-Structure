/* General interface for a position class */

public interface Position<E> {
    E getElement() throws IllegalStateException;
}