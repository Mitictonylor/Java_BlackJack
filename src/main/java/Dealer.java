import java.util.ArrayList;

public class Dealer {

    private String name;
    private ArrayList<Card> cards;

    public Dealer(String name) {
        this.name = name;
        this.cards = new ArrayList<Card>();
    }

    public String getName() {
        return this.name;
    }

    public int countCard() {
        return this.cards.size();
    }

    public void takeCard(Card card) {
        this.cards.add(card);
    }

    public int cardsValue() {
        int total = 0;
        int aces = 0;
        for (Card card : this.cards) {
            if (card.getValue() == 1) {
                aces += 1;
            } else {
                total += card.getValue();
            }
        }
            for (int i = 0; i < aces; i++) {
                if (total > 10) {
                    total += 1;
                } else {
                    total += 11;
                }
            }
        return total;
    }

    public String toString() {
        String cardListOutput = "";
        for (Card card : this.cards) {
            cardListOutput += "\n" + card.toString();
        }
        return cardListOutput;
    }

    public String ToStringFirstCard() {
        String firstCard = "\n" + this.cards.get(0).toString();
        return firstCard;
    }

    public void looseCard() {
        this.cards.clear();
    }

    public Card getCardAtIndex(int index) {
        return this.cards.get(index);
    }

}

