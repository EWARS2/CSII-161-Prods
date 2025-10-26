
/**
 * 4. Implement a Game class that represents a card game.  This Game class must
 *    include:
 *  a. An overload constructor that sets:
 *      i.  An instance variable that represents the number of players in the
 *          game (should be passed in as a constructor parameter).
 *      ii. An instance variable that represents the maximum number of cards
 *          that can be in each player’s hand (should be passed in as a
 *          constructor parameter).
 *  b. An instance variable for the deck of cards used in the game.
 *  c. An instance variable that is a list of the player’s card hands.  You can
 *     choose what data structure to use for this list.
 *  d. A method getCard() that deals one card to each player in the list of
 *     players (item c).  When a player gets a new card, they must immediately
 *     add this card to their hand so that they are ordered correctly by suit and
 *     rank (item 1).
 *  e. As mentioned early, each player must organize their hand by suit (Spades,
 *     Hearts, Clubs, Diamonds) with spades being displayed first and then by
 *     rank within each suit (Ace, King, Queen, Jack, 10, 9, 8, 7, 6, 5, 4, 3, 2)
 *     with Ace being displayed first.
 *  f. Note that the player must immediately insert each new card into the
 *     correct position in their hand.  The player cannot wait until they have
 *     received all of their cards and then sort the cards.
 */
/**
 * Lab107
 * Uses Deck, CardHand, and in turn, Card classes to implement game play.
 *
 * @author Ethan T. Reed
 * @version 2025/10/25
 */
public class Game {

    private int playerCount;
    private int maxHand;
    private Deck deck;
    private CardHand[] players;

    /**
     * Constructor
     */
    public Game() {
        this(4, 52);
    }

    /**
     * Overloaded Constructor
     *
     * @param playerCount
     * @param maxHand
     */
    public Game(int playerCount, int maxHand) {
        this.playerCount = playerCount;
        this.maxHand = maxHand;
        deck = new Deck();
        players = new CardHand[playerCount];
        for (int i = 0; i < playerCount; i++) {
            players[i] = new CardHand();
        }
    }

    /**
     * Each player draws a card.
     */
    public void getCard() {
        for (int i = 0; i < playerCount; i++) {
            if (players[i].getSize() < maxHand) {
                players[i].addCard(deck.card());
            }
        }
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playerCount; i++) {
            sb.append("Player ").append(i).append(": ");
            sb.append(players[i].toString());
            if (i + 1 < playerCount) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
