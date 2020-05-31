public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public int getValue() {
        return this.rank.getValue();
    }

    public String toString() {
        return this.rank.toString() + " of " + this.suit.toString();
    }
}
