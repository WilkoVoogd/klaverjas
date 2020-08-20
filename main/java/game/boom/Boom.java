package game.boom;

import game.player.Maten;
import game.player.Player;

import java.util.List;

public class Boom {
    private List<Round> rounds;
    private static final int NUMBER_OF_ROUNDS = 16;
    private static final int NUMBER_OF_PLAYERS = 4;

    private final List<Player> players;
    private final Maten teamOne;
    private final Maten teamTwo;


    public Boom(List<Player> players) {
        this.players = players;
        teamOne = new Maten(players.get(0), players.get(2));
        teamTwo = new Maten(players.get(1), players.get(3));
    }
}
