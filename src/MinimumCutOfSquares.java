/**
 * @author : Amirhossein Azimyzadeh
 * */
// Strategy : Greedy
//
public class MinimumCutOfSquares {
    public static void main(String[] args) {
        System.out.println(numberOfCuts(5,4));
        System.out.println(sumOfCuts(5,4));
    }

    public static int numberOfCuts(int m , int n){
        if(m==n)
            return 0;
        else if(m>n)
            return 1+ numberOfCuts(m-n,n);
        return 1+ numberOfCuts(m,n-m);
    }

    public static int sumOfCuts(int a , int b){
        if ( a==b) {
            return 0;
        }
        int max= Math.max(a , b);
        int min= Math.min(a, b);
        if(max%min==0){
            return ((max/min)-1)*min;
        }
        else {
            return (max/min)*min + sumOfCuts(max%min , min);
        }
    }
}
