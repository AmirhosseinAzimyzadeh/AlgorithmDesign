import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * @author : Amirhossein Azimyzadeh
 * */
public class MaxHeap {
    private static int[] array ;

    @Test
    public  void heapSortTest(){
        int[] array = {4,100,-7,-100,5,7,8,1,2,3};
        MaxHeap mh = new MaxHeap();
        mh.heapSort(array);
        int[] tempSorted = {-100, -7, 1, 2, 3, 4, 5, 7, 8, 100};
        Assertions.assertArrayEquals(array,tempSorted);
    }

    public void  maxHeapify( int[] array, int i , int n){
        int leftIndex = 2*i+1;
        int rightIndex = (2*i)+2;
        int indexOfMaximum = i;
        if(leftIndex<n && array[leftIndex]>array[indexOfMaximum])
            indexOfMaximum=leftIndex;
        if(rightIndex<n && array[rightIndex]>array[indexOfMaximum])
            indexOfMaximum=rightIndex;
        if(indexOfMaximum!=i){
            swap(indexOfMaximum,i,array);
            maxHeapify(array,indexOfMaximum,n);
        }

    }

    public  void buildMaxHeap(int[] array){
        for (int i = (array.length/2)-1; i >=0 ; i--) {
            maxHeapify(array,i,array.length);
        }
    }

    public void heapSort(int[] array){
        buildMaxHeap(array);
        for (int i = array.length-1; i >= 0 ; i--) {
            swap(0,i,array);
            maxHeapify(array,0,i);
        }
    }

    private void swap(int i, int j,int[] array) {
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }

}
