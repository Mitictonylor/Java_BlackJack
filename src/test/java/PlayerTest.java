import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player player;
    Card card;

    @Before
    public void setUp(){
        player = new Player("Filippo");
        card = new Card(Suit.HEARTS, Rank.ACE);
    }
    @Test
    public void hasAName(){
        assertEquals("Filippo", player.getName());
    }
    @Test
    public void playerStartWithNoCards(){
        assertEquals(0, player.countCard());
    }
    @Test
    public void playerCanTakeACard(){
        player.takeCard(card);
        assertEquals(1, player.countCard());
    }
    @Test
    public void weCanGetTheScoreOfTheCard(){
        player.takeCard(card);
        assertEquals(1, player.cardValue());
    }
}
