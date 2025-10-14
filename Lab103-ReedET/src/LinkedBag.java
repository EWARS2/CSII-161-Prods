
/**
 * Lab103
 * Manual implementation of a generic linked list
 * Built on top of included SinglyLinkedList example class
 * TODO : Not fully null safe
 *
 * @author Ethan T. Reed
 * @version 2025/09/23
 */
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class LinkedBag<E> implements Bag<E> {

    private SinglyLinkedList<E> list;

    /**
     * Default constructor
     */
    public LinkedBag() {
        list = new SinglyLinkedList<>();
    }

    /**
     * Overloaded constructor
     *
     * @param capacity (is ignored)
     */
    public LinkedBag(int capacity) {
        this();
    }

    /**
     * The textbook example of SinglyLinkedList is a horribly incomplete
     * implementation, and the lab instructions require that its contents remain
     * untouched, which is rather annoying, given that traversing this list
     * implementation is destructive. Wrote this to figure out how to properly
     * traverse the list.
     *
     * ChatGPT wrote a rough version of this single method, to which I polished
     * up to reuse with all of the other methods. I don't recall any instruction
     * against the use of AI, but if there are problems with this please let me
     * know. I'd like to give credit where credit is due.
     *
     * https://chatgpt.com/share/68d061f5-9024-8005-92bc-198a295d60ce
     *
     * @return array representing the current contents of list.
     */
    private Object[] toArray() {
        Object[] arr = new Object[list.size()];
        // Iterate over list
        int n = list.size();
        for (int i = 0; i < n; i++) {
            E item = list.removeFirst();
            list.addLast(item);
            arr[i] = item;
        }
        return arr;
    }

    /**
     * @return size of list
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * @return Boolean of whether list is empty
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Clears all items in list by simply creating a new list in memory.
     * Potentially inefficient.
     */
    @Override
    public void clear() {
        list = new SinglyLinkedList<>();
    }

    /**
     * @param e object to search for
     * @return integer count of object
     */
    @Override
    public int getFrequencyOf(E e) {
        int count = 0;
        // Iterate over list
        int n = list.size();
        for (int i = 0; i < n; i++) {
            E item = list.removeFirst();
            list.addLast(item);
            if (item.equals(e)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param e
     * @return true if e is in list
     */
    @Override
    public boolean contains(E e) {
        boolean contained = false;
        // Iterate over list
        int n = list.size();
        for (int i = 0; i < n; i++) {
            E item = list.removeFirst();
            list.addLast(item);
            if (item.equals(e)) {
                contained = true;
            }
        }
        return contained;
    }

    /**
     * @param e object to add to list
     */
    @Override
    public void add(E e) {
        list.addLast(e);
    }

    /**
     * @param e object to target, first instance is removed
     * @return object removed
     */
    @Override
    public E remove(E e) {
        E removed = null;
        // Iterate over list
        int n = list.size();
        for (int i = 0; i < n; i++) {
            E item = list.removeFirst();
            if (removed == null && Objects.equals(item, e)) {
                removed = item;
            } else {
                list.addLast(item);
            }
        }
        return removed;
    }

    /**
     * @return random item removed from list
     */
    @Override
    public E remove() {
        int n = list.size();
        if (n <= 0) {
            throw new IllegalStateException("The remove() method cannot be "
                    + "called on an empty list");
        }
        E removed = null;
        int index = ThreadLocalRandom.current().nextInt(list.size());
        // Iterate over list
        for (int i = 0; i < n; i++) {
            E item = list.removeFirst();
            if (i == index) {
                removed = item;
            } else {
                list.addLast(item);
            }
        }
        return removed;
    }

    /**
     * @param i index to get
     * @return
     */
    @Override
    public E get(int index) {
        int n = list.size();
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        E e = null;
        // Iterate over list
        for (int i = 0; i < n; i++) {
            E item = list.removeFirst();
            list.addLast(item);
            if (i == index) {
                e = item;
            }
        }
        return e;
    }

    /**
     * @return string representing list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append(", [");
        // Iterate over list
        int n = list.size();
        for (int i = 0; i < n; i++) {
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

    /**
     * Relies on toString
     *
     * @param o object to compare this against
     * @return whether compared objects equate
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LinkedBag<?> other)) {
            return false;
        }
        int n = this.size();
        if (n != other.size()) {
            return false;
        }

        // Relies on toString
        return Objects.equals(this.toString(), o.toString());
    }
}
