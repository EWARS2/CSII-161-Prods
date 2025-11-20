
/** 
 * Lab106
 * 
 * Data Structures & Algorithms 6th Edition
 *
 * Goodrick, Tamassia, Goldwasser
 *
 * Code Fragments: 6.1
 *
 * A collection of objects that are inserted and removed according to the
 * last-in first-out principle. Although similar in purpose, this interface
 * differs from java.util.Stack.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @author transcribed by Ethan T. Reed
 * @version 2025/10/31
 * @param <E>
 */
public interface Stack<E> {

    /**
     * Returns the number of elements in the stack.
     *
     * @return number of elements in the stack
     */
    int size();

    /**
     * Tests whether the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts an element at the top of the stack.
     *
     * @param e the element to be inserted
     * @throws Stack.StackFullException
     */
    void push(E e) throws StackFullException;

    /**
     * Returns, but does not remove, the element at the top of the stack.
     *
     * @return top element in the stack (or null if empty)
     */
    E top();

    /**
     * Removes and returns the top element from the stack.
     *
     * @return element removed (or null if empty)
     */
    E pop();

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
    public static class StackFullException extends IllegalStateException {

        /**
         * Default constructor
         */
        public StackFullException() {
            super("Stack is full");
        }

        /**
         * Overloaded constructor
         *
         * @param message
         */
        public StackFullException(String message) {
            super(message);
        }
    }
}
