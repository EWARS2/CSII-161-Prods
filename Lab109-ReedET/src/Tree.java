
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Lab108
 *
 * Data Structures & Algorithms 6th Edition
 *
 * Goodrick, Tamassia, Goldwasser
 *
 * Code Fragments: 8.1 and 8.23 - 8.26
 *
 * An interface for a tree where nodes can have an arbitrary number of children.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @author transcribed by Ethan T. Reed
 * @version 2025/10/31
 * @param <E>
 */
public interface Tree<E> extends Iterable<E> {

    /**
     * @return root
     */
    Position<E> root();

    /**
     * @param p
     * @return parent
     * @throws IllegalArgumentException
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /**
     * @param p
     * @return children
     * @throws IllegalArgumentException
     */
    Iterable<Position<E>> children(Position<E> p)
            throws IllegalArgumentException;

    /**
     * @param p
     * @return number of children
     * @throws IllegalArgumentException
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;

    /**
     * @param p
     * @return isInternal?
     * @throws IllegalArgumentException
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /**
     * @param p
     * @return isExternal?
     * @throws IllegalArgumentException
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /**
     * @param p
     * @return isRoot?
     * @throws IllegalArgumentException
     */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    /**
     * @return size
     */
    int size();

    /**
     * @return isEmpty?
     */
    boolean isEmpty();

    /**
     * @return iterator
     */
    @Override
    Iterator<E> iterator();

    /**
     * @return positions
     */
    Iterable<Position<E>> positions();

    /**
     * Needed for code fragments 8.23 and 8.24
     *
     * @param n
     * @return
     */
    public static String spaces(int n) {
        return new String(new char[n]).replace("\0", " ");
    }

    /**
     * Code Fragment 8.23: Efficient recursion for printing indented version of
     * a pre- order traversal. To print an entire tree T, the recursion should
     * be started with form printPreorderIndent(T, T.root( ), 0). Prints
     * preorder representation of subtree of T rooted at p having depth d.
     *
     * @param <E>
     * @param T
     * @param p
     * @param d
     */
    public static <E> void printPreorderIndent(
            Tree<E> T, Position<E> p, int d) {
        System.out.println(spaces(2 * d) + p.getElement()); // indent based on d
        for (Position<E> c : T.children(p)) {
            printPreorderIndent(T, c, d + 1); // child depth is d+1
        }
    }

    /**
     * Code Fragment 8.24: Efficient recursion for printing an indented and
     * labeled pre- sentation of a preorder traversal. Prints labeled
     * representation of subtree of T rooted at p having depth d.
     *
     * @param <E>
     * @param T
     * @param p
     * @param path
     */
    public static <E> void printPreorderLabeled(Tree<E> T,
            Position<E> p, ArrayList<Integer> path) {
        int d = path.size(); // depth equals the length of the path
        System.out.print(spaces(2 * d)); // print indentation, then label
        for (int j = 0; j < d; j++) {
            System.out.print(path.get(j) + (j == d - 1 ? " " : "."));
        }
        System.out.println(p.getElement());
        path.add(1); // add path entry for first child
        for (Position<E> c : T.children(p)) {
            printPreorderLabeled(T, c, path);
            path.set(d, 1 + path.get(d)); // increment last entry of path
        }
        path.remove(d); // restore path to its incoming state
    }

    /**
     * Code Fragment 8.25: Recursive computation of disk space for a tree. We
     * assume that each tree element reports the local space used at that
     * position. Returns total disk space for subtree of T rooted at p.
     *
     * @param T
     * @param p
     * @return
     */
    public static int diskSpace(Tree<Integer> T, Position<Integer> p) {
        int subtotal = p.getElement(); // we assume element represents space usage
        for (Position<Integer> c : T.children(p)) {
            subtotal += diskSpace(T, c);
        }
        return subtotal;
    }

    /**
     * Code Fragment 8.26: Method that prints parenthetic string representation
     * of a tree. Prints parenthesized representation of subtree of T rooted at
     * p.
     *
     * @param <E>
     * @param T
     * @param p
     */
    public static <E> void parenthesize(Tree<E> T, Position<E> p) {
        System.out.print(p.getElement());
        if (T.isInternal(p)) {
            boolean firstTime = true;
            for (Position<E> c : T.children(p)) {
                System.out.print((firstTime ? " (" : ", ")); // determine proper punctuation
                firstTime = false; // any future passes will get comma
                parenthesize(T, c); // recur on child
            }
            System.out.print(")");
        }
    }
}
