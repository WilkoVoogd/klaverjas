package game;

import game.cards.Card;
import game.cards.CardSuit;

import java.util.List;

public class ValueCalculator {

    public int calculateValue(Card card, CardSuit troef) {
        if (card.isTroef(troef)) {
            return card.getTroefValue();
        } else {
            return card.getNormalValue();}
    }

    public int calculateValue(List<Card> cards, CardSuit troef) {
        int valueOfCards = 0;
        for (Card card : cards) {
            valueOfCards += calculateValue(card, troef);
        }
        return valueOfCards;
    }
}
