import java.util.ArrayList;

public class Game {
    ArrayList<Player> players;
    Deck deck;
    Dealer dealer;

    public Game(Deck deck){
        this.deck = deck;
        this.players = new ArrayList<Player>();
        this.dealer = dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    public int countPlayer(){
        return this.players.size();
    }
    public void createDealer() {
        this.setDealer(new Dealer("Dealer"));
    }
    public void addPlayer(Player player) {
        this.players.add(player);
    }
    public void startTheGame(){
        for(Player player:this.players){
            for (int i = 0; i < 2; i ++){
                Card card = deck.getCard(0);
                deck.removeCard(0);
                player.takeCard(card);
            }
        }
        for (int i = 0; i < 2; i ++){
            Card card = deck.getCard(0);
            deck.removeCard(0);
            dealer.takeCard(card);
        }
    }
    public boolean checkDraw(){
        boolean drawGame = false;
        int handTotal = this.players.get(0).cardsValue();
        for(Player player: this.players){
            if(player.cardsValue() == dealer.cardsValue()){
                drawGame = true;
            }
        }
        return drawGame;
    }

    public ArrayList<Player> checkWinner(){
        int highest = 0;
        ArrayList<Player> winner = new ArrayList<Player>();
        for(Player player:this.players){
            if(player.cardsValue() > dealer.cardsValue()){
                winner.add(player);
            }else{
            }
        }
        return winner;
    }
}
