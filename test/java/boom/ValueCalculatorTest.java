package boom;

import boom.cards.CardRank;
import boom.cards.CardSuit;
import boom.cards.Card;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValueCalculatorTest {

    private Card card;
    private List<Card> cards;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Card jackOfClubs = new Card(CardRank.JACK, CardSuit.CLUBS); // value = 2, troefValue = 20
        Card eightOfClubs = new Card(CardRank.EIGHT, CardSuit.CLUBS); // value = 0, troefValue = 0
        Card tenOfHearts = new Card(CardRank.TEN, CardSuit.HEARTS); // value = 10, troefValue = 10
        Card jackOfDiamonds = new Card(CardRank.JACK, CardSuit.DIAMONDS); // value = 2, troefValue = 20
        this.card = jackOfClubs;
        this.cards = Arrays.asList(jackOfClubs, eightOfClubs, tenOfHearts, jackOfDiamonds);
    }

    @Test
    void testCalculateValueOfNonTroefCard() {
        card.setTroef(false);
        assertEquals(2, new ValueCalculator().calculateValue(card));
    }

    @Test
    void testCalculateValueOfTroefCard() {
        card.setTroef(true);
        assertEquals(20, new ValueCalculator().calculateValue(card));
    }

    @Test
    void testCaclulateValueOfListOfCardsWithTroef() {
        cards.get(0).setTroef(true);
        cards.get(1).setTroef(true);
        assertEquals(32, new ValueCalculator().calculateValue(cards));
    }

    @Test
    void testCaclulateValueOfListOfCardsWithoutTroef() {
        assertEquals(14, new ValueCalculator().calculateValue(cards));
    }
}