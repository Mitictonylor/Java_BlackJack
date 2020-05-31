import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> cards;

    public Player(String name){
        this.name = name;
        this.cards = new ArrayList<Card>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCard() {
        return this.cards;
    }

    public void setCard(ArrayList<Card> card) {
        this.cards = card;
    }

    public int countCard() {
        return this.cards.size();
    }

    public void takeCard(Card card) {
        this.cards.add(card);
    }

    public int cardValue() {
        int total = 0;
        for(Card card :this.cards){
            total += card.getValue();
        }
        return total;
    }
}
