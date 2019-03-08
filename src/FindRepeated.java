public class FindRepeated {
    public static void main(String[] args) {
        double[] a = {-1, 0, 1.6, 4, 5, 5, 5, 5, 10};
        System.out.println(findNumberOfRepeated(a,0,a.length-1, 5));
    }

    public static int findNumberOfRepeated(double[] array, int start, int end, double element){
        if(array[start]==element && start == end)
            return end-start;
        else if(start == end)
            return -1;
        int mid = (start+end)/2;
        if(array[mid]==element){
            //TODO
        }else if(array[mid]>element){
            // go to left
            return findNumberOfRepeated(array,start,mid-1,element);
        }else if(array[mid]<element){
            // go to right
            return findNumberOfRepeated(array,mid+1,end,element);
        }
        return -1;
    }
}
