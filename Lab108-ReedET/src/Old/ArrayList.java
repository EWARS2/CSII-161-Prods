package Old;

/**
 * Lab106
 *
 * Data Structures & Algorithms 6th Edition
 *
 * Goodrick, Tamassia, Goldwasser
 *
 * Code Fragments: 7.2, 7.3, 7.4 and 7.5
 *
 * An implementation of a simple ArrayList class.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @author transcribed by Ethan T. Reed
 * @version 2025/10/31
 * @param <E>
 */
public class ArrayList<E> implements List<E> {

    /**
     * instance variables
     */
    public static final int CAPACITY = 16; // default array capacity
    private E[] data; // generic array used for storage
    private int size = 0; // current number of elements

    /**
     * constructors
     */
    public ArrayList() {
        this(CAPACITY);
    } // constructs list with default capacity

    /**
     * constructors
     *
     * @param capacity
     */
    public ArrayList(int capacity) { // constructs list with given capacity
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }

    // ---------------- Page Break -----------------
    // public methods
    /**
     * Returns the number of elements in the array list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns whether the array list is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the element at index i.
     */
    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    /**
     * Replaces the element at index i with e, and returns the replaced element.
     */
    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    /**
     * Inserts element e to be at index i, shifting all subsequent elements
     * later.
     */
    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        if (size == data.length) {   // not enough capacity
            resize(2 * data.length); // so double the current capacity
        } // rest of method unchanged...
        checkIndex(i, size + 1);
        for (int k = size - 1; k >= i; k--) {   // start by shifting rightmost
            data[k + 1] = data[k];
        }
        data[i] = e; // ready to place the new element
        size++;
    }

    /**
     * Removes/returns the element at index i, shifting subsequent elements
     * earlier.
     */
    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++) // shift elements to fill hole
        {
            data[k] = data[k + 1];
        }
        data[size - 1] = null; // help garbage collection
        size--;
        return temp;
    }

    // utility method
    /**
     * Checks whether the given index is in the range [0, n-1].
     *
     * @param i
     * @param n
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    /**
     * Resizes internal array to have given capacity >= size.
     *
     * @param capacity
     */
    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity]; // safe cast; compiler may give warning
        for (int k = 0; k < size; k++) {
            temp[k] = data[k];
        }
        data = temp; // start using the new array
    }

}
