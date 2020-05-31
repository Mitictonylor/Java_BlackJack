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
                Card card = deck.getCard(i);
                deck.removeCard(i);
                player.takeCard(card);
            }
        }
    }
//    public boolean checkDraw(){
//        boolean drawgame = true;
//        int handTotal = this.players.get(0).cardValue();
//        for(Player player: this.players){
//            if(player.cardValue() != handTotal){
//                drawgame = false;
//            }
//        }
//        return drawgame;
//    }
//
//    public Player checkWinner(){
//        int highest = 0;
//        Player winner = null;
//        for(Player player:this.players){
//            if(player.cardValue() > highest){
//                highest = player.cardValue();
//                winner = player;
//            }
//        }
//        return winner;
//    }
}
