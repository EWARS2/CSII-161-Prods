
/**
 * 2. Implement a Card class that represents a playing card.
 * a. Each card has a suit ( Club, Diamond, Heart, or Spade )
 * b. A card has a value ( 2 through 10, Jack, Queen, King, or Ace) with 2 being
 *    the lowest value and Ace being the highest value.
 * c. You can include additional instance variables if you wish.
 * d. You do not need to support Jokers.
 */
/**
 * Lab107
 * Implements a standard 52 cards.
 *
 * @author Ethan T. Reed
 * @version 2025/10/25
 */
public class Card {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static final char SPADE = '\u2660';
    public static final char HEART = '\u2665';
    public static final char CLUB = '\u2663';
    public static final char DIAMOND = '\u2666';

    /**
     * Enumeration for the four suits.
     */
    public enum Suit {
        SPADES(1, "" + SPADE),
        HEARTS(2, ANSI_RED + HEART + ANSI_RESET),
        CLUBS(3, "" + CLUB),
        DIAMONDS(4, ANSI_RED + DIAMOND + ANSI_RESET);
        private final int value;
        private final String chara;

        Suit(int value, String chara) {
            this.value = value;
            this.chara = chara;
        }

        public int getValue() {
            return value;
        }

        public String getChar() {
            return chara;
        }
    }

    /**
     * Enumeration for the thirteen possible ranks.
     */
    public enum Rank {
        TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"),
        SEVEN(7, "7"), EIGHT(8, "8"), NINE(9, "9"), TEN(10, "10"),
        JACK(11, "J"), QUEEN(12, "Q"), KING(13, "K"), ACE(14, "A");
        private final int value;
        private final String chara;

        Rank(int value, String chara) {
            this.value = value;
            this.chara = chara;
        }

        public int getValue() {
            return value;
        }

        public String getChar() {
            return chara;
        }
    }

    private final Suit suit;
    private final Rank rank;

    /**
     * Constructs a Card with the specified suit and rank.
     *
     * @param suit the suit of the card
     * @param rank the rank of the card
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * @return suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @return rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return rank.chara + suit.chara;
    }

    /**
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Card)) {
            return false;
        }
        Card other = (Card) obj;
        return this.rank == other.rank && this.suit == other.suit;
    }
}
