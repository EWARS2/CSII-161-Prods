
/**
 * Lab106
 * Data Structures & Algorithms 6th Edition
 * Goodrich, Tamassia, Goldwasser
 * Code Fragment 6.4
 *
 * An implementation of a simple LinkedStack class.
 * Transcribed by:
 *
 * @author Ethan T. Reed
 * @version 2025/10/17
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>(); // an empty list

    public LinkedStack() {
    } // new stack relies on the initially empty list

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E element) {
        list.addFirst(element);
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    /**
     * @return string representing list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append(", [");
        int n = list.size();
        for (int i = 0; i < n; i++) {   // Iterate over list
            E item = list.removeFirst();
            list.addLast(item);
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(item);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;    // same object
        } else if (o == null) {
            return false;   // null check
        } else if (getClass() != o.getClass()) {
            return false;   // must be same class
        }
        LinkedStack<E> other = (LinkedStack<E>) o;
        int n = this.size();
        if (n != other.size()) {
            return false;   // size mismatch
        }
        boolean equal = true;
        for (int i = 0; i < n; i++) {
            E a = this.pop();
            E b = other.pop();
            if (!java.util.Objects.equals(a, b)) {  // Compare elements
                equal = false;
            }
            this.list.addLast(a);   // restore order
            other.list.addLast(b);  // TODO : Does this actually work???
        }
        return equal;
    }

}
