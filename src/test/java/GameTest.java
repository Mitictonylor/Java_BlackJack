import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {

    Player player1;
    Player player2;
    Player player3;
    Deck deck;
    Game game;
    Card card;
    Card card2;
    Card card5;
    Card card6;
    Card card9;

    @Before
    public void setup() {
        player1 = new Player("Colin");
        player2 = new Player("Louise");
        player3 = new Player("John");
        deck = new Deck();
        game = new Game(deck);
        card = new Card(Suit.HEARTS, Rank.ACE);
        card2 = new Card(Suit.HEARTS, Rank.TWO);
        card5 = new Card(Suit.HEARTS, Rank.FIVE);
        card6 = new Card(Suit.HEARTS, Rank.SIX);
        card9 = new Card(Suit.HEARTS, Rank.NINE);
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.createDealer();

    }

    @Test
    public void gameHasPlayers() {
        assertEquals(2, game.countPlayer());
    }
    @Test
    public void gameCanAddPlayers() {
        game.addPlayer(player3);
        assertEquals(3, game.countPlayer());
    }
    @Test
    public void gameCanStart() {
        game.startTheGame();
        assertEquals(2, player1.countCard());
        assertEquals(2, player2.countCard());
        assertEquals(2, game.countPlayer());
    }
//    @Test
//    public void gameCanCheckDraw(){
//        player1.takeCard(highCard);
//        player2.takeCard(highCard);
//        assertTrue(game.checkDraw());
//    }
//
//    @Test
//    public void gameCanCheckWinner(){
//        player1.takeCard(highCard);
//        player2.takeCard(lowCard);
//        assertEquals(player1, game.checkWinner());
//    }

}