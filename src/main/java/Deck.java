import java.util.ArrayList;
import java.util.Collections;


public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        this.populateDeck();
        Collections.shuffle(this.cards);
    }

    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }

    public void populateDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.addCard(new Card(suit, rank));
            }
        }
    }

    public Card getCard(int index) {
        return this.cards.get(index);
    }

    public void removeCard(int index) {
        this.cards.remove(index);
    }

    public int countCard() {
        return this.cards.size();
    }

}
