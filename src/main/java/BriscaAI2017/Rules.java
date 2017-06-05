package BriscaAI2017;

/**
 * Created by vikta on 6/3/2017.
 */
public class Rules {

    private Card trump;

    public Rules(Card killer){
        this.trump = killer;
    }

    public int winnerOfRound(ArrayList<Card> round){
        return 0;
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
        if(score1 > score2){
            return 1;
        }
        else if(score1 < score2){
            return 2;
        }
        else return 0;
    }
}
