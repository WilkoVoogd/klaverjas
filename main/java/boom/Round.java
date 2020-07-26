package boom;

import boom.cards.CardSuit;
import boom.cards.DeckOfCards;
import boom.cards.PlayingCard;

import java.util.List;

public class Round {
    private List<Slag> slagen;
    private static final int NUMBER_OF_SLAGEN = 8;
    private CardSuit troef;
    private DeckOfCards deck;

    public Round(CardSuit troef) {
        this.deck = new DeckOfCards();
        this.troef = troef;
        appointTroefCards();
    }

    public CardSuit getTroef() {
        return this.troef;
    }

    private void appointTroefCards() {
        for (PlayingCard card : deck.getPlayingCards()) {
            if (card.getCardSuit().equals(getTroef())) {
                card.setTroef(true);
            }
        }
    }

}
