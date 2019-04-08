/**
 * @author : Amirhosein Azimyzadeh
 * ⚠️ No test method implemented */
import java.util.Arrays;

/*
* recursive formula --> M(i,j)=min{M(i,k)+M(k+1,j)+(P[0]*P[k]*P[j])}
*                               for k=1 -> n
* */
public class MatrixMultiply {
    private int[][] M;
    private int[][] X; //auxiliary matrix for printing solution
    private int[] P; // this Array keep size of row and column of Matrices e.g. -> for A1 row in P[0] & column in P[1]

    private void initialMatrices(int n,int[] p){
        M = new int[n+1][n+1]; // index from 1 !
        X = new int[n+1][n+1];
        P = p;

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if(i==j)
                    M[i][j]=0;
                else if(j==0||i==0){ //because all indexes start from 1 !
                    M[i][j]=0;
                }else {
                    M[i][j]=Integer.MAX_VALUE; // ∞
                }
            }
        }

    }

    private void create_M_Matrix(int n, int[] p){
        initialMatrices(n,p);
        for(int l = 2 ; l<=n ;l++)
            for(int i=1;i<=n-l+1;i++){
                int j = i+l-1;
                for (int k=i ; k<j ; k++){
                    if(M[i][j]>M[i][k]+M[k+1][j]+(P[i-1]*P[k]*P[j])) {
                        M[i][j] = M[i][k] + M[k + 1][j] + (P[i-1] * P[k] * P[j]);
                        X[i][j]=k;
                    }
                }
            }
    }
    public String solution(){
        return toString(1,M[0].length-1);
    }

    private String toString(int i, int j){
        if(i==j)
            return "M"+String.valueOf(i);
        return "( ".concat(toString(i,X[i][j])+" x ").concat(toString(X[i][j]+1,j)).concat(" )");
    }

    public static void main(String[] args) {
        int[] p =  new int[]{ 7 , 1 , 5 , 4 , 2}; //meaning --> A(7x1),A(1x5),A(5x4),A(4x2)
        int n=4 ;
        MatrixMultiply m =  new MatrixMultiply();
        m.create_M_Matrix(n,p);
        //print solution matrix -->
        for (int i = 0; i < n + 1; i++) {
            System.out.println(Arrays.toString(m.M[i]));
        }
        System.out.println("______________________");
        // print solution
        System.out.println(m.solution());

    }

}
