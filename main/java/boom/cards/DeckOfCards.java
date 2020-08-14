package boom.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DeckOfCards {
    public static int numSuits = 4;
    public static int numRanks = 13;
    public static int numCards = numSuits * numRanks;

    private final List<Card> cards = new ArrayList<>();

    public DeckOfCards() {
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }

    public String getCard(CardSuit cardSuit, CardRank cardRank) {
        return Objects.requireNonNull(cards
                .stream()
                .filter(card -> card.getCardSuit().equals(cardSuit) && card.getCardRank().equals(cardRank))
                .findFirst()
                .orElse(null))
                .toString();
    }

    public List<Card> getPlayingCards() {
        return cards;
    }
}