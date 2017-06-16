package BriscaAI2017;

import java.util.ArrayList;

/**
 * Created by vikta on 6/3/2017.
 */
public class Deck {

    private ArrayList<String> suites = new ArrayList<String>();

    private ArrayList<Card> cardList = new ArrayList<Card>();

    public Deck(){
        suites.add("Espada");
        suites.add("Bastón");
        suites.add("Moneda");
        suites.add("Copa");
        for(int i = 0; i < 4 ; i++) {
            for (int j = 1; j < 11; j++) {
                if (j == 1) {
                    this.cardList.add(new Card(suites.get(i), j, 11));
                } else if (j == 3) {
                    this.cardList.add(new Card(suites.get(i), j, 10));
                } else if (j == 8) {
                    this.cardList.add(new Card(suites.get(i), 10, 2));
                } else if (j == 9) {
                    this.cardList.add(new Card(suites.get(i), 11, 3));
                } else if (j == 10) {
                    this.cardList.add(new Card(suites.get(i), 12, 4));
                } else {
                    this.cardList.add(new Card(suites.get(i), j, 0));
                }
            }
        }
    }

    public Card getTopCard(){
        return cardList.remove(cardList.size()-1);
    }

    public void shuffle(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < this.cardList.size(); j++){
                Card temp = this.cardList.remove(0);
                this.cardList.add((int) (Math.random() * (39 - 0 +  1))+0,temp);
            }
        }
    }

    public boolean empty(){
        return cardList.isEmpty();
    }

    public Card trump(){
        Card temp = this.cardList.remove(cardList.size());
        this.cardList.add(0,temp);
        return temp;
    }

    public void remove(Card C){
        for(int i = 0; i < 40; i++){
            if(C.getSuite().equals(this.cardList.get(i).getSuite()) && C.getNumber() == this.cardList.get(i).getNumber()){
                this.cardList.remove(this.cardList.get(i));
                break;
            }}
    }

    public Card getCard(int i){
        return this.cardList.get(i);
    }
}
