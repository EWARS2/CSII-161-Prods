
/**
 * P-7.60 Implement a CardHand class that supports a person arranging a group of
 * cards in his or her hand. The simulator should represent the sequence of
 * cards using a single positional list ADT so that cards of the same suit are
 * kept together. Implement this strategy by means of four “fingers” into the
 * hand, one for each of the suits of hearts, clubs, spades, and diamonds, so
 * that adding a new card to the person’s hand or playing a correct card from
 * the hand can be done in constant time. The class should support the following
 * methods:
 * 1. addCard(r, s): Add a new card with rank r and suit s to the hand.
 * 2. play(s): Remove and return a card of suit s from the player’s hand; if
 *    there is no card of suit s, then remove and return an arbitrary card from
 *    the hand.
 * 3. iterator( ): Return an iterator for all cards currently in the hand.
 * 4. suitIterator(s): Return an iterator for all cards of suit s that are
 *    currently in the hand.
 */
/**
 * 1. Complete assignment P-7.60 on page 305 of the textbook that implements the
 * CardHand class with the additional requirements as listed. When arranging
 * your cards:
 * a.   You must group the cards by suit with Spades first, follow by Hearts,
 *      Clubs, and then Diamonds.
 * b.   Within each suit the cards should be arranged by rank with Ace first,
 *      followed by King, Queen, Jack, 10, 9, 8, 7, 6, 5, 4, 3, 2 in that order.
 * c.   Implement your CardHand class so that adding a new card can be done at
 *      worst case of O( m ) time where m is the number of cards of a given suit
 *      in a hand.
 * d.   You must use a LinkedPositionalList to represent the card hand.
 * e.   You must use the “four fingers” method suggested in the textbook.
 * f.   You do NOT need to implement the play(s) method described in the text.
 * g.   You DO NOT need to implement the addCard(r,s). You can implement an
 *      addCard( card ) instead.
 * h.   You DO NOT need to implement the iterator() and suitIterator(s) methods
 *      described in the text but you can if you want.
 */
/**
 * Lab107
 * Uses Card class to implement a player's hand of cards.
 *
 * @author Ethan T. Reed
 * @version 2025/10/25
 */
public class CardHand {

    private final LinkedPositionalList<Card> hand;
    private Position<Card> spades;
    private Position<Card> hearts;
    private Position<Card> clubs;
    private Position<Card> diamonds;

    /**
     * Constructor
     */
    public CardHand() {
        hand = new LinkedPositionalList<>();
        spades = hearts = clubs = diamonds = null;
    }

    /**
     * Adds a card to the hand
     *
     * @param c
     */
    public void addCard(Card c) {
        switch (c.getSuit()) {
            case Card.Suit.SPADES ->
                addInOrder(spades, c);
            case Card.Suit.HEARTS ->
                addInOrder(hearts, c);
            case Card.Suit.CLUBS ->
                addInOrder(clubs, c);
            case Card.Suit.DIAMONDS ->
                addInOrder(diamonds, c);
        }
    }

    /**
     * @param start
     * @param c
     */
    private void addInOrder(Position<Card> start, Card c) {
        Position<Card> walk;
        if (start == null) {    // Start at the first position
            walk = hand.first();
        } else {
            walk = start;
        }
        int suit = c.getSuit().getValue();
        int rank = c.getRank().getValue();
        // Traverse the list, until...
        while (walk != null // ...we reach the end, or...
                && walk.getElement().getSuit().getValue()
                <= suit // ...we've reached the end of our group, or...
                && !(walk.getElement().getSuit().getValue()
                == suit // ...in our suit...
                && walk.getElement().getRank().getValue()
                < rank) // ...we are outranked.
                ) {
            walk = hand.after(walk);
        }
        // Now that we've found where, we place the card.
        Position<Card> newpos;
        if (walk == null) {
            hand.addLast(c);    // We've reached the end, insert at the back
            newpos = hand.last();
        } else {
            hand.addBefore(walk, c); // Insert before the first larger value
            newpos = hand.before(walk);
        }
        // Determine if the card was the earliest of it's suit.
        Position<Card> prev = hand.before(newpos);
        boolean isFirstOfSuit = (prev == null)
                || (prev.getElement().getSuit() != c.getSuit());
        // Now update positions.
        switch (c.getSuit()) {
            case Card.Suit.SPADES -> {
                if (spades == null || isFirstOfSuit) {
                    spades = newpos;
                }
            }
            case Card.Suit.HEARTS -> {
                if (hearts == null || isFirstOfSuit) {
                    hearts = newpos;
                }
            }
            case Card.Suit.CLUBS -> {
                if (clubs == null || isFirstOfSuit) {
                    clubs = newpos;
                }
            }
            case Card.Suit.DIAMONDS -> {
                if (diamonds == null || isFirstOfSuit) {
                    diamonds = newpos;
                }
            }
        }
    }

    /**
     * @return size
     */
    public int getSize() {
        return hand.size();
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Position<Card> cursor = hand.first();  // start at first element
        while (cursor != null) {
            sb.append(cursor.getElement());
            cursor = hand.after(cursor);  // move to next position
            if (cursor != null) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
