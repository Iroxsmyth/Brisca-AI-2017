package BriscaAI2017;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by vikta on 6/3/2017.
 */
public class Rules {

    private Card trump;

    public Rules(Card killer){
        this.trump = killer;
    }

    public int winnerOfRound(ArrayList<Card> round){
        int winner = 0;
        Card temp = round.get(0);
        boolean killer;
        killer = Objects.equals(temp.getSuite(), this.trump.getSuite());
        for(int i = 1; i < round.size();i++){
            if(killer){
                if(round.get(i).getSuite().equals(temp.getSuite()) && round.get(i).getValue() > temp.getValue()){
                    winner = i;
                    temp = round.get(i);
                }
                else if(round.get(i).getSuite().equals(temp.getSuite()) && round.get(i).getValue() == temp.getValue() && round.get(i).getNumber() > temp.getNumber()) {
                    winner = i;
                    temp = round.get(i);
                }
                else if(round.get(i).getSuite().equals(temp.getSuite()) && round.get(i).getNumber() > temp.getNumber() && round.get(i).getValue() == temp.getValue()){
                    winner = i;
                    temp = round.get(i);
                }
            }
            else{
                if(round.get(i).getSuite().equals(this.trump.getSuite())){
                    winner = i;
                    temp = round.get(i);
                    killer = true;
                }
                else if(round.get(i).getSuite().equals(temp.getSuite()) && round.get(i).getValue() > temp.getValue()){
                    winner = i;
                    temp = round.get(i);
                }
                else if(round.get(i).getSuite().equals(temp.getSuite()) && round.get(i).getNumber() > temp.getNumber() && round.get(i).getValue() == temp.getValue()){
                    winner = i;
                    temp = round.get(i);
                }

            }
        }
        return winner;
    }

    public int winnerOfGame(ArrayList<Card> player1, ArrayList<Card> player2){
        int score1 = 0;
        int score2 = 0;
        for(int i = 0; i < player1.size(); i++){
            score1 = score1 + player1.get(i).getValue();
        }
        for(int j = 0; j < player2.size(); j++){
            score2 = score2 + player2.get(j).getValue();
        }
        System.out.println("Player 1 score: "+ score1+"; Agent Score: "+score2);
        if(score1 > score2){
            return 1;
        }
        else if(score1 < score2){
            return 2;
        }
        else return 0;
    }
}
