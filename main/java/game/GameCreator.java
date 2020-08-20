package game;

import game.boom.Boom;
import game.player.Maten;
import game.player.Player;

import java.util.List;

public class GameCreator {

    private final Boom boom;


    public GameCreator(List<Player> players) {
        this.boom = new Boom(players);
    }

    public void createGame() {

    }


}
