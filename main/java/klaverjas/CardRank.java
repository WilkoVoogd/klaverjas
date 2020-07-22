package klaverjas;

public enum CardRank {
        SEVEN(7,0,0),
        EIGHT(8,0,0),
        NINE(9,0,14),
        TEN(10,10,10),
        JACK(11,2,20),
        QUEEN(12,3,3),
        KING(13,4,4),
        ACE(14,11,11);

    private final int rank;
    private final int normalValue;
    private final int troefValue;

    CardRank (int rank, int normalValue, int troefValue) {
            this.rank = rank;
            this.normalValue = normalValue;
            this.troefValue = troefValue;
        }

    public int getRank() {
        return rank;
    }

    public int getNormalValue() {
        return normalValue;
    }

    public int getTroefValue() {
        return troefValue;
    }
}
