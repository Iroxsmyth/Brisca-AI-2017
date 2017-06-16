package BriscaAI2017;
import java.util.ArrayList;
import java.util.Scanner;

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

//        ArrayList<Card> hand = new ArrayList<Card>();
//        Deck deck = new Deck();
//        deck.shuffle();
//        for(int i = 0; i < 3; i++){
//            hand.add(deck.getTopCard());
//        }
//        Card killer = deck.getTopCard();
//        ArrayList<Card> round = new ArrayList<Card>();
//        Agent agent = new Agent(hand, round, killer);
//
//        Card temp = agent.getCardChoice();
//
//        for(int i = 0; i < hand.size(); i++){
//            System.out.println(hand.get(i).getSuite()+","+hand.get(i).getNumber());
//        }
//        System.out.println();
//        System.out.println(killer.getSuite()+","+killer.getNumber());
//        System.out.println();
//
//        System.out.println(temp.getSuite()+","+temp.getNumber());

        int counter = 0;
        Deck deck = new Deck();
        deck.shuffle();
        boolean humanWinner = false;
        Rules rule = new Rules(deck.trump());
        Card trump = deck.getCard(0);
        ArrayList<Card> player1 = new ArrayList<Card>();
        player1.add(deck.getTopCard());
        player1.add(deck.getTopCard());
        player1.add(deck.getTopCard());

        ArrayList<Card> player2 = new ArrayList<Card>();
        player2.add(deck.getTopCard());
        player2.add(deck.getTopCard());
        player2.add(deck.getTopCard());

        ArrayList<Card> player1Points = new ArrayList<Card>();
        ArrayList<Card> player2Points = new ArrayList<Card>();
        ArrayList<Card> round = new ArrayList<Card>();

        System.out.println("trump: "+trump.getSuite()+", "+trump.getNumber());
        System.out.println();


        Scanner reader = new Scanner(System.in);

        for(int i = 0; i < 20; i++){
            if(i == 0){
                System.out.println(counter);
                for(int j = 0; j < player1.size(); j++){
                    System.out.println(player1.get(j).getSuite()+", "+player1.get(j).getNumber());
                }

                int choice = reader.nextInt();
                round.add(player1.remove(choice));

                for(int j = 0; j < player2.size(); j++){
                    System.out.println(player2.get(j).getSuite()+", "+player2.get(j).getNumber());
                }

                System.out.println();

                Agent agent = new Agent(player2, round, trump);
                round.add(player2.remove(player2.indexOf(agent.getCardChoice())));

                for(int j = 0; j < round.size(); j++){
                    System.out.println(round.get(j).getSuite()+", "+round.get(j).getNumber());
                }

                if(rule.winnerOfRound(round)==0){
                    player1Points.add(round.remove(0));
                    player1Points.add(round.remove(0));
                    humanWinner=false;
                    counter++;
                }
                else{
                    player2Points.add(round.remove(0));
                    player2Points.add(round.remove(0));
                    humanWinner=true;
                    counter++;
                }

                System.out.println();
                System.out.println();
            }
            else if(!humanWinner){
                System.out.println(counter);
                if(!deck.empty()) {
                    player1.add(deck.getTopCard());
                    player2.add(deck.getTopCard());
                }

                for(int j = 0; j < player1.size(); j++){
                    System.out.println(player1.get(j).getSuite()+", "+player1.get(j).getNumber());
                }
                int choice = reader.nextInt();
                round.add(player1.remove(choice));

                for(int j = 0; j < player2.size(); j++){
                    System.out.println(player2.get(j).getSuite()+", "+player2.get(j).getNumber());
                }

                System.out.println();

                Agent agent = new Agent(player2, round, trump);
                round.add(player2.remove(player2.indexOf(agent.getCardChoice())));

                for(int j = 0; j < round.size(); j++){
                    System.out.println(round.get(j).getSuite()+", "+round.get(j).getNumber());
                }

                if(rule.winnerOfRound(round)==0){
                    player1Points.add(round.remove(0));
                    player1Points.add(round.remove(0));
                    humanWinner=false;
                    counter++;

                }
                else{

                    player2Points.add(round.remove(0));
                    player2Points.add(round.remove(0));
                    humanWinner=true;
                    counter++;

                }

                System.out.println();
                System.out.println();

            }
            else {
                System.out.println(counter);
                if (!deck.empty()) {
                    player2.add(deck.getTopCard());
                    player1.add(deck.getTopCard());
                }

                for(int j = 0; j < player2.size(); j++){
                    System.out.println(player2.get(j).getSuite()+", "+player2.get(j).getNumber());
                }

                System.out.println();

                Agent agent = new Agent(player2, round, trump);
                round.add(player2.remove(player2.indexOf(agent.getCardChoice())));
                System.out.println(round.get(0).getSuite()+", "+round.get(0).getNumber());
                System.out.println();

                for (int j = 0; j < player1.size(); j++) {
                    System.out.println(player1.get(j).getSuite() + ", " + player1.get(j).getNumber());
                }
                int choice = reader.nextInt();
                round.add(player1.remove(choice));

                for (int j = 0; j < round.size(); j++) {
                    System.out.println(round.get(j).getSuite() + ", " + round.get(j).getNumber());
                }

                if (rule.winnerOfRound(round) == 0) {
                    player2Points.add(round.remove(0));
                    player2Points.add(round.remove(0));
                    humanWinner=true;
                    counter++;
                } else {
                    player1Points.add(round.remove(0));
                    player1Points.add(round.remove(0));
                    humanWinner=false;
                    counter++;
                }
                System.out.println();
                System.out.println();
            }
        }
        System.out.println(rule.winnerOfGame(player1Points, player2Points));

    }
}
