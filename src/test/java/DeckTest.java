import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;


    @Before
    public void setUp(){
        deck = new Deck();
    }

    @Test
    public void canPopulate52Cards(){
        assertEquals(52, deck.countCard());
    }
    @Test
    public void cardsCanBeTakenFromDeck(){
        deck.giveCard();
        assertEquals(51, deck.countCard());
    }

}
