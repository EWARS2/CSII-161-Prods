/**
 * Lab111
 *
 * Comparator interface, from StableSort example project.
 * 
 * @param <E>
 */
public interface Comparator<E> {

    /**
     * @param a
     * @param b
     * @return
     */
    int compare(E a, E b);
}
