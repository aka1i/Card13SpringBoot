package app;

/**
 * @author yjn
 * @creatTime 2019/10/4 - 1:34
 */
public class Card {
    int type;
    int rank;

    public Card(int rank, int flower) {
        this.type = flower;
        this.rank = rank;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
