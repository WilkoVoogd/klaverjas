package game;

import game.boom.Round;
import game.boom.Slag;
import game.cards.CardRank;
import game.cards.CardSuit;
import game.cards.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SlagTest {

    Card[] cards;

    @BeforeEach
    void setUp() {
        cards = new Card[] {
                new Card(CardRank.NINE, CardSuit.CLUBS), //value = 0, troefValue = 14
                new Card(CardRank.JACK, CardSuit.DIAMONDS), //value = 2, troefValue = 20
                new Card(CardRank.TEN, CardSuit.CLUBS), //value = 10, troefValue = 10
                new Card(CardRank.ACE, CardSuit.HEARTS)}; //value = 11, troefValue = 11

    }

    @Test
    void slagWinnerWithTroef() {
        Round round = new Round(CardSuit.HEARTS);
        Slag slag = new Slag(cards, round);
        assertTrue(slag.slagWinner().equals(new Card(CardRank.ACE, CardSuit.HEARTS)));
    }

    @Test
    void slagWinnerWithNoTroef() {
        Round round = new Round(CardSuit.SPADES);
        Slag slag = new Slag(cards, round);
        assertTrue(slag.slagWinner().equals(new Card(CardRank.TEN, CardSuit.CLUBS)));
    }

    @Test
    void slagWinnerWithTroefGevraagd() {
        Round round = new Round(CardSuit.CLUBS);
        Slag slag = new Slag(cards, round);
        assertTrue(slag.slagWinner().equals(new Card(CardRank.NINE, CardSuit.CLUBS)));
    }

    @Test
    void isVolger() {
        Round round = new Round(CardSuit.CLUBS);
        Slag slag = new Slag(cards, round);
        List<Card> slagCards = slag.getCards();
        assertFalse(slag.isVolger(slagCards.get(1), slagCards.get(0).getCardSuit()));
        assertTrue(slag.isVolger(slagCards.get(2), slagCards.get(0).getCardSuit()));
        assertFalse(slag.isVolger(slagCards.get(3), slagCards.get(0).getCardSuit()));
    }
}