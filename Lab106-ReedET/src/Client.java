
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
                    new String(new char[widths[j] + 2]).replace("\0", "-"));
        }
        hBuilder.append("+\n");
        String horizontal = hBuilder.toString();
        // Print data
        System.out.printf(horizontal);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String value = table[i][j];
                System.out.printf("| %" + widths[j] + "s ", value);
            }
            System.out.printf("|\n");
            System.out.printf(horizontal);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        final int TEST_COUNT = 8;       // Should be 8
        final long[][] test_results = new long[TEST_COUNT][3];
        // Iterate over tests to perform
        System.out.printf("Running tests...\n");
        for (int i = 0; i < TEST_COUNT; i++) {
            int n = (int) Math.pow(10, i + 1);
            test_results[i][0] = n;
            System.out.printf("%d . ", i + 1);
            try {
                test_results[i][1] = n;
                System.out.printf(". ");
            } catch (OutOfMemoryError e) {
                test_results[i][1] = -1;
                System.out.println(e);
            }
            try {
                test_results[i][2] = n;
                System.out.printf(". ");
            } catch (OutOfMemoryError e) {
                test_results[i][2] = -1;
                System.out.println(e);
            }
        }
        System.out.printf("\n");
        printtbl(test_results);
    }

}
