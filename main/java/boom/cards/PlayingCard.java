package boom.cards;

import boom.Player;

public class PlayingCard {

    private final CardRank rank;
    private final CardSuit suit;
    private final int troefValue;
    private final int normalValue;
    private boolean troef;
    private Player owner;

    public PlayingCard(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
        this.troefValue = this.getCardRank().getTroefValue();
        this.normalValue = this.getCardRank().getNormalValue();
    }

    public CardSuit getCardSuit() {
        return suit;
    }

    public CardRank getCardRank() {
        return rank;
    }

    private String rankToString(CardRank rank) {
        switch (rank) {
            case SEVEN:
                return "Seven";
            case EIGHT:
                return "Eight";
            case NINE:
                return "Nine";
            case TEN:
                return "Ten";
            case JACK:
                return "Jack";
            case QUEEN:
                return "Queen";
            case KING:
                return "King";
            case ACE:
                return "Ace";
            default:
                return null;
        }
    }

    private String suitToString() {
        switch (suit) {
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
            case HEARTS:
                return "Hearts";
            case SPADES:
                return "Spades";
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return rankToString(this.rank) + " of " + suitToString();
    }

    public boolean equals(PlayingCard otherCard) {
        return (this.getCardRank().equals(otherCard.getCardRank()) && this.getCardSuit().equals(otherCard.getCardSuit()));
    }

    public boolean isTroef() {
        return troef;
    }

    public void setTroef(boolean troef) {
        this.troef = troef;
    }

    public int getTroefValue() {
        return troefValue;
    }

    public int getNormalValue() {
        return normalValue;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
