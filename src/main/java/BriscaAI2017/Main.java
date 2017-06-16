package BriscaAI2017;
import java.util.ArrayList;

/**
 * Created by vikta on 6/2/2017.
 */
public class Main {

    public static void main(String []args) {
//        int n=50000001;
//        int c=0;
//        for(int i=1;i<n+1;i++){
//            double a = Math.random();
//            double b = Math.random();
//            if (Math.sqrt(a*a+b*b)<=1){c=c+1;}
//        }
//        System.out.println((c/n)*4);

//        Deck deck = new Deck();
//        deck.shuffle();
//        Card temp = deck.getTopCard();
//        Rules rule = new Rules(temp);
//        ArrayList<Card> round = new ArrayList<Card>();
//        round.add(deck.getTopCard());
//        round.add(deck.getTopCard());
//        int won = rule.winnerOfRound(round);
//
//        System.out.println(temp.getSuite()+","+temp.getNumber());
//        System.out.println(round.get(0).getSuite()+","+round.get(0).getNumber());
//        System.out.println(round.get(1).getSuite()+","+round.get(1).getNumber());
//        System.out.println(won);

        ArrayList<Card> hand = new ArrayList<Card>();
        Deck deck = new Deck();
        deck.shuffle();
        for(int i = 0; i < 3; i++){
            hand.add(deck.getTopCard());
        }
        Card killer = deck.getTopCard();
        ArrayList<Card> round = new ArrayList<Card>();
        Agent agent = new Agent(hand, round, killer);

        Card temp = agent.getCardChoice();

        for(int i = 0; i < hand.size(); i++){
            System.out.println(hand.get(i).getSuite()+","+hand.get(i).getNumber());
        }
        System.out.println();
        System.out.println(killer.getSuite()+","+killer.getNumber());
        System.out.println();

        System.out.println(temp.getSuite()+","+temp.getNumber());

    }
}
