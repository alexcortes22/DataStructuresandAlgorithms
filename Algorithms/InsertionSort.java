public class InsertionSort{

    /*
        This method displays the InsertionSort algorithm.
        @author Alex Cortes
        @param arr This is the array to be sorted
        @return int[]. The array that was input, sorted in ascending order 

    */
    public int[] InsertionSort(int[] arr){
        for(int j = 1; j < arr.length; j++){
            int current = arr[j];
            int i = j - 1; 
            //while loop is within bounds of array and the current num is greater than previous num
            while (i >= 0 && arr[i] > current){
                arr[i + 1] = arr[i];
                i = i - 1; //this is what moves elements to the left
            }
            arr[i + 1] = current;
        }

        return arr;
    }

    public static void main(String[] args){
        InsertionSort demo = new InsertionSort();

        int[] nums = {5,2,4,6,1,3};

        int[] sorted = demo.InsertionSort(nums);

        for(int i = 0; i < sorted.length; i++){
            System.out.println(sorted[i]);
        }
    }
}