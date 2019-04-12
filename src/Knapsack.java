import java.util.Arrays;

/**
 * @author : Amirhossein Azimyzadeh
 * */
/*
* Recursive formula -> P(w) = Max{p[i]+P(W-W[i])}
*                               i : 1 --> n
*                               W = maximum weight that knapsack can carry
*                               no limits to select items
* */
public class Knapsack {
    private int[] P ;  // saving states
    private int[] weights ; // weight of item "i" is in W[i]
    private int[] prices ; // price of item "i" is in P[i]

    private int[] X; // Array for print solution

    public int knapsack(int maxWeight , int[] p ,int[] ws){
        weights=ws;
        prices=p;
        P=new int[maxWeight+1];   // indexes start from 1
        X=new int[maxWeight+1];
        for (int w = 1; w <= maxWeight; w++) {
            for (int i = 1; i <weights.length ; i++) {
                if(weights[i]<=w)
                    if(P[w]<prices[i]+P[w-weights[i]]){
                        P[w]=prices[i]+P[w-weights[i]];
                        X[w]=i;
                    }
            }
        }
        return P[maxWeight];
    }

    public static void main(String[] args) {
        int[] weight= new int[]{0,10,20,30};
        int[] price = new int[]{0,60,100,120};

        Knapsack ks = new Knapsack();

        System.out.println(ks.knapsack(50,price,weight));
        System.out.println(Arrays.toString(ks.P));
        System.out.println(ks.P.length);
    }
}
