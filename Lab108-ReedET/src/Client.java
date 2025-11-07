
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Lab108
 *
 * Data structure tests
 *
 * @author Ethan T. Reed
 * @version 2025/10/31
 */
public class Client {

    /**
     * Generic tester
     *
     * @param <T>
     * @param name
     * @param add
     * @param remove
     */
    public static <T> void testStructure(
            String name, Consumer<T> add, Supplier<T> remove) {
        Random r = new Random();
        System.out.println(name);
        for (int i = 10; i > 0; i--) {      // Add 10 random numbers
            T n = (T) Integer.valueOf(r.nextInt(10));
            System.out.printf("%d, ", n);
            add.accept(n);
        }
        System.out.println("");
        for (int i = 10; i > 0; i--) {      // Remove 10 numbers
            System.out.printf("%d, ", remove.get());
        }
        System.out.println("\n");
    }

    /**
     * Tests LinkedPositionalList
     */
    public static void testLinkedPositionalList() {
        Random r = new Random();
        System.out.println("LinkedPositionalList");
        LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
        for (int i = 10; i > 0; i--) {
            int n = r.nextInt(10);
            System.out.printf("%d, ", n);
            list.addLast(n);
        }
        System.out.println("");
        for (Position<Integer> p : list.positions()) {
            System.out.printf("%d, ", p.getElement());
        }
        System.out.println("");
        Position<Integer> cursor = list.last();
        while (cursor != null) {
            System.out.printf("%d, ", cursor.getElement());
            cursor = list.before(cursor);
        }
        System.out.println("\n");
    }

    /**
     * Tests LinkedBinaryTree
     */
    public static void testLinkedBinaryTree() {
        // Declare and add bottom level of tree
        LinkedBinaryTree<String>[] nums = new LinkedBinaryTree[10];
        String[] numbers = {"5", "2", "1", "2", "2", "9", "7", "2", "2", "8"};
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new LinkedBinaryTree<>();
            nums[i].addRoot(numbers[i]);
        }
        // Declare and add symbols in equation
        LinkedBinaryTree<String>[] syms = new LinkedBinaryTree[9];
        Position<String>[] positions = new Position[10];
        String[] symbols = {"+", "*", "-", "/", "+", "+", "-", "-", "*"};
        for (int i = 0; i < syms.length; i++) {
            syms[i] = new LinkedBinaryTree<>();
            positions[i] = syms[i].addRoot(symbols[i]);
        }
        // Build tree, first layer
        syms[1].attach(positions[1], nums[1], nums[2]);
        syms[4].attach(positions[4], nums[4], nums[5]);
        syms[6].attach(positions[6], nums[6], nums[7]);
        // Assemble the rest of ( 5 + 2 * 1 - 2 )
        syms[0].attach(positions[0], nums[0], syms[1]);
        syms[2].attach(positions[2], syms[0], nums[3]);
        // Assemble the rest of ( ( 2 + 9 ) + ( 7 - 2 - 2 ) )
        syms[7].attach(positions[7], syms[6], nums[8]);
        syms[5].attach(positions[5], syms[4], syms[7]);
        // Assemble division and final multiply at root
        syms[3].attach(positions[3], syms[2], syms[5]);
        syms[8].attach(positions[8], syms[3], nums[9]);
        // Finalize
        LinkedBinaryTree<String> tree = syms[8];
        Position<String> p = positions[8];
        // Print outputs
        System.out.println("Expression:                 "
                + "( ( 5 + 2 * 1 - 2 ) / ( ( 2 + 9 ) + ( 7 - 2 - 2 ) ) * 8 )");
        System.out.println("Height:                     " + tree.height(p));
        System.out.println("Preorder:                   " + tree.preorder());
        System.out.println("Inorder:                    " + tree.inorder());
        System.out.println("Postorder:                  " + tree.postorder());
        System.out.println("Breadth-first:              " + tree.breadthfirst());
        System.out.print("Euler Tour (parenthesized): ");
        eulerTourBinary(tree, p);
        System.out.println("");
    }

    /**
     * Code Fragment 8.29: Algorithm eulerTourBinary for performing an Euler
     * tour traversal of a subtree rooted at position p of a binary tree.
     *
     * @param <E>
     * @param T
     * @param p
     */
    public static <E> void eulerTourBinary(LinkedBinaryTree<E> T, Position<E> p) {
        System.out.print("(");
        if (T.left(p) != null) {
            eulerTourBinary(T, T.left(p));
        }
        System.out.print(p.getElement());
        if (T.right(p) != null) {
            eulerTourBinary(T, T.right(p));
        }
        System.out.print(")");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(10);
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(10);
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        testStructure("ArrayStack", arrayStack::push, arrayStack::pop);
        testStructure("LinkedStack", linkedStack::push, linkedStack::pop);
        testStructure("ArrayQueue", arrayQueue::enqueue, arrayQueue::dequeue);
        testStructure("LinkedQueue", linkedQueue::enqueue, linkedQueue::dequeue);
        testLinkedPositionalList();
        testLinkedBinaryTree();
    }
}
