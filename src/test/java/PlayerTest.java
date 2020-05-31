import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player player;
    Card card;
    Card card2;
    Card card3;

    @Before
    public void setUp() {
        player = new Player("Filippo");
        card = new Card(Suit.HEARTS, Rank.ACE);
        card2 = new Card(Suit.HEARTS, Rank.SEVEN);
        card3 = new Card(Suit.HEARTS, Rank.THREE);
    }

    @Test
    public void hasAName() {
        assertEquals("Filippo", player.getName());
    }

    @Test
    public void playerStartWithNoCards() {
        assertEquals(0, player.countCard());
    }

    @Test
    public void playerCanTakeACard() {
        player.takeCard(card);
        assertEquals(1, player.countCard());
    }

    @Test
    public void weCanGetTheScoreOfTheCard() {
        player.takeCard(card);
        assertEquals(11, player.cardsValue());
        player.takeCard(card2);
        assertEquals(18, player.cardsValue());
        player.takeCard(card3);
        assertEquals(21, player.cardsValue());
    }
}
