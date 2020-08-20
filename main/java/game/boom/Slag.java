package game.boom;

import game.ValueCalculator;
import game.cards.CardSuit;
import game.cards.Card;

import java.util.Arrays;
import java.util.List;

public class Slag {

    private final Round round;
    private final CardSuit gevraagd;
    private final List<Card> cards;
    private int value;
    private CardSuit troef;

    public Slag(Card[] cards, Round round) {
        this.cards = Arrays.asList(cards);
        this.gevraagd = this.cards.get(0).getCardSuit();
        this.round = round;
        this.troef = round.getTroef();
        setValue();
    }

    public Card slagWinner() {
        Card winner = cards.get(0);
        for (Card card : cards) {
            if (card.isTroef(troef)) {
                if (!winner.isTroef(troef)) {
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

    public boolean isVolger(Card card, CardSuit gevraagd) {
        return card.getCardSuit().equals(gevraagd);
    }

    public void setValue() {
        this.value = ValueCalculator.calculateValue(this.cards, troef);
    }

    public int getValue() {
        return value;
    }

    public List<Card> getCards() {
        return this.cards;
    }
}
