package boom;

import boom.cards.CardDealer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardDealerTest {

    Player a;
    Player b;
    Player c;
    Player d;
    List<Player> players;

    @BeforeEach
    void setUp() {
        a = new Player("A");
        b = new Player("B");
        c = new Player("C");
        d = new Player("D");
        players = Arrays.asList(a, b, c, d);
    }

    @Test
    void testDealHands() {
        CardDealer dealer = new CardDealer();
        dealer.dealHands(players);
        for (Player player : players) {
            assertEquals(8, player.getHand().getCards().size());
        }
    }
}