
/**
 * 3. Implement a Deck class that represents a deck of cards. This Deck class
 *    must include the following methods:
 * a. Deck( ): the constructor that creates a deck of 52 cards, one of each
 *    possible suit-value combination.
 * b. card( ): deals a random card from the deck, where: 1) cards are dealt on a
 *    non-replacement basis (i.e. once a card is dealt it cannot be dealt
 *    again), and 2) on each deal all cards (remaining) in the deck have an
 *    equal probability of being dealt.
 * c. Selecting the correct data structure should make this easy to implement.
 */
/**
 * Lab107
 * Uses Card class to implement a standard 52 card deck.
 *
 * @author Ethan T. Reed
 * @version 2025/10/25
 */
public class Deck {

    private final ArrayBag deck;

    /**
     * Constructs a new deck containing all 52 unique cards.
     */
    public Deck() {
        deck = new ArrayBag(52);
        for (Card.Suit suit : Card.Suit.values()) {     // Generate all cards
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    /**
     * @return Card
     */
    public Card card() {
        return (Card) deck.remove(); // TODO : This cast shouldn't be needed
    }
}
