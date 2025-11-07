
/**
 * Data Structures & Algorithms 6th Edition
 *
 * Goodrick, Tamassia, Goldwasser
 *
 * Code Fragments: 3.14 and 3.15
 *
 * Manual implementation of a singly linked list
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @author transcribed by Ethan T. Reed
 * @version 2025/10/31
 * @param <E>
 */
public class SinglyLinkedList<E> {

    //---------------- nested Node class ----------------
    private static class Node<E> {

        private E element;      // reference to the element stored at this node
        private Node<E> next;   // reference to the subsequent node in the list

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    } //----------- end of nested Node class -----------

    // instance variables of the SinglyLinkedList
    private Node<E> head = null;    // head node of the list (or null if empty)
    private Node<E> tail = null;    // last node of the list (or null if empty)
    private int size = 0;           // number of nodes in the list

    /**
     * Constructs an initially empty list
     */
    public SinglyLinkedList() {
    }

    // access methods
    /**
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * @return isEmpty?
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * returns (but does not remove) the first element
     *
     * @return first
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    /**
     * returns (but does not remove) the last element
     *
     * @return last
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // update methods
    /**
     * adds element e to the front of the list
     *
     * @param e
     */
    public void addFirst(E e) {
        head = new Node<>(e, head);  // create and link a new node
        if (size == 0) {
            tail = head;             // special case: new node becomes tail also
        }
        size++;
    }

    /**
     * adds element e to the end of the list
     *
     * @param e
     */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);// node will eventually be the tail
        if (isEmpty()) {
            head = newest;              // special case: previously empty list
        } else {
            tail.setNext(newest);       // new node after existing tail
        }
        tail = newest;                  // new node becomes the tail
        size++;
    }

    /**
     * removes and returns the first element
     *
     * @return answer removed
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;                // nothing to remove
        }
        E answer = head.getElement();
        head = head.getNext();     // will become null if list had only one node
        size--;
        if (size == 0) {
            tail = null;                // special case as list is now empty
        }
        return answer;
    }
}
