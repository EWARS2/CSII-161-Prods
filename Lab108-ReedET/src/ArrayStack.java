
/** 
 * Lab106
 * 
 * Data Structures & Algorithms 6th Edition
 *
 * Goodrick, Tamassia, Goldwasser
 *
 * Code Fragments: 6.2
 *
 * An implementation of a simple ArrayStack class.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @author transcribed by Ethan T. Reed
 * @version 2025/10/31
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

    /**
     * Instance variables
     */
    public static final int CAPACITY = 1000;// default array capacity
    private E[] data;                       // generic array used for storage
    private int t = -1;                     // index of the top element in stack

    /**
     * Constructor
     */
    public ArrayStack() {
        this(CAPACITY);
    }   // constructs stack with default capacity

    /**
     * Constructor
     *
     * @param capacity
     */
    public ArrayStack(int capacity) {    // constructs stack with given capacity
        data = (E[]) new Object[capacity];// safe cast; compiler may give warning
    }

    /**
     * @return size
     */
    @Override
    public int size() {
        return (t + 1);
    }

    /**
     * @return isEmpty
     */
    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    /**
     * @param e
     * @throws IllegalStateException
     */
    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++t] = e;  // increment t before storing new item
    }

    /**
     * @return top
     */
    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[t];
    }

    /**
     * @return answer
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E answer = data[t];
        data[t] = null;     // dereference to help garbage collection
        t--;
        return answer;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayStack: [");
        for (int i = 0; i <= t; i++) {
            sb.append(data[i]);
            if (i < t) {
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
            return true;                        // same reference
        } else if (o == null || getClass() != o.getClass()) {
            return false;                       // null or different class
        }
        ArrayStack<E> other = (ArrayStack<E>) o;
        if (this.size() != other.size()) {
            return false;                       // Different sizes, not equal
        }
        for (int i = 0; i <= this.t; i++) {     // Compare each element
            E e1 = this.data[i];
            E e2 = other.data[i];
            if (!java.util.Objects.equals(e1, e2)) {
                return false;
            }
        }
        return true;
    }
}
