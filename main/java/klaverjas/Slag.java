package klaverjas;

import java.util.ArrayList;
import java.util.List;

public class Slag {

    private final CardSuit gevraagd;
    private List<PlayingCard> cards = new ArrayList<>();
    private CardSuit troef;
    private List<PlayingCard> troefCards;

    public Slag(List<PlayingCard> cards, CardSuit troef) {
        this.cards.addAll(cards);
        this.troef = troef;
        this.gevraagd = cards.get(0).getCardSuit();
        this.troefCards = addTroefCardsToTroefCardsList();
    }

    public PlayingCard slagWinner() {
        PlayingCard winner = cards.get(0);
        if (troefCards.size() > 0) {
            winner = troefCards.get(0);
            for (PlayingCard card : troefCards) {
                if (card.getCardRank().getRank() > winner.getCardRank().getRank()) {
                    winner = card;
                }
            }
        } else {
            for (PlayingCard card : cards) {
                if (isVolger(card, gevraagd) && card.getCardRank().getRank() > winner.getCardRank().getRank()) {
                    winner = card;
                }
            }
        }
        return winner;
    }

    private List<PlayingCard> addTroefCardsToTroefCardsList() {
        List<PlayingCard> troefCards = new ArrayList<>();
        for (PlayingCard card : cards) {
            if (card.getCardSuit().equals(troef)) {
                troefCards.add(card);
            }
        } return troefCards;
    }

    public PlayingCard getHighCard(PlayingCard card, PlayingCard otherCard) throws Exception {
        if (card.getCardRank().getRank() > otherCard.getCardRank().getRank()) {
            return card;
        } else if (otherCard.getCardRank().getRank() > card.getCardRank().getRank()) {
            return otherCard;
        } else throw new Exception("Cards are of equal rankValue");
    }

    public boolean isVolger(PlayingCard card, CardSuit gevraagd) {
        return card.getCardSuit().equals(gevraagd);
    }

    public int slagValue() {
        ValueCalculator calculator = new ValueCalculator();
        return calculator.calulateValue(this.cards);
    }
}
