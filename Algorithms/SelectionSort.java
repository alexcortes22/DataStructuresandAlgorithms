
public class SelectionSort {

    /*
        Selection Sort Algorithm in Java. Worst and Avg Time Complexity O(n^2). Best Case: O(n^2)
        @author: Alex Cortes
        @param: int array
        @return: Input Array in Sorted Order

    */
    public int[] selectionSort(int[] arr){
        
        for(int i = 0; i < arr.length; i++){
            //base case: Initialization 
            int smallestIndex = i;

            //find the smallest number
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[smallestIndex]){
                    smallestIndex = j;
                }
            }
            //swap
            int temp = arr[smallestIndex];
            arr[smallestIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args){
        SelectionSort demo = new SelectionSort();

        int[] nums = {22,45,6,8,1,5};

        int[] sorted = demo.selectionSort(nums);

        for(int i = 0; i < sorted.length; i++){
            System.out.println(sorted[i]);
        }
        
    }
}
