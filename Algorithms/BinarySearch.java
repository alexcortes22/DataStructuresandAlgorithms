public class BinarySearch {

    /*
        Binary Search: A searching algorithm that has a time complexity of O(log n). It demonstrates
        the divide and conquer strategy by dividing the search in half through each iteration

        @param: int[]:          the array we are searching through
                int target:     the target number
                int lowerIndex: the lower index of the search parameter
                int upperIndex: the upper index of the search parameter
        
        @return: int:           The index in the array in which the target element resides. -1 if the 
                                element does not exist in the array. 
    */
    public int binarySearch(int[] arr, int target, int lowerIndex, int upperIndex){
        //calculate the middle of the search parameter by adding the difference between the upper and 
        //index to the lower index.
        int middle = (lowerIndex + upperIndex) / 2;

        if(upperIndex >= lowerIndex){
            if (arr[middle] == target){
                return middle;
            }
    
            if (target < arr[middle]){
                return binarySearch(arr, target, lowerIndex, middle - 1);
            }
    
            if (target > arr[middle]){
                return binarySearch(arr, target, middle + 1, arr.length - 1);
            }
        }
        
        return -1;    
    
    }

    public static void main(String[] args){
        SelectionSort sorter = new SelectionSort();
        BinarySearch demo = new BinarySearch();


        int[] nums = {5, 6, 35, 21, 6, 8, 9};
        int[] sorted = sorter.selectionSort(nums);

        int target = 2;

        int index = demo.binarySearch(sorted, target, 0, sorted.length); //should return 3

        System.out.println("The element is at index: " + index);

    }
}
