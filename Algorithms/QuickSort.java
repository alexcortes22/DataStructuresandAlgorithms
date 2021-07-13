public class QuickSort {
    /*
        This implementation of QuickSort picks the last element 
        as the pivot.
    */
    public static void quickSort(int[] array, int low, int high){
        if(low < high){
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /*
        Parition: Given an array, and an element, x, of the array as a pivot,
        put x at its correct position in the sorted array and put all the
        smaller elements before x, and the greater elements after x.

        @param: 
                int[] array: the array of unsorted numbers
                int low: the low boundary of the array
                int high: the pivot/high boundary
    */
    private static int partition(int[] array, int low, int high){
        int pivot = array[high];

        //index of smaller element and indicates the right position
        //of pivot found so far
        int i = (low-1);
        //this for loop causes left pointer to increase and right 
        //pointer to decrease
        for(int j = low; j < high; j++){
            if(array[j] <= pivot){
                i++;
                swap(array, i, j);
                //increment index of smaller element
                
            }
        }
        
        swap(array, i+1, high);
        return(i+1);
    }

    public static void main(String[] args){
        int[] nums = {10, 7, 8, 9, 1, 5};
        int n = nums.length;
        quickSort(nums, 0, n - 1);
        for(int i  = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
