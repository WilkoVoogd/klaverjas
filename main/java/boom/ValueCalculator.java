package boom;

import boom.cards.Card;

import java.util.List;

public class ValueCalculator {

    public int calculateValue(Card card) {
        if (card.isTroef()) {
            return card.getTroefValue();
        } else {
            return card.getNormalValue();}
    }

    public int calculateValue(List<Card> cards) {
        int valueOfCards = 0;
        for (Card card : cards) {
            valueOfCards += calculateValue(card);
        }
        return valueOfCards;
    }
}
