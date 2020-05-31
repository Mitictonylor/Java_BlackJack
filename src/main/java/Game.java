import java.util.ArrayList;

public class Game {
    ArrayList<Player> players;
    Deck deck;

    public Game(Deck deck){
        this.deck = deck;
        this.players = new ArrayList<Player>();
    }
    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    public int countPlayer(){
        return this.players.size();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
    public void startTheGame(int amountOfCards){
        for(Player player:this.players){
            for (int i = 0; i < amountOfCards; i ++){
                Card card = deck.giveCard();
                player.takeCard(card);
            }
        }
    }
    public boolean checkDraw(){
        boolean drawgame = true;
        int handTotal = this.players.get(0).cardValue();
        for(Player player: this.players){
            if(player.cardValue() != handTotal){
                drawgame = false;
            }
        }
        return drawgame;
    }

    public Player checkWinner(){
        int highest = 0;
        Player winner = null;
        for(Player player:this.players){
            if(player.cardValue() > highest){
                highest = player.cardValue();
                winner = player;
            }
        }
        return winner;
    }
}
