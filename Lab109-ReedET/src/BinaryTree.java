
/**
 * Lab108
 *
 * Data Structures & Algorithms 6th Edition
 *
 * Goodrick, Tamassia, Goldwasser
 *
 * Code Fragments: 8.6
 *
 * An interface for a binary tree, in which each node has at most two children.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @author transcribed by Ethan T. Reed
 * @version 2025/10/31
 * @param <E>
 */
public interface BinaryTree<E> extends Tree<E> {

    /**
     * Returns the Position of p's left child (or null if no child exists).
     *
     * @param p
     * @return left
     * @throws IllegalArgumentException
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position of p's right child (or null if no child exists).
     *
     * @param p
     * @return right
     * @throws IllegalArgumentException
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the Position of p's sibling (or null if no sibling exists).
     *
     * @param p
     * @return sibling
     * @throws IllegalArgumentException
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
