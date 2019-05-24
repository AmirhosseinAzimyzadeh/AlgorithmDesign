import java.util.ArrayList;
import java.util.Arrays;

public class nQueen {
    private static int[][] chessBoard ; // 1 mean Queen
    public static void main(String[] args) {
        chessBoard =  new int[8][8];
        System.out.println(n_queen(0));
        for (int i = 0; i <chessBoard.length; i++) {
            System.out.println(Arrays.toString(chessBoard[i]));
        }
    }

    private static boolean canPlace(int m, int n){
        if(m>=chessBoard.length || n>= chessBoard.length)
            return false;
        if(chessBoard[m][n]==1)
            return false;
        for (int i = 0; i < chessBoard.length; i++) {
            if(chessBoard[i][n] == 1)
                return false;
            if(chessBoard[m][i]==1)
                return false;
        }
        // move to 4 direction -->
        //up right
        int current_i = m;
        int current_j = n;
        while (true){ ;
            current_i -=1;
            current_j +=1;
            if(!((current_i>=0&&current_j>=0)&&(current_i<chessBoard.length&&current_j<chessBoard.length)))
                break;
            if(chessBoard[current_i][current_j]==1)
                return false;
        }
        //up left
        current_i = m;
        current_j = n;
        while (true){
            current_i-=1;
            current_j-=1;
            if(!((current_i>=0&&current_j>=0)&&(current_i<chessBoard.length&&current_j<chessBoard.length)))
                break;
            if(chessBoard[current_i][current_j]==1)
                return false;
        }
        // down right
        current_i = m;
        current_j = n;
        while (true){
            current_i+=1;
            current_j+=1;
            if(!((current_i>=0&&current_j>=0)&&(current_i<chessBoard.length&&current_j<chessBoard.length)))
                break;
            if(chessBoard[current_i][current_j]==1)
                return false;
        }
        // down left
        current_i = m;
        current_j = n;
        while (true){
            current_i+=1;
            current_j-=1;
            if(!((current_i>=0&&current_j>=0)&&(current_i<chessBoard.length&&current_j<chessBoard.length)))
                break;
            if(chessBoard[current_i][current_j]==1)
                return false;
        }
        return true;
    }

    private static boolean n_queen(int i){
        if(i>=chessBoard.length)
            return true;
        for (int j = 0; j < chessBoard.length; j++) {
            if(canPlace(i,j)){
                chessBoard[i][j]=1;
                if(n_queen(i+1))
                    return true;
                else
                    chessBoard[i][j]=0;
            }
        }
        return false;
    }
}
