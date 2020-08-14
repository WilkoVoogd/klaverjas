package boom;

import boom.cards.CardSuit;
import boom.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Slag {

    private final Round round;
    private CardSuit gevraagd;
    private final List<Card> cards;
    private int value;

    public Slag(Card[] cards, Round round) {
        this.cards = Arrays.asList(cards);
        this.gevraagd = this.cards.get(0).getCardSuit();
        this.round = round;
        setValue();
    }

    public Slag(Round round) {
        this.cards = new ArrayList<>();
        this.round = round;
        setValue();
    }

    public void setGevraagd(CardSuit gevraagd) {
        this.gevraagd = gevraagd;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card slagWinner() {
        Card winner = cards.get(0);
        for (Card card : cards) {
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

    public boolean isVolger(Card card, CardSuit gevraagd) {
        return card.getCardSuit().equals(gevraagd);
    }

    public void setValue() {
        this.value = new ValueCalculator().calculateValue(this.cards);
    }

    public int getValue() {
        return value;
    }

    public List<Card> getCards() {
        return this.cards;
    }
}
