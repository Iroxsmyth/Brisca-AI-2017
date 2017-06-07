package BriscaAI2017;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Danny on 6/7/2017 - 12:50 PM in Brisca-AI-2017.
 */
public class Player {
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Card> point = new ArrayList<>();

    public Player(ArrayList<Card> hand, ArrayList<Card> point) {
        this.hand = hand;
        this.point = point;
    }

    //get card of the algorithms Depth First and Montecarlo Method
    private void play(Card cardToPlay){
        for(int i = 0; i < getHand().size(); i++) {
            if (Objects.equals(getHand().get(i).getSuite(), cardToPlay.getSuite()) && getHand().get(i).getNumber() == cardToPlay.getNumber()) {
                removeItemHand(i);
                break;
            }
        }
        //place to the cards on the table

    }

    private void getCardToHand(Card temp){
        hand.add(temp);
    }

    private void addPoint(ArrayList<Card> round){
        point.addAll(round);
    }

    private void removeItemHand(int i){
        getHand().remove(i);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getPoint() {
        return point;
    }

    public void setPoint(ArrayList<Card> point) {
        this.point = point;
    }
}
