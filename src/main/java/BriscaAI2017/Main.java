package BriscaAI2017;

/**
 * Created by vikta on 6/2/2017.
 */
public class Main {

    public static void main(String []args) {
        int n=50000001;
        int c=0;
        for(int i=1;i<n+1;i++){
            double a = Math.random();
            double b = Math.random();
            if (Math.sqrt(a*a+b*b)<=1){c=c+1;}
        }
        System.out.println((c/n)*4);
    }
}
