package BriscaAI2017;

import java.util.ArrayList;

/**
 * Created by vikta on 6/3/2017.
 */
public class Deck {

    private ArrayList<String> suites = new ArrayList<String>();

    private ArrayList<Card> cardList;

    public Deck(){
        suites.add("Espada");
        suites.add("Bastón");
        suites.add("Moneda");
        suites.add("Copa");
        for(int i = 0; i < 4 ; i++) {
            for (int j = 1; j < 11; j++) {
                if (j == 1) {
                    cardList.add(new Card(suites.get(i), j, 11));
                } else if (j == 3) {
                    cardList.add(new Card(suites.get(i), j, 10));
                } else if (j == 8) {
                    cardList.add(new Card(suites.get(i), 10, 2));
                } else if (j == 9) {
                    cardList.add(new Card(suites.get(i), 11, 3));
                } else if (j == 10) {
                    cardList.add(new Card(suites.get(i), 12, 4));
                } else {
                    cardList.add(new Card(suites.get(i), j, 0));
                }
            }
        }
    }

    public Card getTopCard(){
        return cardList.remove(cardList.size()-1);
    }

    public void shuffle(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < cardList.size(); j++){
                Card temp = cardList.remove(0);
                cardList.add((int) (Math.random() * (39 - 0 +  1))+0,temp);
            }
        }
    }

    public boolean empty(){
        return cardList.isEmpty();
    }

    public Card trump(){
        Card temp = cardList.remove(cardList.size());
        cardList.add(0,temp);
        return temp;
    }

}
