
/**
 * Lab106
 * Example usage of the ArrayStack, LinkedStack, ArrayQueue, LinkedQueue,
 * and ArrayList classes.
 *
 * @author Ethan T. Reed
 * @version 2025/10/17
 */
public class Client {

    /**
     * @param intTable to print
     */
    public static void printtbl(long[][] intTable) {
        int rows = intTable.length;
        int columns = intTable[0].length;
        String[][] table = new String[rows][columns];
        // Convert int table to formatted string table, and get columns
        int[] widths = new int[columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String value = String.format("%,d", intTable[i][j]);
                table[i][j] = value;
                int length = value.length();
                if (length > widths[j]) {
                    widths[j] = length;
                }
            }
        }
        //Generate horizontal line separator string
        StringBuilder hBuilder = new StringBuilder();
        for (int j = 0; j < columns; j++) {
            hBuilder.append("+").append(
                    new String(new char[widths[j] + 4]).replace("\0", "-"));
        }
        hBuilder.append("+\n");
        String horizontal = hBuilder.toString();
        // Print data
        System.out.printf(horizontal);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String value = table[i][j];
                System.out.printf("|  %" + widths[j] + "s  ", value);
            }
            System.out.printf("|\n%s", horizontal);
        }
    }

    /**
     * @param n items to add and remove
     * @return time taken in nanoseconds
     */
    public static long testArrayStack(int n) {
        try {
            ArrayStack element = new ArrayStack(n);
            long startTime = System.nanoTime();
            for (int i = 0; i < n; i++) {
                element.push(1);
            }
            for (int i = 0; i < n; i++) {
                element.pop();
            }
            long endTime = System.nanoTime();
            System.out.printf(". ");
            return endTime - startTime;
        } catch (OutOfMemoryError e) {
            System.out.println(e);
            return -1;
        } 
    }

    /**
     * @param n items to add and remove
     * @return time taken in nanoseconds
     */
    public static long testLinkedStack(int n) {
        try {
            LinkedStack element = new LinkedStack();
            long startTime = System.nanoTime();
            for (int i = 0; i < n; i++) {
                element.push(1);
            }
            for (int i = 0; i < n; i++) {
                element.pop();
            }
            long endTime = System.nanoTime();
            System.out.printf(". ");
            return endTime - startTime;
        } catch (java.lang.OutOfMemoryError e) {
            System.out.println(e);
            return -1;
        }
    }

    /**
     * @param n items to add and remove
     * @return time taken in nanoseconds
     */
    public static long testArrayQueue(int n) {
        try {
            ArrayQueue element = new ArrayQueue(n);
            long startTime = System.nanoTime();
            for (int i = 0; i < n; i++) {
                element.enqueue(1);
            }
            for (int i = 0; i < n; i++) {
                element.dequeue();
            }
            long endTime = System.nanoTime();
            System.out.printf(". ");
            return endTime - startTime;
        } catch (OutOfMemoryError e) {
            System.out.println(e);
            return -1;
        } 
    }

    /**
     * @param n items to add and remove
     * @return time taken in nanoseconds
     */
    public static long testLinkedQueue(int n) {
        try {
            LinkedQueue element = new LinkedQueue();
            long startTime = System.nanoTime();
            for (int i = 0; i < n; i++) {
                element.enqueue(1);
            }
            for (int i = 0; i < n; i++) {
                element.dequeue();
            }
            long endTime = System.nanoTime();
            System.out.printf(". ");
            return endTime - startTime;
        } catch (OutOfMemoryError e) {
            System.out.println(e);
            return -1;
        } 
    }

    /**
     * @param n items to add and remove
     * @return time taken in nanoseconds
     */
    public static long testArrayList(int n) {
        try {
            ArrayList element = new ArrayList(n);
            long startTime = System.nanoTime();
            for (int i = 0; i < n; i++) {
                element.add(i, 1);
            }
            for (int i = n - 1; i > 0; i--) {
                element.remove(i);
            }
            long endTime = System.nanoTime();
            System.out.printf(". ");
            return endTime - startTime;
        } catch (OutOfMemoryError e) {
            System.out.println(e);
            return -1;
        } 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int TEST_COUNT = 6;       // Should be 6 or 9
        //int MEM_PAD = 750000000;
        //int[] MEM_PADDING = new int[MEM_PAD];
        final long[][] test_results = new long[TEST_COUNT][6];
        System.out.printf("Running tests...\n");
        for (int i = 0; i < TEST_COUNT; i++) {  // Iterate over tests to perform
            int n = (int) Math.pow(10, i + 1);
            test_results[i][0] = n;
            System.out.printf("%d ", i + 1);
            test_results[i][1] = testArrayStack(n);
            test_results[i][2] = testLinkedStack(n);
            test_results[i][3] = testArrayQueue(n);
            test_results[i][4] = testLinkedQueue(n);
            test_results[i][5] = testArrayList(n);
        }
        System.out.printf("\n");
        printtbl(test_results);
    }
}
