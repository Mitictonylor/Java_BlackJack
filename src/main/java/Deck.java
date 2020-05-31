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


    public void populateDeck(){
        for (Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                this.cards.add(new Card(suit,rank));
            }
        }

    }
    public Card giveCard() {
        return this.cards.remove(0);
    }

    public int countCard() {
        return this.cards.size();
    }
}
