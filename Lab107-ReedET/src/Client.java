
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * 5. A client that tests your classes by dealing a card game. Your client
 * should: a. Create a new instance of a game with four ( 4 ) players, and 13
 * cards per player (e.g. like a game of Bridge). b. Have cards dealt to each
 * player one card at a time and display the hands of each player after each
 * round is dealt. You output should look something like the example at the end
 * of this assignment.
 */
/**
 * Lab107 Example usage of Game class.
 *
 * @author Ethan T. Reed
 * @version 2025/10/25
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Enable UTF-8 encoding in the terminal
        // (For Unicode characters in NetBeans)
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.out.println("Demonstration of player hand sorting working:");
        Game game = new Game(1, 52);
        for (int i = 1; i <= 52; i++) {
            game.getCard();
        }
        System.out.println(game);
        System.out.println("");
        System.out.println("Demonstration of 4 player game, max hand of 13:");
        game = new Game(4, 13);
        for (int i = 1; i < 15; i++) {
            game.getCard();
            System.out.printf("Card %d: %n", i);
            System.out.println(game);
        }
    }
}
