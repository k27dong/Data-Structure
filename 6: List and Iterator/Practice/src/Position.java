package src;

public interface Position<E> {
    E getElement() throws IllegalStateException;
}