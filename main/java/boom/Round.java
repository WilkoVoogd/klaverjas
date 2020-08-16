package boom;

import boom.cards.CardSuit;
import boom.cards.DeckOfCards;
import boom.cards.Card;

import java.util.List;

public class Round {
    private List<Slag> slagen;
    private static final int NUMBER_OF_SLAGEN = 8;
    private CardSuit troef;
    private DeckOfCards deck;

    public Round(CardSuit troef) {
        this.deck = new DeckOfCards();
        this.troef = troef;
       // appointTroefCards();
    }

    public CardSuit getTroef() {
        return this.troef;
    }
}
