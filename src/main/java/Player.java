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
    public String toString(){
        String cardListOutput = "";
        for(Card card : this.cards){
            cardListOutput += "\n" + card.toString();
        }
        return cardListOutput;
    }
}
