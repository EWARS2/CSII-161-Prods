
/**
 * Lab111
 *
 * Utilities for Client class
 *
 * @author Ethan T. Reed
 * @version 2025/12/5
 */
public class Utility {

    /**
     * @param input
     * @param title
     */
    public static void printtbl(Object[][] input, String title) {
        if (input == null || input.length == 0) {
            return;
        }

        final int rows = input.length;
        final int cols = input[0].length;

        String[][] table = new String[rows][cols];
        boolean[][] isNumeric = new boolean[rows][cols];
        int[] widths = new int[cols];

        // Convert values to strings and compute widths
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Object val = input[r][c];

                String s;
                boolean numeric = false;

                if (val == null) {
                    s = "";
                } else if (val instanceof Integer || val instanceof Long
                        || val instanceof Double) {
                    s = String.format("%,d", ((Number) val).longValue());
                    numeric = true;
                } else if (val instanceof Number) {
                    s = val.toString();
                    numeric = true;
                } else {
                    s = val.toString();
                }

                table[r][c] = s;
                isNumeric[r][c] = numeric;
                widths[c] = Math.max(widths[c], s.length());
            }
        }

        // Horizontal separator
        StringBuilder sep = new StringBuilder();
        for (int c = 0; c < cols; c++) {
            sep.append("+").append("-".repeat(widths[c] + 4));
        }
        sep.append("+\n");
        String horizontal = sep.toString();

        // Compute correct inner title width
        int innerWidth = horizontal.indexOf('\n') - 2;

        // Top title bar
        System.out.println("+" + "-".repeat(innerWidth) + "+");

        // Center the title
        String centered = String.format("%" + ((innerWidth + title.length())
                / 2) + "s", title);
        centered = String.format("%-" + innerWidth + "s", centered);
        System.out.printf("|%s|\n", centered);

        // Separator under title
        System.out.print(horizontal);

        // Print rows
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String s = table[r][c];
                int colWidth = widths[c];
                String formatted;

                if (isNumeric[r][c]) {
                    formatted = String.format("%" + colWidth + "s", s);  // right-align numbers
                } else {
                    int paddedLeft = (colWidth - s.length()) / 2 + s.length();
                    formatted = String.format("%" + paddedLeft + "s", s);
                    formatted = String.format("%-" + colWidth + "s", formatted);
                }

                System.out.printf("|  %s  ", formatted);
            }
            System.out.print("|\n" + horizontal);
        }
    }

    /**
     * ArrayCopy for Employee class
     *
     * @param e
     * @return
     */
    public static Employee[] arraycopy(Employee[] e) {
        int len = e.length;
        Employee[] array = new Employee[len];
        for (int i = 0; i < len; i++) {
            array[i] = e[i];
        }
        return array;
    }

    /**
     * Print an array. Used for testing.
     *
     * @param <E>
     * @param array
     */
    public static <E> void printArray(E[] array) {
        for (E item : array) {
            System.out.println(item);
        }
    }
}
