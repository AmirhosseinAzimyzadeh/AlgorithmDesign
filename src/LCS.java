import java.util.Arrays;

/**
 * @author : Amirhossein Azimyzadeh
 * */
//     X[]  Y[]  find longest subSequence for X and Y
//     recursive formula --> L[i][j] = {if(X[i]==Y[j] --> 1+L[i-1][j-1])
//                                       else --> max(L[i][j-1],L[i-1][j]) }
public class LCS {

    private final static int UP = 0 ;
    private final static int LEFT = 1 ;
    private final static int UP_LEFT = 2;

    private int L[][]; // DP matrix
    private int S[][]; // solution matrix print

    private String X;
    private String Y;

    public static void main(String[] args) {
        // String Examples from geeksForGeeks
        String a = "AGGTAB";
        String b = "GXTXAYB";
        LCS lcs = new LCS();
        System.out.println(lcs.longestCommonSubSequence(a,b));
        System.out.println(lcs.solution());
    }

    public int longestCommonSubSequence(String a , String b){
        X = "\r"+a;
        Y = "\r"+b;  // indexes start from 1 one of solution is to add " " to start of Strings

        L= new int[X.length()][Y.length()];
        S= new int[X.length()][Y.length()];

        for (int i = 0; i <X.length() ; i++) {
            for (int j = 0; j <Y.length() ; j++) {
                if(i-1<0 || j-1<0);
                else if(X.charAt(i)==Y.charAt(j)) {
                    L[i][j] = 1 + L[i - 1][j - 1];
                    S[i][j] = UP_LEFT; // for printing solution
                }
                else if(L[i-1][j]>L[i][j-1]){
                    L[i][j]=L[i-1][j];
                    S[i][j]=LEFT; //for printing solution
                }else{
                    L[i][j]=L[i][j-1];
                    S[i][j]= UP; //for printing solution
                }
            }
        }
        return L[X.length()-1][Y.length()-1];
    }

    public String solution(){
        return solutionToString(X.length()-1,Y.length()-1);
    }

    private String solutionToString(int i ,int j){
        if(i==0 || j==0)
            return "";
        if(S[i][j]==UP_LEFT)
            return solutionToString(i-1,j-1)+":"+X.charAt(i);
        else if(S[i][j]==LEFT)
            return solutionToString(i-1,j);
        else
            return solutionToString(i,j-1);
    }



    ///////////////////////////////////////////////////////////////////////////

    private void printDPMatrix(){
        for (int i = 0; i < L.length; i++) {
            System.out.println(Arrays.toString(L[i]));
        }
    }
    private void printSolutionMatrix(){
        for (int i = 0; i < S.length; i++) {
            System.out.println(Arrays.toString(S[i]));
        }
    }
}
