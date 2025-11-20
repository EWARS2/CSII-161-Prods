
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Lab109
 *
 * Expressions in data structures
 *
 * @author Ethan T. Reed
 * @version 2025/11/14
 */
public class Client {

    public static final String ERROR = "Invalid expression";
    public static final String OPEN = "([{";    // Opening parenthesis symbols
    public static final String CLOSE = ")]}";   // Closing parenthesis symbols
    public static final String SUB = "-";       // Subtraction symbols
    public static final String ADD = "+";       // Addition symbols
    public static final String MULTDIV = "*/";  // Multiplication and division
    public static final String ADDSUB = ADD + SUB; // Addition and subtraction
    public static final String NUMS = ".0123456789";        // Number symbols
    public static final String OPS = ADDSUB + MULTDIV;      // Operator symbols
    public static final String SYMS = OPS + OPEN + CLOSE;   // General symbols

    /**
     * Code Fragment 8.29: Algorithm eulerTourBinary for performing an Euler
     * tour traversal of a subtree rooted at position p of a binary tree.
     *
     * @param <E>
     * @param T
     * @param p
     */
    public static <E> void eulerTourBinary(LinkedBinaryTree<E> T,
            Position<E> p) {
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
     * Tokenize arithmetic expression from string to a queue.
     *
     * @param s
     * @return queue
     * @throws IllegalArgumentException
     */
    public static LinkedQueue<String> tokenize(String s) throws
            IllegalArgumentException {
        LinkedQueue<String> queue = new LinkedQueue<>();
        int i = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            String c = "" + s.charAt(i);
            if (SUB.contains(c)) {  // Subs...
                if ((OPS.contains(sb) || OPEN.contains(sb)) // After op or open
                        && (!queue.isEmpty() // & before num, break
                        && NUMS.contains(queue.first()))) {
                    queue.enqueue(sb.toString());
                    sb = new StringBuilder(c);   // & append
                } else {
                    if (sb.length() > 0) { // from anything, break
                        queue.enqueue(sb.toString());
                        sb = new StringBuilder();
                    }
                    queue.enqueue(c);
                }
            } else if (NUMS.contains(c)) { // Nums...
                if ((SYMS.contains(sb) && !SUB.contains(sb))
                        && sb.length() > 0) { // from syms but not sub, break
                    queue.enqueue(sb.toString());
                    sb = new StringBuilder();
                }
                sb.append(c);
            } else if (SYMS.contains(c)) { // Ops...
                if (sb.length() > 0) { // from anything, break
                    queue.enqueue(sb.toString());
                    sb = new StringBuilder();
                }
                sb.append(c);
            }
            i++;
        }
        if (sb.length() > 0) {  // Flush final values
            queue.enqueue(sb.toString());
        }
        return queue;
    }

