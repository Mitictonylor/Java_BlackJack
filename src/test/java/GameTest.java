import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    Player player1;
    Player player2;
    Deck deck;
    Game game;
    Card highCard;
    Card lowCard;

    @Before
    public void setup(){
        player1 = new Player("Colin");
        player2 = new Player("Louise");
        deck = new Deck();
        game = new Game(deck);
        game.addPlayer(player1);
        game.addPlayer(player2);

        highCard = new Card(Suit.HEARTS, Rank.QUEEN);
        lowCard = new Card(Suit.SPADES, Rank.JACK);
    }
    @Test
    public void gameHasPlayers(){
        assertEquals(2, game.countPlayer());
    }
    @Test
    public void gameCanStart(){
        game.startTheGame(1);
        assertEquals(1, player1.countCard());
        assertEquals(1, player2.countCard());
    }
    @Test
    public void gameCanCheckDraw(){
        player1.takeCard(highCard);
        player2.takeCard(highCard);
        assertTrue(game.checkDraw());
    }

    @Test
    public void gameCanCheckWinner(){
        player1.takeCard(highCard);
        player2.takeCard(lowCard);
        assertEquals(player1, game.checkWinner());
    }

}