import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        this.populateDeck();
        Collections.shuffle(this.cards);
    }


    public void populateDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(suit, rank));
            }
        }
    }

    public void removeCard(int index) {
        this.cards.remove(index);
    }

    public int countCard() {
        return this.cards.size();
    }

    public Card getCard(int index) {
        return this.cards.get(index);
    }

    public String toString() {
        String cardListOutput = "";
        for (Card card : this.cards) {
            cardListOutput += "\n" + card.toString();
        }
        return cardListOutput;
    }

    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }

    public void addDeck(Deck comingFrom) {
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }
}
