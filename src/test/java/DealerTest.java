import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {
    Dealer dealer;
    Card card;
    Card card2;

    @Before
    public void setUp() {
        dealer = new Dealer("Filippo");
        card = new Card(Suit.HEARTS, Rank.ACE);
        card2 = new Card(Suit.HEARTS, Rank.TWO);
    }

    @Test
    public void hasAName() {
        assertEquals("Filippo", dealer.getName());
    }

    @Test
    public void dealerStartWithNoCards() {
        assertEquals(0, dealer.countCard());
    }

    @Test
    public void dealerCanTakeACard() {
        dealer.takeCard(card);
        assertEquals(1, dealer.countCard());
    }

    @Test
    public void weCanGetTheScoreOfTheCard() {
        dealer.takeCard(card);
        dealer.takeCard(card2);
        assertEquals(3, dealer.cardsValue());
    }
}
