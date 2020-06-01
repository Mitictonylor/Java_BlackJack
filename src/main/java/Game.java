import java.util.ArrayList;

public class Game {
    ArrayList<Player> players;
    Deck deck;
    Dealer dealer;

    public Game(Deck deck) {
        this.deck = deck;
        this.players = new ArrayList<Player>();
        this.dealer = dealer;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public int countPlayer() {
        return this.players.size();
    }

    public void createDealer() {
        this.setDealer(new Dealer("Dealer"));
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void startTheGame() {
        for (Player player : this.players) {
            for (int i = 0; i < 2; i++) {
                Card card = deck.getCard(0);
                deck.removeCard(0);
                player.takeCard(card);
            }
        }
        for (int i = 0; i < 2; i++) {
            Card card = deck.getCard(0);
            deck.removeCard(0);
            dealer.takeCard(card);
        }
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public boolean checkDraw() {
        boolean drawGame = false;
        int handTotal = this.players.get(0).cardsValue();
        for (Player player : this.players) {
            if (player.cardsValue() == dealer.cardsValue()) {
                drawGame = true;
            }
        }
        return drawGame;
    }

    public ArrayList<Player> checkWinner() {
        ArrayList<Player> winner = new ArrayList<Player>();
        if (this.checkForStraightBlackJack().size() > 0) {
            for (Player player : this.checkForStraightBlackJack()) {
                if (player.cardsValue() > dealer.cardsValue()) {
                    winner.add(player);
                }
            }
        } else {
            for (Player player : this.players) {
                if (player.cardsValue() > dealer.cardsValue()) {
                    winner.add(player);
                }
            }
        }
        return winner;
    }
    public ArrayList<Player> checkForStraightBlackJack() {
        ArrayList<Player> blackjack = new ArrayList<Player>();
        for (Player player : this.players) {
            if (player.cardsValue() == 21 && player.countCard() == 2) {
                blackjack.add(player);
            }
        }
        return blackjack;
    }

    public void playerHandToString(Player activePlayer) {
        System.out.println(activePlayer.getName() + "'s hand :" + activePlayer.toString());
    }
    public void playerHandValueToString(Player activePlayer) {
        System.out.println(activePlayer.getName() + "'s hand value is " + activePlayer.cardsValue());
    }
    public void twistOrStand() {
        System.out.println("What do you want to do?  press 1 for twist , or 2 to Stick");
    }
    public void dealerHandToString(Dealer dealer) {
        System.out.println(dealer.getName() + "'s hand :" + dealer.toString());
    }
    public void dealerHandValueToString(Dealer dealer) {
        System.out.println(dealer.getName() + "'s hand value is " + dealer.cardsValue());
    }
}
