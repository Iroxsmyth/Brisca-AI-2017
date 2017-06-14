package BriscaAI2017;

/**
 * Created by Danny on 6/14/2017 - 3:59 PM in Brisca-AI-2017.
 */
public class Move {
    private Player player;
    private Card card;

    Move(Player player, Card card) {
        this.player = player;
        this.card = card;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
