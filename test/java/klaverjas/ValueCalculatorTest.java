package klaverjas;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValueCalculatorTest {

    private PlayingCard card;
    private ValueCalculator calculator;
    private Slag slag;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.card = new PlayingCard(CardRank.JACK, CardSuit.CLUBS); // value = 20
        this.calculator =  new ValueCalculator();
        List<PlayingCard> cards = new ArrayList<>();
        cards.add(card);
        cards.add(new PlayingCard(CardRank.EIGHT, CardSuit.CLUBS)); // value = 0
        cards.add(new PlayingCard(CardRank.TEN, CardSuit.HEARTS)); // value = 10
        cards.add(new PlayingCard(CardRank.JACK, CardSuit.DIAMONDS)); // value = 2
        this.slag = new Slag(cards, CardSuit.CLUBS);
    }

    @Test
    void testCalculateValueOfNonTroefCard() {
        card.setTroef(false);
        assertEquals(2, calculator.calculateValue(card));
    }

    @Test
    void testCalculateValueOfTroefCard() {
        card.setTroef(true);
        assertEquals(20, calculator.calculateValue(card));
    }

    @Test
    void testCaclulateValueOfSlag() {
        assertEquals(32, calculator.calculateValue(slag.getCards()));
    }
}