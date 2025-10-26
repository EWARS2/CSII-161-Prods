
/**
 * Lab107
 * An interface for positional lists, from
 * Data Structures & Algorithms, 6th edition
 * by Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser Wiley 2014
 * Transcribed by
 *
 * @author Ethan T. Reed
 * @version 2025/10/25
 * @param <E>
 */
public interface PositionalList<E> {

    /**
     * Returns the number of elements in the list.
     *
     * @return size
     */
    int size();

    /**
     * Tests whether the list is empty.
     *
     * @return isEmpty
     */
    boolean isEmpty();

    /**
     * Returns the first Position in the list (or null, if empty).
     *
     * @return first
     */
    Position<E> first();

    /**
     * Returns the last Position in the list (or null, if empty).
     *
     * @return last
     */
    Position<E> last();

    /**
     * Returns the Position immediately before Position p (or null, if p is
     * first).
     *
     * @param p
     * @return Position
     */
    Position<E> before(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position immediately after Position p (or null, if p is
     * last).
     *
     * @param p
     * @return Position
     */
    Position<E> after(Position<E> p) throws IllegalArgumentException;

    /**
     * Inserts element e at the front of the list and returns its new Position.
     *
     * @param e
     * @return Position
     */
    Position<E> addFirst(E e);

    /**
     * Inserts element e at the back of the list and returns its new Position.
     *
     * @param e
     * @return Position
     */
    Position<E> addLast(E e);

    /**
     * Inserts element e immediately before Position p and returns its new
     * Position.
     *
     * @param p
     * @param e
     * @return Position
     */
    Position<E> addBefore(Position<E> p, E e)
            throws IllegalArgumentException;

    /**
     * Inserts element e immediately after Position p and returns its new
     * Position.
     *
     * @param p
     * @param e
     * @return Position
     */
    Position<E> addAfter(Position<E> p, E e)
            throws IllegalArgumentException;

    /**
     * Replaces the element stored at Position p and returns the replaced
     * element.
     *
     * @param p
     * @param e
     * @return E
     */
    E set(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Removes the element stored at Position p and returns it (invalidating p).
     *
     * @param p
     * @return E
     */
    E remove(Position<E> p) throws IllegalArgumentException;
}
