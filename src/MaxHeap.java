import org.junit.jupiter.api.Test;

public class MaxHeap {
    private static int[] array ;

    @Test
    public void heapSortTest(){

    }
    //TODO --> need to be completed
    public void HeapSort(int[] array){
        buildMaxHeap(array);
        for (int i = 1; i <array.length ; i++) {
            swap(0,array.length-i+1,array);
        }
    }

    public static void buildMaxHeap(int[] array){
        for (int i = array.length/2; i >= 0 ; i--)
            maxHeap(i,array.length,array);
    }

    private static void maxHeap(int i, int vertices, int[] array) {
        int leftChild = 2*i ;
        int rightChild = (2*i)+1;

        //check for no child -->
        if(leftChild>=array.length || rightChild >=array.length)
            return;
        int bigChildIndex = Math.max(array[leftChild],array[rightChild]) == array[leftChild] ? leftChild : rightChild;
        if(array[i]<array[bigChildIndex]){
            swap(i,bigChildIndex,array);
        }
        maxHeap(bigChildIndex,vertices,array);
    }

    private static void swap(int i, int j,int[] array) {
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }

}
