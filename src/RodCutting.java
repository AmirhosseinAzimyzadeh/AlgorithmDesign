import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author : Amirhossein Azimyzadeh
 * Strategy : Dynamic Programming
 * */
/*
* recursive formula --> R(n) = max{Price[i] + R (n-1) }
* */
public class RodCutting {

    private int[] R ;
    private int[] X ; // for printing solution

    public int rodCut(int n , int[] prices){
        R = new int[n+1]; // indexes start from 1
        X = new int[n+1];
        // price of piece with length i is in prices[i]
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= i; j++) {
                if(R[i]< prices[j]+R[i-j]){
                    R[i]= prices[j]+R[i-j];
                    X[i]=j; // best cut place
                }
            }
        return R[n];
    }

    public String solution(){
        return "pieces length --> " + solution(R.length-1);
    }

    private String solution(int n){
        if(n==0)
            return " ";
        return X[n]+" ,"+solution(n-X[n]);
    }
    ////////////////////////////////////////////////////////////////////
    // main for testing solution String
    public static void main(String[] args) {
        int[] p = new int[]{0 ,3  ,5  ,8  ,9 ,10 ,17 ,17 ,20};
        RodCutting rd = new RodCutting();
        System.out.println(rd.rodCut(8,p));
        System.out.println(rd.solution());
    }

    @Test
     void test(){
        int[] p1 = new int[]{0 ,3  ,5  ,8  ,9 ,10 ,17 ,17 ,20};
        int[] p2 = new int[]{0 ,1  ,5  ,8  ,9 ,10 ,17 ,17 ,20};
        //test cases from : geeksForGeeks.org
        Assertions.assertEquals(rodCut(8,p1),24);
        Assertions.assertEquals(rodCut(8,p2),22);
    }
}
