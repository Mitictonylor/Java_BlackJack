import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {
    Dealer dealer;
    Card card;
    Card card2;
    Card card5;
    Card card6;
    Card card9;


    @Before
    public void setUp() {
        dealer = new Dealer("Filippo");
        card = new Card(Suit.HEARTS, Rank.ACE);
        card2 = new Card(Suit.HEARTS, Rank.TWO);
        card5 = new Card(Suit.HEARTS, Rank.FIVE);
        card6 = new Card(Suit.HEARTS, Rank.SIX);
        card9 = new Card(Suit.HEARTS, Rank.NINE);
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
    public void weCanGetTheScoreOfTheCard__startWithACESoItsValueIs11() {
        dealer.takeCard(card);
        assertEquals(11, dealer.cardsValue());
        dealer.takeCard(card2);
        assertEquals(13, dealer.cardsValue());
        dealer.takeCard(card5);
        assertEquals(18, dealer.cardsValue());
    }

    @Test
    public void weCanGetTheScoreOfTheCard__finishWithACESoItsValueIs1() {
        dealer.takeCard(card9);
        assertEquals(9, dealer.cardsValue());
        dealer.takeCard(card2);
        assertEquals(11, dealer.cardsValue());
        dealer.takeCard(card5);
        assertEquals(16, dealer.cardsValue());
        dealer.takeCard(card);
        assertEquals(17, dealer.cardsValue());
    }

    @Test
    public void cardsCanBeConvertedToString() {
        dealer.takeCard(card2);
        dealer.takeCard(card);
        assertEquals("\n" +
                "TWO of HEARTS\n" +
                "ACE of HEARTS", dealer.toString());
    }

    @Test
    public void firstCardCanBeConvertedToString() {
        dealer.takeCard(card2);
        dealer.takeCard(card);
        assertEquals("TWO of HEARTS", dealer.toStringFirstCard());
    }

    @Test
    public void dealerCanLooseAllHisCard() {
        dealer.takeCard(card2);
        assertEquals(1, dealer.countCard());
        assertEquals(2, dealer.cardsValue());
        dealer.takeCard(card);
        assertEquals(2, dealer.countCard());
        assertEquals(13, dealer.cardsValue());
        dealer.looseCard();
        assertEquals(0, dealer.countCard());
        assertEquals(0, dealer.cardsValue());
    }

    @Test
    public void dealerCanGetACardAtASpecifiedIndex() {
        dealer.takeCard(card2);
        assertEquals(1, dealer.countCard());
        assertEquals(2, dealer.cardsValue());
        dealer.takeCard(card);
        assertEquals(2, dealer.countCard());
        assertEquals(13, dealer.cardsValue());
        dealer.getCardAtIndex(0);
        assertEquals(2, dealer.getCards().get(0).getValue());
        dealer.getCardAtIndex(1);
        assertEquals(1, dealer.getCards().get(1).getValue());
    }

}
