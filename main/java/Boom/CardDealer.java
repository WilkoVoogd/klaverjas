package Boom;

import klaverjas.DeckOfCards;
import klaverjas.PlayingCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDealer {
    private DeckOfCards deck;
    private List<Hand> hands;

    public CardDealer() {
        this.deck = new DeckOfCards();
        hands = new ArrayList<Hand>();
        createHands();
    }

    public void dealHands(List<Player> players) {
        int k = 0;
        for (Player player : players) {
            player.setHand(hands.get(k));
            k++;
        }
    }

    private void createHands() {
        for (int i = 0; i < 4; i++) {
            Hand hand = new Hand();
            for (int j = 0; j < 8; j++) {
                hand.addCard(getRandomCard());
            }
            hands.add(hand);
        }

    }

    private PlayingCard getRandomCard() {
        Random random = new Random();
        int index = random.nextInt(deck.getPlayingCards().size());
        PlayingCard card = deck.getPlayingCards().get(index);
        deck.getPlayingCards().remove(index);
        return card;
    }
}
