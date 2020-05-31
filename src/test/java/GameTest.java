import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
        card2 = new Card(Suit.SPADES, Rank.ACE);
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

    @Test
    public void gameCanCheckDraw__true() {
        player1.takeCard(card);
        game.getDealer().takeCard(card2);
        assertTrue(game.checkDraw());
    }

    @Test
    public void gameCanCheckDraw__false() {
        player1.takeCard(card5);
        game.getDealer().takeCard(card9);
        assertFalse(game.checkDraw());
    }

    @Test
    public void gameCanCheckWinner__dealerLost() {
        player1.takeCard(card);
        player1.takeCard(card9);
        player2.takeCard(card5);
        player2.takeCard(card6);
        game.getDealer().looseCard();
        assertEquals(2, game.checkWinner().size());
        assertFalse(game.checkWinner().isEmpty());
    }

    @Test
    public void gameCanCheckWinner__dealerGotLessPointThanPlayer1ButMoreThanPlayer2() {
        player1.takeCard(card);
        player1.takeCard(card9);
        assertEquals(20, player1.cardsValue());
        player2.takeCard(card5);
        player2.takeCard(card6);
        assertEquals(11, player2.cardsValue());
        game.getDealer().takeCard(card2);
        game.getDealer().takeCard(card6);
        assertEquals(17, game.getDealer().cardsValue());
        assertEquals(1, game.checkWinner().size());
        assertFalse(game.checkWinner().isEmpty());
    }

    @Test
    public void gameCanCheckWinner__dealerWins() {
        player1.takeCard(card2);
        player1.takeCard(card6);
        assertEquals(17, player1.cardsValue());
        player2.takeCard(card5);
        player2.takeCard(card6);
        assertEquals(11, player2.cardsValue());
        game.getDealer().takeCard(card);
        game.getDealer().takeCard(card9);
        assertEquals(20, game.getDealer().cardsValue());
        assertEquals(0, game.checkWinner().size());
        assertTrue(game.checkWinner().isEmpty());
    }
}