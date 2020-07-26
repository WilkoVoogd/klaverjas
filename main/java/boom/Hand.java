package boom;

import boom.cards.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<PlayingCard> cards;
    private int numberOfCards;

    public Hand() {
        cards = new ArrayList<>();
    }


    public List<PlayingCard> getCards() {
        return cards;
    }

    public void setCards(List<PlayingCard> cards) {
        this.cards = cards;
    }

    public void addCard(PlayingCard card) {
        cards.add(card);
    }
}
