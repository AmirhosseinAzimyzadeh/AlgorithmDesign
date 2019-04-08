import java.util.Arrays;

/*
* recursive formula --> M(i,j)=min{M(i,k)+M(k+1,j)+(P[0]*P[k]*P[j])}
*                               for k=1 -> n
* */
public class MatrixMutiply {
    private int[][] M;
    private int[][] X;
    private int[] P; // this Array keep size of row and column of Matrices e.g. -> for A1 row in P[0] & column in P[1]

    private void initialMatrices(int n,int[] p){
        M = new int[n][n];
        X = new int[n][n];
        P = p;

        for(int i=0 ;i<n;i++)
            for (int j = 0; j < n; j++) {
               if(i==j)
                   M[i][j]=0;
               else
                   M[i][j]=Integer.MAX_VALUE;
            }
    }

    private void creat_M_Matrix(int n,int[] p){
        initialMatrices(n,p);
        for(int l = 2 ; l<=n ;l++)
            for(int i=0;i<=n-l+1;i++){
                int j = i+l-1;
                for (int k=i ; k<j ; k++){
                    if(M[i][j]>M[i][k]+M[k+1][j]+(P[i-1]*P[k]*P[j])) {
                        M[i][j] = M[i][k] + M[k + 1][j] + (P[i - 1] * P[k] * P[j]);
                        X[i][j]=k;
                    }
                }
            }
    }

}
