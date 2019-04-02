import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class radixSort {
    @Test
    void radixSortTest(){
        int[] array = new int[]{111,224,43547,68,8678,67876};
        int[] expected = new int[]{68,111,224,8678,43547,67876};
        Assertions.assertArrayEquals(expected,array);
    }
    //create all number as array
    private ArrayList<Integer[]> fixedNumbers(int[] numbers){
        ArrayList<Integer[]> result = new ArrayList<>();
        int max = findMax(numbers);
        int maxDigit = String.valueOf(max).length();
        for(int number : numbers){
            result.add(fixNumber(number,maxDigit));
        }
        return result;
    }
    //find maximum number in array
    private int findMax(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]>max)
                max=array[i];
        }
        return max;
    }
    //create fixed number array -->
    private Integer[] fixNumber(int number,int maxDigit){
        Integer[] result = new Integer[maxDigit];
        for (int i = maxDigit-1; i>=0 ; i--) {
            result[i]=number%10;
            number/=10;
        }
        return result;
    }
    /**
     * @see : CountingSort
     */
    public void radixSort(int[] array){
        ArrayList<Integer[]> numbers = fixedNumbers(array);
    }

}
