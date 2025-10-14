
/**
 * Lab102
 * Manual implementation of an int list
 *
 * @author Ethan T. Reed
 * @version 09/12/2025
 */
import java.util.Objects;
import java.util.Random;

public class Scores {

    private int list[];
    private int size; // List size

    /**
     * Default constructor
     */
    public Scores() {
        int initLength = 2;
        list = new int[initLength];
        size = 0;
    }

    /**
     * Overloaded constructor
     *
     * @param initLength initialized length
     */
    public Scores(int initLength) {
        list = new int[initLength];
        size = 0;
    }

    /**
     * @return size of list
     */
    public int size() {
        return size;
    }

    /**
     * @return is list empty?
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * removes all numbers from Scores class
     */
    public void clear() {
        list = new int[0];
    }

    /**
     * @param num to search for
     * @return count/frequency of number in list
     */
    public int getFrequencyOf(int num) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (list[i] == num) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param num
     * @return true if num is in list
     */
    public boolean contains(int num) {
        for (int i = 0; i < size; i++) {
            if (list[i] == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param num is added to the end of the list
     */
    public void add(int num) {
        // If list is full,
        if (size == list.length) {
            // Make a duplicate that's double the size
            // Plus one, in case user starts with an array of zero
            int[] temp = new int[(list.length * 2) + 1];
            // Manual array copy list contents in same order
            for (int i = 0; i < list.length; i++) {
                temp[i] = list[i];
            }
            list = temp;
            temp = null; // Useless, despite the demands of the instructions
        }
        list[size] = num;
        size++;
    }

    /**
     * @param num has it's first occurrence removed.
     */
    public void remove(int num) {
        // Find first instance of num in list 
        int i;
        for (i = 0; i < list.length; i++) {
            if (list[i] == num) {
                break;
            }
        }

        // If whole list has been run, stop function 
        if (i >= list.length) {
            return;
        }   // Else, continue and update list & size

        // From instance after num was found, shift left one
        for (i = i + 1; i < list.length; i++) {
            list[i - 1] = list[i];
        }

        // Update size
        size--;
    }

    /**
     * @return number that has randomly been removed.
     */
    public int remove() {
        if (size <= 0) {
            throw new IllegalStateException("The remove() method cannot be "
                    + "called on an empty list");
        }
        Random random = new Random();
        int num = list[random.nextInt(size)];
        this.remove(num);
        return num;
    }

    /**
     * @param i (index) to return value from
     * @return value at index
     */
    public int get(int i) {
        if (i >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return list[i];
    }

    /**
     * @return string representing list
     */
    @Override
    public String toString() {
        String string = new String();
        string += size + ", [";
        // Iterate over list's actual size
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string += ", ";
            }
            string += list[i];
        }
        string += ']';
        return string;
    }

    /**
     * @param o object to compare this against
     * @return whether compared objects equate
     */
    @Override
    public boolean equals(Object o) {
        // This relies on toString also returning size
        return Objects.equals(this.toString(), o.toString());
    }
}
