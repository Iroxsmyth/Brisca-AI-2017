package BriscaAI2017;

/**
 * Created by Danny on 6/5/2017 - 12:00 AM in Brisca-AI-2017.
 */
public class Card {
    private String suite; //{espada, moneda, copa, baston}
    private int number; // (1 to 7 and 10 to 12)
    private int value; // (10:2)  (11:3)  (12:4)  (3:10) y (1:11)

    public Card(String suite, int number, int value) {
        this.suite = suite;
        this.number = number;
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }
}
