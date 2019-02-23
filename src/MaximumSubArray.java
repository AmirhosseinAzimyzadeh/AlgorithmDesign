import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
/**
 * @author :  Amirhossein Azimyadeh
 * Maximum subArray of a Array --> Algorithm Design :
 * calculate maximum sum of sub array */
public class MaximumSubArray {
    private static int[] Array;
    private static int privateMaxSum(int start , int end){
        if(start==end)
            return Array[start];
        int mid = (start+end)/2;
        int L = privateMaxSum(start,mid);
        int R = privateMaxSum(mid+1,end);
        int maxLeft = findMaxLeft(start,mid);
        int maxRight = findMaxRight(mid+1,end);
        return Math.max(Math.max(L,R),(maxLeft+maxRight));
    }
    public static int maxSum(int[] array){
        Array =array;
        return privateMaxSum(0,Array.length-1);
    }
    private static int findMaxLeft(int start , int mid){
        int maxLeft = -Integer.MAX_VALUE;
        int temp = 0;
        for (int i = mid; i >= start ; i--) {
            temp+=Array[i];
            if(temp>maxLeft)
                maxLeft=temp;
        }
        return maxLeft;
    }
    private static int findMaxRight(int mid , int end){
        int maxRight =  -Integer.MAX_VALUE;
        int temp = 0;
        for (int i = mid; i <=end ; i++) {
            temp+=Array[i];
            if(temp>maxRight)
                maxRight=temp;
        }
        return maxRight;
    }
//======================================================================= TEST
    @Test
     void test(){
        int[] a = {1,2,3,4,5,-7,-4,10,7};
        Assertions.assertEquals(maxSum(a),21);
        int[] b = {-1,-2,-3,-4,-6,1,1,-2};
        Assertions.assertEquals(maxSum(b),2);
    }
}
