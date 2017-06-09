package BriscaAI2017;

import java.util.ArrayList;

/**
 * Created by Danny on 6/8/2017 - 7:59 PM in Brisca-AI-2017.
 */
public class Environment {
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Card> round= new ArrayList<>();

    public Environment(ArrayList<Player> players, ArrayList<Card> round) {
        this.players = players;
        this.round = round;
    }

    protected void addPlayer(Player player){
        players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Card> getRound() {
        return round;
    }

    public void setRound(ArrayList<Card> round) {
        this.round = round;
    }
}