    /**
     * Performs the shunting yard algorithm on an arithmetic expression. Based
     * on the algorithm as written in this Wikipedia article section:
     * https://en.wikipedia.org/wiki/Shunting_yard_algorithm#The_algorithm_in_detail
     *
     * @param s
     * @return LinkedQueue of the expression in postfix notation.
     * @throws IllegalArgumentException
     */
    public static LinkedQueue<Object> shuntingYard(String s) throws
            IllegalArgumentException {
        LinkedQueue<String> input = tokenize(s);
        LinkedQueue<Object> output = new LinkedQueue<>();
        LinkedStack<String> opstack = new LinkedStack<>();

        while (!input.isEmpty()) {      // While there are tokens to be read:
            String token = input.dequeue();     // Read a token

            try {   // If a number, put it into the output queue
                output.enqueue(Double.parseDouble(token));
                continue;
            } catch (NumberFormatException e) {
            }

            if (OPS.contains((String) token)) {     // If an operator o1:
                /**
                 * While there is an operator o2 at the top of the operator
                 * stack which is not a left parenthesis, and (o2 has greater
                 * precedence than or equal to o1):
                 */
                while (!opstack.isEmpty() && !OPEN.contains(opstack.top())
                        && !(ADDSUB.contains(opstack.top())
                        && MULTDIV.contains((String) token))) {
                    // pop o2 from the operator stack into the output queue
                    output.enqueue(opstack.pop());
                }
                // push o1 onto the operator stack
                opstack.push((String) token);
            } // If a left parenthesis: 
            else if (OPEN.contains((String) token)) {
                opstack.push((String) token); // push it onto the operator stack
            } // If a right parenthesis: 
            else if (CLOSE.contains((String) token)) {
                /**
                 * while the operator at the top of the operator stack is not a
                 * left parenthesis:
                 */
                while (!opstack.isEmpty() && !OPEN.contains(opstack.top())) {
                    /**
                     * Assert the operator stack is not empty. If the stack runs
                     * out without finding a left parenthesis, then there are
                     * mismatched parentheses.
                     */
                    if (opstack.isEmpty()) {
                        throw new IllegalArgumentException(ERROR);
                    }
                    /**
                     * pop the operator from the operator stack into the output
                     * queue
                     */
                    output.enqueue(opstack.pop());
                }
                /**
                 * Assert there is a left parenthesis at the top of the operator
                 * stack
                 */
                if (!opstack.isEmpty() && !OPEN.contains(opstack.top())) {
                    throw new IllegalArgumentException(ERROR);
                }
                /**
                 * pop the left parenthesis from the operator stack and discard
                 * it
                 */
                opstack.pop();
            }
        }

        /**
         * After the while loop, pop the remaining items from the operator stack
         * into the output queue.
         */
        while (!opstack.isEmpty()) {
            /**
             * assert the operator on top of the stack is not a (left)
             * parenthesis
             */
            if (OPEN.contains(opstack.top())) {
                throw new IllegalArgumentException(ERROR);
            }
            // pop the operator from the operator stack onto the output queue
            output.enqueue(opstack.pop());
        }

        return output;
    }

    /**
     * Converts postfix expression to an expression tree
     *
     * @param input
     * @return output
     */
    public static LinkedBinaryTree<Object> postfixToTree(
            LinkedQueue<Object> input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR);
        }
        LinkedStack<LinkedBinaryTree<Object>> stack = new LinkedStack<>();
        while (!input.isEmpty()) {
            Object token = input.dequeue();
            LinkedBinaryTree<Object> tree = new LinkedBinaryTree<>();
            if (token instanceof Double) {
                tree.addRoot(token);
            } else if (token instanceof String) {
                Position p = tree.addRoot(token);
                LinkedBinaryTree<Object> right = stack.pop();
                LinkedBinaryTree<Object> left = stack.pop();
                if (left == null || right == null) {
                    throw new IllegalArgumentException(ERROR);
                }
                tree.attach(p, left, right);
            }
            stack.push(tree);
        }
        return stack.pop();
    }

    /**
     * Recursive function that evaluates a tree
     *
     * @param tree
     * @return
     */
    public static double evaluateTree(LinkedBinaryTree<Object> tree) {
        return evaluateNode(tree.root(), tree);
    }

    /**
     * Recursive function that evaluates a node
     *
     * @param p
     * @param tree
     * @return
     */
    private static double evaluateNode(Position<Object> p,
            LinkedBinaryTree<Object> tree) {
        Object elem = p.getElement();
        if (elem instanceof Double) {   // Number
            return (Double) elem;
        } // Otherwise, operator
        String op = (String) elem;
        double left = evaluateNode(tree.left(p), tree);
        double right = evaluateNode(tree.right(p), tree);
        switch (op) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = inputScanner.nextLine();
        //String path = "data.txt";
        try {
            File file = new File(path);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println("Expression: " + line);
                try {
                    LinkedQueue<Object> postfix = shuntingYard(line);
                    System.out.println("Postfix: " + postfix);
                    LinkedBinaryTree<Object> tree = postfixToTree(postfix);
                    System.out.println("Result:     " + evaluateTree(tree));
                    System.out.println("Preorder:   " + tree.preorder());
                    System.out.println("Inorder:    " + tree.inorder());
                    System.out.println("Postorder:  " + tree.postorder());
                    System.out.print  ("Euler Tour: ");
                    eulerTourBinary(tree, tree.root);
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }
                System.out.println("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}
