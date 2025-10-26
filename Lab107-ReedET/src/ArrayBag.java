
/**
 * Lab103
 * Manual implementation of a generic list
 *
 * @author Ethan T. Reed
 * @version 2025/09/24
 */
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayBag<E> implements Bag<E> {

    private E[] list;
    private int size; // List size
    private int capacity;

    /**
     * Default constructor
     */
    public ArrayBag() {
        this(2);
    }

    /**
     * Overloaded constructor
     *
     * @param capacity is initialized length
     */
    public ArrayBag(int capacity) {
        this.capacity = capacity;
        list = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * @return size of list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return is list empty?
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * removes all numbers from ArrayBag class
     */
    @Override
    public void clear() {
        list = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * @param e to search for
     * @return count/frequency of number in list
     */
    @Override
    public int getFrequencyOf(E e) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(list[i], e)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param e
     * @return true if e is in list
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(list[i], e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param e is added to the end of the list
     */
    @Override
    public void add(E e) {
        // If list is full,
        if (size == list.length) {
            // Make a duplicate that's double the size
            // Plus one, in case user starts with an array of zero
            E[] temp = (E[]) new Object[(list.length * 2) + 1];
            // Manual array copy list contents in same order
            for (int i = 0; i < list.length; i++) {
                temp[i] = list[i];
            }
            list = temp;
            temp = null; // Useless, despite the demands of the instructions
        }
        list[size] = e;
        size++;
    }

    /**
     * @param e has it's first occurrence removed.
     * @return item that has been removed.
     */
    @Override
    public E remove(E e) {
        // Find first instance of e in list 
        int i;
        for (i = 0; i < size; i++) {
            if (Objects.equals(list[i], e)) {
                break;
            }
        }
        if (i >= size) { // If whole list has been run, stop function s
            return null;
        }   // Else, continue and update list & size
        // From instance after e was found, shift left one
        for (i = i + 1; i < size; i++) {
            list[i - 1] = list[i];
        }
        // Update size
        size--;
        // Free up memory for garbage collection
        list[size] = null;
        return e;
    }

    /**
     * @return number that has been randomly removed.
     */
    @Override
    public E remove() {
        if (size <= 0) {
            throw new IllegalStateException("The remove() method cannot be "
                    + "called on an empty list");
        }
        int index = ThreadLocalRandom.current().nextInt(size);
        return this.remove(list[index]);
    }

    /**
     * @param i (index) to return value from
     * @return value at index
     */
    @Override
    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
        return list[i];
    }

    /**
     * @return string representing list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size()).append(", [");
        // Iterate over list's actual size
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(list[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    /**
     * @param o object to compare this against
     * @return whether compared objects equate
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ArrayBag<?> other)) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(this.list[i], other.list[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * this method adds to the end of the array.
     *
     * @param e
     */
    public void addTest(E e) {
        this.add(e);
    }

    /**
     * this method removes the last item at the end of the array.
     *
     * @return E
     */
    public E removeTest() {
        E value = this.get(size - 1); 
        size--;
        return value;
    }
}
