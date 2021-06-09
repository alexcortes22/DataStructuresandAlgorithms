public class InsertionSort{

    /*
        This method displays the InsertionSort algorithm.
        @param arr This is the array to be sroted
        @return int[]. The array that was input, sorted in ascending order 

    */

    public int[] InsertionSort(int[] arr){
        for(int j = 2; j < arr.length; j++){
            int key = arr[j];
            int i = j-1; 
            while (i > 0 & arr[i] > key){
                arr[i+1] = a[i];
                i--;
            }
            a[i+1] = key;
        }
    }
}