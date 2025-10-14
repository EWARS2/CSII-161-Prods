
/**
 * Lab103
 *
 * @author Ethan T. Reed
 * @version 2025/09/16
 * @param <E>
 */
public interface Bag<E> {
    int size();
    boolean isEmpty();
    void clear();
    int getFrequencyOf(E e);
    boolean contains(E e);
    void add(E e);
    E remove(E e);
    E remove();
    E get(int i);
    @Override
    String toString();
    @Override
    boolean equals(Object o);
}
