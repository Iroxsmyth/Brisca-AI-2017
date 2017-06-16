package BriscaAI2017;

import aima.core.robotics.MonteCarloLocalization;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Danny on 6/15/2017 - 1:36 PM in Brisca-AI-2017.
 */
public class Agent {
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Card> round = new ArrayList<>();
    private Card killer;

    //Monte Carlo Tree Search
    private ArrayList<Double> UCT = new ArrayList<Double>(); // The Selection Function Montecarlo
    private ArrayList<Integer> nVisit = new ArrayList<>();
    private ArrayList<Integer> nWin = new ArrayList<>();
    private ArrayList<Integer> nSimulation = new ArrayList<>();
    private Card cardChoice;


    public Agent(ArrayList<Card> hand, ArrayList<Card> round, Card killer) {
        this.hand = hand;
        this.round = round;
        this.killer = killer;
        for(int i=0; i<=hand.size()-1; i++){
            if(round.isEmpty()){
                this.UCT.add(i, 0.0);
                this.nVisit.add(i,0);
                this.nWin.add(i,0);
                this.nSimulation.add(i,37);
            }
            else{
                this.UCT.add(i, 0.0);
                this.nVisit.add(i,0);
                this.nWin.add(i,0);
                this.nSimulation.add(i,1);
            }
        }
            this.cardChoice = MonteCarloTreeSearch();

    }

    private Card MonteCarloTreeSearch(){ //return a Card
        Rules rule = new Rules(this.killer);
        ArrayList<Integer> points = new ArrayList<Integer>();
        ArrayList<Integer> winPoints = new ArrayList<Integer>();
        Card wincard;
        int tempint = -100;
        int wins = 0;
        ArrayList<Card> temp = new ArrayList<Card>();

        if(this.nSimulation.get(0) == 1){
            for(int i = hand.size(); i > 0; i--){
                temp.add(this.round.get(0));
                temp.add(this.hand.get(i-1));
                if(rule.winnerOfRound(temp) == 1){
                    points.add(i-1, this.round.get(0).getValue()+this.hand.get(i-1).getValue());
                }
                else{
                    points.add(i-1, -(this.round.get(0).getValue()+this.hand.get(i-1).getValue()));
                }
            }
            for(int j = points.size()-1; j >= 0; j--){
                if(points.get(j) >= tempint){
                    tempint = points.get(j);
                }
            }
            return this.hand.get(points.indexOf(tempint));
        }
        else{
            Deck deck = new Deck();
            for(int i = 0; i < this.hand.size(); i++){
                deck.remove(this.hand.get(i));
            }
            deck.remove(this.killer);
            for(int i = this.hand.size()-1; i >= 0; i--){
                Card handcard = this.hand.get(i);
                temp.add(this.hand.get(i));
                for(int j = 0; j < 36; j++){
                    Card topcard = deck.getCard(j);
                    temp.add(topcard);
                    if(rule.winnerOfRound(temp)==0){
                        wins++;
                    }
                    temp.remove(topcard);
                }
                temp.remove(handcard);
                winPoints.add(wins);
                wins = 0;

            }
            for(int j = winPoints.size()-1; j >= 0; j--){
                if(winPoints.get(j) >= tempint){
                    tempint = winPoints.get(j);
                }
            }
            return this.hand.get(winPoints.indexOf(tempint));
        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

//    public ArrayList<Move> getRound() {
//        return round;
//    }
//
//    public void setRound(ArrayList<Move> round) {
//        this.round = round;
//    }

    public Card getKiller() {
        return killer;
    }

    public void setKiller(Card killer) {
        this.killer = killer;
    }

    public Card getCardChoice(){
        return this.cardChoice;
    }
}
