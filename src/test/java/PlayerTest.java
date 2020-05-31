import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player player;
    Card card;
    Card card7;
    Card card3;
    Card card2;

    @Before
    public void setUp() {
        player = new Player("Filippo");
        card = new Card(Suit.HEARTS, Rank.ACE);
        card7 = new Card(Suit.HEARTS, Rank.SEVEN);
        card3 = new Card(Suit.HEARTS, Rank.THREE);
        card2 = new Card(Suit.HEARTS, Rank.TWO);
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
    public void playerCanLooseAllCard() {
        player.takeCard(card);
        assertEquals(1, player.countCard());
        player.takeCard(card7);
        assertEquals(2, player.countCard());
        player.takeCard(card3);
        assertEquals(3, player.countCard());
        player.looseCard();
        assertEquals(0, player.countCard());
    }

    @Test
    public void weCanGetTheScoreOfTheCard__AceAsFirstSoWillValue11() {
        player.takeCard(card);
        assertEquals(11, player.cardsValue());
        player.takeCard(card7);
        assertEquals(18, player.cardsValue());
        player.takeCard(card3);
        assertEquals(21, player.cardsValue());
    }

    @Test
    public void weCanGetTheScoreOfTheCard__AceAsLastSoWillValue1() {
        player.takeCard(card3);
        assertEquals(3, player.cardsValue());
        player.takeCard(card7);
        assertEquals(10, player.cardsValue());
        player.takeCard(card2);
        assertEquals(12, player.cardsValue());
        player.takeCard(card);
        assertEquals(13, player.cardsValue());
    }

    @Test
    public void cardsCanBeConvertedToString() {
        player.takeCard(card2);
        player.takeCard(card);
        assertEquals("\n" +
                "TWO of HEARTS\n" +
                "ACE of HEARTS", player.toString());
    }
}
