
/**
 * Lab106
 * Data Structures & Algorithms 6th Edition
 * Goodrich, Tamassia, Goldwasser
 * Code Fragment 6.11
 *
 * An implementation of a simple LinkedQueue class.
 * Transcribed by:
 *
 * @author Ethan T. Reed
 * @version 2025/10/17
 */
/** Realization of a FIFO queue as an adaptation of a SinglyLinkedList.
 *
 * @param <E>
 */
public class LinkedQueue<E> implements Queue<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>(); // an empty list

    public LinkedQueue() {
    } // new queue relies on the initially empty list

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E element) {
        list.addLast(element);
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

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
        LinkedQueue<E> other = (LinkedQueue<E>) o;
        int n = this.size();
        if (n != other.size()) {
            return false;   // size mismatch
        }
        boolean equal = true;
        for (int i = 0; i < n; i++) {
            E a = this.list.removeFirst();
            E b = other.list.removeFirst();
            if (!java.util.Objects.equals(a, b)) {  // Compare elements
                equal = false;
            }
            this.list.addLast(a);   // restore order
            other.list.addLast(b);  // TODO : Does this actually work???
        }
        return equal;
    }

}
