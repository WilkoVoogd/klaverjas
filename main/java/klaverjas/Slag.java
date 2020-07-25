package klaverjas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Slag {

    private final CardSuit gevraagd;
    private final List<PlayingCard> cards;
    private final CardSuit troef;
    private int value;

    public Slag(PlayingCard[] cards , CardSuit troef) {
        this.cards = Arrays.asList(cards);
        this.troef = troef;
        this.gevraagd = this.cards.get(0).getCardSuit();
        appointTroefCards();
        setValue();
    }

    private void appointTroefCards() {
        for (PlayingCard card : cards) {
            if (card.getCardSuit().equals(troef)) {
                card.setTroef(true);
            }
        }
    }

    public PlayingCard slagWinner() {
        PlayingCard winner = cards.get(0);
        for (PlayingCard card : cards) {
            if (card.isTroef()) {
                if (!winner.isTroef()) {
                    winner = card;
                } else if (card.getCardRank().getTroefRank() > winner.getCardRank().getTroefRank()) {
                    winner = card;
                }
            } else if (isVolger(card, gevraagd) && card.getCardRank().getRank() > winner.getCardRank().getRank()) {
                winner = card;
            }

        }
        return winner;
    }

    public boolean isVolger(PlayingCard card, CardSuit gevraagd) {
        return card.getCardSuit().equals(gevraagd);
    }

    public void setValue() {
        this.value = new ValueCalculator().calculateValue(this.cards);
    }

    public int getValue() {
        return value;
    }

    public List<PlayingCard> getCards() {
        return this.cards;
    }
}
