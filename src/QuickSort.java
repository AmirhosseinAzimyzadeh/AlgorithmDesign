import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class QuickSort {
    private static double[] array ;
    @Test
    public void test(){
        double[] testArray = new double[]{1 ,24,5.6,-10,100,1000,88,33};
        double[] sortedArray = new double[]{-10,1 ,5.6,24,33,88,100,1000};
        quickSort(testArray);
        Assertions.assertArrayEquals(sortedArray,array);

    }
    public static void quickSort(double[] Array){
        array=Array;
        quickSort(0,array.length-1);
    }
    private static void quickSort(int start , int end){
        if(start>=end)
            return;
            int pivot = partition(start, end);
            quickSort(start, pivot - 1);
            quickSort(pivot + 1, end);
    }

    private static int partition(int start, int end) {
        //randomize
        int random = new Random().nextInt(end);
        swap(start,random);

        double pivot = array[end];

        int i = (start - 1) ;
        for (int j = start; j<end; j++)
            if (array[j] <= pivot) {
                i++;
                swap(i, j);
            }
        swap(i+1,end);
        return (i + 1);
    }

    private static void swap(int i, int j) {
        double temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
