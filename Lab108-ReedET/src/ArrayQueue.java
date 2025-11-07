
/**
 * Lab106
 *
 * Data Structures & Algorithms 6th Edition
 *
 * Goodrick, Tamassia, Goldwasser
 *
 * Code Fragments: 6.10
 *
 * Implementation of the queue ADT using a fixed-length array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @author transcribed by Ethan T. Reed
 * @version 2025/10/31
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

    private static final int CAPACITY = 10; // default array capacity

    // instance variables
    private E[] data; // generic array used for storage
    private int f = 0; // index of the front element
    private int sz = 0; // current number of elements

    /**
     * constructors
     */
    public ArrayQueue() {
        this(CAPACITY);
    } // constructs queue with default capacity

    /**
     * constructors
     *
     * @param capacity
     */
    public ArrayQueue(int capacity) { // constructs queue with given capacity
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }

    // methods
    /**
     * Returns the number of elements in the queue.
     *
     * @return
     */
    @Override
    public int size() {
        return sz;
    }

    /**
     * Tests whether the queue is empty.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (sz == 0);
    }

    /**
     * Inserts an element at the rear of the queue.
     *
     * @param e
     */
    @Override
    public void enqueue(E e) throws IllegalStateException {
        if (sz == data.length) {
            throw new IllegalStateException("Queue is full");
        }
        int avail = (f + sz) % data.length; // use modular arithmetic
        data[avail] = e;
        sz++;
    }

    /**
     * Returns, but does not remove, the first element of the queue (null if
     * empty).
     *
     * @return
     */
    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return data[f];
    }

    /**
     * Removes and returns the first element of the queue (null if empty).
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[f];
        data[f] = null; // dereference to help garbage collection
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayQueue: [");
        for (int i = 0; i < sz; i++) {
            int index = (f + i) % data.length;
            sb.append(data[index]);
            if (i < sz - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * @param o
     * @return Boolean representing if compared objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;    // same reference
        }
        if (!(o instanceof ArrayQueue<?> other)) {
            return false;   // type check
        } else if (this.sz != other.sz) {
            return false;   // must have same size
        }
        for (int i = 0; i < sz; i++) {  // Compare each element
            int index1 = (this.f + i) % this.data.length;
            int index2 = (other.f + i) % other.data.length;
            E e1 = this.data[index1];
            Object e2 = other.data[index2];
            if (!java.util.Objects.equals(e1, e2)) {
                return false;
            }
        }
        return true;
    }
}
