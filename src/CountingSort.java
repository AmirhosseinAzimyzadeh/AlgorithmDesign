import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * @author : Amirhossein Azimyzadeh
 * */
public class CountingSort {
    @Test
    public void test(){
        int test1[] = new int[]{9,6,4,3,2,1};
        int test2[] =  new int[]{100,2,1,3,4,5,70};
        Assertions.assertArrayEquals(new int[]{0,1,2,3,4,6,9},countingSort(test1,9));
        Assertions.assertArrayEquals(new int[]{0,1,2,3,4,5,70,100},countingSort(test2,100));
    }

    public int[] countingSort(int[] array, int max){
        int[] countingArray = new int[max+1];
        for (int element : array) {
            countingArray[element]++;
        }
        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i]+=countingArray[i-1];
        }
        // now counting array ready to use -->
        int[] result = new int[array.length+1];
        for (int i = array.length-1; i >= 0 ; i--) {
            result[countingArray[array[i]]]=array[i];
        }
        return result;
    }
}
