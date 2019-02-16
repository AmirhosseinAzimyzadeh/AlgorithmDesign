import java.util.Arrays;
/**
 * @author :  Amirhossein Azimyadeh
 * merge sort --> Algorithm Design : --> */
public class mergeSort {
    public static void main(String[] args) {
        int[] exampleArray =  {3,4,5,6,7,8,9,11,13,0,-1,-3,2,2,10};
        System.out.println(Arrays.toString(mSort(exampleArray)));
    }

    public static int[] mSort(int[] array) {
        return mSortPrivate(array);
    }

    private static int[] mSortPrivate(int[] array) {
        //init result Array -->
        if(array.length==1){
            return array;
        }
        int[] left = new int[array.length/2];
        int[] right = new int[array.length-left.length];

        for (int i = 0; i <left.length; i++) {
            left[i]=array[i];
        }
        for (int i = 0 , j= left.length; i < right.length; i++ ,j++) {
            right[i]=array[j];
        }
        return merge(mSortPrivate(left),mSortPrivate(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result =  new int[left.length+right.length];
        int indexRight=0;
        int indexLeft=0;
        for (int i = 0; i < left.length + right.length; i++) {
            if(indexLeft>=left.length || indexRight>=right.length){
                if(indexLeft>=left.length){
                    result[i]=right[indexRight];
                    indexRight++;
                }else {
                    result[i]=left[indexLeft];
                    indexLeft++;
                }
                continue;
            }
            if(left[indexLeft]<=right[indexRight]){
                result[i]=left[indexLeft];
                indexLeft++;
            }else{
                result[i]=right[indexRight];
                indexRight++;
            }
        }
        return result;
    }
}
