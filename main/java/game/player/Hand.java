package game.player;

import game.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;
    private int numberOfCards;

    public Hand() {
        cards = new ArrayList<>();
    }


    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
