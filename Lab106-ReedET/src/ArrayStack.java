
/**
 * Lab106
 * Data Structures & Algorithms 6th Edition
 * Goodrich, Tamassia, Goldwasser
 * Code Fragment 6.2
 *
 * An implementation of a simple ArrayStack class.
 * Transcribed by:
 *
 * @author Ethan T. Reed
 * @version 2025/10/17
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

    public static final int CAPACITY = 1000;// default array capacity
    private E[] data;                       // generic array used for storage
    private int t = -1;                     // index of the top element in stack

    public ArrayStack() {
        this(CAPACITY);
    }   // constructs stack with default capacity

    public ArrayStack(int capacity) {    // constructs stack with given capacity
        data = (E[]) new Object[capacity];// safe cast; compiler may give warning
    }

    @Override
    public int size() {
        return (t + 1);
    }

    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++t] = e;  // increment t before storing new item
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return data[t];
    }

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
