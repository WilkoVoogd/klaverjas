package game.player;

public class Maten {
    private final Player playerOne;
    private Player playerTwo;
    private int points;

    public Maten(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.points = 0;
    }
}
