
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

/**
 * Lab110
 * 
 * Test files in a directory if they contain different types of palindromes
 *
 * @author Ethan T. Reed
 * @version 2025/11/19
 */
public class Client {

    /**
     * Takes a string and tests on an object basis if it is a palindrome.
     * Degenerate cases are not reported as positive. (i.e. single object)
     *
     * @param <E>
     * @param e
     * @return Boolean
     */
    public static <E> boolean isPalindrome(E[] e) {
        int length = e.length;
        if (length <= 1) {
            return false;
        }
        int last = length - 1;
        int middle = length / 2;
        for (int i = 0; i < middle; i++) {
            if (!e[i].equals(e[last - i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param table to print
     */
    public static void printtbl(String[][] table) {
        int rows = table.length;
        int columns = table[0].length;
        // Get column widths
        int[] widths = new int[columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (table[i][j] == null) {
                    continue;
                }
                int length = table[i][j].length();
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
                int width = (widths[j] / 2) + 1;
                value = String.format("%" + width + "s", value);
                value = String.format("%-" + widths[j] + "s", value);
                System.out.printf("|  %s  ", value);
            }
            System.out.printf("|\n%s", horizontal);
        }
    }

    /**
     * @param Boolean
     * @return a string representing the Boolean as either "Y" or "N"
     */
    public static String bool2YN(boolean Boolean) {
        if (Boolean) {
            return "Y";
        } else {
            return "N";
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        final String[] header = {"Filename", "Character", "Word", "Line"};
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter path: ");
        String path = inputScanner.nextLine();
        //String path = "./test/samples";         // Sample path,
        Object[] temp;                          // Declare temp array,
        Path dir = Paths.get(path);             // Get the path for nio.Files,
        Object[] files = Files.list(dir) // nio.Files witchcraft to get an
                .filter(Files::isRegularFile).toArray();    // array of files,
        long count = files.length;              // Get file count,
        final String[][] test_results // Declaration of table data
                = new String[(int) count + 1][header.length]; // using info,
        test_results[0] = header;               // Insert header into table data
        for (int i = 0; i < count; i++) {       // Operating on every file,
            Path file = (Path) files[i];        // Get the file to operate on,
            int j = i + 1;
            // Insert Filename entry,
            test_results[j][0] = file.getFileName().toString();
            // Get contents of file in a format to be used,
            String content = Files.readString(file)
                    .replaceAll("[\":;',.!?-]", "").toLowerCase();
            // Character entry: Split based off of letters
            temp = content.replaceAll("[\\t\\n\\r ]", "").split("");
            test_results[j][1] = bool2YN(isPalindrome(temp));
            // Word entry: Split based off of spaces and newlines
            temp = content.split("[\n\r\t ]+");
            test_results[j][2] = bool2YN(isPalindrome(temp));
            // Line entry: Split based off of newlines
            temp = content.replaceAll("[\t ]+", "").split("[\n\r]+");
            test_results[j][3] = bool2YN(isPalindrome(temp));
        }
        System.out.println("Palindrome tests:");
        printtbl(test_results);
    }
}
