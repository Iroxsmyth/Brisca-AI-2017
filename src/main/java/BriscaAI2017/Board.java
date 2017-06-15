package BriscaAI2017;

import java.util.ArrayList;

/**
 * Created by Danny on 6/8/2017 - 7:59 PM in Brisca-AI-2017.
 */
public class Board {
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Move> round = new ArrayList<>();
    private Card killer;

    public Board(ArrayList<Player> players, ArrayList<Move> round, Card killer) {
        this.players = players;
        this.round = round;
        this.killer = killer;
    }

    protected void addPlayer(Player player) {
        players.add(player);
    }

    protected void addCard(Player player, Card card) {
        round.add(new Move(player, card));
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Move> getRound() {
        return round;
    }

    public void setRound(ArrayList<Move> round) {
        this.round = round;
    }

    public Card getKiller() {
        return killer;
    }

    public void setMate(Card killer) {
        this.killer = killer;
    }
}
