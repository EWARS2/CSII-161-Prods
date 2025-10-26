
/**
 * Lab106
 * Data Structures & Algorithms 6th Edition
 * Goodrich, Tamassia, Goldwasser
 * Code Fragment 6.9
 *
 * Transcribed by:
 *
 * @author Ethan T. Reed
 * @version 2025/10/17
 * @param <E>
 */
public interface Queue<E> {

    /**
     * Returns the number of elements in the queue.
     * @return 
     */
    int size();

    /**
     * Tests whether the queue is empty.
     * @return 
     */
    boolean isEmpty();

    /**
     * Inserts an element at the rear of the queue.
     * @param e
     */
    void enqueue(E e) throws QueueFullException;

    /**
     * Returns, but does not remove, the first element of the queue (null if
     * empty).
     * @return 
     */
    E first();

    /**
     * Removes and returns the first element of the queue (null if empty).
     * @return 
     */
    E dequeue();

    /**
     * @return String
     */
    @Override
    String toString();

    /**
     * @param o
     * @return Boolean representing if compared objects are equal
     */
    @Override
    boolean equals(Object o);

    /**
     * Custom defined exception
     */
    public static class QueueFullException extends IllegalStateException {

        /**
         * Default constructor
         */
        public QueueFullException() {
            super("Stack is full");
        }

        /**
         * Overloaded constructor
         *
         * @param message
         */
        public QueueFullException(String message) {
            super(message);
        }
    }
}
