package Boom;

public class Player {
    private String name;
    private Player maat;
    private Hand hand;
    private Position position;

    public Player(String name) {
        this.name = name;
    }

    public void setMaat(Player maat) {
        this.maat = maat;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Player getMaat() {
        return maat;
    }

    public Hand getHand() {
        return hand;
    }

    public Position getPosition() {
        return position;
    }
}
