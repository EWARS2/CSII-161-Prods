
/**
 * Lab108
 *
 * Data Structures & Algorithms 6th Edition
 *
 * Goodrick, Tamassia, Goldwasser
 *
 * Code Fragments: 8.9 - 8.11
 *
 * Concrete implementation of a binary tree using a node-based, linked
 * structure.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @author transcribed by Ethan T. Reed
 * @version 2025/10/31
 * @param <E>
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

//---------------- nested Node class ----------------
    /**
     * @param <E>
     */
    protected static class Node<E> implements Position<E> {

        private E element; // an element stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child (if any)
        private Node<E> right; // a reference to the right child (if any)

        /**
         * Constructs a node with the given element and neighbors.
         *
         * @param e
         * @param above
         * @param leftChild
         * @param rightChild
         */
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
        // accessor methods

        /**
         * @return element
         */
        @Override
        public E getElement() {
            return element;
        }

        /**
         * @return parent
         */
        public Node<E> getParent() {
            return parent;
        }

        /**
         * @return left
         */
        public Node<E> getLeft() {
            return left;
        }

        /**
         * @return right
         */
        public Node<E> getRight() {
            return right;
        }
        // update methods

        /**
         * @param e
         */
        public void setElement(E e) {
            element = e;
        }

        /**
         * @param parentNode
         */
        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }

        /**
         * @param leftChild
         */
        public void setLeft(Node<E> leftChild) {
            left = leftChild;
        }

        /**
         * @param rightChild
         */
        public void setRight(Node<E> rightChild) {
            right = rightChild;
        }

        /**
         * Custom toString
         * @return String
         */
        public String toString() {
            return element.toString();
        }

    } //----------- end of nested Node class -----------

    /**
     * Factory function to create a new node storing element e.
     *
     * @param e
     * @param parent
     * @param left
     * @param right
     * @return
     */
    protected Node<E> createNode(E e, Node<E> parent,
            Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    /**
     * LinkedBinaryTree instance variables
     */
    protected Node<E> root = null; // root of the tree
    private int size = 0; // number of nodes in the tree

    /**
     * constructor
     */
    public LinkedBinaryTree() {
    } // constructs an empty binary tree

    // nonpublic utility
    /**
     * Validates the position and returns it as a node.
     *
     * @param p
     * @return
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type");
        }
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getParent() == node) // our convention for defunct node
        {
            throw new IllegalArgumentException("p is no longer in the tree");
        }
        return node;
    }

    // accessor methods (not already implemented in AbstractBinaryTree)
    /**
     * Returns the number of nodes in the tree.
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the root Position of the tree (or null if tree is empty).
     *
     * @return
     */
    @Override
    public Position<E> root() {
        return root;
    }

    /**
     * Returns the Position of p's parent (or null if p is root).
     *
     * @param p
     * @return
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    /**
     * Returns the Position of p's left child (or null if no child exists).
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    /**
     * Returns the Position of p's right child (or null if no child exists).
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();

    }

    // update methods supported by this class
    /**
     * Places element e at the root of an empty tree and returns its new
     * Position.
     *
     * @param e
     * @return
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree is not empty");
        }
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    /**
     * Creates a new left child of Position p storing element e; returns its
     * Position.
     *
     * @param p
     * @param e
     * @return
     */
    public Position<E> addLeft(Position<E> p, E e)
            throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("p already has a left child");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * Creates a new right child of Position p storing element e; returns its
     * Position.
     *
     * @param p
     * @param e
     * @return
     */
    public Position<E> addRight(Position<E> p, E e)
            throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalArgumentException("p already has a right child");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /**
     * Replaces the element at Position p with e and returns the replaced
     * element.
     *
     * @param p
     * @param e
     * @return
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;

    }

    /**
     * Attaches trees t1 and t2 as left and right subtrees of external p.
     *
     * @param p
     * @param t1
     * @param t2
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1,
            LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) {
            throw new IllegalArgumentException("p must be a leaf");
        }
        size += t1.size() + t2.size();
        if (!t1.isEmpty()) { // attach t1 as left subtree of node
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) { // attach t2 as right subtree of node
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    /**
     * Removes the node at Position p and replaces it with its child, if any.
     *
     * @param p
     * @return
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2) {
            throw new IllegalArgumentException("p has two children");
        }
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null) {
            child.setParent(node.getParent()); // child’s grandparent becomes its parent
        }
        if (node == root) {
            root = child; // child becomes root
        } else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        size--;
        E temp = node.getElement();
        node.setElement(null); // help garbage collection
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node); // our convention for defunct node
        return temp;
    }
} //----------- end of LinkedBinaryTree class -----------
