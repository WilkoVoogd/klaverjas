package klaverjas;

public enum CardRank {
        SEVEN(1, 1,0,0),
        EIGHT(2, 2,0,0),
        NINE(3, 7,0,14),
        JACK(4,8, 2,20),
        QUEEN(5, 3,3,3),
        KING(6, 4,4,4),
        TEN(7, 5, 10,10),
        ACE(8, 6,11,11);

    private final int rank;
    private final int normalValue;
    private final int troefValue;
    private final int troefRank;

    CardRank (int normalRank, int troefRank, int normalValue, int troefValue) {
            this.rank = normalRank;
            this.troefRank = troefRank;
            this.normalValue = normalValue;
            this.troefValue = troefValue;
        }

    public int getRank() {
        return rank;
    }

    public int getTroefRank() {
        return troefRank;
    }

    public int getNormalValue() {
        return normalValue;
    }

    public int getTroefValue() {
        return troefValue;
    }


}
