public class CountingSort {
    public static void main(String[] args) {

    }

    public void countingSort(int[] array, int max){
        int[] countingArray = new int[max+1];
        for (int element : array) {
            countingArray[element]++;
        }
        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i]+=countingArray[i-1];
        }
        // now counting array ready to use -->
        int[] result = new int[array.length];

    }
}
