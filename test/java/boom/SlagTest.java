package boom;

import boom.Slag;
import boom.cards.CardRank;
import boom.cards.CardSuit;
import boom.cards.PlayingCard;
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
    void slagWinnerWithTroef() {
        Round round = new Round(CardSuit.HEARTS);
        Slag slag = new Slag(cards, round);
        slag.getCards().get(3).setTroef(true);
        assertTrue(slag.slagWinner().equals(new PlayingCard(CardRank.ACE, CardSuit.HEARTS)));
    }

    @Test
    void slagWinnerWithNoTroef() {
        Round round = new Round(CardSuit.CLUBS);
        Slag slag = new Slag(cards, round);
        assertTrue(slag.slagWinner().equals(new PlayingCard(CardRank.TEN, CardSuit.CLUBS)));
    }

    @Test
    void slagWinnerWithTroefGevraagd() {
        Round round = new Round(CardSuit.CLUBS);
        Slag slag = new Slag(cards, round);
        slag.getCards().get(0).setTroef(true);
        slag.getCards().get(2).setTroef(true);
        assertTrue(slag.slagWinner().equals(new PlayingCard(CardRank.NINE, CardSuit.CLUBS)));
    }

    @Test
    void isVolger() {
        Round round = new Round(CardSuit.CLUBS);
        Slag slag = new Slag(cards, round);
        List<PlayingCard> slagCards = slag.getCards();
        assertFalse(slag.isVolger(slagCards.get(1), slagCards.get(0).getCardSuit()));
        assertTrue(slag.isVolger(slagCards.get(2), slagCards.get(0).getCardSuit()));
        assertFalse(slag.isVolger(slagCards.get(3), slagCards.get(0).getCardSuit()));
    }
}