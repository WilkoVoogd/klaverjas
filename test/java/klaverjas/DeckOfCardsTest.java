package klaverjas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

    DeckOfCards deck;

    @BeforeEach
    void setUp() {
        deck = new DeckOfCards();
    }

    @Test
    void testCardsInDeckAreUnique() {
        Set<PlayingCard> uniqueCards = new HashSet<>(deck.getPlayingCards());
        assertEquals(uniqueCards.size(), deck.getPlayingCards().size());
    }


}