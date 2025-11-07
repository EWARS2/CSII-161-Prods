package Old;

/**
 * Lab106
 *
 * Data Structures & Algorithms 6th Edition
 *
 * Goodrick, Tamassia, Goldwasser
 *
 * Code Fragments: 7.1
 *
 * A simplified version of the java.util.List interface.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @author transcribed by Ethan T. Reed
 * @version 2025/10/31
 * @param <E>
 */
public interface List<E> {

    /**
     * Returns the number of elements in this list.
     *
     * @return size
     */
    int size();

    /**
     * Returns whether the list is empty.
     *
     * @return isEmpty?
     */
    boolean isEmpty();

    /**
     * Returns (but does not remove) the element at index i.
     *
     * @param i
     * @return element
     */
    E get(int i) throws IndexOutOfBoundsException;

    /**
     * Replaces the element at index i with e, and returns the replaced element.
     *
     * @param i
     * @param e
     * @return element
     */
    E set(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Inserts element e to be at index i, shifting all subsequent elements
     * later.
     *
     * @param i
     * @param e
     */
    void add(int i, E e) throws IndexOutOfBoundsException;

    /**
     * Removes/returns the element at index i, shifting subsequent elements
     * earlier.
     *
     * @param i
     * @return element
     */
    E remove(int i) throws IndexOutOfBoundsException;
}
