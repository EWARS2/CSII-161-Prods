
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * Lab108
 * 
 * Data Structures & Algorithms 6th Edition
 *
 * Goodrick, Tamassia, Goldwasser
 *
 * Code Fragments: 8.2 - 8.5 and 8.16 - 8.21
 *
 * An abstract base class providing some functionality of the Tree interface.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @author transcribed by Ethan T. Reed
 * @version 2025/10/31
 * @param <E>
 */
public abstract class AbstractTree<E> implements Tree<E> {

    /**
     * @param p
     * @return boolean
     */
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    /**
     * @param p
     * @return boolean
     */
    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    /**
     * @param p
     * @return boolean
     */
    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    /**
     * @return boolean
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of levels separating Position p from the root.
     *
     * @param p
     * @return depth
     */
    public int depth(Position<E> p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }

    /**
     * Returns the height of the tree.
     *
     * @return height
     */
    private int heightBad() { // works, but quadratic worst-case time
        int h = 0;
        for (Position<E> p : positions()) {
            if (isExternal(p)) // only consider leaf positions
            {
                h = Math.max(h, depth(p));
            }
        }
        return h;
    }

    /**
     * Returns the height of the subtree rooted at Position p.
     *
     * @param p
     * @return height
     */
    public int height(Position<E> p) {
        int h = 0; // base case if p is external
        for (Position<E> c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }
        return h;
    }

    //---------------- nested ElementIterator class ----------------
    /**
     * This class adapts the iteration produced by positions() to return
     * elements.
     */
    private class ElementIterator implements Iterator<E> {

        Iterator<Position<E>> posIterator = positions().iterator();

        /**
         * @return hasNext
         */
        public boolean hasNext() {
            return posIterator.hasNext();
        }

        /**
         * @return next
         */
        public E next() {
            return posIterator.next().getElement();
        } // return element!

        public void remove() {
            posIterator.remove();
        }
    }

    /**
     * Returns an iterator of the elements stored in the tree.
     *
     * @return ElementIterator
     */
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    /**
     * Code Fragment 8.17: Defining preorder as the default traversal algorithm
     * for the public positions method of an abstract tree.
     *
     * @return preorder
     */
    public Iterable<Position<E>> positions() {
        return preorder();
    }

    /**
     * Code Fragment 8.18: A recursive subroutine for performing a preorder
     * traversal of the subtree rooted at position p of a tree. Adds positions
     * of the subtree rooted at Position p to the given snapshot.
     *
     * @param p
     * @param snapshot
     */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p); // for preorder, we add position p before exploring subtrees
        for (Position<E> c : children(p)) {
            preorderSubtree(c, snapshot);
        }
    }

    /**
     * Code Fragment 8.19: A public method that performs a preorder traversal of
     * an entire tree. Returns an iterable collection of positions of the tree,
     * reported in preorder.
     *
     * @return snapshot
     */
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            preorderSubtree(root(), snapshot); // fill the snapshot recursively
        }
        return snapshot;
    }

    /**
     * Code Fragment 8.20: Support for performing a postorder traversal of a
     * tree. Adds positions of the subtree rooted at Position p to the given
     * snapshot.
     *
     * @param p
     * @param snapshot
     */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p)) {
            postorderSubtree(c, snapshot);
        }
        snapshot.add(p); // for postorder, we add position p after exploring subtrees
    }

    /**
     * Code Fragment 8.20: Support for performing a postorder traversal of a
     * tree. Returns an iterable collection of positions of the tree, reported
     * in postorder.
     *
     * @return snapshot
     */
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            postorderSubtree(root(), snapshot); // fill the snapshot recursively
        }
        return snapshot;
    }

    /**
     * Code Fragment 8.21: An implementation of a breadth-first traversal of a
     * tree. Returns an iterable collection of positions of the tree in
     * breadth-first order.
     *
     * @return snapshot
     */
    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root()); // start with the root
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue(); // remove from front of the queue
                snapshot.add(p); // report this position
                for (Position<E> c : children(p)) {
                    fringe.enqueue(c); // add children to back of queue
                }
            }
        }
        return snapshot;
    }
}
