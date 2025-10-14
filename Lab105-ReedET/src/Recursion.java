
/**
 * Lab105
 * Recursive methods for Harmonics, Summation, and File Finding.
 * Includes user-interactive methods via terminal for all three.
 *
 * @author Ethan T. Reed
 * @version 2025/10/10
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Recursion {

    /**
     * @param n
     * @return nth Harmonic number, or sum of 1/k where k=1 to n.
     */
    public static double harmonic(double n) {
        if (n == 1) {
            return 1;
        } else if (n < 0) {
            throw new IllegalArgumentException("Value cannot be negative.");
        }
        return (1 / n) + harmonic(n - 1);
    }

    /**
     * @return harmonic that user prompted from terminal.
     */
    public static double interactiveHarmonic() {
        double output = -1;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("(Q to quit) "
                        + "Enter harmonic number of n to calculate: ");
                String line = scanner.nextLine();
                if ("Q".equals(line.toUpperCase())) {
                    System.out.println("Quitting...");
                    break;
                }
                output = harmonic(Double.parseDouble(line));
                System.out.println(output);
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println("Please enter a whole integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                System.out.println("Please enter a whole integer.");
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Unexpected error, please try again.");
                System.out.println("Enter a whole integer.");
            }
        }   // Don't close Scanner when using System.in
        return output;
    }

    /**
     * @param n
     * @return sum of integers from 1 and n inclusively.
     */
    public static long sum(long n) {
        if (n == 1) {
            return 1;
        } else if (n < 0) {
            throw new IllegalArgumentException("Value cannot be negative.");
        }
        return n + sum(n - 1);
    }

    /**
     * @return summation that user prompted from terminal.
     */
    public static long interactiveSum() {
        long output = -1;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("(Q to quit) "
                        + "Enter number of 1 to n to calculate sum: ");
                String line = scanner.nextLine();
                if ("Q".equals(line.toUpperCase())) {
                    System.out.println("Quitting...");
                    break;
                }
                output = sum(Long.parseLong(line));
                System.out.println(output);
            } catch (NumberFormatException e) {
                System.out.println(e);
                System.out.println("Please enter a whole integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                System.out.println("Please enter a whole integer.");
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Unexpected error, please try again.");
                System.out.println("Enter a whole integer.");
            }
        }   // Don't close Scanner when using System.in
        return output;
    }

    /**
     * @param targetFileName the name of the file to search for.
     * @param startPath the directory path to start searching from.
     * @throws java.io.FileNotFoundException
     */
    public static void findFile(String targetFileName, String startPath)
            throws FileNotFoundException {
        File startDir = new File(startPath);
        if (!startDir.exists()) {
            throw new FileNotFoundException("Error: The path \"" + startPath
                    + "\" does not exist.");
        } else if (!startDir.isDirectory()) {
            throw new FileNotFoundException("Error: The path \"" + startPath
                    + "\" is not a directory.");
        }
        File[] files = startDir.listFiles();
        if (files == null) {
            return;  // handle permission errors or empty folders
        }   // Recursive search
        for (File f : files) {
            if (f.getName().equalsIgnoreCase(targetFileName)) {
                // Match found
                System.out.println("Found: " + f.getAbsolutePath());
            } else if (f.isDirectory()) {
                // Recursive call for subdirectory
                findFile(targetFileName, f.getAbsolutePath());
            }
        }
    }

    /**
     * findFile() via terminal
     */
    public static void interactiveFindFile() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {   // TODO : The following input checks are repeated.
                System.out.print("(Q to quit) "
                        + "Enter file to search for: ");
                String file = scanner.nextLine();
                if ("Q".equals(file.toUpperCase())) {
                    System.out.println("Quitting...");
                    break;
                }
                System.out.print("(Q to quit) "
                        + "Enter starting path: ");
                String path = scanner.nextLine();
                if ("Q".equals(path.toUpperCase())) {
                    System.out.println("Quitting...");
                    break;
                }
                findFile(file, path);
            } catch (FileNotFoundException e) {
                System.out.println(e);
                System.out.println("Error, please try again.");
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Unexpected error, please try again.");
            }
        }   // Don't close Scanner when using System.in
    }
}
