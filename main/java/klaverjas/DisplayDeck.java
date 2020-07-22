package klaverjas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DisplayDeck {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            List<PlayingCard> slagCards = slagCards();

            for (PlayingCard card : slagCards) {
                System.out.println(card.toString());
            }

            System.out.println();

            Random random = new Random();
            int troefSuit = random.nextInt(CardSuit.values().length);
            CardSuit troef = CardSuit.values()[troefSuit];
            System.out.println(troef);
            for (PlayingCard card : slagCards) {
                if (card.getCardSuit().equals(troef)) {
                    card.setTroef(true);
                }

            }

            Slag slag = new Slag(slagCards, troef);

            System.out.println("Winner: " + slag.slagWinner().toString());
            System.out.println();

            System.out.println(slag.getValue());
            System.out.println("----------------");
        }
    }

    public static List<PlayingCard> slagCards() {
        List<PlayingCard> cards = new ArrayList<>();
        addCards : for (int i = 0; i < 4; i++) {
            Random random = new Random();
            int rank = random.nextInt(CardRank.values().length);
            int suit = random.nextInt(CardSuit.values().length);
            PlayingCard card = new PlayingCard(CardRank.values()[rank], CardSuit.values()[suit]);
            for (PlayingCard existingCard : cards) {
                if (card.equals(existingCard)) {
                    i--;
                    continue addCards;
                }
            }
            cards.add(card);
        }
        return cards;
    }
}