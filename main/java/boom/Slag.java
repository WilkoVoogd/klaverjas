package boom;

import boom.cards.CardSuit;
import boom.cards.PlayingCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Slag {

    private final Round round;
    private CardSuit gevraagd;
    private final List<PlayingCard> cards;
    private int value;

    public Slag(PlayingCard[] cards, Round round) {
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

    public void addCard(PlayingCard card) {
        this.cards.add(card);
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
