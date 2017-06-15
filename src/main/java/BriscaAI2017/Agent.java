package BriscaAI2017;

import aima.core.robotics.MonteCarloLocalization;

import java.util.ArrayList;

/**
 * Created by Danny on 6/15/2017 - 1:36 PM in Brisca-AI-2017.
 */
public class Agent {
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Move> round = new ArrayList<>();
    private Card killer;

    //Monte Carlo Tree Search
    private ArrayList<Double> UCT = new ArrayList<>(); // The Selection Function Montecarlo
    private ArrayList<Integer> nVisit = new ArrayList<>();
    private ArrayList<Integer> nWin = new ArrayList<>();
    private ArrayList<Integer> nSimulation = new ArrayList<>();


    public Agent(ArrayList<Card> hand, ArrayList<Move> round, Card killer) {
        this.hand = hand;
        this.round = round;
        this.killer = killer;
        if(!hand.isEmpty()){
            for(int i=0; i<hand.size()-1; i++){
                this.UCT.set(i, 0.0);
                this.nVisit.set(i,0);
                this.nWin.set(i,0);
                this.nSimulation.set(i,0);
            }
            MonteCarloTreeSearch();
        }else {
            // First Move, Board Empty
        }

    }

    private void MonteCarloTreeSearch(){ //return a Card

    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
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

    public void setKiller(Card killer) {
        this.killer = killer;
    }
}
