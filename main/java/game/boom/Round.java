package game.boom;

import game.cards.CardSuit;
import game.cards.DeckOfCards;

import java.util.List;

public class Round {
    private List<Slag> slagen;
    private static final int NUMBER_OF_SLAGEN = 8;
    private CardSuit troef;
    private DeckOfCards deck;

    public Round(CardSuit troef) {
        this.deck = new DeckOfCards();
        this.troef = troef;
    }

    public CardSuit getTroef() {
        return this.troef;
    }
}
