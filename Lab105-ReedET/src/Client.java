
/**
 * Lab105
 * Example menu for Recursion class.
 *
 * @author Ethan T. Reed
 * @version 2025/10/10
 */
import java.util.Scanner;

public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean execute = true;
        while (execute) {
            System.out.println("==========  Menu  ==========");
            System.out.println(" A)  Harmonic Integer ");
            System.out.println(" B)  Sum of Positive Integers ");
            System.out.println(" C)  Find File ");
            System.out.println(" Q)  Quit ");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().toUpperCase();
            switch (choice) {
                case "Q" ->
                    execute = false;
                case "A" ->
                    System.out.println(Recursion.interactiveHarmonic());
                case "B" ->
                    System.out.println(Recursion.interactiveSum());
                case "C" ->
                    Recursion.interactiveFindFile();
                default ->
                    System.out.println("Invalid Choice, Try Again\n");
            }
        }
        System.out.println("Exiting...");
    }
}
