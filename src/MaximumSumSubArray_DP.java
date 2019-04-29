/**
 * @author :  Amirhossein Azimyadeh
 */

// recursive formula -->  S[i] = {A[i],A[i]+S[i-1]}

public class MaximumSumSubArray_DP {

    int S[] ;
    int A[] ;
    int index ;
    public static void main(String[] args) {
        MaximumSumSubArray_DP mssa = new MaximumSumSubArray_DP();
        int[] a = new int[]{-2,-3,4,-1,-2,1,5,-3};
        System.out.println(mssa.MSSA(a));
        System.out.println(mssa.solution());
    }

    public int MSSA(int[] a){
        A = a;
        S =  new int[a.length];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < S.length; i++) {
            if(A[i]>A[i]+S[i-1])
                S[i]=A[i];
            else
                S[i]=A[i]+S[i-1];
            if(S[i]>max){
                max=S[i];
                index=i;
            }
        }
        return S[index];
    }

    public String solution(){
        return solutionToString(index);
    }

    private String solutionToString(int i) {
        if(S[i]==A[i])
            return String.valueOf(A[i]);
        return solutionToString(i-1)+":"+A[i];
    }
}


