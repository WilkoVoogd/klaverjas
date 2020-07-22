package klaverjas;

import java.util.List;

public class ValueCalculator {

    public int calculateValue(PlayingCard card) {
        if (card.isTroef()) {
            return card.getTroefValue();
        } else {
            return card.getNormalValue();}
    }

    public int calculateValue(List<PlayingCard> cards) {
        int valueOfCards = 0;
        for (PlayingCard card : cards) {
            valueOfCards += calculateValue(card);
        }
        return valueOfCards;
    }
}
