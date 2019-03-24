import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class binarySearch {
    @Test
    void BSTest(){
        int[] arrayTest = new int[]{1,3,4,5,6,8,9,11,13,23,100};
        for (int i = 0; i < arrayTest.length; i++) {
            Assertions.assertEquals(i,binarySearch(arrayTest,arrayTest[i]));
        }
        Assertions.assertEquals(-1,binarySearch(arrayTest,1000));
    }
    public int binarySearch(int[] array , int key){
        return binary_search(array,0,array.length-1,key);
    }
    /**
     * @return -1 when key not found else return index of key
     * */
    private int binary_search(int[] array , int start ,int end , int key){
        if(start==end && array[start]!=key)
            return -1;
        int mid  = (start+end)/2;
        if(array[mid]==key)
            return mid;
        else if(array[mid]<key)
            return binary_search(array,mid+1,end,key);
        else
            return binary_search(array,start,mid-1,key);
    }
}
