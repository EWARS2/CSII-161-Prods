
/**
 * Lab107
 * Position for PositionalList, from
 * Data Structures & Algorithms, 6th edition
 * by Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser Wiley 2014
 * Transcribed by
 *
 * @author Ethan T. Reed
 * @version 2025/10/25
 * @param <E>
 */
public interface Position<E> {

    /**
     * Returns the element stored at this position.
     *
     * @return the stored element
     * @throws IllegalStateException if position no longer valid
     */
    E getElement() throws IllegalStateException;
}
