package klaverjas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SlagTest {

    PlayingCard[] cards;

    @BeforeEach
    void setUp() {
        cards = new PlayingCard[] {
                new PlayingCard(CardRank.NINE, CardSuit.CLUBS), //value = 0, troefValue = 14
                new PlayingCard(CardRank.JACK, CardSuit.DIAMONDS), //value = 2, troefValue = 20
                new PlayingCard(CardRank.TEN, CardSuit.CLUBS), //value = 10, troefValue = 10
                new PlayingCard(CardRank.ACE, CardSuit.HEARTS)}; //value = 11, troefValue = 11

    }

    @Test
    void slagWinnerWithTwoTroef() {
        Slag slag = new Slag(cards, CardSuit.CLUBS);
        assertTrue(slag.slagWinner().equals(new PlayingCard(CardRank.NINE, CardSuit.CLUBS)));
    }

    @Test
    void slagWinnerWithNoTroef() {
        Slag slag = new Slag(cards, CardSuit.SPADES);
        assertTrue(slag.slagWinner().equals(new PlayingCard(CardRank.TEN, CardSuit.CLUBS)));
    }

    @Test
    void slagWinnerWithTroefGevraagd() {
        Slag slag = new Slag(cards, CardSuit.CLUBS);
        assertTrue(slag.slagWinner().equals(new PlayingCard(CardRank.NINE, CardSuit.CLUBS)));
    }

    @Test
    void isVolger() {
        Slag slag = new Slag(cards, CardSuit.CLUBS);
        List<PlayingCard> slagCards = slag.getCards();
        assertFalse(slag.isVolger(slagCards.get(1), slagCards.get(0).getCardSuit()));
        assertTrue(slag.isVolger(slagCards.get(2), slagCards.get(0).getCardSuit()));
        assertFalse(slag.isVolger(slagCards.get(3), slagCards.get(0).getCardSuit()));
    }
}