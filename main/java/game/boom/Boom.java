package game.boom;

import boeren.Boerer;
import game.player.Maten;
import game.player.Player;

import java.util.List;

public class Boom {
    private List<Round> rounds;
    private static final int NUMBER_OF_ROUNDS = 16;
    private static final int NUMBER_OF_PLAYERS = 4;

    private final Maten teamOne;
    private final Maten teamTwo;


    public Boom(List<Player> players) {
        if (players.size() != NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException("Number of players must be 4");
        }
        Boerer boerer = new Boerer(players);
        boerer.appointMaten();
        teamOne = boerer.getMatenList().get(0);
        teamTwo = boerer.getMatenList().get(1);
    }
}
